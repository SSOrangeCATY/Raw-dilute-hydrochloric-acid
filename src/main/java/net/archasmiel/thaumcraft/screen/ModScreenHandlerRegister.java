package net.archasmiel.thaumcraft.screen;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.ThaumcraftClient;
import net.archasmiel.thaumcraft.screen.handler.*;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlerRegister {
    public static final ScreenHandlerType<Arcane_WorkbenchScreenHandler> ARCANE_WORKBENCH_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Thaumcraft.MOD_ID,"arcane_workbench"),Arcane_WorkbenchScreenHandler::new);
    public static void registerScreen() {
        Thaumcraft.LOGGER.debug("Registering Mod Screen for " + Thaumcraft.MOD_ID);
    }
}
