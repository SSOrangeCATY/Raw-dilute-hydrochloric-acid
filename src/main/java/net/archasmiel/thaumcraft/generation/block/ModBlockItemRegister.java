package net.archasmiel.thaumcraft.generation.block;

import net.archasmiel.thaumcraft.Thaumcraft;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlockItemRegister {
    public static void registerModBlockItems() {
        Thaumcraft.LOGGER.debug("Registering Mod Blocks for " + Thaumcraft.MOD_ID);
        Registry.register(Registries.ITEM, new Identifier(Thaumcraft.MOD_ID, "arcane_workbench"), new ModBlockItemGeneration
                (ModBlockRegister.ARCANE_WORKBENCH,new Item.Settings(),"arcane_workbench","blockItem"));
        Registry.register(Registries.ITEM, new Identifier(Thaumcraft.MOD_ID, "aura_node"), new ModBlockItemGeneration
                (ModBlockRegister.AURA_NODE,new Item.Settings(),"aura_node","blockItem"));
    }
}
