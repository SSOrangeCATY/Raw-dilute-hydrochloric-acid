package net.archasmiel.thaumcraft.item.item.wand;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class Wand extends BowItem {
    private String name;
    private String quality;
    NbtCompound nbt = new NbtCompound();
    NbtCompound elements = new NbtCompound();
    int element = 0;
    int maxElement = 100;
    int maxFire = 100;
    int maxWater = 100;
    int maxOrder = 100;
    int maxChaos = 100;
    int maxWind = 100;
    int maxEarth = 100;
    int wind;
    int earth;
    int fire;
    int water;
    int order;
    int chaos;
    int tick;

    public Wand(Settings settings) {
        super(settings);
    }
    public Wand(Settings settings,String name) {
        super(settings);
        this.name = name;
    }
    public Wand(Settings settings,String name,String quality) {
        super(settings);
        this.name = name;
        this.quality = quality;
    }
    public Wand(Settings settings,String name,String quality,int element,int maxElement) {
        super(settings);
        this.name = name;
        this.quality = quality;
        this.element = element;
        this.maxElement = maxElement;
        setCustomMaxElement();
    }
    public Wand(Settings settings,String name,String quality,int element,int maxFire,int maxWater,int maxEarth,int maxOrder,int maxChaos,int maxWind) {
        super(settings);
        this.name = name;
        this.quality = quality;
        this.element = element;
        this.maxChaos = maxChaos;
        this.maxEarth = maxEarth;
        this.maxOrder = maxOrder;
        this.maxFire = maxFire;
        this.maxWater = maxWater;
        this.maxWind = maxWind;
    }
    public void setCustomMaxElement(){
        maxChaos = maxElement;
        maxEarth = maxElement;
        maxOrder = maxElement;
        maxFire = maxElement;
        maxWater = maxElement;
        maxWind = maxElement;
    }
    public void setCustomElement(){
        nbt.putInt("fire",element);
        nbt.putInt("max_fire",maxFire);
        nbt.putInt("wind",element);
        nbt.putInt("max_wind",maxWind);
        nbt.putInt("water",element);
        nbt.putInt("max_water",maxWater);
        nbt.putInt("earth",element);
        nbt.putInt("max_earth",maxEarth);
        nbt.putInt("chaos",element);
        nbt.putInt("max_chaos",maxChaos);
        nbt.putInt("order",element);
        nbt.putInt("max_order",maxOrder);
    }
    public void addWindElement(ItemStack stack,int number) {if(stack.getNbt().getInt("wind")+ number<maxWind){wind = stack.getNbt().getInt("wind") + number;elements = stack.getNbt().copy();elements.putInt("wind",wind);stack.setNbt(elements);}}
    public void addEarthElement(ItemStack stack,int number) {if(stack.getNbt().getInt("earth")+ number<maxEarth){earth = stack.getNbt().getInt("earth") + number;elements = stack.getNbt().copy();elements.putInt("earth",earth);stack.setNbt(elements);}}
    public void addFireElement(ItemStack stack,int number) {if(stack.getNbt().getInt("fire")+ number<maxFire){fire = stack.getNbt().getInt("fire") + number;elements = stack.getNbt().copy();elements.putInt("fire",fire);stack.setNbt(elements);}}
    public void addWaterElement(ItemStack stack,int number) {if(stack.getNbt().getInt("water")+ number<maxWater){water = stack.getNbt().getInt("water") + number;elements = stack.getNbt().copy();elements.putInt("water",water);stack.setNbt(elements);}}
    public void addOrderElement(ItemStack stack,int number) {if(stack.getNbt().getInt("order")+ number<maxOrder){order = stack.getNbt().getInt("order") + number;elements = stack.getNbt().copy();elements.putInt("order",order);stack.setNbt(elements);}}
    public void addChaosElement(ItemStack stack,int number) {if(stack.getNbt().getInt("chaos")+ number<maxChaos){chaos = stack.getNbt().getInt("chaos") + number;elements = stack.getNbt().copy();elements.putInt("chaos",chaos);stack.setNbt(elements);}}

    public String ItemName() {return name;}
    public String ItemQuality() {return quality;}
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("item.thaumcraft.quality." + ItemQuality()).formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("0").formatted(Formatting.YELLOW)
                .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                .append(Text.translatable("0").formatted(Formatting.DARK_GREEN)
                        .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                        .append(Text.translatable("0").formatted(Formatting.RED))
                        .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                        .append(Text.translatable("0").formatted(Formatting.DARK_AQUA))
                        .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                        .append(Text.translatable("0").formatted(Formatting.GRAY))
                        .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                        .append(Text.translatable("0").formatted(Formatting.DARK_GRAY))));
        tooltip.add(Text.translatable("item.thaumcraft." + ItemName() + ".tips"));
        if (stack.getNbt() == null) {
            setCustomElement();
            stack.setNbt(nbt);}
        tooltip.set(3, Text.translatable(""+ stack.getNbt().getInt("wind")).formatted(Formatting.YELLOW)
                    .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                    .append(Text.translatable(""+ stack.getNbt().getInt("earth")).formatted(Formatting.DARK_GREEN)
                    .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                    .append(Text.translatable(""+ stack.getNbt().getInt("fire")).formatted(Formatting.RED))
                    .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                    .append(Text.translatable(""+ stack.getNbt().getInt("water")).formatted(Formatting.DARK_AQUA))
                    .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                    .append(Text.translatable(""+ stack.getNbt().getInt("order")).formatted(Formatting.GRAY))
                    .append(Text.translatable(" | ").formatted(Formatting.WHITE))
                    .append(Text.translatable(""+ stack.getNbt().getInt("chaos")).formatted(Formatting.DARK_GRAY))));
    }
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        tick = 0;
    }
    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        tick++;
        if (tick == 5){
            tick = 0;
        addWindElement(stack,1);
        addFireElement(stack,2);
        addEarthElement(stack,3);
        addWaterElement(stack,4);
        addChaosElement(stack,5);
        addOrderElement(stack,6);
        }

    }


}
