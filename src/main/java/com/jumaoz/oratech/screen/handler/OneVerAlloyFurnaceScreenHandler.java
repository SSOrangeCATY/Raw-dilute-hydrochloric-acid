package com.jumaoz.oratech.screen.handler;

import com.jumaoz.oratech.OraTech;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class OneVerAlloyFurnaceScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public OneVerAlloyFurnaceScreenHandler(int synId, PlayerInventory inventory){
        this(synId, inventory, new SimpleInventory(4),new ArrayPropertyDelegate(4));
    }
    public OneVerAlloyFurnaceScreenHandler(int synId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate){
        super(OraTech.EARTH_BLAST_FURNACE_SCREEN_HANDLER_SCREEN_HANDLER, synId);
        checkSize(inventory,5);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;


        this.addSlot(new Slot(this.inventory,0,41,17){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,1,62,17){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,2,52,53){
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.getItem() == Items.COAL;
            }
        });
        this.addSlot(new Slot(this.inventory,3,103,35){
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });
        this.addSlot(new Slot(this.inventory,4,124,35){
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });
        int i;
        for (i = 0;i < 3;++i){
            for (int j = 0;j<9;++j){
                this.addSlot(new Slot(playerInventory,j + i* 9 + 9,8 + j * 18,84 + i * 18));
            }
        }
        for(i=0;i<9;i++){
            this.addSlot(new Slot(playerInventory,i,8 + i * 18,142));
        }
        addProperties(delegate);
    }


    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (index < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    public boolean isCrafting(){
        return propertyDelegate.get(0) > 0;
    }
    public int getScaledProgress(){
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 24;

        return  maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress :0;
    }
    public int getScaledFuelTime(){
        int fuelTime = this.propertyDelegate.get(2);
        int maxFuelTime = this.propertyDelegate.get(3);
        int fuelTimeArrowSize = 14;

        return  maxFuelTime != 0 && fuelTime != 0 ? fuelTime * fuelTimeArrowSize / maxFuelTime :0;
    }
}

