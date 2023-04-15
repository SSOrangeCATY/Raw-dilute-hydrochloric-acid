package net.ssorangecaty.hydrochloric.generation.command;

import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.StopSoundCommand;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import net.ssorangecaty.hydrochloric.util.HungerData;

import java.util.Calendar;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandGen {
    private static final SimpleCommandExceptionType INSTALL_CHECK_FAIL = new SimpleCommandExceptionType(Text.literal("本存档已经安装了生稀盐酸请勿重复安装!").formatted(Formatting.RED));
    private static final SimpleCommandExceptionType INSTALL_CHECK_SUCCESS = new SimpleCommandExceptionType(Text.literal("本存档还未安装生稀盐酸模组,请使用install指令进行安装!").formatted(Formatting.RED));

    public static void registerCommand() {

        /*CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("install").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("uninstall").executes(context -> {
                    ServerState serverState = ServerState.getServerState(context.getSource().getServer());
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
                    context.getSource().sendMessage(Text.literal("死亡不掉落 ").formatted(Formatting.GREEN)
                            .append(Text.literal(""+cache).formatted(Formatting.AQUA)).append(Text.literal(" → ").formatted(Formatting.GOLD))
                            .append(Text.literal(""+context.getSource().getWorld().getGameRules().getBoolean(GameRules.KEEP_INVENTORY)).formatted(Formatting.AQUA)));
                    cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_IMMEDIATE_RESPAWN);
                    context.getSource().getWorld().getGameRules().get(GameRules.DO_IMMEDIATE_RESPAWN).set(true,context.getSource().getServer());
                    context.getSource().sendMessage(Text.literal("自动重生 ").formatted(Formatting.GREEN)
                            .append(Text.literal(""+cache).formatted(Formatting.AQUA)).append(Text.literal(" → ").formatted(Formatting.GOLD))
                            .append(Text.literal(""+context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_IMMEDIATE_RESPAWN)).formatted(Formatting.AQUA)));
                    cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE);
                    context.getSource().getWorld().getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).set(false,context.getSource().getServer());
                    context.getSource().sendMessage(Text.literal("昼夜交替 ").formatted(Formatting.GREEN)
                            .append(Text.literal(""+cache).formatted(Formatting.AQUA)).append(Text.literal(" → ").formatted(Formatting.GOLD))
                            .append(Text.literal(""+context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE)).formatted(Formatting.AQUA)));
                    cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_WEATHER_CYCLE);
                    context.getSource().getWorld().getGameRules().get(GameRules.DO_WEATHER_CYCLE).set(false,context.getSource().getServer());
                    context.getSource().sendMessage(Text.literal("天气交替 ").formatted(Formatting.GREEN)
                            .append(Text.literal(""+cache).formatted(Formatting.AQUA)).append(Text.literal(" → ").formatted(Formatting.GOLD))
                            .append(Text.literal(""+context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_WEATHER_CYCLE)).formatted(Formatting.AQUA)));
                    cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.LOG_ADMIN_COMMANDS);
                    context.getSource().getWorld().getGameRules().get(GameRules.LOG_ADMIN_COMMANDS).set(false,context.getSource().getServer());
                    context.getSource().sendMessage(Text.literal("信息输出 ").formatted(Formatting.GREEN)
                            .append(Text.literal(""+cache).formatted(Formatting.AQUA)).append(Text.literal(" → ").formatted(Formatting.GOLD))
                            .append(Text.literal(""+context.getSource().getWorld().getGameRules().getBoolean(GameRules.LOG_ADMIN_COMMANDS)).formatted(Formatting.AQUA)));
                    context.getSource().getWorld().getGameRules().get(GameRules.SHOW_DEATH_MESSAGES).set(false,context.getSource().getServer());
                    cache = context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_FIRE_TICK);
                    context.getSource().getWorld().getGameRules().get(GameRules.DO_FIRE_TICK).set(false,context.getSource().getServer());
                    context.getSource().sendMessage(Text.literal("火焰蔓延 ").formatted(Formatting.GREEN)
                            .append(Text.literal(""+cache).formatted(Formatting.AQUA)).append(Text.literal(" → ").formatted(Formatting.GOLD))
                            .append(Text.literal(""+context.getSource().getWorld().getGameRules().getBoolean(GameRules.DO_FIRE_TICK)).formatted(Formatting.AQUA)));
                    int intCache = context.getSource().getWorld().getGameRules().getInt(GameRules.SPAWN_RADIUS);
                    context.getSource().getWorld().getGameRules().get(GameRules.SPAWN_RADIUS).set(0,context.getSource().getServer());
                    context.getSource().sendMessage(Text.literal("重生范围 ").formatted(Formatting.GREEN)
                            .append(Text.literal(""+intCache).formatted(Formatting.AQUA)).append(Text.literal(" → ").formatted(Formatting.GOLD))
                            .append(Text.literal(""+context.getSource().getWorld().getGameRules().getInt(GameRules.SPAWN_RADIUS)).formatted(Formatting.AQUA)));
                    String stringCache = context.getSource().getWorld().getSpawnPos().toShortString();
                    context.getSource().getWorld().setSpawnPos(context.getSource().getPlayer().getBlockPos(),0);
                    context.getSource().sendMessage((Text.literal("世界出生点 ").formatted(Formatting.GREEN)
                            .append(Text.literal(""+stringCache).formatted(Formatting.AQUA)).append(Text.literal(" → ").formatted(Formatting.GOLD))
                            .append(Text.literal(""+context.getSource().getWorld().getSpawnPos().toShortString()).formatted(Formatting.AQUA))));
                    context.getSource().getServer().getCommandFunctionManager().execute(context.getSource().getServer().getCommandFunctionManager()
                            .getFunction(new Identifier("raw","scoreboard/install")).get(), context.getSource().withSilent().withMaxLevel(4));
                    Calendar c = Calendar.getInstance();
                    context.getSource().sendMessage(Text.literal("当前时间: "+ c.get(Calendar.HOUR_OF_DAY)+" : "+c.get(Calendar.MINUTE)+" : "+c.get(Calendar.SECOND)).formatted(Formatting.GREEN));
                    ServerState.installCheck = true;
                    for (ServerPlayerEntity playerEntity : context.getSource().getServer().getPlayerManager().getPlayerList()){
                        playerEntity.kill();
                    }
                    context.getSource().getServer().getCommandFunctionManager().execute(context.getSource().getServer().getCommandFunctionManager()
                            .getFunction(new Identifier("raw","adventure/install")).get(), context.getSource().withSilent().withMaxLevel(4));
                    return 1;
                })));*/
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("debugger")
                .requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("hunger").executes(context -> {
                    HungerData.resetHunger((EntityGameDataSaver)context.getSource().getPlayer());
                    context.getSource().sendMessage(Text.literal("已经重置hunger值").formatted(Formatting.GREEN));
                    return 1;
                })).then(CommandManager.literal("nbt").executes(context -> {
                    return 1;
                }))));
    }
}
