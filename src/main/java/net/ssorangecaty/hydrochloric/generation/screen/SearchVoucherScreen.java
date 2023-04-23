package net.ssorangecaty.hydrochloric.generation.screen;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import me.x150.renderer.font.FontRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;
import net.ssorangecaty.hydrochloric.network.data.HydrochloricEvents;
import net.ssorangecaty.hydrochloric.util.ArkData;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;


public class SearchVoucherScreen extends HandledScreen<SearchVoucherScreenHandler> {
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
    float animationSize = 3F;
    int drawImage = 0;
    int screenTick = 50;
    private static final Identifier BG_TEXTURE = new Identifier("hydrochloric","textures/gui/gacha/gacha_bg.png");
    private final CharacterGen[] character;
    public SearchVoucherScreen(SearchVoucherScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler,inventory,title);
        this.character = handler.getCharacter();
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 0.99f);
        RenderSystem.setShaderTexture(0, BG_TEXTURE);
        drawTexture(matrices, 0, 0, 0, 0, this.width,this.height,this.width,this.height);
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.drawBackground(matrices, delta, mouseX, mouseY);
        RenderSystem.disableDepthTest();
        super.render(matrices, mouseX, mouseY, delta);
        this.drawCharacters(matrices);
        matrices.push();
    }

    public void drawCharacters(MatrixStack matrices) {
        matrices.push();
        nextAnimation(matrices);
        matrices.pop();
    }
    public void drawCharacter(MatrixStack matrices){
        RenderSystem.setShaderTexture(0,character[drawImage].image);
        MinecraftClient mc = MinecraftClient.getInstance();
        TextureManager textureManager = mc.getTextureManager();
        AbstractTexture texture = textureManager.getTexture(character[drawImage].image);
        int textureId = texture.getGlId();
        GlStateManager._bindTexture(textureId);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
        int x = this.width/2 - this.width/4;
        drawTexture(matrices, x, 0, 0, 0, this.width, this.height, this.height, this.height);
    }
    public void nextAnimation(MatrixStack matrixStack) {
        float color = 0;
        if(screenTick > 0){
            color += 0.02F;
            screenTick--;
            if(character[drawImage].quality>3){
                animationSize -= 0.03F;
            }else animationSize -= 0.04F;
        }else{
            if(character[drawImage].quality>3){
                animationSize =1.5F;
            }else animationSize = 1F;
            color = 1F;
        }
        RenderSystem.setShaderColor(color, color, color, 0.99f);
        float centerX = this.width / 2.0f;
        float centerY = this.height / 2.0f;
        matrixStack.translate(centerX, centerY, 0);
        matrixStack.scale(animationSize, animationSize, 1);
        matrixStack.translate(-centerX, -centerY, 0);
        drawCharacter(matrixStack);
    }
    @Override
    public void close() {
        this.client.getSoundManager().stopSounds(HydrochloricEvents.MIZUKI_MUSIC1, SoundCategory.PLAYERS);
        this.client.setScreen(null);
    }
    public void next(){
        if((drawImage + 1 ) < 10 && character[drawImage+1] != null){
            drawImage += 1;
            animationSize = 3F;
            screenTick = 50;
        }else{
            this.close();
        }
    }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if(button == 0 && screenTick == 0){
            next();
        }
        return false;
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
    }
    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        super.mouseMoved(mouseX, mouseY);
    }
}
