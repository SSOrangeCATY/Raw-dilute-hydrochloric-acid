package net.ssorangecaty.hydrochloric.generation;

import net.minecraft.item.Items;
import net.ssorangecaty.hydrochloric.Mod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroupSet {
    public static void createItemGroup(){
        final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(Mod.MOD_ID, "item_group"))
                .icon(() -> new ItemStack(Items.DIAMOND))
                .entries((enabledFeatures, entries)-> {
                    entries.add(Items.DIAMOND);
                })
                .build();
    }
}