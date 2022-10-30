package com.jumaoz.oratech;

import com.jumaoz.oratech.item.block.*;
import com.jumaoz.oratech.item.block.entitys.*;
import com.jumaoz.oratech.item.block.machine.Coke_Oven;
import com.jumaoz.oratech.item.block.machine.Earth_Blast_Furnace;
import com.jumaoz.oratech.item.block.machine.Steam_Turbine;
import com.jumaoz.oratech.item.block.ores.Deepslate_Iridium_Ore;
import com.jumaoz.oratech.item.block.ores.Deepslate_Tin_Ore;
import com.jumaoz.oratech.item.block.ores.Iridium_Ore;
import com.jumaoz.oratech.item.block.ores.Tin_Ore;
import com.jumaoz.oratech.item.item.*;
import com.jumaoz.oratech.item.tool.*;
import com.jumaoz.oratech.item.tool.ToolMaterials.*;
import com.jumaoz.oratech.mixin.ItemAccessor;
import com.jumaoz.oratech.repice.type.EarthBlastFurnaceRecipe;
import com.jumaoz.oratech.screen.handler.*;
import com.jumaoz.oratech.world.feature.ModConfiguredFeatures;
import com.jumaoz.oratech.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.ToIntFunction;


public class OraTech implements ModInitializer {
	public static final String MOD_ID = "oratech";
	public static final Logger LOGGER = LoggerFactory.getLogger("OrangeTech");
	private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
		return (state) -> {
			return (Boolean)state.get(Properties.LIT) ? litLevel : 0;
		};
	}

	//ScreenRegister
	public static final ScreenHandlerType<EarthBlastFurnaceScreenHandler> EARTH_BLAST_FURNACE_SCREEN_HANDLER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID,"earth_blast_furnace"),EarthBlastFurnaceScreenHandler::new);
	public static final ScreenHandlerType<CokeOvenScreenHandler> COKE_OVEN_SCREEN_HANDLER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID,"coke_oven"),CokeOvenScreenHandler::new);
	public static final Item COKING_COAL = new Coking_Coal(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item STEEL_POLE = new Steel_Pole(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item STEEL_INGOT = new Steel_Ingot(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item IRIDIUM_INGOT = new Iridium_Ingot(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item BRONZE_INGOT = new Bronze_Ingot(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item NICKEL_INGOT = new Nickel_Ingot(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item TIN_INGOT = new Tin_Ingot(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item GLITTERING_INGOT = new Glittering_Ingot(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item ASHES = new Ashes(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item STEEL_PLATE = new Steel_Plate(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item BRONZE_PLATE = new Bronze_Plate(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item ORANGE = new Orange(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build()));
	public static final Item V1_MOTOR = new V1_Motor(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item CREOSOTE_OIL = new Creosote_Oil(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item COPPER_COIL = new Copper_Coil(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));
	public static final Item MAGNETIZED_STEEL_ROD = new Magnetized_Steel_Rod(new FabricItemSettings().group(OraTech.OTHER_GROUP).maxCount(64));






	public static final ToolItem STEEL_SWORD = new Steel_Sword(SteelToolMaterials.INSTANCE, 7, -1.75F, new Item.Settings().group(OraTech.OTHER_GROUP));
	public static final ToolItem STEEL_HOE = new Steel_Hoe(SteelToolMaterials.INSTANCE, 2, -2.75F, new Item.Settings().group(OraTech.OTHER_GROUP));
	public static final ToolItem STEEL_PICKAXE = new Steel_Pickaxe(SteelToolMaterials.INSTANCE, 4, -2.75F, new Item.Settings().group(OraTech.OTHER_GROUP));
	public static final ToolItem STEEL_SHOVEL = new Steel_Shovel(SteelToolMaterials.INSTANCE, 3, -2.75F, new Item.Settings().group(OraTech.OTHER_GROUP));
	public static final ToolItem STEEL_AXE = new Steel_Axe(SteelToolMaterials.INSTANCE, 8, -3.25F, new Item.Settings().group(OraTech.OTHER_GROUP));

	public static final ToolItem STEEL_HAMMER = new Steel_Hammer(CraftTool.INSTANCE,new FabricItemSettings().group(OraTech.OTHER_GROUP));

	public static final ToolItem SOFT_HAMMER = new Soft_Hammer(CraftTool.INSTANCE, new FabricItemSettings().group(OraTech.OTHER_GROUP));
	public static final ToolItem STEEL_FILE = new Steel_File(CraftTool.INSTANCE, new FabricItemSettings().group(OraTech.OTHER_GROUP));
	public static final ToolItem STEEL_WRENCH = new Steel_Wrench(CraftTool.INSTANCE, new FabricItemSettings().group(OraTech.OTHER_GROUP));

	public static final ToolItem STEEL_SCREWDRIVER = new Steel_Screwdriver(CraftTool.INSTANCE,new FabricItemSettings().group(OraTech.OTHER_GROUP));
	public static final ToolItem STEEL_SAW = new Steel_Saw(CraftTool.INSTANCE, new FabricItemSettings().group(OraTech.OTHER_GROUP));
	public static final ToolItem POCKET_KNIFE = new Pocket_Knife(CraftTool.INSTANCE, new FabricItemSettings().group(OraTech.OTHER_GROUP));
	public static final ToolItem CROWBAR = new Crowbar(CraftTool.INSTANCE, new FabricItemSettings().group(OraTech.OTHER_GROUP));


	// BlockEntity
	public static BlockEntityType<BreakEntity> BREAK_ENTITY;
	public static BlockEntityType<SteelChestEntity> STEEL_CHEST_ENTITY;
	public static BlockEntityType<EarthBlastFurnaceEntity> EARTH_BLAST_FURNACE_ENTITY;
	public static BlockEntityType<CokeOvenEntity> COKE_OVEN_ENTITY;
	public static BlockEntityType<SteamTurbineEntity> STEAM_TURBINE_ENTITY;
	// Block
	public static final Block IRIDIUM_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());
	public static final Block BREAK_BLOCK = new BreakBlock(AbstractBlock.Settings.of(Material.STONE));
	public static final Block STEEL_CHEST = new Steel_Chest(AbstractBlock.Settings.of(Material.STONE));
	public static final Block EARTH_BLAST_FURNACE = new Earth_Blast_Furnace(AbstractBlock.Settings.of(Material.STONE).nonOpaque().requiresTool().strength(3.5F).luminance(createLightLevelFromLitBlockState(13)));
	public static final Block COKE_OVEN = new Coke_Oven(AbstractBlock.Settings.of(Material.STONE).nonOpaque().strength(3.5F).luminance(createLightLevelFromLitBlockState(13)));
	public static final Block DEEPSTALTE_IRIDIUM_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F));
	public static final Block DEEPSTALE_TIN_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F));
	public static final Block TIN_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F));
	public static final Block BRONZE_SHELL = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F));
	public static final Block STEAM_TURBINE = new Steam_Turbine(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().nonOpaque().strength(3.5F));
	static
	{
		((ItemAccessor) STEEL_HAMMER ).setRecipeRemainder(STEEL_HAMMER);
		((ItemAccessor) SOFT_HAMMER ).setRecipeRemainder(SOFT_HAMMER);
		((ItemAccessor) STEEL_FILE ).setRecipeRemainder(STEEL_FILE);
		((ItemAccessor) STEEL_WRENCH ).setRecipeRemainder(STEEL_WRENCH);
		((ItemAccessor) STEEL_SCREWDRIVER ).setRecipeRemainder(STEEL_SCREWDRIVER);
		((ItemAccessor) STEEL_SAW ).setRecipeRemainder(STEEL_SAW);
		((ItemAccessor) POCKET_KNIFE ).setRecipeRemainder(POCKET_KNIFE);
		((ItemAccessor) CROWBAR ).setRecipeRemainder(CROWBAR);
	}

	public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
					new Identifier(MOD_ID, "item"))
			.icon(() -> new ItemStack(ORANGE))
			.appendItems(stacks -> {
				// Material
				stacks.add(new ItemStack(V1_MOTOR));
				stacks.add(new ItemStack(STEEL_POLE));
				stacks.add(new ItemStack(MAGNETIZED_STEEL_ROD));
				stacks.add(new ItemStack(STEEL_PLATE));
				stacks.add(new ItemStack(BRONZE_PLATE));
				stacks.add(new ItemStack(COPPER_COIL));
				stacks.add(new ItemStack(ASHES));

				// Ore/Ingot
				stacks.add(new ItemStack(COKING_COAL));
				stacks.add(new ItemStack(TIN_INGOT));
				stacks.add(new ItemStack(NICKEL_INGOT));
				stacks.add(new ItemStack(BRONZE_INGOT));
				stacks.add(new ItemStack(GLITTERING_INGOT));
				stacks.add(new ItemStack(STEEL_INGOT));
				stacks.add(new ItemStack(IRIDIUM_INGOT));
				stacks.add(new ItemStack(IRIDIUM_ORE));
				stacks.add(new ItemStack(DEEPSTALTE_IRIDIUM_ORE));
				stacks.add(new ItemStack(TIN_ORE));
				stacks.add(new ItemStack(DEEPSTALE_TIN_ORE));
				// Machine
				stacks.add(new ItemStack(EARTH_BLAST_FURNACE));
				stacks.add(new ItemStack(COKE_OVEN));
				stacks.add(new ItemStack(BRONZE_SHELL));

				// Block
				stacks.add(new ItemStack(STEEL_CHEST));

				// fluid
				stacks.add(new ItemStack(CREOSOTE_OIL));
				// Food
				stacks.add(new ItemStack(ORANGE));
				// Tool
				stacks.add(new ItemStack(STEEL_FILE));
				stacks.add(new ItemStack(STEEL_HAMMER));
				stacks.add(new ItemStack(STEEL_WRENCH));
				stacks.add(new ItemStack(SOFT_HAMMER));

				stacks.add(new ItemStack(STEEL_SCREWDRIVER));
				stacks.add(new ItemStack(STEEL_SAW));
				stacks.add(new ItemStack(POCKET_KNIFE));
				stacks.add(new ItemStack(CROWBAR));

				stacks.add(new ItemStack(STEEL_SWORD));
				stacks.add(new ItemStack(STEEL_HOE));
				stacks.add(new ItemStack(STEEL_PICKAXE));
				stacks.add(new ItemStack(STEEL_SHOVEL));
				stacks.add(new ItemStack(STEEL_AXE));
			})
			.build();
	@Override
	public void onInitialize() {
		LOGGER.info("OrangeTech: Hello Minecraft");

		// RecipeRegister
		Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, EarthBlastFurnaceRecipe.Serializer.ID),
				EarthBlastFurnaceRecipe.Serializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, EarthBlastFurnaceRecipe.Type.ID),
				EarthBlastFurnaceRecipe.Type.INSTANCE);

		// Item
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "coking_coal"), COKING_COAL);FuelRegistry.INSTANCE.add(COKING_COAL, 2400);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "orange"), ORANGE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_ingot"), STEEL_INGOT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "tin_ingot"), TIN_INGOT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nickel_ingot"), NICKEL_INGOT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bronze_ingot"), BRONZE_INGOT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "glittering_ingot"), GLITTERING_INGOT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iridium_ingot"), IRIDIUM_INGOT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_hoe"), STEEL_HOE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_sword"), STEEL_SWORD);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_pickaxe"), STEEL_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_axe"), STEEL_AXE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_shovel"), STEEL_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_pole"), STEEL_POLE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ashes"), ASHES);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_plate"), STEEL_PLATE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bronze_plate"), BRONZE_PLATE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_hammer"), STEEL_HAMMER);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_file"), STEEL_FILE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_wrench"), STEEL_WRENCH);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "soft_hammer"), SOFT_HAMMER);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_screwdriver"), STEEL_SCREWDRIVER);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_saw"), STEEL_SAW);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pocket_knife"), POCKET_KNIFE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crowbar"), CROWBAR);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "v1_motor"), V1_MOTOR);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "creosote_oil"), CREOSOTE_OIL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "copper_coil"), COPPER_COIL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "magnetized_steel_rod"), MAGNETIZED_STEEL_ROD);
		// BLOCK_ITEM
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iridium_ore"), new Iridium_Ore(IRIDIUM_ORE, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "coke_oven"), new Coke_Oven_Item(COKE_OVEN, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "earth_blast_furnace"), new Earth_Blast_Furnace_Item(EARTH_BLAST_FURNACE, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_chest"), new BlockItem(STEEL_CHEST, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "break_block"), new BlockItem(BREAK_BLOCK, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "deepslate_iridium_ore"), new Deepslate_Iridium_Ore(DEEPSTALTE_IRIDIUM_ORE, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "deepslate_tin_ore"), new Deepslate_Tin_Ore(DEEPSTALE_TIN_ORE, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "tin_ore"), new Tin_Ore(TIN_ORE, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bronze_shell"), new Bronze_Shell(BRONZE_SHELL, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steam_turbine"), new Steam_Turbine_Item(STEAM_TURBINE, new Item.Settings()));
		// BlockEntity
		STEAM_TURBINE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "steam_turbine"), FabricBlockEntityTypeBuilder.create(SteamTurbineEntity::new,STEAM_TURBINE).build(null));

		BREAK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "break_block"), FabricBlockEntityTypeBuilder.create(BreakEntity::new,BREAK_BLOCK).build(null));
		STEEL_CHEST_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "steel_chest"), FabricBlockEntityTypeBuilder.create(SteelChestEntity::new,STEEL_CHEST).build(null));
		EARTH_BLAST_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "earth_blast_furnace"), FabricBlockEntityTypeBuilder.create(EarthBlastFurnaceEntity::new,EARTH_BLAST_FURNACE).build(null));
		COKE_OVEN_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "coke_oven"), FabricBlockEntityTypeBuilder.create(CokeOvenEntity::new,COKE_OVEN).build(null));
		// Block
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "iridium_ore"), IRIDIUM_ORE);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "break_block"), BREAK_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "steel_chest"), STEEL_CHEST);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "earth_blast_furnace"), EARTH_BLAST_FURNACE);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "coke_oven"), COKE_OVEN);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "bronze_shell"), BRONZE_SHELL);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "deepslate_tin_ore"), DEEPSTALE_TIN_ORE);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "deepslate_iridium_ore"), DEEPSTALTE_IRIDIUM_ORE);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "tin_ore"), TIN_ORE);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "steam_turbine"), STEAM_TURBINE);
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModOreGeneration.generateOres();
	}
}
