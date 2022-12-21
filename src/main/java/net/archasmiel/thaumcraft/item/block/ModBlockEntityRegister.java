package net.archasmiel.thaumcraft.item.block;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.block.entitys.Arcane_WorkbenchEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityRegister {
    public static BlockEntityType<Arcane_WorkbenchEntity> ARCANE_WORKBENCHENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Thaumcraft.MOD_ID, "arcane_workbench"),
            FabricBlockEntityTypeBuilder.create(Arcane_WorkbenchEntity::new,ModBlockRegister.ARCANE_WORKBENCH).build(null));
    public static BlockEntityType<Arcane_WorkbenchEntity> AURANODEENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Thaumcraft.MOD_ID, "aura_node"),
            FabricBlockEntityTypeBuilder.create(Arcane_WorkbenchEntity::new,ModBlockRegister.ARCANE_WORKBENCH).build(null));

    public static void registerModBlockEntities() {
        Thaumcraft.LOGGER.debug("Registering Mod BlockEntities for " + Thaumcraft.MOD_ID);
    }
}
