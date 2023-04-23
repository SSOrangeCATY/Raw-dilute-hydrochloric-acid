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
import net.ssorangecaty.hydrochloric.Hydrochloric;

import java.util.List;

public class HydrochloricItemGeneration extends Item {
    private final String name;
    private final String quality;

    public HydrochloricItemGeneration(Settings settings, String name, String quality) {
        super(settings);
        this.name = name;
        this.quality = quality;
    }

    public Item registerItem(){
        return Registry.register(Registries.ITEM,new Identifier(Hydrochloric.MOD_ID,this.name),this);
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
        tooltip.add(Text.translatable("item.hydrochloric."+ItemQuality()).formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("按下shift以查看详情").formatted(Formatting.DARK_GRAY));
    }
}