package net.ssorangecaty.hydrochloric.generation.item.character.data;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterIdentifier;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;

public class Ines extends CharacterGen {
    public Ines(String[][] arkData, int number, CharacterIdentifier identifier) {
        super(arkData, number, identifier);
        this.triggerTime = 45*20;
        this.auto = false;
        this.firstSimpleSkillInfo = "技能开启时获得隐身与力量并在攻击时虚弱敌方";
        this.firstSkillInfo= new String[]{"手动开启,"+triggerTime/20+"sp"+",持续时间12s,技能开启时获得隐身II与力量II", "并在攻击敌方时对其施加虚弱(虚弱等级随攻击次数计算)","虚弱持续时间无限"};

    }
    public void firstSkill(ItemStack stack, World world, LivingEntity entity){
        if(!world.isClient()) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20, 1,true,true,true),entity);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20, 1,true,true,true),entity);
            ((EntityGameDataSaver) entity).getGameInfo().putBoolean("inesSkill", true);
        }
    }
    public void secondSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的二技能但是没有写功能.").formatted(Formatting.GRAY));
    }
    public void thirdSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的三技能但是没有写功能.").formatted(Formatting.GRAY));
    }
    public void resetSkillEffect(Entity entity){
        ((EntityGameDataSaver) entity).getGameInfo().putBoolean("inesSkill", false);
    }
}
