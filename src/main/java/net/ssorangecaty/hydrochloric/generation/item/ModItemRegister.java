package net.ssorangecaty.hydrochloric.generation.item;

import net.ssorangecaty.hydrochloric.Mod;
import net.minecraft.item.Item;

import net.ssorangecaty.hydrochloric.generation.character.CharacterIdentifier;
import net.ssorangecaty.hydrochloric.generation.character.data.Amiya;
import net.ssorangecaty.hydrochloric.generation.character.data.Ines;
import net.ssorangecaty.hydrochloric.generation.character.data.Kkdy;
import net.ssorangecaty.hydrochloric.util.ArkData;

public class ModItemRegister{
    public static final Item INES = new Ines(ArkData.sixStar,72, new CharacterIdentifier("ines")).registerItem();
    public static final Item AMIYA = new Amiya(ArkData.fiveStar,10,new CharacterIdentifier("amiya")).registerItem();
    public static final Item KKDY = new Kkdy(ArkData.threeStar,6,new CharacterIdentifier("kkdy")).registerItem();
    public static final Item ORIGIN_STONE = new ModItemGeneration(new Item.Settings().maxDamage(3),"origin_stone","stone").registerItem();
    public static final Item LONGMEN_COIN = new ModItemGeneration(new Item.Settings().maxDamage(3),"longmen_coin","coin").registerItem();
    public static final Item SYNTHETIC_JADE = new ModItemGeneration(new Item.Settings().maxDamage(3),"synthetic_jade","coin").registerItem();

    public static void registerModItems() {
        Mod.LOGGER.debug("Registering Mod Items for " + Mod.MOD_ID);
    }

}