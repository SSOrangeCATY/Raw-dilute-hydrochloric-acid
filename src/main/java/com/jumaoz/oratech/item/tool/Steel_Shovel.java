package com.jumaoz.oratech.item.tool;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class Steel_Shovel extends ShovelItem {
    public Steel_Shovel(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable(""));
        // 对于 1.19 之后的版本
        tooltip.add(Text.translatable("item.oratech.quality.tool").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.oratech.steel_shovel.tips"));
    }
}