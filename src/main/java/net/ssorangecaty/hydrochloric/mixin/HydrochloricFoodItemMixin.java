package net.ssorangecaty.hydrochloric.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import net.ssorangecaty.hydrochloric.util.HungerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class HydrochloricFoodItemMixin {

    @Inject(method = "finishUsing",at = @At("HEAD"))
    private void injectFinishUsingMethod(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir){
        if(stack.isFood() && user.isPlayer()){
            HungerData.addHunger((EntityGameDataSaver) user,stack.getItem().getFoodComponent().getHunger());
            ((EntityGameDataSaver) user).getGameInfo().putInt("foodLevel",((EntityGameDataSaver) user).getGameInfo().getInt("foodLevel") - 1);
            int l = ((EntityGameDataSaver) user).getGameInfo().getInt("foodLevel");
            switch (l){
                case 0 : user.sendMessage(Text.literal("吃饱力！"));
                case 1 : user.sendMessage(Text.literal("再整一口！"));
                case 2 : user.sendMessage(Text.literal("饿死了饿死了！"));
                case 3 : user.sendMessage(Text.literal("@*(#$^吃!#!)"));
            }
        }
    }
}
