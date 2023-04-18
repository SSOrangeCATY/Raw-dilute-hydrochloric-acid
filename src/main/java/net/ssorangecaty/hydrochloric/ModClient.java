package net.ssorangecaty.hydrochloric;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.ssorangecaty.hydrochloric.generation.character.CharacterGen;
import net.ssorangecaty.hydrochloric.generation.screen.RoleScreen;
import net.ssorangecaty.hydrochloric.generation.screen.ScreenRegister;
import org.lwjgl.glfw.GLFW;


public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ScreenRegister.ROLE_SCREEN_HANDLER, RoleScreen::new);

        ItemTooltipCallback.EVENT.register((stack, context, lines) -> {
            if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
                if (stack.getItem() instanceof CharacterGen) {
                    CharacterGen item = ((CharacterGen)stack.getItem());
                    lines.clear();
                    if(item.quality == 1){
                        for (int i = 0; i < item.skillInfo.length; i++) {
                            lines.add(Text.literal(item.skillInfo[i]));
                        }
                    }else if (item.quality == 2){
                        for (int i = 0; i < item.skillInfo.length; i++) {
                            lines.add(Text.literal(item.skillInfo[i]).formatted(Formatting.GREEN));
                        }
                    }else if (item.quality == 3){
                        for (int i = 0; i < item.skillInfo.length; i++) {
                            lines.add(Text.literal(item.skillInfo[i]).formatted(Formatting.BLUE));
                        }
                    }else if (item.quality == 4){
                        for (int i = 0; i < item.skillInfo.length; i++) {
                            lines.add(Text.literal(item.skillInfo[i]).formatted(Formatting.LIGHT_PURPLE));
                        }
                    }else if (item.quality == 5){
                        for (int i = 0; i < item.skillInfo.length; i++) {
                            lines.add(Text.literal(item.skillInfo[i]).formatted(Formatting.GOLD));
                        }
                    }else if (item.quality == 6){
                        for (int i = 0; i < item.skillInfo.length; i++) {
                            lines.add(Text.literal(item.skillInfo[i]).formatted(Formatting.RED));
                        }
                    }
                    lines.add((((CharacterGen)stack.getItem()).getNextTriggerTime(stack)));
                }
            }
        });
    }
}
