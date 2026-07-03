package net.dragoteen.ywformc.screen;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.dragoteen.ywformc.medallium.MedalliumSet;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, YoKaiWatchForMinecraftMod.MODID);

    public static final RegistryObject<MenuType<MedalliumMenu>> MEDALLIUM_MENU =
            MENUS.register("medallium_menu", () -> IForgeMenuType.create((id, inv, buf) -> {
                MedalliumSet set = buf.readEnum(MedalliumSet.class);
                int pageIndex = buf.readInt();
                return new MedalliumMenu(id, inv, set, pageIndex);
            }));


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}