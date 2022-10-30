package com.jumaoz.oratech.item.block.entitys;

import com.jumaoz.oratech.OraTech;
import com.jumaoz.oratech.repice.type.EarthBlastFurnaceRecipe;
import com.jumaoz.oratech.screen.handler.EarthBlastFurnaceScreenHandler;
import com.jumaoz.oratech.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
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

import java.util.Optional;


public class EarthBlastFurnaceEntity extends BlockEntity implements NamedScreenHandlerFactory , ImplementedInventory {
    private DefaultedList<ItemStack> inv = DefaultedList.ofSize(5,ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 2880;
    private int fuelTime = 0;
    private int maxFuelTime = 1600;

    public EarthBlastFurnaceEntity(BlockPos blockPos, BlockState blockState) {
        super(OraTech.EARTH_BLAST_FURNACE_ENTITY, blockPos, blockState);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> EarthBlastFurnaceEntity.this.progress;
                    case 1 -> EarthBlastFurnaceEntity.this.maxProgress;
                    case 2 -> EarthBlastFurnaceEntity.this.fuelTime;
                    case 3 -> EarthBlastFurnaceEntity.this.maxFuelTime;
                    default -> 0;
                };
            }
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> EarthBlastFurnaceEntity.this.progress = value;
                    case 1 -> EarthBlastFurnaceEntity.this.maxProgress = value;
                    case 2 -> EarthBlastFurnaceEntity.this.fuelTime = value;
                    case 3 -> EarthBlastFurnaceEntity.this.maxFuelTime = value;
                }
            }
            public int size() {
                return 4;
            }
        };
    }

    public DefaultedList<ItemStack> getItems() {
        return this.inv;
    }
    @Override
    public Text getDisplayName() {
        return Text.translatable("block.oratech.earth_blast_furnace.GUI");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new EarthBlastFurnaceScreenHandler(syncId,inv,this,this.propertyDelegate);
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,inv);
        nbt.putInt("earth_blast_furnace_progress",progress);
        nbt.putInt("earth_blast_furnace_fuelTime",fuelTime);

    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inv);
        progress = nbt.getInt("earth_blast_furnace_progress");
        fuelTime = nbt.getInt("earth_blast_furnace_fuelTime");
    }
    public static <E extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, EarthBlastFurnaceEntity entity) {
        if(world.isClient()) {
            return;
        }
        if (entity.getStack(4).getCount()<=60 && entity.getStack(3).getCount()<64){
          if(hasRecipes(entity)){
            if (hasFuel(entity)) {
                entity.world.setBlockState(blockPos,blockState.with(Properties.LIT,true));
                markDirty(world, blockPos, blockState);
                if (entity.progress >= entity.maxProgress) {
                    craftItem(entity);
                }
              } else {entity.setUnWork(blockPos,blockState);}
            } else {entity.setUnWork(blockPos,blockState);}
        } else {entity.setUnWork(blockPos,blockState);}
    }
    private void setUnWork(BlockPos blockPos,BlockState blockState) {
        this.resetProgress();
        this.resetFuelTime();
        this.world.setBlockState(blockPos,blockState.with(Properties.LIT,false));}
    private void resetProgress() {this.progress = 0;}
    private void resetFuelTime() {if(this.fuelTime>0){this.fuelTime--;}}

    private static void craftItem(EarthBlastFurnaceEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        Optional<EarthBlastFurnaceRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(EarthBlastFurnaceRecipe.Type.INSTANCE,inventory,entity.getWorld());
        if(hasRecipes(entity)) {
            entity.removeStack(0, 1);

            entity.setStack(3, new ItemStack(recipe.get().getOutput().getItem(),
                    entity.getStack(3).getCount() + recipe.get().getOutput().getCount()));
            entity.removeStack(1, 1);
            entity.setStack(4, new ItemStack(recipe.get().getOutput1().getItem(),
                    entity.getStack(4).getCount() + recipe.get().getOutput1().getCount()));


            entity.resetProgress();
        }
    }
    private static boolean hasFuel(EarthBlastFurnaceEntity entity){
        if (entity.fuelTime > 0 ){
            entity.fuelTime--;
            entity.progress++;
            return true;
        } else if (entity.fuelTime == 0 && !entity.getStack(2).isEmpty() ){
            entity.getStack(2).setCount(entity.getStack(2).getCount()-1);
            entity.fuelTime = entity.maxFuelTime;
            entity.fuelTime--;
            entity.progress++;
            return true;
        } else {
            entity.resetProgress();
            entity.resetFuelTime();
            return false;}
    }

    private static boolean hasRecipes(EarthBlastFurnaceEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        Optional<EarthBlastFurnaceRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(EarthBlastFurnaceRecipe.Type.INSTANCE,inventory,entity.getWorld());
        match.ifPresent(earthBlastFurnaceRecipe -> entity.maxProgress = earthBlastFurnaceRecipe.getProgress() * 20);
        if(match.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem())){
            if (entity.getStack(0).getItem() == match.get().getinput0().getItem() ||
                    entity.getStack(1).getItem() == match.get().getinput0().getItem()){
                return entity.getStack(0).getItem() == match.get().getinput1().getItem() ||
                        entity.getStack(1).getItem() == match.get().getinput1().getItem();
            } else return false;
        }else return false;
    }
    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(3).getItem() == output || inventory.getStack(3).isEmpty() && inventory.getStack(4).getItem() == output || inventory.getStack(4).isEmpty();
    }
    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount()&&inventory.getStack(4).getMaxCount() > inventory.getStack(4).getCount();
    }
}

