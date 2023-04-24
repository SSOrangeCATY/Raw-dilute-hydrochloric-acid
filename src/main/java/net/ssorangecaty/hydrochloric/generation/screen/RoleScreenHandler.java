package net.ssorangecaty.hydrochloric.generation.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;


public class RoleScreenHandler extends ScreenHandler {
    private final CharacterGen CHARACTER;
    public RoleScreenHandler(int i, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        super(HydrochloricScreenRegister.ROLE_SCREEN_HANDLER,i);
        CHARACTER = ((CharacterGen)playerInventory.player.getMainHandStack().getItem());
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }
    public CharacterGen getCharacter(){
        return this.CHARACTER;
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
