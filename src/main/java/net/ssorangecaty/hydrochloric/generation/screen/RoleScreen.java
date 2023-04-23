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
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;
import net.ssorangecaty.hydrochloric.network.data.HydrochloricEvents;
import net.ssorangecaty.hydrochloric.util.ArkData;
import org.joml.Quaternionf;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class RoleScreen extends HandledScreen<RoleScreenHandler>{
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
    private static final Identifier TEXTURE = new Identifier("hydrochloric","textures/gui/bg_default.png");
    private final CharacterGen role;


    public RoleScreen(RoleScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.role = handler.getCharacter();
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
        drawTexture(matrices,0,0,0,0,this.width,this.height,this.width,this.height);
    }
    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
    }
    protected void drawRoleImage(MatrixStack matrices){
        matrices.push();
        RenderSystem.setShaderTexture(0,role.image);
        MinecraftClient mc = MinecraftClient.getInstance();
        TextureManager textureManager = mc.getTextureManager();
        AbstractTexture texture = textureManager.getTexture(role.image);
        int textureId = texture.getGlId();
        GlStateManager._bindTexture(textureId);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
        float centerX = this.width / 2.0f;
        float centerY = this.height / 2.0f;
        matrices.translate(centerX, centerY, 0);
        if(role.quality > 4){
            matrices.scale(2.5F,2.5F,0);
        }else {
            matrices.scale(1F,1F,0);
        }
        matrices.translate(-centerX, -centerY, 0);
        int x = this.width/2 - this.width/4;
        drawTexture(matrices, x, 0, 0, 0, this.width, this.height, this.height, this.height);
        matrices.pop();
    }
    protected void drawTextElements(MatrixStack matrices){
        float tHeight = (float) (this.height- (float) this.height /3.75);
        float tWidth = 10;
        float strokeWidth = 1.0f; // 描边宽度
// 绘制描边
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    this.fontRenderer1.drawString(matrices, role.cnName, tWidth + dx * strokeWidth,tHeight + dy * strokeWidth,128/255f, 128/255f, 128/255f, 128/255f);
                    this.fontRendererB.drawString(matrices,role.enName,tWidth + dx * strokeWidth,this.height- (float) this.height /3 + dy * strokeWidth,128/255f, 128/255f, 128/255f, 128/255f);
                }
            }
        }
        this.fontRenderer1.drawString(matrices,role.cnName,tWidth,tHeight,1.0f, 1.0f, 1.0f, 1.0f);
        this.fontRendererB.drawString(matrices, role.enName, tWidth ,this.height- (float) this.height /3 ,1.0f, 1.0f, 1.0f, 1.0f);
// 绘制文本
        tHeight = (float) (this.height- (float) this.height /2.5);
        float angleInRadians = (float) Math.toRadians(20); // 将旋转角度改为20度
        Quaternionf quaternion = new Quaternionf(
                0.0F,
                0.0F,
                (float) Math.sin(angleInRadians / 2),
                (float) Math.cos(angleInRadians / 2)
        );
        for (int j = 0; j < role.quality; j++) {
            matrices.push();
            float k = 15 + j * 8;
            matrices.translate(k, tHeight, 0);
            matrices.multiply(quaternion);
            matrices.translate(-k, -tHeight, 0);
            this.fontRendererE.drawString(matrices,"★",k,tHeight,0.5f, 0.5f, 0.5f, 1.0f);
            matrices.pop();
        }

/*
        matrices.push();
        tHeight =this.height- (float) this.height /6;
        tWidth = 10 + this.textRenderer.getWidth(ROLE.cnName);
        matrices.translate(tWidth,tHeight,0);
        matrices.scale(1.5F,1.5F,1F);
        this.textRenderer.draw(matrices,ROLE.characteristic,0,0,0xFFFFFF);
        matrices.pop();
        */
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {/*
        if (button == 0){
            if (ROLE == EnableCharacter.AMIYA) {
                ROLE = EnableCharacter.INES;
            } else {
                ROLE = EnableCharacter.AMIYA;
            }
        }*/
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

    public int getX() {
        return this.width;
    }
    public int getY() {
        return this.height;
    }
}
