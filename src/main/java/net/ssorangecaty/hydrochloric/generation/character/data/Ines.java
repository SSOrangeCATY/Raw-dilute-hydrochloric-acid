package net.ssorangecaty.hydrochloric.generation.character.data;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.generation.character.CharacterGen;
import net.ssorangecaty.hydrochloric.generation.character.CharacterIdentifier;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Ines extends CharacterGen {
    public Ines(String[][] arkData, int number, CharacterIdentifier identifier) {
        super(arkData, number, identifier);
        this.triggerTime = 45*20;
        this.auto = false;
        this.simpleSkillInfo = "技能开启时获得隐身与力量并在攻击时虚弱敌方";
        this.skillInfo= new String[]{"手动开启,45SP,持续时间12s,技能开启时获得隐身II与力量II", "并在攻击敌方时对其施加虚弱(虚弱等级随攻击次数计算)"};
    }
    @Override
    public void triggerSkill(ItemStack stack, World world, LivingEntity entity){
        if(!world.isClient()) {
            entity.setStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20, 1,true,true,true),entity);
            entity.setStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20, 1,true,true,true),entity);
            ((EntityGameDataSaver) entity).getGameInfo().putBoolean("inesSkill", true);
        }
    }
    public void resetSkillEffect(Entity entity){
        ((EntityGameDataSaver) entity).getGameInfo().putBoolean("inesSkill", false);
    }
}
