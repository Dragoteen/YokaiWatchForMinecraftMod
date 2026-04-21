package net.dragoteen.ywformc.entity;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.dragoteen.ywformc.entity.custom.JibanyanEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, YoKaiWatchForMinecraftMod.MODID);

    public static final RegistryObject<EntityType<JibanyanEntity>> JIBANYAN =
            ENTITY_TYPES.register("jibanyan", () -> EntityType.Builder.of(JibanyanEntity::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("jibanyan"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
