package net.archasmiel.thaumcraft.item.block;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.block.entityBlock.Arcane_Workbench;
import net.archasmiel.thaumcraft.item.item.ModItemRegister;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.archasmiel.thaumcraft.util.lib.register.Rotatable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockRegister {
    public static final Block ARCANE_WORKBENCH = registerBlock(
            new Arcane_Workbench(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F)),"arcane_workbench");
    private static Block registerBlock(Block block,String blockName) {
        Rotatable.register(blockName,block);
        return Registry.register(Registries.BLOCK, new Identifier(Thaumcraft.MOD_ID, blockName), block);
    }
    public static void registerModBlocks() {
        Thaumcraft.LOGGER.debug("Registering Mod Blocks for " + Thaumcraft.MOD_ID);
    }
}
