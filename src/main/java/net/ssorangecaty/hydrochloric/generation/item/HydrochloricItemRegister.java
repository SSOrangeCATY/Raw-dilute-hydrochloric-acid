package net.ssorangecaty.hydrochloric.generation.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.ssorangecaty.hydrochloric.Hydrochloric;
import net.minecraft.item.Item;

import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterIdentifier;
import net.ssorangecaty.hydrochloric.generation.item.character.data.Amiya;
import net.ssorangecaty.hydrochloric.generation.item.character.data.Ines;
import net.ssorangecaty.hydrochloric.generation.item.character.data.Kkdy;
import net.ssorangecaty.hydrochloric.generation.item.items.PrtsTerminal;
import net.ssorangecaty.hydrochloric.generation.item.items.SearchVoucher;
import net.ssorangecaty.hydrochloric.generation.item.items.SearchVoucherX10;
import net.ssorangecaty.hydrochloric.util.ArkData;

public class HydrochloricItemRegister {
    static final Item.Settings COMMON64 = new FabricItemSettings().maxCount(64);
    static final Item.Settings COMMON1 = new FabricItemSettings().maxCount(1);
    public static final Item INES = new Ines(ArkData.sixStar,72, new CharacterIdentifier("ines")).registerItem();
    public static final Item AMIYA = new Amiya(ArkData.fiveStar,10,new CharacterIdentifier("amiya")).registerItem();
    public static final Item KKDY = new Kkdy(ArkData.threeStar,6,new CharacterIdentifier("kkdy")).registerItem();
    public static final Item SUSURO = new CharacterGen(ArkData.fourStar,26,new CharacterIdentifier("susuro")).registerItem();
    public static final Item TACHAK = new CharacterGen(ArkData.fiveStar,75,new CharacterIdentifier("tachak")).registerItem();
    public static final Item ORIGIN_STONE = new HydrochloricItemGeneration(COMMON64,"origin_stone","consumables").registerItem();
    public static final Item LONGMEN_COIN = new HydrochloricItemGeneration(COMMON64,"longmen_coin","consumables").registerItem();
    public static final Item SYNTHETIC_JADE = new HydrochloricItemGeneration(COMMON64,"synthetic_jade","consumables").registerItem();
    public static final Item PRTS_TERMINAL = new PrtsTerminal(COMMON1,"prts_terminal","prts").registerItem();
    public static final Item SEARCH_VOUCHER = new SearchVoucher(COMMON64,"search_voucher","consumables").registerItem();
    public static final Item SEARCH_VOUCHER_X10 = new SearchVoucherX10(COMMON64,"search_voucher_x10","consumables").registerItem();
    public static final Item ADVANCED_VOUCHER = new HydrochloricItemGeneration(COMMON64,"advanced_voucher","consumables").registerItem();
    public static final Item NORMAL_VOUCHER = new HydrochloricItemGeneration(COMMON64,"normal_voucher","consumables").registerItem();


    public static void registerModItems() {
        Hydrochloric.LOGGER.debug("Registering Hydrochloric Items for " + Hydrochloric.MOD_ID);
    }

}