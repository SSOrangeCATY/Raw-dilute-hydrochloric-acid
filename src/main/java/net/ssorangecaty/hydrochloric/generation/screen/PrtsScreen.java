package net.ssorangecaty.hydrochloric.generation.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import me.x150.renderer.font.FontRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.network.data.HydrochloricEvents;
import net.ssorangecaty.hydrochloric.util.ArkData;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class PrtsScreen extends HandledScreen<PrtsScreenHandler>{
    Font[] font1 = new Font[1];
    Font[] font2 = new Font[1];
    {
        try {
            InputStream inputStream1 = ArkData.class.getResourceAsStream("/assets/hydrochloric/textures/afont.ttf");
            if (inputStream1 != null) {
                font1[0] = Font.createFont(Font.TRUETYPE_FONT, inputStream1);
            }
            InputStream inputStream2 = ArkData.class.getResourceAsStream("/assets/hydrochloric/textures/font.otf");
            if (inputStream2 != null) {
                font2[0] = Font.createFont(Font.TRUETYPE_FONT, inputStream2);
            }
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    FontRenderer fontRendererB = new FontRenderer(font1, 20);
    FontRenderer fontRenderer1 = new FontRenderer(font2,30);
    FontRenderer fontRendererE = new FontRenderer(font2,15);
    MinecraftClient mc = MinecraftClient.getInstance();
    private static final Identifier TEXTURE = new Identifier("hydrochloric","textures/gui/prts_screen.png");


    public PrtsScreen(PrtsScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public void close() {
        this.client.getSoundManager().stopSounds(HydrochloricEvents.MIZUKI_MUSIC1, SoundCategory.PLAYERS);
        this.client.setScreen((Screen)null);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,0.99f);
        RenderSystem.setShaderTexture(0,TEXTURE);
        TextureManager textureManager = mc.getTextureManager();
        AbstractTexture texture = textureManager.getTexture(TEXTURE);
        int textureId = texture.getGlId();
        GlStateManager._bindTexture(textureId);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
        drawTexture(matrices,x,y,0,0,x+256,y+256,256,256);
    }
    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
    }
    protected void drawRoleImage(MatrixStack matrices){
    }
    protected void drawTextElements(MatrixStack matrices){
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return super.mouseClicked(mouseX, mouseY, button);
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        int i = this.x;
        int j = this.y;
        this.drawBackground(matrices, delta, mouseX, mouseY);
        RenderSystem.disableDepthTest();
        super.render(matrices, mouseX, mouseY, delta);
        this.drawRoleImage(matrices);
        drawTextElements(matrices);
        matrices.push();
        matrices.translate((float)i, (float)j, 0.0F);
    }

}
