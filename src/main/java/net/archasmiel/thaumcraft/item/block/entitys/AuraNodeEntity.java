package net.archasmiel.thaumcraft.item.block.entitys;

import net.archasmiel.thaumcraft.util.Elements;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.Objects;

public class AuraNodeEntity extends BlockEntity {
    int wind;
    int earth;
    int fire;
    int water;
    int order;
    int chaos;
    public AuraNodeEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public void setElements(){
     if(world.getBiome(pos).matchesKey(BiomeKeys.PLAINS)) {
         int random = Random.create().nextBetween(0,108);
         int chance = 0;
         chance=(random/25)+1;
         for (int a = chance;a == 5;a++){
             random = Random.create().nextBetween(0,125);
             if(random<=25){
                 earth = earth + 10 + Random.create().nextBetween(1,35);
             } else if (random <=50) {
                 fire = fire + 10 + Random.create().nextBetween(1,35);
             } else if (random <=75) {
                 water = water + 10 + Random.create().nextBetween(1,35);
             } else if (random <=100) {
                 order = order + 10 + Random.create().nextBetween(1,35);
             } else if (random <=125) {
                 chaos = chaos + 10 + Random.create().nextBetween(1,35);}
             }
         }
         wind = 35 + Random.create().nextBetween(1,50);
        }
    NbtCompound elements = new Elements().SetBasicElements();
    public boolean CheckElements(NbtCompound nbt){
        return nbt.get("wind") != null &&
                nbt.get("earth") != null &&
                nbt.get("fire") != null &&
                nbt.get("water") != null &&
                nbt.get("order") != null &&
                nbt.get("chaos") != null;
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        wind = nbt.getInt("wind");
        earth = nbt.getInt("earth");
        fire = nbt.getInt("fire");
        water = nbt.getInt("water");
        order = nbt.getInt("order");
        chaos = nbt.getInt("chaos");
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if(CheckElements(nbt)){
            nbt.putInt("wind",wind);
            nbt.putInt("earth",earth);
            nbt.putInt("fire",fire);
            nbt.putInt("water",water);
            nbt.putInt("order",order);
            nbt.putInt("chaos",chaos);
        }else{
            nbt.copyFrom(elements);
        }

    }
}
