package net.ssorangecaty.hydrochloric.generation.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.Hydrochloric;

public class HydrochloricEffectRegister {
    public static final StatusEffect RAW_HUNGER = applyRegister("raw_hunger",new RawHungerEffect());
    public static StatusEffect applyRegister(String name, StatusEffect effect){
        return  Registry.register(Registries.STATUS_EFFECT, new Identifier(Hydrochloric.MOD_ID, name), effect);
    }

    public static void register() {
        Hydrochloric.LOGGER.info("Registration effect successful");
    }
}
