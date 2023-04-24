package net.ssorangecaty.hydrochloric.mixin;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.ssorangecaty.hydrochloric.Hydrochloric;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class HydrochloricHudInGameMixin extends DrawableHelper {

    @Shadow public abstract TextRenderer getTextRenderer();

    @Inject(method = "render",at = @At("HEAD"))
    private void render(MatrixStack matrices, float tickDelta, CallbackInfo ci){
        this.getTextRenderer().drawWithShadow(matrices, Text.literal(Hydrochloric.VERSION),5,5,0x00FF7F);
        // this.getTextRenderer().drawWithShadow(matrices, Text.literal(Hydrochloric.VERSION),5,15,0x00FFFF);
    }
}
