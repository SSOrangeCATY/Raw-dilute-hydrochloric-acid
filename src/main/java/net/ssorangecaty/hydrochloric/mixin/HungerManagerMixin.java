package net.ssorangecaty.hydrochloric.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.ssorangecaty.hydrochloric.Mod;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.logging.Logger;

@Mixin(HungerManager.class)
public abstract class HungerManagerMixin {
    @Shadow private int foodTickTimer;
    @Shadow private int foodLevel;
    private int loopCount = 0;
    private int modTick;
    private int hunger_;

    private boolean healCheck;

    /**
     * @author SSOrangeCATY
     * @reason to raw hydrochloric Mod
     */
    @Overwrite
    public void update(PlayerEntity player) {
        int hunger = ((EntityGameDataSaver) player).getGameInfo().getInt("hunger");
        int hungerLevel = ((EntityGameDataSaver) player).getGameInfo().getInt("hungerLevel");
        foodTickTimer = ((EntityGameDataSaver) player).getGameInfo().getInt("foodTickTimer");
        if (++modTick == 2) {
            if (!healCheck && hunger > 0 && loopCount == 0) {
                hunger_ = hunger;
                loopCount = hunger * 10;
            }
            if (hunger_ < hunger) {
                int j = hunger - hunger_;
                hunger_ = hunger;
                loopCount += j*10;
            }
            if (--loopCount > 0) {
                player.heal(0.1F);
                if(loopCount > 30){
                    player.heal(0.5F);
                    loopCount -= 5;
                }
                healCheck = true;
            } else {
                loopCount = 0;
                ((EntityGameDataSaver)player).getGameInfo().putInt("hunger",0);
                healCheck = false;
            }
            if(hungerLevel == 4){
                player.damage(player.getDamageSources().starve(),0.1F);
            }
            modTick = 0;
        }
        if (foodTickTimer == 3600){
            player.sendMessage(Text.literal("你稍微有点饿了"));
            ((EntityGameDataSaver)player).getGameInfo().putInt("hungerLevel",1);
        } else if (foodTickTimer == 4800) {
            player.sendMessage(Text.literal("应该需要吃点东西了"));
            ((EntityGameDataSaver)player).getGameInfo().putInt("hungerLevel",2);
        } else if (foodTickTimer == 7200){
            player.sendMessage(Text.literal("好饿...").formatted(Formatting.RED));
            ((EntityGameDataSaver)player).getGameInfo().putInt("hungerLevel",3);
        } else if (foodTickTimer == 12000){
            player.sendMessage(Text.literal("饥肠辘辘！").formatted(Formatting.DARK_RED));
            ((EntityGameDataSaver)player).getGameInfo().putInt("hungerLevel",4);
        }
        if(foodLevel != 4){
            ((EntityGameDataSaver) player).getGameInfo().putInt("foodTickTimer",++foodTickTimer);
        }
    }

    @Inject(method = "isNotFull",at = @At("HEAD"), cancellable = true)
    public void isNotFull(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
