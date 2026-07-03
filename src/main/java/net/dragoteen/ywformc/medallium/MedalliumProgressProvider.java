package net.dragoteen.ywformc.medallium;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class MedalliumProgressProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static final Capability<IMedalliumProgress> MEDALLIUM_PROGRESS =
            CapabilityManager.get(new CapabilityToken<>() {});

    private final IMedalliumProgress progress = new MedalliumProgress();
    private final LazyOptional<IMedalliumProgress> optional = LazyOptional.of(() -> progress);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == MEDALLIUM_PROGRESS ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        return progress.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        progress.deserializeNBT(tag);
    }
}