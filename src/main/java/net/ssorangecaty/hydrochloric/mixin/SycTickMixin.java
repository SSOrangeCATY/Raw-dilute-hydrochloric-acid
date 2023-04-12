package net.ssorangecaty.hydrochloric.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Calendar;
import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public abstract class SycTickMixin {
    @Shadow public abstract ServerWorld getOverworld();
    @Inject(at = @At("HEAD"), method = "tick")
    private void SycRealTime(BooleanSupplier shouldKeepTicking, CallbackInfo ci){
        Calendar c = Calendar.getInstance();
        long hour = 18000 + c.get(Calendar.HOUR_OF_DAY)*1000;
        long minute = (long) (c.get(Calendar.MINUTE)*16.67);
        long second = (long) (c.get(Calendar.SECOND)*0.278);
        this.getOverworld().setTimeOfDay(hour + minute + second);
        }
    }
