package net.archasmiel.thaumcraft.item.tool.ToolMaterials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CraftTool implements ToolMaterial {
    public static final CraftTool INSTANCE = new CraftTool();
    @Override
    public int getDurability() {
        return 256;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    public Ingredient getRepairIngredient() {
            return Ingredient.ofItems();
    }
}