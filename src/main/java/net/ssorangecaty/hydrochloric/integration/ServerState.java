package net.ssorangecaty.hydrochloric.integration;


import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.Hydrochloric;

public class ServerState extends PersistentState {

    public String weatherCity = "北京";

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putString("weatherCity", weatherCity);
        return nbt;
    }

    public static ServerState createFromNbt(NbtCompound tag) {
        ServerState serverState = new ServerState();
        serverState.weatherCity = tag.getString("weatherCity");
        return serverState;
    }
    public static ServerState getServerState(MinecraftServer server) {
        PersistentStateManager persistentStateManager = server
                .getWorld(World.OVERWORLD).getPersistentStateManager();
        ServerState serverState = persistentStateManager.getOrCreate(
                ServerState::createFromNbt,
                ServerState::new,
                Hydrochloric.MOD_ID);
        serverState.markDirty();
        return serverState;
    }
}
