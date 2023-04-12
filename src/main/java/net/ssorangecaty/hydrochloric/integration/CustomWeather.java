package net.ssorangecaty.hydrochloric.integration;

import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.GameRules;

public class CustomWeather {
    // 根据关卡来更换相应的天气
    public static final IntProvider ACID_RAIN = UniformIntProvider.create(12000, 24000);
    public static int processDuration(ServerCommandSource source, int duration, IntProvider provider) {
        if (duration == -1) {
            return provider.get(source.getWorld().getRandom());
        }
        return duration;
    }
    /*private void tickWeather() {
        boolean bl = this.isRaining();
        if (this.getDimension().hasSkyLight()) {
            if (this.getGameRules().getBoolean(GameRules.DO_WEATHER_CYCLE)) {
                int i = this.worldProperties.getClearWeatherTime();
                int j = this.worldProperties.getThunderTime();
                int k = this.worldProperties.getRainTime();
                boolean bl2 = this.properties.isThundering();
                boolean bl3 = this.properties.isRaining();
                if (i > 0) {
                    --i;
                    j = bl2 ? 0 : 1;
                    k = bl3 ? 0 : 1;
                    bl2 = false;
                    bl3 = false;
                } else {
                    if (j > 0) {
                        if (--j == 0) {
                            bl2 = !bl2;
                        }
                    } else {
                        j = bl2 ? THUNDER_WEATHER_DURATION_PROVIDER.get(this.random) : CLEAR_THUNDER_WEATHER_DURATION_PROVIDER.get(this.random);
                    }
                    if (k > 0) {
                        if (--k == 0) {
                            bl3 = !bl3;
                        }
                    } else {
                        k = bl3 ? RAIN_WEATHER_DURATION_PROVIDER.get(this.random) : CLEAR_WEATHER_DURATION_PROVIDER.get(this.random);
                    }
                }
                this.worldProperties.setThunderTime(j);
                this.worldProperties.setRainTime(k);
                this.worldProperties.setClearWeatherTime(i);
                this.worldProperties.setThundering(bl2);
                this.worldProperties.setRaining(bl3);
            }
            this.thunderGradientPrev = this.thunderGradient;
            this.thunderGradient = this.properties.isThundering() ? (this.thunderGradient += 0.01f) : (this.thunderGradient -= 0.01f);
            this.thunderGradient = MathHelper.clamp(this.thunderGradient, 0.0f, 1.0f);
            this.rainGradientPrev = this.rainGradient;
            this.rainGradient = this.properties.isRaining() ? (this.rainGradient += 0.01f) : (this.rainGradient -= 0.01f);
            this.rainGradient = MathHelper.clamp(this.rainGradient, 0.0f, 1.0f);
        }
        if (this.rainGradientPrev != this.rainGradient) {
            this.server.getPlayerManager().sendToDimension(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.RAIN_GRADIENT_CHANGED, this.rainGradient), this.getRegistryKey());
        }
        if (this.thunderGradientPrev != this.thunderGradient) {
            this.server.getPlayerManager().sendToDimension(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.THUNDER_GRADIENT_CHANGED, this.thunderGradient), this.getRegistryKey());
        }
        if (bl != this.isRaining()) {
            if (bl) {
                this.server.getPlayerManager().sendToAll(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.RAIN_STOPPED, GameStateChangeS2CPacket.DEMO_OPEN_SCREEN));
            } else {
                this.server.getPlayerManager().sendToAll(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.RAIN_STARTED, GameStateChangeS2CPacket.DEMO_OPEN_SCREEN));
            }
            this.server.getPlayerManager().sendToAll(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.RAIN_GRADIENT_CHANGED, this.rainGradient));
            this.server.getPlayerManager().sendToAll(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.THUNDER_GRADIENT_CHANGED, this.thunderGradient));
        }
    }*/
}
