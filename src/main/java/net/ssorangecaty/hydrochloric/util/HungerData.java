package net.ssorangecaty.hydrochloric.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

public class HungerData {

    public static int addHunger(EntityGameDataSaver player, int amount) {
        int hunger = player.getGameInfo().getInt("hunger");
        if(hunger + amount > 20) {
            hunger = 20;
            //((PlayerEntity)player).getHungerManager().setFoodLevel(20);
        } else {
            hunger += amount;
            //((PlayerEntity)player).getHungerManager().setFoodLevel(hunger);
        }
        player.getGameInfo().putInt("hunger", hunger);
        return hunger;
    }

    public static int removeHunger(EntityGameDataSaver player, int amount) {
        int hunger = player.getGameInfo().getInt("hunger");
        if(hunger - amount < 0) {
            hunger = 0;
           //((PlayerEntity)player).getHungerManager().setFoodLevel(0);
        } else {
            hunger -= amount;
          //((PlayerEntity)player).getHungerManager().setFoodLevel(hunger);
        }

        player.getGameInfo().putInt("hunger", hunger);
        // synchunger(hunger, (ServerPlayerEntity) player);
        return hunger;
    }
    public static int resetHunger(EntityGameDataSaver player){
        NbtCompound nbt = player.getGameInfo();
        int hunger = nbt.getInt("hunger");
        ((PlayerEntity)player).getHungerManager().setFoodLevel(20);
        return hunger;
    }
}
