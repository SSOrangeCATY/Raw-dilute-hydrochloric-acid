package net.ssorangecaty.hydrochloric.generation.item.items;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.ssorangecaty.hydrochloric.generation.item.HydrochloricItemGeneration;
import net.ssorangecaty.hydrochloric.generation.screen.PrtsScreenHandler;
import org.jetbrains.annotations.Nullable;

public class PrtsTerminal extends HydrochloricItemGeneration implements ExtendedScreenHandlerFactory  {
    public PrtsTerminal(Settings settings, String name, String quality) {
        super(settings, name, quality);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        context.getPlayer().openHandledScreen(this);
        return super.useOnBlock(context);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("PRTS");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        PacketByteBuf buf = PacketByteBufs.create();
        return new PrtsScreenHandler(syncId,playerInventory,buf);
    }

}
