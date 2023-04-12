package net.ssorangecaty.hydrochloric.network.data;

import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.Mod;
import net.ssorangecaty.hydrochloric.integration.PlayerTickHandler;
import net.ssorangecaty.hydrochloric.integration.ServerState;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;

import java.util.Objects;

public class ServerEvent {
    public static void registerEvent(){
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            // You can see we use the function getServer() that's on the player.
            ServerState serverState = ServerState.getServerState(Objects.requireNonNull(handler.player.world.getServer()));
            // Sending the packet to the player (look at the networking page for more information)
            PacketByteBuf data = PacketByteBufs.create();
            /*data.writeBoolean(ServerState.installCheck);
            // data.writeNbt(((EntityGameDataSaver)handler.player).getGameInfo());
            if(!ServerState.installCheck){
                handler.player.sendMessage(Text.literal("当前尚未安装生稀盐酸,请使用/install指令或者联系管理员解决").formatted(Formatting.GOLD));
            }
            ServerPlayNetworking.send(handler.player, new Identifier(Mod.MOD_ID,"raw_mod"), data);*/
        });
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
    }
}
