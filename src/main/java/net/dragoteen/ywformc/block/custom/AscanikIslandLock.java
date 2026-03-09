package net.dragoteen.ywformc.block.custom;

import net.dragoteen.ywformc.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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

    public AscanikIslandLock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LOCKED_CLEYOKANTIK, false)
                .setValue(LOCKED_CLEYOLCANIK, false));
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (!pLevel.isClientSide()) {
            ItemStack heldItem = pPlayer.getItemInHand(pHand);
            boolean isLockedCleyokantik = pState.getValue(LOCKED_CLEYOKANTIK);
            boolean isLockedCleyolcanik = pState.getValue(LOCKED_CLEYOLCANIK);

            // === RETIRER CLÉ AVEC MAIN VIDE ===
            if ((isLockedCleyokantik || isLockedCleyolcanik) && heldItem.isEmpty()) {
                if (isLockedCleyokantik) {
                    giveItem(pPlayer, new ItemStack(ModItems.CLEYOKANTIK.get()));
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, false), 3);
                } else if (isLockedCleyolcanik) {
                    giveItem(pPlayer, new ItemStack(ModItems.CLEYOLCANIK.get()));
                    pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOLCANIK, false), 3);
                }
                return InteractionResult.SUCCESS;
            }

            // === 1er : Vérifier si BLOC VERROUILLÉ + clé différente = CHANGEMENT ===
            if (isLockedCleyokantik && heldItem.getItem() == ModItems.CLEYOLCANIK.get()) {
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOKANTIK.get()));
                heldItem.shrink(1);
                if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, false)
                        .setValue(LOCKED_CLEYOLCANIK, true), 3);
                return InteractionResult.CONSUME;
            }
            if (isLockedCleyolcanik && heldItem.getItem() == ModItems.CLEYOKANTIK.get()) {
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOLCANIK.get()));
                heldItem.shrink(1);
                if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, true)
                        .setValue(LOCKED_CLEYOLCANIK, false), 3);
                return InteractionResult.CONSUME;
            }

            // === 2e : Vérifier si BLOC VERROUILLÉ + même clé = DÉVERROUILLAGE ===
            if (isLockedCleyokantik && heldItem.getItem() == ModItems.CLEYOKANTIK.get()) {
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOKANTIK.get()));
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, false), 3);
                return InteractionResult.SUCCESS;
            }
            if (isLockedCleyolcanik && heldItem.getItem() == ModItems.CLEYOLCANIK.get()) {
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOLCANIK.get()));
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOLCANIK, false), 3);
                return InteractionResult.SUCCESS;
            }

            // === 3e : Bloc NON verrouillé = VERROUILLAGE ===
            if (!isLockedCleyokantik && heldItem.getItem() == ModItems.CLEYOKANTIK.get()) {
                heldItem.shrink(1);
                if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, true)
                        .setValue(LOCKED_CLEYOLCANIK, false), 3);
                return InteractionResult.CONSUME;
            }
            if (!isLockedCleyolcanik && heldItem.getItem() == ModItems.CLEYOLCANIK.get()) {
                heldItem.shrink(1);
                if (heldItem.isEmpty()) pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, false)
                        .setValue(LOCKED_CLEYOLCANIK, true), 3);
                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.SUCCESS;
    }


    // Méthode utilitaire : donne un item au joueur
    private void giveItem(Player pPlayer, ItemStack pItemStack) {
        if (!pPlayer.getInventory().add(pItemStack)) {
            // Si inventaire plein → drop au sol
            pPlayer.drop(pItemStack, false);
        }
    }

    // Définit les propriétés du bloc (obligatoire)
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LOCKED_CLEYOKANTIK, LOCKED_CLEYOLCANIK);
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
