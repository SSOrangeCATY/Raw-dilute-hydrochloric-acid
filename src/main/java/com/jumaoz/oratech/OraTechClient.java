package com.jumaoz.oratech;

import com.jumaoz.oratech.screen.*;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class OraTechClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(OraTech.EARTH_BLAST_FURNACE_SCREEN_HANDLER_SCREEN_HANDLER, EarthBlastFurnaceScreen::new);
        HandledScreens.register(OraTech.COKE_OVEN_SCREEN_HANDLER_SCREEN_HANDLER,CokeOvenScreen::new);
        //HandledScreens.register(OraTech.ONE_VER_ALLOY_FURNACE_SCREEN_HANDLER,OneVerAlloyFurnaceScreen::new);
    }

}
