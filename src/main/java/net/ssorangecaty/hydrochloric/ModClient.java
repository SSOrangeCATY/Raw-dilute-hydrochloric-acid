package net.ssorangecaty.hydrochloric;


import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.ssorangecaty.hydrochloric.generation.screen.RoleScreen;
import net.ssorangecaty.hydrochloric.generation.screen.ScreenRegister;


public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ScreenRegister.ROLE_SCREEN_HANDLER, RoleScreen::new);
    }

}
