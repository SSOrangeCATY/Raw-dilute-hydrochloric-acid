package net.ssorangecaty.hydrochloric;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.command.argument.MessageArgumentType;
import net.minecraft.entity.damage.BadRespawnPointDamageSource;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.server.command.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.TeleportTarget;
import net.ssorangecaty.hydrochloric.generation.ModItemGroupSet;
import net.ssorangecaty.hydrochloric.generation.item.ModItemRegister;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.ssorangecaty.hydrochloric.integration.ServerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

import java.util.Calendar;
import java.util.function.ToIntFunction;


public class Mod implements ModInitializer {
	private static final SimpleCommandExceptionType INSTALL_CHECK_FAIL = new SimpleCommandExceptionType(Text.literal("本存档已经安装了生稀盐酸请勿重复安装!").formatted(Formatting.RED));
	private static final SimpleCommandExceptionType INSTALL_CHECK_SUCCESS = new SimpleCommandExceptionType(Text.literal("本存档还未安装生稀盐酸模组,请使用install指令进行安装!").formatted(Formatting.RED));
	public static final String MOD_ID = "hydrochloric";
	public static final String VERSION = "版本: Demo 23w05a CodeTesting 0.1";
	public static final Logger LOGGER = LoggerFactory.getLogger("Hydrochloric");
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
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			// You can see we use the function getServer() that's on the player.
			ServerState serverState = ServerState.getServerState(handler.player.world.getServer());
			// Sending the packet to the player (look at the networking page for more information)
			PacketByteBuf data = PacketByteBufs.create();
			data.writeBoolean(serverState.installCheck);
			ServerPlayNetworking.send(handler.player, new Identifier(MOD_ID,"installcheck"), data);
		});
        LOGGER.info(Mod.MOD_ID+": Hello Minecraft,Mod now loading");
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("install").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("uninstall").executes(context -> {
			if(!ServerState.installCheck){
				throw INSTALL_CHECK_SUCCESS.create();
			}
			ServerState.installCheck = false;
			context.getSource().sendMessage(Text.literal("安装限制已解除,可以继续使用install指令安装模组").formatted(Formatting.GREEN));
			return 1;
		}))
				.executes(context -> {
					if (ServerState.installCheck){
						throw INSTALL_CHECK_FAIL.create();
					}
                    context.getSource().sendMessage(Text.literal("服务器进入模组安装阶段").formatted(Formatting.RED));
					boolean cache;
					cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.KEEP_INVENTORY);
                    context.getSource().getWorld().getGameRules().get(GameRules.KEEP_INVENTORY).set(false,context.getSource().getServer());
					context.getSource().sendMessage(Text.literal("死亡不掉落 "+ cache + " → " + context.getSource().getWorld().getGameRules().getBoolean(GameRules.KEEP_INVENTORY)));
					cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_IMMEDIATE_RESPAWN);
					context.getSource().getWorld().getGameRules().get(GameRules.DO_IMMEDIATE_RESPAWN).set(true,context.getSource().getServer());
					context.getSource().sendMessage(Text.literal("自动重生 "+ cache + " → " + context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_IMMEDIATE_RESPAWN)));
					cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE);
					context.getSource().getWorld().getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).set(false,context.getSource().getServer());
					context.getSource().sendMessage(Text.literal("昼夜交替 "+ cache + " → " + context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE)));
					cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_WEATHER_CYCLE);
					context.getSource().getWorld().getGameRules().get(GameRules.DO_WEATHER_CYCLE).set(false,context.getSource().getServer());
					context.getSource().sendMessage(Text.literal("天气交替 "+ cache + " → " + context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_WEATHER_CYCLE)));
					cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.LOG_ADMIN_COMMANDS);
					context.getSource().getWorld().getGameRules().get(GameRules.LOG_ADMIN_COMMANDS).set(false,context.getSource().getServer());
					context.getSource().sendMessage(Text.literal("日志输出 "+ cache + " → " + context.getSource().getWorld().getGameRules().getBoolean(GameRules.LOG_ADMIN_COMMANDS)));
					cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_FIRE_TICK);
					context.getSource().getWorld().getGameRules().get(GameRules.DO_FIRE_TICK).set(false,context.getSource().getServer());
					context.getSource().sendMessage(Text.literal("火焰蔓延 "+ cache + " → " + context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_FIRE_TICK)));
					int intCache = context.getSource().getWorld().getGameRules().getInt(GameRules.SPAWN_RADIUS);
					context.getSource().getWorld().getGameRules().get(GameRules.SPAWN_RADIUS).set(0,context.getSource().getServer());
					context.getSource().sendMessage(Text.literal("重生范围 "+ intCache + " → " + context.getSource().getWorld().getGameRules().getInt(GameRules.SPAWN_RADIUS)));
					String stringCache = context.getSource().getWorld().getSpawnPos().toShortString();
					context.getSource().getWorld().setSpawnPos(new BlockPos(0,328,0),0);
					context.getSource().sendMessage(Text.literal("世界出生点 "+ stringCache + " → " + context.getSource().getWorld().getSpawnPos().toShortString()));
					context.getSource().getServer().getCommandFunctionManager().execute(context.getSource().getServer().getCommandFunctionManager()
							.getFunction(new Identifier("raw","scoreboard/install")).get(), context.getSource().withSilent().withMaxLevel(4));
					Calendar c = Calendar.getInstance();
					context.getSource().sendMessage(Text.literal("当前时间: "+ c.get(Calendar.HOUR_OF_DAY)+" : "+c.get(Calendar.MINUTE)+" : "+c.get(Calendar.SECOND)).formatted(Formatting.GREEN));
					ServerState.installCheck = true;
					return 1;
                })));
		ModItemRegister.registerModItems();
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