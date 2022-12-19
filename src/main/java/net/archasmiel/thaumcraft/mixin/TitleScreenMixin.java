package net.archasmiel.thaumcraft.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title){
        super(title);
    }
    @Inject(at = @At("RETURN"), method = "initWidgetsNormal")
    private void addCustomButton(int y, int spacingY, CallbackInfo ci){
        this.addDrawableChild(ButtonWidget.builder(Text.translatable("menu.thaumcraft"), (button) -> {
            this.client.setScreen(new SelectWorldScreen(new SelectWorldScreen(this)));
        }).dimensions(this.width / 2 - 100 + 205, y, 50, 20).build());
    }
}
