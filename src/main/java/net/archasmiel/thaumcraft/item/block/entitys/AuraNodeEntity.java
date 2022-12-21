package net.archasmiel.thaumcraft.item.block.entitys;

import net.archasmiel.thaumcraft.item.block.ModBlockEntityRegister;
import net.archasmiel.thaumcraft.util.Elements;
import net.archasmiel.thaumcraft.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;

public class AuraNodeEntity extends BlockEntity implements ImplementedInventory {
    private DefaultedList<ItemStack> inv = DefaultedList.ofSize(6,ItemStack.EMPTY);
    static int wind=0;
    static int earth=0;
    static int fire=0;
    static int water=0;
    static int order=0;
    static int chaos=0;
    static int isWriteElements;
    public AuraNodeEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityRegister.AURANODEENTITY, pos, state);
    }
    public void setElements(){
        if (isNearLava(world,pos)|| world.getBiome(pos).matchesKey(BiomeKeys.DESERT) || world.getBiome(pos).matchesKey(BiomeKeys.SAVANNA) ||world.getBiome(pos).matchesKey(BiomeKeys.SAVANNA_PLATEAU)) {
            fire += Random.create().nextBetween(36, 85);
            setOtherElements();
        }
        else if(world.getBiome(pos).matchesKey(BiomeKeys.PLAINS)|| world.getBiome(pos).matchesKey(BiomeKeys.STONY_PEAKS)) {
             wind += Random.create().nextBetween(36, 85);
         setOtherElements();
         }else if (world.getBiome(pos).matchesKey(BiomeKeys.OCEAN)|| world.getBiome(pos).matchesKey(BiomeKeys.DEEP_OCEAN)|| world.getBiome(pos).matchesKey(BiomeKeys.DEEP_COLD_OCEAN)||
             world.getBiome(pos).matchesKey(BiomeKeys.DEEP_FROZEN_OCEAN)|| world.getBiome(pos).matchesKey(BiomeKeys.WARM_OCEAN)|| world.getBiome(pos).matchesKey(BiomeKeys.LUKEWARM_OCEAN)){
         water += Random.create().nextBetween(36, 85);
         setOtherElements();
     } else if (world.getBiome(pos).matchesKey(BiomeKeys.SNOWY_BEACH)||world.getBiome(pos).matchesKey(BiomeKeys.SNOWY_PLAINS)||
                world.getBiome(pos).matchesKey(BiomeKeys.SNOWY_SLOPES)||world.getBiome(pos).matchesKey(BiomeKeys.SNOWY_TAIGA) ||
                world.getBiome(pos).matchesKey(BiomeKeys.FROZEN_PEAKS) || world.getBiome(pos).matchesKey(BiomeKeys.FROZEN_RIVER)||world.getBiome(pos).matchesKey(BiomeKeys.FROZEN_OCEAN)) {
            order += Random.create().nextBetween(36, 85);
            setOtherElements();
     } else if (world.getBiome(pos).matchesKey(BiomeKeys.SWAMP) ||world.getBiome(pos).matchesKey(BiomeKeys.DARK_FOREST)) {
            chaos += Random.create().nextBetween(36, 85);
            setOtherElements();
        } else {
            earth += Random.create().nextBetween(36, 85);
            setOtherElements();
        }
        isWriteElements = 1;

    }
    public boolean isNearLava(World world,BlockPos pos){
        // broken
        int k = -4;int i = -4;
        for (int j = -3;j<4;){
                    if(j ==3) return false;
                    if(i==5){j++;i = -4;}
                    if(k == 5){i++;k = -4;}
                    if(world.getBlockState(pos.add(i,j,k)).getBlock() == Blocks.LAVA){

                        return true;}else{
                        k++;
                    }
        }
        return false;
    }
     public void setOtherElements() {
         int chance = Random.create().nextBetween(0, 100);
         if(chance<=25){chance = 0;}
          else if (chance<= 50) chance = 1;
          else if (chance<= 70) chance = 2;
          else if (chance<=85) chance = 3;
          else if (chance<=95) chance = 4;
          else if (chance <=100) chance = 5;

         for (int a = chance; a > 0; a--) {
             int random = Random.create().nextBetween(1, 6);
             int elementRandom = Random.create().nextBetween(3, 25);
             switch (random) {
                 case 1 -> wind += elementRandom;
                 case 2 -> earth += elementRandom;
                 case 3 -> fire += elementRandom;
                 case 4 -> water += elementRandom;
                 case 5 -> order += elementRandom;
                 case 6 -> chaos += elementRandom;
             }
         }
     }
    public boolean checkElements(NbtCompound nbt){
        return isWriteElements == 0;
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        readElements(nbt);
        invElements(nbt);
    }
    public void readElements(NbtCompound nbt){
        wind = nbt.getInt("wind");
        earth = nbt.getInt("earth");
        fire = nbt.getInt("fire");
        water = nbt.getInt("water");
        order = nbt.getInt("order");
        chaos = nbt.getInt("chaos");
        isWriteElements = nbt.getInt("isWriteElements");
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if(checkElements(nbt)){
            setElements();
            writeElementNbt(nbt);
            invElements(nbt);
        }else {
            writeElementNbt(nbt);
            invElements(nbt);
        }
    }
    public NbtCompound writeElementNbt(NbtCompound nbt){
        nbt.putInt("wind",wind);
        nbt.putInt("earth",earth);
        nbt.putInt("fire",fire);
        nbt.putInt("water",water);
        nbt.putInt("order",order);
        nbt.putInt("chaos",chaos);
        nbt.putInt("isWriteElements",isWriteElements);
        return nbt;
    }
    public void invElements(NbtCompound nbt){
        readElements(nbt);
        int count = wind  / 10 % 10;
        if (count !=0) inv.set(0,new ItemStack(Items.YELLOW_WOOL)).setCount(count);
        count = earth  / 10 % 10;
        if (count !=0) inv.set(1,new ItemStack(Items.GREEN_WOOL)).setCount(count);
        count = fire  / 10 % 10;
        if (count !=0) inv.set(2,new ItemStack(Items.RED_WOOL)).setCount(count);
        count = water  / 10 % 10;
        if (count !=0) inv.set(3,new ItemStack(Items.LIGHT_BLUE_WOOL)).setCount(count);
        count = order  / 10 % 10;
        if (count !=0) inv.set(4,new ItemStack(Items.WHITE_WOOL)).setCount(count);
        count = chaos  / 10 % 10;
        if (count !=0) inv.set(5,new ItemStack(Items.GRAY_WOOL)).setCount(count);
    }
    public static <E extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, E e) {

    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inv;
    }
}
