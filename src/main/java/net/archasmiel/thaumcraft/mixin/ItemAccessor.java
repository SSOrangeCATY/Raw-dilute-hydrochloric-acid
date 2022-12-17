package net.archasmiel.thaumcraft.mixin;

import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Item.class)
public interface ItemAccessor
{
    @Mutable
    @Accessor("recipeRemainder")
    public void setRecipeRemainder(Item recipeRemainder);
}
