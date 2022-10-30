package com.jumaoz.oratech.item.tool.ToolMaterials;

import com.jumaoz.oratech.OraTech;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SteelToolMaterials implements ToolMaterial {
    public static final SteelToolMaterials INSTANCE = new SteelToolMaterials();
    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.5F;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(OraTech.STEEL_INGOT);
    }
}