package net.archasmiel.thaumcraft.repice.type;
/*
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class EarthBlastFurnaceRecipe implements Recipe<SimpleInventory> {
    public ItemStack createIcon() {
        return new ItemStack(OraTech.EARTH_BLAST_FURNACE);
    }
    private  final Identifier id;
    private  final ItemStack output;
    private  final ItemStack output1;
    private  final int progress;

    private  final DefaultedList<Ingredient> recipeItems;

    public EarthBlastFurnaceRecipe(Identifier id, ItemStack output, ItemStack output1, DefaultedList<Ingredient> recipeItems, int progress) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.output1 = output1;
        this.progress = progress;
    }
    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient){
            return false;
        }
        return recipeItems.get(0).test(inventory.getStack(0)) ||
               recipeItems.get(0).test(inventory.getStack(1)) &&
               recipeItems.get(1).test(inventory.getStack(1)) ||
               recipeItems.get(1).test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }
    public ItemStack craft1(SimpleInventory inventory) {
        return output1;
    }
    public ItemStack getinput0() {
        ItemStack item;
        return item = recipeItems.get(0).getMatchingStacks()[0];
    }
    public ItemStack getinput1() {
        ItemStack item;
        return item = recipeItems.get(1).getMatchingStacks()[0];
    }


    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    public int getProgress() {
        return progress;
    }
    @Override
    public ItemStack getOutput() {
        return output.copy();
    }
    public ItemStack getOutput1() {
        return output1.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }
    public static class Type implements RecipeType<EarthBlastFurnaceRecipe>{
        private Type(){}
        public static  final Type INSTANCE = new Type();
        public static final String ID = "earth_blast_furnace";
    }
    public static class Serializer implements RecipeSerializer<EarthBlastFurnaceRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "earth_blast_furnace";

        @Override
        public EarthBlastFurnaceRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
            ItemStack output1 = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output1"));
            int progress = JsonHelper.getInt(json, "progress", 60);

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            return new EarthBlastFurnaceRecipe(id, output,output1,inputs,progress);
        }
        @Override
        public EarthBlastFurnaceRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            ItemStack output1 = buf.readItemStack();
            int progress = buf.readInt();
            return new EarthBlastFurnaceRecipe(id, output,output1,inputs,progress);
        }
        @Override
        public void write(PacketByteBuf buf, EarthBlastFurnaceRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
            buf.writeItemStack(recipe.getOutput1());
            buf.writeInt(recipe.progress);
        }
    }
}*/
