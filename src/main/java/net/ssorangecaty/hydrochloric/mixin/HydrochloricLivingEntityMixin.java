package net.ssorangecaty.hydrochloric.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class HydrochloricLivingEntityMixin {
    @Shadow protected abstract void applyDamage(DamageSource source, float amount);

    @Shadow public abstract boolean damage(DamageSource source, float amount);

    @Shadow protected abstract void takeShieldHit(LivingEntity attacker);

    @Shadow public abstract Random getRandom();

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void skillDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        Entity entity = source.getAttacker();
        if(entity instanceof PlayerEntity ){
            NbtCompound nbt = ((EntityGameDataSaver)entity).getGameInfo();
            if(!nbt.getBoolean("needTakenDamage")){
                if(nbt.getBoolean("amiyaSkill")){
                    this.applyDamage(source,amount);
                    nbt.putBoolean("amiyaSkill",false);
                }
                if(nbt.getInt("kkdyTick") >= 4) {
                    float a = (float) (amount*1.5);
                    if(getRandom().nextBetween(0,100) >= 80){
                        a += a*0.2;
                        source.getAttacker().sendMessage(Text.literal("暴击! "+a));
                    }
                    nbt.putBoolean("needTakenDamage",true);
                    this.damage(source,a);
                    nbt.putInt("kkdyTick",0);
                } else if (nbt.getBoolean("kkdySkill")) {
                    nbt.putInt("kkdyTick",nbt.getInt("kkdyTick")+1);
                }
            }
        }
    }
    @Inject(method = "applyDamage", at = @At("HEAD"), cancellable = true)
    private void takenDamage(DamageSource source, float amount, CallbackInfo ci) {
        if(source.getAttacker() instanceof PlayerEntity ) {
            NbtCompound nbt = ((EntityGameDataSaver) source.getAttacker()).getGameInfo();
            nbt.putBoolean("needTakenDamage",false);
        }
    }
}