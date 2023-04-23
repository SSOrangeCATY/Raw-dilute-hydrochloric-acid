package net.ssorangecaty.hydrochloric.generation.item.character.data;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterIdentifier;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;

public class Kkdy extends CharacterGen {
    public Kkdy(String[][] arkData, int number, CharacterIdentifier identifier) {
        super(arkData, number, identifier);
        this.attackTrigger = true;
        this.triggerTime = 4;
        this.firstSimpleSkillInfo = "当技能触发时连续攻击两次,每次攻击造成150%的物理伤害";
        this.firstSkillInfo = new String[]{"攻击回复,"+triggerTime+"sp"+",自动触发","当技能触发时连续攻击两次,每次攻击造成150%的物理伤害","并且有20%的概率使攻击伤害额外提升20%"};
    }
    public void firstSkill(ItemStack stack, World world, LivingEntity entity){
        stack.getNbt().putInt("characterTick",((EntityGameDataSaver)entity).getGameInfo().getInt("kkdyTick"));
        ((EntityGameDataSaver) entity).getGameInfo().putBoolean("kkdySkill", true);
    }
    public void secondSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的二技能但是没有写功能.").formatted(Formatting.GRAY));
    }
    public void thirdSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的三技能但是没有写功能.").formatted(Formatting.GRAY));
    }
}
