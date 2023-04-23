package net.ssorangecaty.hydrochloric.integration;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.Hydrochloric;

public class HydrochloricServerState extends PersistentState {

    public String weatherCity = "北京";

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putString("weatherCity", weatherCity);
        return nbt;
    }

    public static HydrochloricServerState createFromNbt(NbtCompound tag) {
        HydrochloricServerState serverState = new HydrochloricServerState();
        serverState.weatherCity = tag.getString("weatherCity");
        return serverState;
    }
    public static HydrochloricServerState getServerState(MinecraftServer server) {
        PersistentStateManager persistentStateManager = server
                .getWorld(World.OVERWORLD).getPersistentStateManager();
        HydrochloricServerState serverState = persistentStateManager.getOrCreate(
                HydrochloricServerState::createFromNbt,
                HydrochloricServerState::new,
                Hydrochloric.MOD_ID);
        serverState.markDirty();
        return serverState;
    }
}
