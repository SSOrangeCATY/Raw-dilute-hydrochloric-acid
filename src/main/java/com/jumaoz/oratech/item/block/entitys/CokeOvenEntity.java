package com.jumaoz.oratech.item.block.entitys;

import com.jumaoz.oratech.OraTech;
import com.jumaoz.oratech.item.block.machine.Coke_Oven;
import com.jumaoz.oratech.screen.handler.CokeOvenScreenHandler;
import com.jumaoz.oratech.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
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



public class CokeOvenEntity extends BlockEntity implements NamedScreenHandlerFactory , ImplementedInventory {
    private DefaultedList<ItemStack> inv = DefaultedList.ofSize(2, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 2400;
    private int fluid = 0;
    private int maxFluid = 10000;
    public CokeOvenEntity(BlockPos blockPos, BlockState blockState) {
        super(OraTech.COKE_OVEN_ENTITY, blockPos, blockState);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> CokeOvenEntity.this.progress;
                    case 1 -> CokeOvenEntity.this.maxProgress;
                    case 2 -> CokeOvenEntity.this.fluid;
                    case 3 -> CokeOvenEntity.this.maxFluid;
                    default -> 0;
                };
            }
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CokeOvenEntity.this.progress = value;
                    case 1 -> CokeOvenEntity.this.maxProgress = value;
                    case 2 -> CokeOvenEntity.this.fluid = value;
                    case 3 -> CokeOvenEntity.this.maxFluid = value;
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
        return Text.translatable("block.oratech.coke_oven.GUI");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new CokeOvenScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inv);
        nbt.putInt("coke_oven_progress", progress);
        nbt.putInt("coke_oven_fluid", fluid);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inv);
        progress = nbt.getInt("coke_oven_progress");
        fluid = nbt.getInt("coke_oven_fluid");
    }
    public static <E extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, CokeOvenEntity entity) {
        if (world.isClient()) {
            return;
        }
        entity.fluid = entity.world.getBlockState(blockPos).get(Coke_Oven.FLUID_VALUE) * 1000;
        if (entity.getStack(1).getCount() <=  63 && entity.fluid <= entity.maxFluid) {
            if (hasFuel(entity)) {
                entity.world.setBlockState(blockPos,blockState.with(Properties.LIT,true));
                markDirty(world, blockPos, blockState);
                if (entity.progress >= entity.maxProgress) {
                    craftItem(entity);
                }
            } else {
                entity.setUnWork(blockPos, blockState);
            }
        } else {
            entity.setUnWork(blockPos, blockState);
        }
    }
    private void setUnWork(BlockPos blockPos, BlockState blockState) {
        this.resetProgress();
        this.world.setBlockState(blockPos,blockState.with(Properties.LIT,false));
    }
    private void resetProgress() {
        this.progress = 0;
    }

    private void CraftingFluid() {
        this.world.setBlockState(this.pos,this.getCachedState().with(Coke_Oven.FLUID_VALUE,this.world.getBlockState(pos).get(Coke_Oven.FLUID_VALUE)+1));
    }

    private static void craftItem(CokeOvenEntity entity) {
        entity.removeStack(0, 1);
        entity.setStack(1, new ItemStack(OraTech.COKING_COAL, entity.getStack(1).getCount() + 1));
        entity.CraftingFluid();
        entity.resetProgress();
    }

    private static boolean hasFuel(CokeOvenEntity entity) {
        if (entity.progress > 0) {
            entity.progress++;
            return true;
        } else if (entity.progress == 0 && !entity.getStack(0).isEmpty()) {
            entity.getStack(0).setCount(entity.getStack(0).getCount() - 1);
            entity.progress++;
            return true;
        } else {
            entity.resetProgress();
            return false;
        }
    }
}
