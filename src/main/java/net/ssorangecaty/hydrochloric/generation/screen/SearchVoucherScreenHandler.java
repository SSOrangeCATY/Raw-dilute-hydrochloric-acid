package net.ssorangecaty.hydrochloric.generation.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;


public class SearchVoucherScreenHandler extends ScreenHandler{
    CharacterGen[] characters = new CharacterGen[10];

    public SearchVoucherScreenHandler(int i, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        super(HydrochloricScreenRegister.SEARCH_VOUCHER_SCREEN_HANDLER,i);
        if (packetByteBuf.readBoolean()) {
            int[] items = packetByteBuf.readIntArray();
            for (int j = 0; j < 10; j++) {
                this.characters[j] = (CharacterGen) Registries.ITEM.get(items[j]);
            }
        }else{
            this.characters[0] = ((CharacterGen) Registries.ITEM.get(packetByteBuf.readVarInt()));
        }
    }
    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }
    public CharacterGen[] getCharacter(){
        return  this.characters;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
