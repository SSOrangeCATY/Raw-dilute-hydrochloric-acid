package net.ssorangecaty.hydrochloric.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.ssorangecaty.hydrochloric.Mod;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Calendar;

@Mixin(InGameHud.class)
public abstract class HudInGameMixin {
    @Shadow @Final private MinecraftClient client;

    @Shadow public abstract TextRenderer getTextRenderer();

    @Inject(method = "render",at = @At("HEAD"))
    private void render(MatrixStack matrices, float tickDelta, CallbackInfo ci){
        this.getTextRenderer().drawWithShadow(matrices, Text.literal("生稀盐酸早期版本,游戏可能会出现重大错误"),5,5,0x00FF7F);
        this.getTextRenderer().drawWithShadow(matrices, Text.literal(Mod.VERSION),5,15,0x00FFFF);
    }
}
