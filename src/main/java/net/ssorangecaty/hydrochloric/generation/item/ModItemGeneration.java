package net.ssorangecaty.hydrochloric.generation.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.Mod;

import java.util.List;

public class ModItemGeneration extends Item {
    private String name;
    private String quality;

    public ModItemGeneration(Settings settings) {
        super(settings);
    }
    public ModItemGeneration(Settings settings,String name,String quality) {
        super(settings);
        this.name = name;
        this.quality = quality;
    }

    public Item registerItem(){
        return Registry.register(Registries.ITEM,new Identifier(Mod.MOD_ID,this.name),this);
    }
    public String ItemName() {
        return name;
    }
    public String ItemQuality() {
        return quality;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.hy.ui."+ItemQuality()).formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.hy."+ItemName()+".tips"));
    }
}