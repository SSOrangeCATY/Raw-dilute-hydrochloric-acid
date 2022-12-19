package net.archasmiel.thaumcraft.util.lib;

import net.devtech.arrp.json.models.*;
import net.minecraft.util.Identifier;


import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

public class ItemDataGen {

    public static void simpleItemModel(String type, String modelName, String textureName) {
        RESOURCE_PACK.addModel(
                new JModel()
                        .parent("item/" + type)
                        .textures(
                                new JTextures().layer0("thaumcraft:item/" + textureName)
                        ),

                new Identifier("thaumcraft:item/" + modelName)
        );
    }


    public static void simpleItemBlockModel(String blockName) {
        RESOURCE_PACK.addModel(
                new JModel().parent("thaumcraft:block/" + blockName),

                new Identifier("thaumcraft:item/block/" + blockName)
        );
    }


}
