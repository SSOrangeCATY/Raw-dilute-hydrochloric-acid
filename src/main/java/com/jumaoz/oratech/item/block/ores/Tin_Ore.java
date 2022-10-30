package com.jumaoz.oratech.item.block.ores;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class Tin_Ore extends BlockItem {

    public Tin_Ore(Block block, Settings settings) {
        super(block, settings);
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.oratech.quality.ore").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.oratech.tin_ore.tips"));
    }
}
