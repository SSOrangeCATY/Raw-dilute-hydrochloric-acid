package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.screen.ArcaneWorkbenchScreen;
import net.archasmiel.thaumcraft.screen.ModScreenHandlerRegister;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ThaumcraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlerRegister.ARCANE_WORKBENCH_SCREEN_HANDLER, ArcaneWorkbenchScreen::new);
    }

}
