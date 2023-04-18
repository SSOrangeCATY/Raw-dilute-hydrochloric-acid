package net.ssorangecaty.hydrochloric.generation.character.data;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.generation.character.CharacterGen;
import net.ssorangecaty.hydrochloric.generation.character.CharacterIdentifier;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;

public class Kkdy extends CharacterGen {
    public Kkdy(String[][] arkData, int number, CharacterIdentifier identifier) {
        super(arkData, number, identifier);
        this.attackTrigger = true;
        this.triggerTime = 4;
        this.simpleSkillInfo = "当技能触发时连续攻击两次,每次攻击造成150%的物理伤害";
        this.skillInfo = new String[]{"攻击回复,"+triggerTime+"sp"+"自动触发","当技能触发时连续攻击两次,每次攻击造成150%的物理伤害","并且有20%的概率使攻击伤害额外提升20%"};
    }
    @Override
    public void triggerSkill(ItemStack stack, World world, LivingEntity entity){
        stack.getNbt().putInt("characterTick",((EntityGameDataSaver)entity).getGameInfo().getInt("kkdyTick"));
        ((EntityGameDataSaver) entity).getGameInfo().putBoolean("kkdySkill", true);
    }
}
