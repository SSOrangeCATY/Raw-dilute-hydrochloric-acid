package net.ssorangecaty.hydrochloric.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.GameRules;
import net.ssorangecaty.hydrochloric.generation.item.HydrochloricItemRegister;
import net.ssorangecaty.hydrochloric.integration.HydrochloricServerState;
import net.ssorangecaty.hydrochloric.network.data.HydrochloricEvents;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import net.ssorangecaty.hydrochloric.util.InternetUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Calendar;
import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public abstract class HydrochloricSyncTickMixin {
    int weatherTick =0;
    Calendar c = Calendar.getInstance();
    @Shadow public abstract ServerWorld getOverworld();
    @Inject(at = @At("HEAD"), method = "tick")
    private void syncRealWorld(BooleanSupplier shouldKeepTicking, CallbackInfo ci) throws Exception {
        if(this.getOverworld().getServer().getGameRules().getBoolean(HydrochloricEvents.SYNC_REAL_WORLD) &&
                this.getOverworld().getServer().getGameRules().getBoolean(GameRules.DO_WEATHER_CYCLE) ||
                this.getOverworld().getServer().getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE)){
            this.getOverworld().getServer().getGameRules().get(GameRules.DO_WEATHER_CYCLE).set(false,this.getOverworld().getServer());
            this.getOverworld().getServer().getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).set(false,this.getOverworld().getServer());
        }
        syncTime();
        if(weatherTick >= 12000){
            syncWeather();
        }
    }
    private void syncTime(){
        if(this.getOverworld().getServer().getGameRules().getBoolean(HydrochloricEvents.SYNC_REAL_WORLD)){
            weatherTick++;
            int month = c.get(Calendar.MONTH);
            long hour;
            if (month >= 2 && month <= 4) {
                hour = 18000 + c.get(Calendar.HOUR_OF_DAY)*1000;
            } else if (month >= 5 && month <= 7) {
                hour = 18000 + (c.get(Calendar.HOUR_OF_DAY)+1)*1000;
            } else if (month >= 8 && month <= 10) {
                hour = 18000 + c.get(Calendar.HOUR_OF_DAY)*1000;
            } else {
                hour = 18000 + (c.get(Calendar.HOUR_OF_DAY)-1)*1000;
            }
            long minute = (long) (c.get(Calendar.MINUTE)*16.67);
            long second = (long) (c.get(Calendar.SECOND)*0.278);
            this.getOverworld().setTimeOfDay(hour + minute + second);
        }
    }
        private void syncWeather() throws Exception {
        // 10分钟更新一次
                String weather = InternetUtil.getWeather(HydrochloricServerState.getServerState(this.getOverworld().getServer()).weatherCity);
                for (ServerPlayerEntity player : this.getOverworld().getServer().getPlayerManager().getPlayerList()){
                    player.sendMessage(Text.literal("SyncGameRule: 当前"+ HydrochloricServerState.getServerState(this.getOverworld().getServer()).weatherCity+"的天气为"+weather).formatted(Formatting.LIGHT_PURPLE));
                }
                if(weather.contains("晴")){
                    this.getOverworld().setWeather(-1,0,false,false);
                }else if (weather.contains("雨") && !weather.contains("大") && !weather.contains("暴")) {
                    this.getOverworld().setWeather(0,-1,true,false);
                }else if(weather.contains("雨") && weather.contains("大") || weather.contains("暴") || weather.contains("雷") || weather.contains("龙卷风") || weather.contains("雪")){
                    this.getOverworld().setWeather(0,-1,true,true);
                }else this.getOverworld().setWeather(-1,0, false,false);
                weatherTick = 0;
        }
    @Inject(at = @At("HEAD"), method = "tick")
    private void checkPlayerInv(BooleanSupplier shouldKeepTicking, CallbackInfo ci){
        for(ServerPlayerEntity player : this.getOverworld().getServer().getPlayerManager().getPlayerList()){
            if(!player.getInventory().contains(new ItemStack(HydrochloricItemRegister.KKDY))){
                ((EntityGameDataSaver)player).getGameInfo().putBoolean("kkdySkill",false);
            }
        }
    }
}
