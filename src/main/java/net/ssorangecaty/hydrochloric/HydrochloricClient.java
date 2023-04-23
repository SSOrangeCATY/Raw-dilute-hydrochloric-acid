package net.ssorangecaty.hydrochloric;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;
import net.ssorangecaty.hydrochloric.generation.item.HydrochloricItemGeneration;
import net.ssorangecaty.hydrochloric.generation.screen.PrtsScreen;
import net.ssorangecaty.hydrochloric.generation.screen.RoleScreen;
import net.ssorangecaty.hydrochloric.generation.screen.ScreenRegister;
import net.ssorangecaty.hydrochloric.generation.screen.SearchVoucherScreen;
import org.lwjgl.glfw.GLFW;


public class HydrochloricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ScreenRegister.ROLE_SCREEN_HANDLER, RoleScreen::new);
        HandledScreens.register(ScreenRegister.SEARCH_VOUCHER_SCREEN_HANDLER, SearchVoucherScreen::new);
        HandledScreens.register(ScreenRegister.PRTS_SCREEN_HANDLER, PrtsScreen::new);

        ItemTooltipCallback.EVENT.register((stack, context, lines) -> {
            if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
                if (stack.getItem() instanceof CharacterGen item) {
                    String[] skillInfo;
                    String skillName;
                    switch (stack.getNbt().getInt("selectSkill")) {
                        case 1 -> {
                            skillName = item.skillName[1];
                            skillInfo = item.secondSkillInfo;
                        }
                        case 2 -> {
                            skillName = item.skillName[2];
                            skillInfo = item.thirdSkillInfo;
                        }
                        default -> {
                            skillName = item.skillName[0];
                            skillInfo = item.firstSkillInfo;
                        }
                    };
                    lines.clear();
                    if(item.quality == 1){
                        lines.add(Text.literal("当前技能: "+skillName));
                        for (int i = 0; i < skillInfo.length; i++) {
                            lines.add(Text.literal(skillInfo[i]));
                        }
                    }else if (item.quality == 2){
                        lines.add(Text.literal("当前技能: "+skillName).formatted(Formatting.GREEN));
                        for (int i = 0; i < skillInfo.length; i++) {
                            lines.add(Text.literal(skillInfo[i]).formatted(Formatting.GREEN));
                        }
                    }else if (item.quality == 3){
                        lines.add(Text.literal("当前技能: "+skillName).formatted(Formatting.BLUE));
                        for (int i = 0; i < skillInfo.length; i++) {
                            lines.add(Text.literal(skillInfo[i]).formatted(Formatting.BLUE));
                        }
                    }else if (item.quality == 4){
                        lines.add(Text.literal("当前技能: "+skillName).formatted(Formatting.LIGHT_PURPLE));
                        for (int i = 0; i < skillInfo.length; i++) {
                            lines.add(Text.literal(skillInfo[i]).formatted(Formatting.LIGHT_PURPLE));
                        }
                    }else if (item.quality == 5){
                        lines.add(Text.literal("当前技能: "+skillName).formatted(Formatting.GOLD));
                        for (int i = 0; i < skillInfo.length; i++) {
                            lines.add(Text.literal(skillInfo[i]).formatted(Formatting.GOLD));
                        }
                    }else if (item.quality == 6){
                        lines.add(Text.literal("当前技能: "+skillName).formatted(Formatting.RED));
                        for (int i = 0; i < skillInfo.length; i++) {
                            lines.add(Text.literal(skillInfo[i]).formatted(Formatting.RED));
                        }
                    }
                    lines.add((((CharacterGen)stack.getItem()).getNextTriggerTime(stack)));
                } else if (stack.getItem() instanceof HydrochloricItemGeneration) {
                    lines.set(3,Text.translatable("item.hydrochloric."+((HydrochloricItemGeneration)stack.getItem()).ItemName()+".tips"));
                    lines.add(Text.translatable("item.hydrochloric."+((HydrochloricItemGeneration)stack.getItem()).ItemName()+".tips1"));
                }
            }
        });
    }
}
