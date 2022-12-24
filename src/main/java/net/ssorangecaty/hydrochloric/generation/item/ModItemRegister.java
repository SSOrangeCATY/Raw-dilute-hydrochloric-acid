package net.ssorangecaty.hydrochloric.generation.item;

import net.ssorangecaty.hydrochloric.Mod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItemRegister{

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Mod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Mod.LOGGER.debug("Registering Mod Items for " + Mod.MOD_ID);
    }
}