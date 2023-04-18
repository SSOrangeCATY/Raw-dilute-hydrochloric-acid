package net.ssorangecaty.hydrochloric.integration;


import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import net.ssorangecaty.hydrochloric.util.HungerData;

import java.util.UUID;


public class PlayerTickHandler implements ServerTickEvents.StartTick {
    private static final String MESSAGE_HUNGER_TASK = "message.hydrochloric.hunger";
    private static boolean isEat = false;
    private static int healthUp = 0;
    private static String itemName = "NONE";
    private static UUID uuid;
    @Override
    public void onStartTick(MinecraftServer server) {
        /*for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if (new Random().nextFloat() <= 0.005f) {
                EntityGameDataSaver dataPlayer = ((EntityGameDataSaver) player);
                HungerData.removeHunger(dataPlayer, 1);
                player.sendMessage(Text.literal("removeHunger"+dataPlayer.getGameInfo().get("hunger")));
            }
        }*/
        if(isEat) {
            // Notify the player
            // server.getPlayerManager().getPlayer(uuid).sendMessage(Text.literal("你吃了"+itemName+"回复了"+ ((EntityGameDataSaver) server.getPlayerManager().getPlayer(uuid)).getGameInfo().getInt("hunger")).fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);
            // outputting the current thirst level of player
            server.getPlayerManager().getPlayer(uuid).sendMessage((Text.translatable("你吃了").formatted(Formatting.YELLOW))
                    .append(Text.literal(""+itemName).formatted(Formatting.GREEN))
                    .append(Text.literal("回复了").formatted(Formatting.YELLOW))
                    .append(Text.literal(""+healthUp).formatted(Formatting.GOLD))
                    .append(Text.literal("点饥饿值,当前饥饿值为").formatted(Formatting.YELLOW))
                    .append(Text.literal(" "+((EntityGameDataSaver) server.getPlayerManager().getPlayer(uuid)).getGameInfo().getInt("hunger")).formatted(Formatting.GREEN)));
            server.getPlayerManager().getPlayer(uuid).sendMessage(Text.literal(""+(server.getPlayerManager().getPlayer(uuid)).getHungerManager().getFoodLevel()));
            isEat = false;
        }

    }
    public static void addHunger(EntityGameDataSaver player,int amount,String name){
        HungerData.addHunger(player, amount);
        isEat = true;
        healthUp = amount*100;
        itemName = name;
        uuid = ((LivingEntity)player).getUuid();
    }
}
