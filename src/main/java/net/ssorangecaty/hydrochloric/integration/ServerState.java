package net.ssorangecaty.hydrochloric.integration;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

public class ServerState extends PersistentState {

    public static boolean installCheck = false;

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putBoolean("installCheck", installCheck);
        return nbt;
    }

    public static ServerState createFromNbt(NbtCompound tag) {
        ServerState serverState = new ServerState();
        installCheck = tag.getBoolean("installCheck");
        return serverState;
    }
    public static ServerState getServerState(MinecraftServer server) {
        PersistentStateManager persistentStateManager = server
                .getWorld(World.OVERWORLD).getPersistentStateManager();
        ServerState serverState = persistentStateManager.getOrCreate(
                ServerState::createFromNbt,
                ServerState::new,
                "INSTALL_CHECK");
        serverState.markDirty();
        return serverState;
    }
}
