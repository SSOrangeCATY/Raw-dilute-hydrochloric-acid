package net.ssorangecaty.hydrochloric.network.data;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.generation.character.CharacterGen;
import net.ssorangecaty.hydrochloric.integration.PlayerTickHandler;
import net.ssorangecaty.hydrochloric.integration.ServerState;
import net.ssorangecaty.hydrochloric.mixin.EntityMixin;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import net.ssorangecaty.hydrochloric.util.PlayerAttackCountGetter;
import org.lwjgl.glfw.GLFW;

import java.util.List;
import java.util.Objects;

public class ModEvents {
    public static final Identifier MIZUKI_MUSIC1 = new Identifier("hydrochloric:mizuki_music1");
    public static SoundEvent MIZUKI_MUSIC1_SOUNDEVENT = SoundEvent.of(MIZUKI_MUSIC1);
    public static void registerEvent(){
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            // You can see we use the function getServer() that's on the player.
        });
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
        Registry.register(Registries.SOUND_EVENT, MIZUKI_MUSIC1, MIZUKI_MUSIC1_SOUNDEVENT);
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
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if(((EntityGameDataSaver)player).getGameInfo().getBoolean("inesSkill")) {
                StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.WEAKNESS, -1, ((PlayerAttackCountGetter) entity).getPlayerAttackCount());
                ((LivingEntity) entity).setStatusEffect(effect,entity);
            }
            return ActionResult.PASS;
        });
    }
}
