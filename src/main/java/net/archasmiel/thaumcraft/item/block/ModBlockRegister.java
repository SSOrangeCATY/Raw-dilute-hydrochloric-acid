package net.archasmiel.thaumcraft.item.block;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.block.entityBlock.Arcane_Workbench;
import net.archasmiel.thaumcraft.item.block.entityBlock.AuraNode;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockRegister {
    public static final Block ARCANE_WORKBENCH = registerBlock(
            new Arcane_Workbench(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F)),"arcane_workbench");
    public static final Block AURA_NODE = registerBlock(
            new AuraNode(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F)),"aura_node");
    private static Block registerBlock(Block block,String blockName) {
        return Registry.register(Registries.BLOCK, new Identifier(Thaumcraft.MOD_ID, blockName), block);
    }
    public static void registerModBlocks() {
        Thaumcraft.LOGGER.debug("Registering Mod Blocks for " + Thaumcraft.MOD_ID);
    }
}
