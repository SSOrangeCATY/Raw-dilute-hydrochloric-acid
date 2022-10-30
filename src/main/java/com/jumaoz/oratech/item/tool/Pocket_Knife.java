package com.jumaoz.oratech.item.tool;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class Pocket_Knife extends ToolItem {

    public Pocket_Knife(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable(""));
        // 对于 1.19 之后的版本
        tooltip.add(Text.translatable("item.oratech.quality.tool").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.oratech.pocket_knife.tips"));
    }
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        stack.setDamage(stack.getDamage()-1);
    }
}
