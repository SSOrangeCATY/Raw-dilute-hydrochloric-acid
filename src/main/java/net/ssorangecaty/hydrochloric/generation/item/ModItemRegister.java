package net.ssorangecaty.hydrochloric.generation.item;

import net.ssorangecaty.hydrochloric.Mod;
import net.minecraft.item.Item;

import net.ssorangecaty.hydrochloric.generation.character.CharacterIdentifier;
import net.ssorangecaty.hydrochloric.generation.character.data.Ines;
import net.ssorangecaty.hydrochloric.util.ArkData;

public class ModItemRegister{
    public static final Item INES = new Ines(ArkData.sixStar,72, new CharacterIdentifier("ines")).registerItem();

    public static void registerModItems() {
        Mod.LOGGER.debug("Registering Mod Items for " + Mod.MOD_ID);
    }

}