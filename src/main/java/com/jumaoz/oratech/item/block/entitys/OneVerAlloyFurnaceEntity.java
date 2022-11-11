package com.jumaoz.oratech.item.block.entitys;

import com.jumaoz.oratech.OraTech;
import com.jumaoz.oratech.screen.handler.EarthBlastFurnaceScreenHandler;
import com.jumaoz.oratech.screen.handler.OneVerAlloyFurnaceScreenHandler;
import com.jumaoz.oratech.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class OneVerAlloyFurnaceEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inv = DefaultedList.ofSize(4,ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 2880;
    public final SimpleEnergyStorage orangePowerStorage = new SimpleEnergyStorage(5000,32,32){
        @Override
        protected void onFinalCommit(){
            markDirty();
        }
    };
    private int maxEnergy = (int)orangePowerStorage.capacity;

    public OneVerAlloyFurnaceEntity(BlockPos blockPos, BlockState blockState) {
        super(OraTech.EARTH_BLAST_FURNACE_ENTITY, blockPos, blockState);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> OneVerAlloyFurnaceEntity.this.progress;
                    case 1 -> OneVerAlloyFurnaceEntity.this.maxProgress;
                    case 2 -> (int)OneVerAlloyFurnaceEntity.this.orangePowerStorage.amount;
                    case 3 -> OneVerAlloyFurnaceEntity.this.maxEnergy;
                    default -> 0;
                };
            }
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> OneVerAlloyFurnaceEntity.this.progress = value;
                    case 1 -> OneVerAlloyFurnaceEntity.this.maxProgress = value;
                    case 2 -> OneVerAlloyFurnaceEntity.this.orangePowerStorage.amount = value;
                    case 3 -> OneVerAlloyFurnaceEntity.this.maxEnergy = value;
                }
            }
            public int size() {
                return 4;
            }
        };
    }

    public static <E extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, OneVerAlloyFurnaceEntity entity) {
        if(world.isClient()) {
            return;
        }
            if(hasRecipes(entity)){
                if (hasEnergy(entity)) {
                    entity.world.setBlockState(blockPos,blockState.with(Properties.LIT,true));
                    markDirty(world, blockPos, blockState);
                    if (entity.progress >= entity.maxProgress) {
                        craftItem(entity);
                    }
                } else {entity.setUnWork(blockPos,blockState);}
            } else {entity.setUnWork(blockPos,blockState);}
    }

    private void setUnWork(BlockPos blockPos, BlockState blockState) {
        this.resetProgress();
        this.world.setBlockState(blockPos,blockState.with(Properties.LIT,false));}

    private static void craftItem(OneVerAlloyFurnaceEntity entity) {
        entity.setStack(2,new ItemStack(OraTech.ORANGE,
                entity.getStack(3).getCount() + 1));
        entity.removeStack(0,1);
        entity.resetProgress();

    }
    private void resetProgress() {this.progress = 0;}

    private static boolean hasEnergy(OneVerAlloyFurnaceEntity entity) {
        if(entity.orangePowerStorage.amount >= 16){
            entity.progress++;
            entity.orangePowerStorage.amount=entity.orangePowerStorage.amount-16;
            return true;
        }else return false;
    }

    private static boolean hasRecipes(OneVerAlloyFurnaceEntity entity) {
        return !entity.getStack(0).isEmpty();
    }

    protected void writeNbt(NbtCompound nbt){
        super.writeNbt(nbt);
        nbt.putInt("Progress",progress);
        nbt.putLong("OrangePower",orangePowerStorage.amount);
    }
    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        progress = nbt.getInt("Progress");
        orangePowerStorage.amount = nbt.getLong("OrangePower");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inv;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.oratech.1v_alloy_furnace.GUI");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new OneVerAlloyFurnaceScreenHandler(syncId,inv,this,this.propertyDelegate);
    }
}
