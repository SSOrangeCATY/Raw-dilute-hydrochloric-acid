package net.ssorangecaty.hydrochloric.generation.item;

import net.ssorangecaty.hydrochloric.Hydrochloric;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class HydrochloricItemGroupSet {
    public static void createItemGroup(){
        final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(Hydrochloric.MOD_ID, "item_group"))
                .icon(() -> new ItemStack(HydrochloricItemRegister.ORIGIN_STONE))
                .entries((enabledFeatures, entries)-> {
                    entries.add(HydrochloricItemRegister.INES);
                    entries.add(HydrochloricItemRegister.AMIYA);
                    entries.add(HydrochloricItemRegister.KKDY);
                    entries.add(HydrochloricItemRegister.SUSURO);
                    entries.add(HydrochloricItemRegister.TACHAK);

                    entries.add(HydrochloricItemRegister.ORIGIN_STONE);
                    entries.add(HydrochloricItemRegister.LONGMEN_COIN);
                    entries.add(HydrochloricItemRegister.SYNTHETIC_JADE);
                    entries.add(HydrochloricItemRegister.SEARCH_VOUCHER);
                    entries.add(HydrochloricItemRegister.SEARCH_VOUCHER_X10);
                    entries.add(HydrochloricItemRegister.ADVANCED_VOUCHER);
                    entries.add(HydrochloricItemRegister.NORMAL_VOUCHER);
                    entries.add(HydrochloricItemRegister.PRTS_TERMINAL);
                })
                .build();
    }
}