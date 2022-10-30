package com.jumaoz.oratech.item.block.entitys;

import com.jumaoz.oratech.OraTech;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class SteelChestEntity extends LootableContainerBlockEntity {
    private  DefaultedList<ItemStack> inv = DefaultedList.ofSize(54,ItemStack.EMPTY);

    public SteelChestEntity(BlockPos pos, BlockState state) {
        super(OraTech.STEEL_CHEST_ENTITY, pos, state);
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inv;
    }
    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inv = list;
    }
    @Override
    protected Text getContainerName() {
        return Text.translatable("item.oratech.steel_chest.GUI");
    }
    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x6(syncId,playerInventory,this);
    }
    @Override
    public int size() {
        return 54;
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inv);
    }
    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inv);
    }
}

