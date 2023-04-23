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

public class Amiya extends CharacterGen {
    public Amiya(String[][] arkData, int number, CharacterIdentifier identifier) {
        super(arkData, number, identifier);
        this.auto = false;
        this.triggerTime = 40*20;
        this.skillDuration = 30*20;
        this.firstSimpleSkillInfo = "技能开启时获得力量与抗性提升,攻击变为二连击";
        this.firstSkillInfo = new String[]{"手动开启,"+triggerTime/20+"sp"+",持续时间30s,技能开启时获得力量I与抗性提升II","技能开启时,你的攻击伤害类型变为真实且攻击敌方将造成双倍伤害","当与陈同时在场时技能将会被替换"};
    }
    public void firstSkill(ItemStack stack, World world, LivingEntity entity){
        if(!world.isClient()) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20, 0,true,true,true),entity);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 1,true,true,true),entity);
            ((EntityGameDataSaver) entity).getGameInfo().putBoolean("amiyaSkill", true);
        }
    }
    public void secondSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的二技能但是没有写功能.").formatted(Formatting.GRAY));
    }
    public void thirdSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的三技能但是没有写功能.").formatted(Formatting.GRAY));
    }
    public void resetSkillEffect(Entity entity){
        ((EntityGameDataSaver) entity).getGameInfo().putBoolean("amiyaSkill", false);
    }
}
