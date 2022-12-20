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
    static String[] elements = new String[6];
    static String[] maxElements = new String[6];
    static {
        elements[0] = "wind";
        elements[1] = "earth";
        elements[2] = "fire";
        elements[3] = "water";
        elements[4] = "order";
        elements[5] = "chaos";
        maxElements[0] = "maxWind";
        maxElements[1] = "maxEarth";
        maxElements[2] = "maxFire";
        maxElements[3] = "maxWater";
        maxElements[4] = "maxOrder";
        maxElements[5] = "maxChaos";
    }

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
    public void addElements(ItemStack stack,String element) {
        assert stack.getNbt() != null;
        if (CheckElement(stack, element)) {
            if (element.equals("wind")) {
                wind = stack.getNbt().getInt(element) + 1;
                nbt.putInt("wind",wind);
            }
            if (element.equals("earth")) {
                earth = stack.getNbt().getInt(element) + 1;
                nbt.putInt("earth",earth);
            }
            if (element.equals("fire")) {
                fire = stack.getNbt().getInt(element) + 1;
                nbt.putInt("fire",fire);
            }
            if (element.equals("water")) {
                water = stack.getNbt().getInt(element) + 1;
                nbt.putInt("water",water);
            }
            if (element.equals("order")) {
                order = stack.getNbt().getInt(element) + 1;
                nbt.putInt("order",order);
            }
            if (element.equals("chaos")) {
                chaos = stack.getNbt().getInt(element) + 1;
                nbt.putInt("chaos",chaos);
            }
        }
    }

    public String ItemName() {
        return name;
    }
    public String ItemQuality() {
        return quality;
    }
    public boolean CheckElement(ItemStack stack,String element){
        int check=0;
        for (int i = 0;i<=5;i++){
            if(element.equals(elements[i])) {
                assert stack.getNbt() != null;
                if (stack.getNbt().getInt(elements[i]) < stack.getNbt().getInt(maxElements[i])) {
                    return true;
                } else if (stack.getNbt().getInt(elements[i]) == stack.getNbt().getInt(maxElements[i])) {
                    return false;
                } else if (stack.getNbt().getInt(elements[i]) > stack.getNbt().getInt(maxElements[i])) {
                        nbt.putInt(elements[i],0);
                        stack.setNbt(nbt);
                        return true;
                }
            } else if (element.equals("all")){
                if (stack.getNbt().getInt(elements[i]) < stack.getNbt().getInt(maxElements[i])) {
                        check = check + 1;
                        return true;
                } else if (stack.getNbt().getInt(elements[i]) == stack.getNbt().getInt(maxElements[i])) {
                    return false;
                } else if (stack.getNbt().getInt(elements[i]) > stack.getNbt().getInt(maxElements[i])) {
                        nbt.putInt(elements[i],0);
                        stack.setNbt(nbt);
                        check = check + 1;
                } else if (check == 6) return true;
            }
        }
        return false;
    }
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
            stack.setNbt(nbt);
        } else if (CheckElement(stack,"all")){
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
        }else if (!CheckElement(stack,"all")){
            element = 0;
            setCustomElement();
            stack.setNbt(nbt);
        }
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
        //user.getBlockPos();
        addElements(stack,"wind");
        stack.setNbt(nbt);
        }

    }


}
