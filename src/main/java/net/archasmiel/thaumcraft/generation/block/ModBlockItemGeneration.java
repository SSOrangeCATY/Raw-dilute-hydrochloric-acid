package net.archasmiel.thaumcraft.generation.block;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class ModBlockItemGeneration extends BlockItem {
    private String name;
    private String quality;
    public ModBlockItemGeneration(Block block, Settings settings) {
        super(block, settings);
    }
    public ModBlockItemGeneration(Block block, Settings settings,String name) {
        super(block, settings);
        this.name = name;
    }
    public ModBlockItemGeneration(Block block, Settings settings,String name,String quality) {
        super(block, settings);
        this.name = name;
        this.quality = quality;
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
        tooltip.add(Text.translatable("item.thaumcraft.quality."+ItemQuality()).formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("block.thaumcraft."+ItemName()+".tips"));
    }
}
