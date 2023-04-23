package net.ssorangecaty.hydrochloric.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import net.ssorangecaty.hydrochloric.util.PlayerAttackCountGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class HydrochloricEntityMixin implements PlayerAttackCountGetter {
    private int playerAttackCount = 0;

    @Inject(method = "onDamaged", at = @At("HEAD"))
    private void onAttackEntityFrom(DamageSource damageSource, CallbackInfo ci) {
        if (damageSource.getAttacker() instanceof PlayerEntity) {
            if(((EntityGameDataSaver)damageSource.getAttacker()).getGameInfo().getBoolean("inesSkill")){
                playerAttackCount++;
            }else{
                playerAttackCount = 0;
            }
        }
    }

    @Override
    public int getPlayerAttackCount() {
        return playerAttackCount;
    }
}
