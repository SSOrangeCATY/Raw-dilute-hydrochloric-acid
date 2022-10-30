package com.jumaoz.oratech.item.block.entitys;

import com.jumaoz.oratech.OraTech;
import com.jumaoz.oratech.util.ImplementedInventory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class SteamTurbineEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public final SimpleEnergyStorage orangePowerStorage = new SimpleEnergyStorage(10000,32,32){
      @Override
      protected void onFinalCommit(){
          markDirty();
      }
    };
    public SteamTurbineEntity(BlockPos pos, BlockState state) {
        super(OraTech.STEAM_TURBINE_ENTITY,pos,state);
    }

    public static <E extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, SteamTurbineEntity entity) {
        if(world.isClient){
            return;
        }
        if(world.isDay()){
            if(entity.orangePowerStorage.amount < entity.orangePowerStorage.capacity){
            entity.orangePowerStorage.amount=entity.orangePowerStorage.amount+10;}
        }
    }
    private static void extractEnergy(SteamTurbineEntity entity){
        try(Transaction transaction = Transaction.openOuter()){
            entity.orangePowerStorage.extract(32,transaction);
            transaction.commit();
        }
    }
    protected void writeNbt(NbtCompound nbt){
        super.writeNbt(nbt);
        nbt.putLong("Steam_Turbine_Power",orangePowerStorage.amount);
    }
    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        orangePowerStorage.amount = nbt.getLong("Steam_Turbine_Power");
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }

    @Override
    public Text getDisplayName() {
        return null;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return null;
    }
}
