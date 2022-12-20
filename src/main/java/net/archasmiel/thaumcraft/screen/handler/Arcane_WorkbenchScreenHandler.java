package net.archasmiel.thaumcraft.screen.handler;

import net.archasmiel.thaumcraft.screen.ModScreenHandlerRegister;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class Arcane_WorkbenchScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    public Arcane_WorkbenchScreenHandler(int synId, PlayerInventory inventory){
        this(synId, inventory, new SimpleInventory(11));
    }
    public Arcane_WorkbenchScreenHandler(int synId, PlayerInventory playerInventory, Inventory inventory){
        super(ModScreenHandlerRegister.ARCANE_WORKBENCH_SCREEN_HANDLER, synId);
        checkSize(inventory,5);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        int i;
        this.addSlot(new Slot(this.inventory,0,40,40){
             @Override
             public boolean canInsert(ItemStack stack) {
                        return true;
                    }
        });
        this.addSlot(new Slot(this.inventory,1,64,40){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,2,88,40){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,3,40,64){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,4,64,64){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,5,88,64){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,6,40,88){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,7,64,88){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,8,88,88){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,9,160,24){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,10,160,64){
            @Override
            public boolean canInsert(ItemStack stack) {
                return true;
            }
        });

        for (i = 0;i < 3;++i){
            for (int j = 0;j<9;++j){
                this.addSlot(new Slot(playerInventory,j + i* 9 + 9,16 + j * 18,151 + i * 18));
            }
        }
        for(i=0;i<9;i++){
            this.addSlot(new Slot(playerInventory,i,16 + i * 18,209));
        }
    }

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
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    public boolean isFoundWand(){
        return slots.get(9).getStack().isEmpty();
    }
}