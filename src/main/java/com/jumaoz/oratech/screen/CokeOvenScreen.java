package com.jumaoz.oratech.screen;

import com.jumaoz.oratech.screen.handler.CokeOvenScreenHandler;
import com.jumaoz.oratech.screen.handler.EarthBlastFurnaceScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CokeOvenScreen extends HandledScreen<CokeOvenScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("oratech","textures/gui/coke_oven_gui.png");
    public CokeOvenScreen(CokeOvenScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.passEvents = false;
        this.backgroundHeight = 167;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }
    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,TEXTURE);
        int i = this.x;
        int j = this.y;
        this.drawTexture(matrices,i,j,0,0,this.backgroundWidth,this.backgroundHeight);

        renderProgressArrow(matrices,x,y);
    }
    private void renderProgressArrow(MatrixStack matrices,int x,int y){
        if(handler.isCrafting()){
            drawTexture(matrices,x+138,y+10,177,34,20,64-handler.getScaledFluid());
            drawTexture(matrices,x+64,y+35,177,15,handler.getScaledProgress(),17);
        } else if(handler.getScaledFluid()>0) {
            drawTexture(matrices,x+138,y+10,177,34,20,64-handler.getScaledFluid());
        } else drawTexture(matrices,x+138,y+10,177,34,20,64);

    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices,mouseX, mouseY,delta);
        this.drawMouseoverTooltip(matrices,mouseX, mouseY);
    }
}
