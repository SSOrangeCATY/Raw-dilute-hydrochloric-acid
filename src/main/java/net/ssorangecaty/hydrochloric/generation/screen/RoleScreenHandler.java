package net.ssorangecaty.hydrochloric.generation.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.ssorangecaty.hydrochloric.generation.character.CharacterGen;


public class RoleScreenHandler extends ScreenHandler {
    private CharacterGen character;
    public RoleScreenHandler(int synId, PlayerInventory inventory){
        super(ScreenRegister.ROLE_SCREEN_HANDLER,synId);
        character = ((CharacterGen)inventory.player.getMainHandStack().getItem());
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }
    public CharacterGen getCharacter(){
        return this.character;
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
