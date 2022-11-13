package com.jumaoz.oratech.item.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class Silver_Ingot extends Item {
    public Silver_Ingot(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.oratech.quality.mineral").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.oratech.silver_ingot.tips"));
    }
}

