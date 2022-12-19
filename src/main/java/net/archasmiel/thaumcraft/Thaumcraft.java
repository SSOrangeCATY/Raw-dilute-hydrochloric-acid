package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.item.ModItemGroupSet;
import net.archasmiel.thaumcraft.item.block.ModBlockEntityRegister;
import net.archasmiel.thaumcraft.item.block.ModBlockItemRegister;
import net.archasmiel.thaumcraft.item.block.ModBlockRegister;
import net.archasmiel.thaumcraft.item.item.ModItemGeneration;
import net.archasmiel.thaumcraft.item.item.ModItemRegister;
import net.archasmiel.thaumcraft.screen.ModScreenHandlerRegister;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.ToIntFunction;


public class Thaumcraft implements ModInitializer {
	public static final String MOD_ID = "thaumcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger("Thaumcraft");
	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("thaumcraft:resources");
	private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
		return (state) -> {
			return (Boolean)state.get(Properties.LIT) ? litLevel : 0;
		};
	}

	//ScreenRegister
	//public static final ScreenHandlerType<EarthBlastFurnaceScreenHandler> EARTH_BLAST_FURNACE_SCREEN_HANDLER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID,"earth_blast_furnace"),EarthBlastFurnaceScreenHandler::new);

	//public static final ToolItem STEEL_SWORD = new Steel_Sword(SteelToolMaterials.INSTANCE, 7, -1.75F, new Item.Settings().group(OraTech.OTHER_GROUP));


	// BlockEntity
	//public static BlockEntityType<CokeOvenEntity> COKE_OVEN_ENTITY;
	// Block
	//public static final Block IRIDIUM_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());
	//public static final Block STEAM_TURBINE = new Steam_Turbine(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F));
	//public static final Block ONE_VER_ALLOY_FURNACE = new One_Ver_Alloy_Furnace(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F));
	/*static
	{
		((ItemAccessor) STEEL_HAMMER ).setRecipeRemainder(STEEL_HAMMER);
		((ItemAccessor) SOFT_HAMMER ).setRecipeRemainder(SOFT_HAMMER);
		((ItemAccessor) STEEL_FILE ).setRecipeRemainder(STEEL_FILE);
		((ItemAccessor) STEEL_WRENCH ).setRecipeRemainder(STEEL_WRENCH);
		((ItemAccessor) STEEL_SCREWDRIVER ).setRecipeRemainder(STEEL_SCREWDRIVER);
		((ItemAccessor) STEEL_SAW ).setRecipeRemainder(STEEL_SAW);
		((ItemAccessor) POCKET_KNIFE ).setRecipeRemainder(POCKET_KNIFE);
		((ItemAccessor) CROWBAR ).setRecipeRemainder(CROWBAR);
	}*/
	@Override
	public void onInitialize() {
		LOGGER.info(Thaumcraft.MOD_ID+": Hello Minecraft,Mod now loading");
		ModItemRegister.registerModItems();
		ModScreenHandlerRegister.registerScreen();
		ModBlockEntityRegister.registerModBlockEntities();
		ModBlockRegister.registerModBlocks();
		ModBlockItemRegister.registerModBlockItems();
		ModItemGroupSet.createItemGroup();
/*
		// RecipeRegister
		Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, EarthBlastFurnaceRecipe.Serializer.ID),
				EarthBlastFurnaceRecipe.Serializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, EarthBlastFurnaceRecipe.Type.ID),
				EarthBlastFurnaceRecipe.Type.INSTANCE);

		// Item
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "coking_coal"), COKING_COAL);FuelRegistry.INSTANCE.add(COKING_COAL, 2400);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "orange"), ORANGE);
		// BLOCK_ITEM
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iridium_ore"), new Iridium_Ore(IRIDIUM_ORE, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "1v_alloy_furnace"), new One_Ver_Alloy_Furnace_Item(ONE_VER_ALLOY_FURNACE, new Item.Settings()));
		// BlockEntity
		ONE_VER_ALLOY_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "1v_alloy_furnace"), FabricBlockEntityTypeBuilder.create(OneVerAlloyFurnaceEntity::new,ONE_VER_ALLOY_FURNACE).build(null));
		// Block
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "iridium_ore"), IRIDIUM_ORE);
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModOreGeneration.generateOres();
	}
}
*/
	}
}