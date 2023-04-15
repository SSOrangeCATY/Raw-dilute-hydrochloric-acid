package net.ssorangecaty.hydrochloric.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class HudInGameMixin extends DrawableHelper {
    @Shadow @Final private MinecraftClient client;

    @Shadow public abstract TextRenderer getTextRenderer();

    @Shadow private long heartJumpEndTick;

    @Shadow private int ticks;

    @Shadow private int lastHealthValue;

    @Shadow private long lastHealthCheckTime;

    @Shadow private int renderHealthValue;

    @Shadow @Final private Random random;

    @Shadow private int scaledWidth;

    @Shadow private int scaledHeight;

    @Shadow protected abstract int getHeartRows(int heartCount);

    @Shadow protected abstract PlayerEntity getCameraPlayer();

    @Shadow protected abstract void renderHealthBar(MatrixStack matrices, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking);

    @Shadow protected abstract LivingEntity getRiddenEntity();

    @Shadow protected abstract int getHeartCount(LivingEntity entity);

    @Shadow protected abstract void drawTextBackground(MatrixStack matrices, TextRenderer textRenderer, int yOffset, int width, int color);

    @Inject(method = "render",at = @At("HEAD"))
    private void render(MatrixStack matrices, float tickDelta, CallbackInfo ci){
        this.getTextRenderer().drawWithShadow(matrices, Text.literal("Demo Version"),5,5,0x00FF7F);
        // this.getTextRenderer().drawWithShadow(matrices, Text.literal(Mod.VERSION),5,15,0x00FFFF);
    }
    private void musicRender(MatrixStack matrices){
    }
    /**
     * @author
     * @reason
     */
    @Overwrite
    private void renderStatusBars(MatrixStack matrices) {
        int ac;
        int ab;
        int aa;
        int z;
        int y;
        int x;
        PlayerEntity playerEntity = this.getCameraPlayer();
        if (playerEntity == null) {
            return;
        }
        int i = MathHelper.ceil(playerEntity.getHealth());
        boolean bl = this.heartJumpEndTick > (long)this.ticks && (this.heartJumpEndTick - (long)this.ticks) / 3L % 2L == 1L;
        long l = Util.getMeasuringTimeMs();
        if (i < this.lastHealthValue && playerEntity.timeUntilRegen > 0) {
            this.lastHealthCheckTime = l;
            this.heartJumpEndTick = this.ticks + 20;
        } else if (i > this.lastHealthValue && playerEntity.timeUntilRegen > 0) {
            this.lastHealthCheckTime = l;
            this.heartJumpEndTick = this.ticks + 10;
        }
        if (l - this.lastHealthCheckTime > 1000L) {
            this.lastHealthValue = i;
            this.renderHealthValue = i;
            this.lastHealthCheckTime = l;
        }
        this.lastHealthValue = i;
        int j = this.renderHealthValue;
        this.random.setSeed(this.ticks * 312871);
        HungerManager hungerManager = playerEntity.getHungerManager();
        int k = hungerManager.getFoodLevel() / 5;
        int m = this.scaledWidth / 2 - 91;
        int n = this.scaledWidth / 2 + 91;
        int o = this.scaledHeight - 39;
        float f = Math.max((float)playerEntity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH), (float)Math.max(j, i));
        int p = MathHelper.ceil(playerEntity.getAbsorptionAmount());
        int q = MathHelper.ceil((f + (float)p) / 2.0f / 10.0f);
        int r = Math.max(10 - (q - 2), 3);
        int s = o - (q - 1) * r - 10;
        int t = o - 10;
        int u = playerEntity.getArmor();
        int v = -1;
        if (playerEntity.hasStatusEffect(StatusEffects.REGENERATION)) {
            v = this.ticks % MathHelper.ceil(f + 5.0f);
        }
        this.client.getProfiler().push("armor");
        for (int w = 0; w < 10; ++w) {
            if (u <= 0) continue;
            x = m + w * 8;
            if (w * 2 + 1 < u) {
                this.drawTexture(matrices, x, s, 34, 9, 9, 9);
            }
            if (w * 2 + 1 == u) {
                this.drawTexture(matrices, x, s, 25, 9, 9, 9);
            }
            if (w * 2 + 1 <= u) continue;
            this.drawTexture(matrices, x, s, 16, 9, 9, 9);
        }
        this.client.getProfiler().swap("health");
        this.client.getProfiler().pop();
    }
    public void renderHealthBar(MatrixStack matrices, int x) {
        float program = this.client.player.getHealth() / this.client.player.getMaxHealth();
        this.client.getProfiler().push("health");
        RenderSystem.setShaderTexture(0, DrawableHelper.GUI_ICONS_TEXTURE);
        int k;
        int l;
        boolean j = true;
            k = (int)(program * 183.0F);
            l = this.scaledHeight - 32 - 3;
            drawTexture(matrices, x, l, 0, 84, 182, 5);
        if (k > 0) {
            drawTexture(matrices, x, l, 0, 89, k, 5);
        }

        this.client.getProfiler().pop();
        if (this.client.player.getHealth() > 0) {
            this.client.getProfiler().push("health");
            String string = String.format("%.1f", this.client.player.getHealth()) + "/" +this.client.player.getMaxHealth();
            float progress = this.client.player.getHealth() / this.client.player.getMaxHealth();
            int startRed = 0x8B;
            int startGreen = 0x00;
            int startBlue = 0x00;
            int endRed = 0x00;
            int endGreen = 0xFF;
            int endBlue = 0x00;

            int red = (int) (startRed + progress * (endRed - startRed));
            int green = (int) (startGreen + progress * (endGreen - startGreen));
            int blue = (int) (startBlue + progress * (endBlue - startBlue));

            int color = 0xFF000000 | (red << 16) | (green << 8) | blue;

            k = (this.scaledWidth - this.getTextRenderer().getWidth(string)) / 2;
            l = this.scaledHeight - 31 - 12;
            this.getTextRenderer().draw(matrices, string, (float)(k + 1), (float)l, 0);
            this.getTextRenderer().draw(matrices, string, (float)(k - 1), (float)l, 0);
            this.getTextRenderer().draw(matrices, string, (float)k, (float)(l + 1), 0);
            this.getTextRenderer().draw(matrices, string, (float)k, (float)(l - 1), 0);
            this.getTextRenderer().draw(matrices, string, (float)k, (float)l, color);
            this.client.getProfiler().pop();
        }

    }
    /**
     * @author
     * @reason
     */
    @Overwrite
    public void renderExperienceBar(MatrixStack matrices, int x) {
        this.renderHealthBar(matrices,x);
        this.client.getProfiler().push("expBar");
        RenderSystem.setShaderTexture(0, DrawableHelper.GUI_ICONS_TEXTURE);
        int i = this.client.player.getNextLevelExperience();
        int k;
        int l;
        if (i > 0) {
            boolean j = true;
            k = (int)(this.client.player.experienceProgress * 183.0F);
            l = this.scaledHeight - 32 + 3;
            drawTexture(matrices, x, l, 0, 64, 182, 5);
            if (k > 0) {
                drawTexture(matrices, x, l, 0, 69, k, 5);
            }
        }

        this.client.getProfiler().pop();
        if (this.client.player.experienceLevel > 0) {
            this.client.getProfiler().push("expLevel");
            String string = "" + this.client.player.experienceLevel;
            k = (this.scaledWidth - this.getTextRenderer().getWidth(string)) / 2;
            l = this.scaledHeight - 31;
            this.getTextRenderer().draw(matrices, string, (float)(k + 1), (float)l, 0);
            this.getTextRenderer().draw(matrices, string, (float)(k - 1), (float)l, 0);
            this.getTextRenderer().draw(matrices, string, (float)k, (float)(l + 1), 0);
            this.getTextRenderer().draw(matrices, string, (float)k, (float)(l - 1), 0);
            this.getTextRenderer().draw(matrices, string, (float)k, (float)l, 8453920);
            this.client.getProfiler().pop();
        }

    }
}
