package net.dragoteen.ywformc.block.custom;

import net.dragoteen.ywformc.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.phys.BlockHitResult;

public class AscanikIslandLock extends Block {

    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    // États du bloc : true = verrouillé avec cet item
    public static final BooleanProperty LOCKED_CLEYOKANTIK = BooleanProperty.create("locked_cleyokantik");
    public static final BooleanProperty LOCKED_CLEYOLCANIK = BooleanProperty.create("locked_cleyolcanik");
    public static final BooleanProperty LOCKED_CLEYOKANSTRALE = BooleanProperty.create("locked_cleyokanstrale");
    public static final BooleanProperty LOCKED_CLEYOKOURAGE = BooleanProperty.create("locked_cleyokourage");        // ✅ NOUVEAU
    public static final BooleanProperty LOCKED_CLEYOKONNAISSANCE = BooleanProperty.create("locked_cleyokonnaissance"); // ✅ NOUVEAU

    public AscanikIslandLock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LOCKED_CLEYOKANTIK, false)
                .setValue(LOCKED_CLEYOLCANIK, false)
                .setValue(LOCKED_CLEYOKANSTRALE, false)
                .setValue(LOCKED_CLEYOKOURAGE, false)           // ✅ NOUVEAU
                .setValue(LOCKED_CLEYOKONNAISSANCE, false));    // ✅ NOUVEAU
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (!pLevel.isClientSide()) {
            ItemStack heldItem = pPlayer.getItemInHand(pHand);
            boolean isLockedCleyokantik = pState.getValue(LOCKED_CLEYOKANTIK);
            boolean isLockedCleyolcanik = pState.getValue(LOCKED_CLEYOLCANIK);
            boolean isLockedCleyokanstrale = pState.getValue(LOCKED_CLEYOKANSTRALE);
            boolean isLockedCleyokourage = pState.getValue(LOCKED_CLEYOKOURAGE);           // ✅ NOUVEAU
            boolean isLockedCleyokonnaissance = pState.getValue(LOCKED_CLEYOKONNAISSANCE); // ✅ NOUVEAU

            // === RETIRER CLÉ AVEC MAIN VIDE ===
            if ((isLockedCleyokantik || isLockedCleyolcanik || isLockedCleyokanstrale ||
                    isLockedCleyokourage || isLockedCleyokonnaissance) && heldItem.isEmpty()) {
                if (isLockedCleyokantik) {
                    giveItem(pPlayer, new ItemStack(ModItems.CLEYOKANTIK.get()));
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, false), 3);
                } else if (isLockedCleyolcanik) {
                    giveItem(pPlayer, new ItemStack(ModItems.CLEYOLCANIK.get()));
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOLCANIK, false), 3);
                } else if (isLockedCleyokanstrale) {
                    giveItem(pPlayer, new ItemStack(ModItems.CLEYOKANSTRALE.get()));
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANSTRALE, false), 3);
                } else if (isLockedCleyokourage) {                                            // ✅ NOUVEAU
                    giveItem(pPlayer, new ItemStack(ModItems.CLEYOKOURAGE.get()));            // ✅ NOUVEAU
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKOURAGE, false), 3);    // ✅ NOUVEAU
                } else if (isLockedCleyokonnaissance) {                                       // ✅ NOUVEAU
                    giveItem(pPlayer, new ItemStack(ModItems.CLEYOKONNAISSANCE.get()));       // ✅ NOUVEAU
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKONNAISSANCE, false), 3); // ✅ NOUVEAU
                }
                return InteractionResult.SUCCESS;
            }

            Item heldItemType = heldItem.getItem();

            // === DÉVERROUILLAGE (même clé) ===
            if (isLockedCleyokantik && heldItemType == ModItems.CLEYOKANTIK.get()) {
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOKANTIK.get()));
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, false), 3);
                return InteractionResult.SUCCESS;
            }
            if (isLockedCleyolcanik && heldItemType == ModItems.CLEYOLCANIK.get()) {
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOLCANIK.get()));
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOLCANIK, false), 3);
                return InteractionResult.SUCCESS;
            }
            if (isLockedCleyokanstrale && heldItemType == ModItems.CLEYOKANSTRALE.get()) {
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOKANSTRALE.get()));
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANSTRALE, false), 3);
                return InteractionResult.SUCCESS;
            }
            if (isLockedCleyokourage && heldItemType == ModItems.CLEYOKOURAGE.get()) {         // ✅ NOUVEAU
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOKOURAGE.get()));                 // ✅ NOUVEAU
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKOURAGE, false), 3);         // ✅ NOUVEAU
                return InteractionResult.SUCCESS;
            }
            if (isLockedCleyokonnaissance && heldItemType == ModItems.CLEYOKONNAISSANCE.get()) { // ✅ NOUVEAU
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOKONNAISSANCE.get()));            // ✅ NOUVEAU
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKONNAISSANCE, false), 3);    // ✅ NOUVEAU
                return InteractionResult.SUCCESS;
            }

            // === VERROUILLAGE (bloc vide) ===
            if (!isLockedCleyokantik && !isLockedCleyolcanik && !isLockedCleyokanstrale &&
                    !isLockedCleyokourage && !isLockedCleyokonnaissance) {
                if (heldItemType == ModItems.CLEYOKANTIK.get()) {
                    heldItem.shrink(1); if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, true), 3);
                    return InteractionResult.CONSUME;
                }
                if (heldItemType == ModItems.CLEYOLCANIK.get()) {
                    heldItem.shrink(1); if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOLCANIK, true), 3);
                    return InteractionResult.CONSUME;
                }
                if (heldItemType == ModItems.CLEYOKANSTRALE.get()) {
                    heldItem.shrink(1); if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANSTRALE, true), 3);
                    return InteractionResult.CONSUME;
                }
                if (heldItemType == ModItems.CLEYOKOURAGE.get()) {                            // ✅ NOUVEAU
                    heldItem.shrink(1); if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKOURAGE, true), 3);     // ✅ NOUVEAU
                    return InteractionResult.CONSUME;
                }
                if (heldItemType == ModItems.CLEYOKONNAISSANCE.get()) {                       // ✅ NOUVEAU
                    heldItem.shrink(1); if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKONNAISSANCE, true), 3); // ✅ NOUVEAU
                    return InteractionResult.CONSUME;
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
        pBuilder.add(FACING, LOCKED_CLEYOKANTIK, LOCKED_CLEYOLCANIK, LOCKED_CLEYOKANSTRALE,
                LOCKED_CLEYOKOURAGE, LOCKED_CLEYOKONNAISSANCE);  // ✅ NOUVEAU
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
