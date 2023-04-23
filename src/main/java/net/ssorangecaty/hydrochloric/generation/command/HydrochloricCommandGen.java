package net.ssorangecaty.hydrochloric.generation.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.ssorangecaty.hydrochloric.integration.HydrochloricServerState;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import net.ssorangecaty.hydrochloric.util.HungerData;
import net.ssorangecaty.hydrochloric.util.InternetUtil;

import static net.minecraft.server.command.CommandManager.literal;

public class HydrochloricCommandGen {
    private static final SimpleCommandExceptionType INSTALL_CHECK_FAIL = new SimpleCommandExceptionType(Text.literal("本存档已经安装了生稀盐酸请勿重复安装!").formatted(Formatting.RED));
    private static final SimpleCommandExceptionType INSTALL_CHECK_SUCCESS = new SimpleCommandExceptionType(Text.literal("本存档还未安装生稀盐酸模组,请使用install指令进行安装!").formatted(Formatting.RED));

    public static void registerCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("debugger")
                .requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("hunger").executes(context -> {
                    HungerData.resetHunger((EntityGameDataSaver) context.getSource().getPlayer());
                    context.getSource().sendMessage(Text.literal("已经重置hunger值").formatted(Formatting.GREEN));
                    return 1;
                }))));
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("sync")
                .requires(source -> source.hasPermissionLevel(4)).then(CommandManager.argument("city", StringArgumentType.greedyString())
                .executes(context -> {
                    String city = StringArgumentType.getString(context, "city");
                    try {
                        syncWeather(context,city);
                        HydrochloricServerState.getServerState(context.getSource().getWorld().getServer()).weatherCity = city;
                        context.getSource().sendMessage((Text.literal("[SUCCESS] ").formatted(Formatting.GREEN))
                                .append(Text.literal(context.getSource().getName()+" 同步城市已变更为 " + city).formatted(Formatting.GRAY)));
                        return 1;
                    } catch (Exception e) {
                        context.getSource().sendMessage((Text.literal("[FAIL] ").formatted(Formatting.RED))
                                .append(Text.literal(context.getSource().getName()+" "+city+"城市变更失败API未返回数据,可能尚未拥有该地区数据").formatted(Formatting.GRAY)));
                        return 0;
                    }
                })
        )));
    }
    public static void syncWeather(CommandContext<ServerCommandSource> context, String city) throws Exception {
        String weather = InternetUtil.getWeather(city);
        context.getSource().sendMessage(Text.literal("SyncGameRule: "+city+"当前的天气为"+weather));
        if(weather.contains("晴")){
            context.getSource().getWorld().setWeather(-1,0,false,false);
        }else if (weather.contains("雨") && !weather.contains("大") && !weather.contains("暴")) {
            context.getSource().getWorld().setWeather(0,-1,true,false);
        }else if(weather.contains("雨") && weather.contains("大") || weather.contains("暴") || weather.contains("雷") || weather.contains("龙卷风")){
            context.getSource().getWorld().setWeather(0,-1,true,true);
        }else context.getSource().getWorld().setWeather(0,0, false,false);
    }
}
