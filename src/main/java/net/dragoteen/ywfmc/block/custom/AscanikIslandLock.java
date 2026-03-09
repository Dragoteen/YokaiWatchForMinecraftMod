package net.dragoteen.ywfmc.block.custom;

import net.dragoteen.ywfmc.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class AscanikIslandLock extends Block {

    // États du bloc : true = verrouillé avec cet item
    public static final BooleanProperty LOCKED_CLEYOKANTIK = BooleanProperty.create("locked_cleyokantik");
    public static final BooleanProperty LOCKED_CLEYOLCANIK = BooleanProperty.create("locked_cleyolcanik");

    public AscanikIslandLock(Properties pProperties) {
        super(pProperties);
        // État par défaut : rien verrouillé
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LOCKED_CLEYOKANTIK, false)
                .setValue(LOCKED_CLEYOLCANIK, false));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        // SEULEMENT CÔTÉ SERVEUR (pas client)
        if (!pLevel.isClientSide()) {
            ItemStack heldItem = pPlayer.getItemInHand(pHand); // Item tenu par le joueur

            // Récupérer l'état actuel du bloc
            boolean isLockedCleyokantik = pState.getValue(LOCKED_CLEYOKANTIK);
            boolean isLockedCleyolcanik = pState.getValue(LOCKED_CLEYOLCANIK);

            // === CAS 1 : Joueur utilise CLEYOKANTIK sur bloc NON verrouillé ===
            if (heldItem.getItem() == ModItems.CLEYOKANTIK.get() && !isLockedCleyokantik) {
                heldItem.shrink(1); // Enlève 1 exemplaire de l'item
                if (heldItem.isEmpty()) {
                    pPlayer.setItemInHand(pHand, ItemStack.EMPTY); // Vide la main si stack à 0
                }

                // Change l'état : verrouillé avec cleyokantik seulement
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, true)
                        .setValue(LOCKED_CLEYOLCANIK, false), 3);
                return InteractionResult.CONSUME; // Item consommé
            }

            // === CAS 2 : Joueur utilise CLEYOLCANIK sur bloc NON verrouillé ===
            if (heldItem.getItem() == ModItems.CLEYOLCANIK.get() && !isLockedCleyolcanik) {
                heldItem.shrink(1);
                if (heldItem.isEmpty()) {
                    pPlayer.setItemInHand(pHand, ItemStack.EMPTY);
                }

                // Change l'état : verrouillé avec cleyolcanik seulement
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, false)
                        .setValue(LOCKED_CLEYOLCANIK, true), 3);
                return InteractionResult.CONSUME;
            }

            // === CAS 3 : Bloc verrouillé avec CLEYOKANTIK → rendre l'item ===
            if (isLockedCleyokantik && !isLockedCleyolcanik) {
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOKANTIK.get())); // Donne l'item au joueur
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOKANTIK, false), 3); // Déverrouille
                return InteractionResult.SUCCESS;
            }

            // === CAS 4 : Bloc verrouillé avec CLEYOLCANIK → rendre l'item ===
            if (isLockedCleyolcanik && !isLockedCleyokantik) {
                giveItem(pPlayer, new ItemStack(ModItems.CLEYOLCANIK.get()));
                pLevel.setBlock(pPos, pState.setValue(LOCKED_CLEYOLCANIK, false), 3);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.SUCCESS; // Par défaut
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
        pBuilder.add(LOCKED_CLEYOKANTIK, LOCKED_CLEYOLCANIK);
    }
}
