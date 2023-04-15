package net.ssorangecaty.hydrochloric.generation.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.Mod;
import net.ssorangecaty.hydrochloric.generation.item.ModItemRegister;

public class ScreenRegister {
    public static final ScreenHandlerType<RoleScreenHandler> ROLE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Mod.MOD_ID,"role_screen_handler"),RoleScreenHandler::new);
    public static void register(){}

}
