package net.ssorangecaty.hydrochloric.generation.item.items;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.ssorangecaty.hydrochloric.generation.item.character.CharacterGen;
import net.ssorangecaty.hydrochloric.generation.item.character.GachaData;
import net.ssorangecaty.hydrochloric.generation.screen.SearchVoucherScreenHandler;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class SearchVoucherX10 extends SearchVoucher{
    public SearchVoucherX10(Settings settings, String name, String quality) {
        super(settings, name, quality);
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        PacketByteBuf buf = PacketByteBufs.create();
        Item[] characters = gachaX10(player);
        int[] rawId = new int[10];
        for (int j = 0;j<10;j++){
            rawId[j] = Registries.ITEM.getRawId(characters[j]);
        }
        buf.writeBoolean(true);
        ((EntityGameDataSaver)player).getGameInfo().putIntArray("varIntArray",rawId);
        buf.writeIntArray(rawId);
        return new SearchVoucherScreenHandler(syncId,playerInventory,buf);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBoolean(true);
        buf.writeIntArray(((EntityGameDataSaver)player).getGameInfo().getIntArray("varIntArray"));
    }

    public Item[] gachaX10(PlayerEntity player) {
        MinecraftServer server = player.getServer();
        ServerPlayerEntity sp = server.getPlayerManager().getPlayer(player.getUuid());
        CharacterGen[] characters = GachaData.gachaX10();
        for (CharacterGen c : characters){
            sp.giveItemStack(c.getItemStack());
            sp.currentScreenHandler.sendContentUpdates();
            sp.playerScreenHandler.onContentChanged(sp.getInventory());
        }
        sp.getMainHandStack().setCount(sp.getMainHandStack().getCount() - 1);
        sp.currentScreenHandler.sendContentUpdates();
        sp.playerScreenHandler.onContentChanged(sp.getInventory());
        return characters;
    }
}
