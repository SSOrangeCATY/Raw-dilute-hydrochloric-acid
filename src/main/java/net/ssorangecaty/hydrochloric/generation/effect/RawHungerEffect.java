package net.ssorangecaty.hydrochloric.generation.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;

public class RawHungerEffect extends StatusEffect {
    public RawHungerEffect() {
        super(
                StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
                0x98D982); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            NbtCompound nbt = ((EntityGameDataSaver) entity).getGameInfo();
            int hungerLevel = nbt.getInt("hungerLevel");
            if (hungerLevel == 4){
                entity.damage(entity.getDamageSources().starve(),1F);
            }
        }
    }
}
