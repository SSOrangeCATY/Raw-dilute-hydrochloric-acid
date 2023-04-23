package net.ssorangecaty.hydrochloric.generation.item.items;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.ssorangecaty.hydrochloric.generation.item.HydrochloricItemGeneration;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;
import net.ssorangecaty.hydrochloric.generation.item.character.GachaData;
import net.ssorangecaty.hydrochloric.generation.screen.SearchVoucherScreenHandler;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import org.jetbrains.annotations.Nullable;

public class SearchVoucher extends HydrochloricItemGeneration implements ExtendedScreenHandlerFactory {

    public SearchVoucher(Settings settings, String name, String quality) {
        super(settings, name, quality);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("gacha");
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        context.getPlayer().openHandledScreen(this);
        return ActionResult.SUCCESS;
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        PacketByteBuf buf = PacketByteBufs.create();
        ((EntityGameDataSaver)player).getGameInfo().putInt("varInt",Registries.ITEM.getRawId(gacha(player)));
        buf.writeBoolean(false);
        buf.writeVarInt(((EntityGameDataSaver)player).getGameInfo().getInt("varInt"));
        return new SearchVoucherScreenHandler(syncId,playerInventory,buf);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBoolean(false);
        buf.writeVarInt(((EntityGameDataSaver)player).getGameInfo().getInt("varInt"));
    }
    public Item gacha(PlayerEntity player){
        MinecraftServer server = player.getServer();
        ServerPlayerEntity sp = server.getPlayerManager().getPlayer(player.getUuid());
        CharacterGen character = GachaData.gacha();
        sp.giveItemStack(character.getItemStack());
        sp.getMainHandStack().setCount(sp.getMainHandStack().getCount() - 1);
        sp.currentScreenHandler.sendContentUpdates();
        sp.playerScreenHandler.onContentChanged(sp.getInventory());
        return character;
    }
}
