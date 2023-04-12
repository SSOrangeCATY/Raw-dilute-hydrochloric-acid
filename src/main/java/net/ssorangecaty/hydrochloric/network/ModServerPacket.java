package net.ssorangecaty.hydrochloric.network;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.Mod;
import net.ssorangecaty.hydrochloric.integration.PlayerTickHandler;
import net.ssorangecaty.hydrochloric.network.packet.InformationC2SPacket;

public class ModServerPacket {
    public static final Identifier HUNGER_ID = new Identifier(Mod.MOD_ID, "hunger");
    public static void register(){
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
        ServerPlayNetworking.registerGlobalReceiver(HUNGER_ID, InformationC2SPacket::receive);
    }
}
