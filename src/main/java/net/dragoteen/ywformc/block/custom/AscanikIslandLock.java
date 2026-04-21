package net.dragoteen.ywformc.block.custom;

import net.dragoteen.ywformc.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class AscanikIslandLock extends Block {

    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    public enum LockState implements StringRepresentable {
        EMPTY("empty"),
        CLEYOKANTIK("cleyokantik"),
        CLEYOLCANIK("cleyolcanik"),
        CLEYOKANSTRALE("cleyokanstrale"),
        CLEYOKOURAGE("cleyokourage"),
        CLEYOKONNAISSANCE("cleyokonnaissance"),
        CLEYOFORCE("cleyoforce"),
        CLEYOTERRE("cleyoterre"),
        CLEYOVENT("cleyovent");

        private final String name;
        LockState(String name) { this.name = name; }

        @Override
        public String getSerializedName() { return name; }
    }

    public static final EnumProperty<LockState> LOCKED = EnumProperty.create("locked", LockState.class);

    private static final Map<LockState, AscanikIslandDoor.DoorState> LOCK_TO_DOOR = Map.of(
            LockState.EMPTY, AscanikIslandDoor.DoorState.LOCKED,
            LockState.CLEYOKANTIK, AscanikIslandDoor.DoorState.MYSTERIK_TEMPLE,
            LockState.CLEYOLCANIK, AscanikIslandDoor.DoorState.MOUNT_ARDENT,
            LockState.CLEYOKANSTRALE, AscanikIslandDoor.DoorState.ANCIENT_WRECK,
            LockState.CLEYOKOURAGE, AscanikIslandDoor.DoorState.COURAGE_STATUE,
            LockState.CLEYOKONNAISSANCE, AscanikIslandDoor.DoorState.KNOWLEDGE_STATUE,
            LockState.CLEYOFORCE, AscanikIslandDoor.DoorState.STRENGTH_STATUE,
            LockState.CLEYOTERRE, AscanikIslandDoor.DoorState.TERRESTRIAL_PART,
            LockState.CLEYOVENT, AscanikIslandDoor.DoorState.WINDY_PART
    );

    private static final Map<LockState, java.util.function.Supplier<Item>> LOCK_TO_ITEM = Map.of(
            LockState.CLEYOKANTIK,      () -> ModItems.CLEYOKANTIK.get(),
            LockState.CLEYOLCANIK,      () -> ModItems.CLEYOLCANIK.get(),
            LockState.CLEYOKANSTRALE,   () -> ModItems.CLEYOKANSTRALE.get(),
            LockState.CLEYOKOURAGE,     () -> ModItems.CLEYOKOURAGE.get(),
            LockState.CLEYOKONNAISSANCE,() -> ModItems.CLEYOKONNAISSANCE.get(),
            LockState.CLEYOFORCE,       () -> ModItems.CLEYOFORCE.get(),
            LockState.CLEYOTERRE,       () -> ModItems.CLEYOTERRE.get(),
            LockState.CLEYOVENT,       () -> ModItems.CLEYOVENT.get()
    );

    public AscanikIslandLock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LOCKED, LockState.EMPTY));
    }

    private void checkAndOpenDoor(Level pLevel, BlockPos pPos, LockState lockState) {
        AscanikIslandDoor.DoorState doorState = LOCK_TO_DOOR.get(lockState);
        if (doorState == null) return;

        BlockPos doorPos = pPos.north(3);
        BlockState blockState = pLevel.getBlockState(doorPos);

        if (blockState.getBlock() instanceof AscanikIslandDoor
                && blockState.getValue(AscanikIslandDoor.FACING) == Direction.SOUTH) {
            pLevel.setBlock(doorPos, blockState.setValue(AscanikIslandDoor.DOOR, doorState), 3);
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (!pLevel.isClientSide()) {
            ItemStack heldItem = pPlayer.getItemInHand(pHand);
            LockState currentLock = pState.getValue(LOCKED);

            // === RETIRER CLÉ AVEC MAIN VIDE ===
            if (currentLock != LockState.EMPTY && heldItem.isEmpty()) {
                giveItem(pPlayer, new ItemStack(LOCK_TO_ITEM.get(currentLock).get()));
                pLevel.setBlock(pPos, pState.setValue(LOCKED, LockState.EMPTY), 3);
                checkAndOpenDoor(pLevel, pPos, LockState.EMPTY); // ← AJOUTER
                return InteractionResult.SUCCESS;
            }

            Item heldItemType = heldItem.getItem();

            // === DÉVERROUILLAGE (même clé) ===
            if (currentLock != LockState.EMPTY
                    && LOCK_TO_ITEM.containsKey(currentLock)
                    && heldItemType == LOCK_TO_ITEM.get(currentLock).get()) {
                giveItem(pPlayer, new ItemStack(heldItemType));
                pLevel.setBlock(pPos, pState.setValue(LOCKED, LockState.EMPTY), 3);
                checkAndOpenDoor(pLevel, pPos, LockState.EMPTY); // ← AJOUTER
                return InteractionResult.SUCCESS;
            }

            // === VERROUILLAGE (bloc vide) ===
            if (currentLock == LockState.EMPTY) {
                for (Map.Entry<LockState, java.util.function.Supplier<Item>> entry : LOCK_TO_ITEM.entrySet()) {
                    if (heldItemType == entry.getValue().get()) {
                        heldItem.shrink(1);
                        if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                        pLevel.setBlock(pPos, pState.setValue(LOCKED, entry.getKey()), 3);
                        checkAndOpenDoor(pLevel, pPos, entry.getKey());
                        return InteractionResult.CONSUME;
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    private void giveItem(Player pPlayer, ItemStack pItemStack) {
        if (!pPlayer.getInventory().add(pItemStack)) {
            pPlayer.drop(pItemStack, false);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LOCKED);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext)
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
}