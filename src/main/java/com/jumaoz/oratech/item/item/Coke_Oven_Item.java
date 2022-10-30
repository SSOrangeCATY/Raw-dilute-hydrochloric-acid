package com.jumaoz.oratech.item.item;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class Coke_Oven_Item extends BlockItem {
    public Coke_Oven_Item(Block block, Settings settings) {
        super(block, settings);
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.oratech.quality.machine").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.oratech.coke_oven.tips"));
    }
}