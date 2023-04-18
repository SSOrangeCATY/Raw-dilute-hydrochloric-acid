package net.ssorangecaty.hydrochloric.network.data;

import com.google.gson.internal.NonNullElementWrapperList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.EnumRule;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;
import net.ssorangecaty.hydrochloric.Mod;
import net.ssorangecaty.hydrochloric.generation.character.CharacterGen;
import net.ssorangecaty.hydrochloric.integration.PlayerTickHandler;
import net.ssorangecaty.hydrochloric.integration.ServerState;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import net.ssorangecaty.hydrochloric.util.PlayerAttackCountGetter;
import org.lwjgl.glfw.GLFW;

import java.util.List;
import java.util.Objects;

public class ModEvents {
    public static final Identifier MIZUKI_MUSIC1 = new Identifier("hydrochloric:mizuki_music1");
    public static final Identifier WEATHER_MESSAGE = new Identifier(Mod.MOD_ID,"weather_message");
    public static SoundEvent MIZUKI_MUSIC1_SOUNDEVENT = SoundEvent.of(MIZUKI_MUSIC1);

    public static final GameRules.Key<GameRules.BooleanRule> SYNC_REAL_WORLD =
            GameRuleRegistry.register("syncRealWorld", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(false));
    public static void registerEvent(){

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerState serverState = ServerState.getServerState(handler.player.world.getServer());
            // Sending the packet to the player (look at the networking page for more information)
            PacketByteBuf data = PacketByteBufs.create();
            data.writeString(serverState.weatherCity);
            ServerPlayNetworking.send(handler.player,WEATHER_MESSAGE, data);
            // You can see we use the function getServer() that's on the player.
        });
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
        Registry.register(Registries.SOUND_EVENT, MIZUKI_MUSIC1, MIZUKI_MUSIC1_SOUNDEVENT);
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if(((EntityGameDataSaver)player).getGameInfo().getBoolean("inesSkill")) {
                StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.WEAKNESS, -1, ((PlayerAttackCountGetter) entity).getPlayerAttackCount());
                ((LivingEntity) entity).setStatusEffect(effect,entity);
            }
            return ActionResult.PASS;
        });
    }
}
