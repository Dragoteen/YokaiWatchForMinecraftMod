package net.dragoteen.ywformc.sound;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, YoKaiWatchForMinecraftMod.MODID);

    public static final RegistryObject<SoundEvent> UPTOWN_SPRINGDALE_THEME = registerSoundEvents("uptown_springdale_theme");
    public static final RegistryObject<SoundEvent> MOUNT_WILDWOOD_THEME = registerSoundEvents("mount_wildwood_theme");
    public static final RegistryObject<SoundEvent> BLOSSOM_HEIGHTS_THEME = registerSoundEvents("blossom_heights_theme");
    public static final RegistryObject<SoundEvent> SHOPPERS_ROW_THEME = registerSoundEvents("shoppers_row_theme");
    public static final RegistryObject<SoundEvent> DOWNTOWN_SPRINGDALE_THEME = registerSoundEvents("downtown_springdale_theme");
    public static final RegistryObject<SoundEvent> BREEZY_HILLS_THEME = registerSoundEvents("breezy_hills_theme");
    public static final RegistryObject<SoundEvent> EXCELLENT_TOWER_THEME = registerSoundEvents("excellent_tower_theme");
    public static final RegistryObject<SoundEvent> SPARKOPOLIS_THEME = registerSoundEvents("sparkopolis_theme");
    public static final RegistryObject<SoundEvent> YOKAI_WORLD_THEME = registerSoundEvents("yokai_world_theme");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(YoKaiWatchForMinecraftMod.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
