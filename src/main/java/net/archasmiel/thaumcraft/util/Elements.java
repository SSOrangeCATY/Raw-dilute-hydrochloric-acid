package net.archasmiel.thaumcraft.util;

import net.minecraft.nbt.NbtCompound;

public class Elements {
    /*
    // basic
    int wind; // 风
    int earth; // 地
    int fire; // 火
    int water; // 水
    int order; // 秩序
    int chaos; // 混沌
    //level1
    int light;
    int swap;
    int cold;
    int poison;
    int climate;
    int crystal;
    int life;
    int energy;
    int theVoid;
    int move;

    //level2
    int death;
    int treatment;
    int beast;
    int slime;
    int travel;
    int botany;
    int hunger;
    int metal;
    int trap;
    int flight;
    int magic;
    int dark;
    //level3
    int undead;
    int exotic;
    int tree;
    int contaminated;
    int anima;
    int soul;
    int body;
    //level4
    int thinking;
    int perception;
    //level5
    int human;
    //leve6
    int crop;
    int tool;
    int mineral;
    int greedy;

    //level7
    int craft;
    int cloth;
    int mechanics;
    int arms;
    int equipment;
*/

    public NbtCompound SetBasicElements(){
        NbtCompound elementBasic = new NbtCompound();
        elementBasic.putInt("wind",0);
        elementBasic.putInt("earth",0);
        elementBasic.putInt("fire",0);
        elementBasic.putInt("water",0);
        elementBasic.putInt("order",0);
        elementBasic.putInt("chaos",0);
        return elementBasic;
    }
}
