package net.ssorangecaty.hydrochloric.generation.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.Hydrochloric;

public class ScreenRegister {
    public static final ScreenHandlerType<RoleScreenHandler> ROLE_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(Hydrochloric.MOD_ID, "role_screen_handler"), new ExtendedScreenHandlerType<>(RoleScreenHandler::new));
    public static final ScreenHandlerType<PrtsScreenHandler> PRTS_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(Hydrochloric.MOD_ID, "prts_screen_handler"), new ExtendedScreenHandlerType<>(PrtsScreenHandler::new));

    public static final ScreenHandlerType<SearchVoucherScreenHandler> SEARCH_VOUCHER_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(Hydrochloric.MOD_ID, "search_voucher_screen_handler"), new ExtendedScreenHandlerType<>(SearchVoucherScreenHandler::new));
    public static void register(){
    }

}
