package net.ssorangecaty.hydrochloric.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import net.ssorangecaty.hydrochloric.util.LongmenCurrencyDataSaver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class ModEntityGameDataSavingServerMixin implements EntityGameDataSaver , LongmenCurrencyDataSaver {
    private NbtCompound persistentData;
    @Override
    public int getDropCount() {
        NbtCompound nbt = ((EntityGameDataSaver)this).getGameInfo();
        return (int) (nbt.getInt("longMenCoinCount") + nbt.getInt("longMenCoinCount") * nbt.getDouble("longMenCoinAddition"));
    }
    @Override
    public int getCount() {
        NbtCompound nbt = ((EntityGameDataSaver)this).getGameInfo();
        return nbt.getInt("longMenCoinCount");
    }

    @Override
    public void setCount(int count) {
        NbtCompound nbt = ((EntityGameDataSaver)this).getGameInfo();
        nbt.putInt("longMenCoinCount",count);
    }
    @Override
    public NbtCompound getGameInfo() {
        if(this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable info) {
        if(persistentData != null) {
            nbt.put("persistentData", persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains("persistentData", 10)) {
            persistentData = nbt.getCompound("persistentData");
        }
    }
}
