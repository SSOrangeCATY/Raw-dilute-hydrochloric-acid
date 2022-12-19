package net.archasmiel.thaumcraft.util.lib;

import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.blockstate.JVariant;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.loot.JPool;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

public class BlockDataGen {

    // Models
    public static void simpleBlockModel(String blockName) {
        RESOURCE_PACK.addModel(
                new JModel()
                        .parent("block/cube_all")
                        .textures(
                                new JTextures().var("all", "thaumcraft:block/" + blockName)
                        ),

                new Identifier("thaumcraft:block/" + blockName)
        );
    }





    // States
    public static void simpleRotatableBlockState(String blockName) {
        RESOURCE_PACK.addBlockState(
                new JState().add(
                        new JVariant()
                                .put("facing=north", new JBlockModel(new Identifier("thaumcraft:block/" + blockName)).y(0))
                                .put("facing=east", new JBlockModel(new Identifier("thaumcraft:block/" + blockName)).y(90))
                                .put("facing=south", new JBlockModel(new Identifier("thaumcraft:block/" + blockName)).y(180))
                                .put("facing=west", new JBlockModel(new Identifier("thaumcraft:block/" + blockName)).y(270))
                ),

                new Identifier("thaumcraft:" + blockName)
        );
    }

    public static void simpleBlockState(String blockName) {
        RESOURCE_PACK.addBlockState(
                new JState().add(
                        new JVariant()
                                .put("facing=north", new JBlockModel(new Identifier("thaumcraft:block/" + blockName)).y(0))
                                .put("facing=east", new JBlockModel(new Identifier("thaumcraft:block/" + blockName)).y(90))
                                .put("facing=south", new JBlockModel(new Identifier("thaumcraft:block/" + blockName)).y(180))
                                .put("facing=west", new JBlockModel(new Identifier("thaumcraft:block/" + blockName)).y(270))
                ),

                new Identifier("thaumcraft:" + blockName)
        );
    }



    // Loot tables
    public static void simpleBlockLootTable(String blockName) {
        RESOURCE_PACK.addLootTable(
                new Identifier("thaumcraft:blocks/" + blockName),

                new JLootTable("minecraft:block")
                        .pool(
                                new JPool()
                                        .rolls(1)
                                        .entry(
                                                new JEntry()
                                                        .type("minecraft:item")
                                                        .name("thaumcraft:block/" + blockName)
                                        )
                                        .condition(new JCondition("minecraft:survives_explosion"))
                        )
        );
    }

}
