package net.archasmiel.thaumcraft.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.archasmiel.thaumcraft.screen.handler.Arcane_WorkbenchScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ArcaneWorkbenchScreen extends HandledScreen<Arcane_WorkbenchScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("thaumcraft","textures/gui/thaumonomicon/gui_arcaneworkbench.png");


    public ArcaneWorkbenchScreen(Arcane_WorkbenchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.passEvents = false;
        this.backgroundHeight = 256;
        this.backgroundWidth = 256;
        this.playerInventoryTitleY = this.backgroundHeight - 105;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,TEXTURE);
        int i = this.x;
        int j = this.y;
        this.drawTexture(matrices,i,j,0,0,this.backgroundWidth,this.backgroundHeight);
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices,mouseX, mouseY,delta);
        this.drawMouseoverTooltip(matrices,mouseX, mouseY);
    }
}
