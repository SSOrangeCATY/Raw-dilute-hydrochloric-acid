package net.archasmiel.thaumcraft.util.lib.register;

import net.archasmiel.thaumcraft.util.lib.BlockDataGen;
import net.archasmiel.thaumcraft.util.lib.ItemDataGen;
import net.minecraft.block.Block;

public class Rotatable {

    // TODO
    // Delete in future commits
    public static void register(String name, Block block) {
        ItemDataGen.simpleItemBlockModel(name);
        BlockDataGen.simpleBlockLootTable(name);
        BlockDataGen.simpleRotatableBlockState(name);
    }

}
