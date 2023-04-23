package net.ssorangecaty.hydrochloric.generation.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;
import net.ssorangecaty.hydrochloric.util.ImplementedInventory;


public class PrtsScreenHandler extends ScreenHandler implements ImplementedInventory {
    Inventory inv = new SimpleInventory(3);
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public PrtsScreenHandler(int i, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        super(ScreenRegister.PRTS_SCREEN_HANDLER,i);
        //some inventories do custom logic when a player opens it.
        //This will place the slot in the correct locations for a 3x3 Grid. The slots exist on both server and client!
        //This will not render the background of the slots however, this is the Screens job
        int m;
        int l;
        //Our inventory
        this.addSlot(new Slot(inv, 0, 62 + 18, 17 + 9));
        this.addSlot(new Slot(inv,1,62 + 2*18,17+2 * 18));
        this.addSlot(new Slot(inv, 2, 62, 17 + 2 * 18));
        //The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }
}
