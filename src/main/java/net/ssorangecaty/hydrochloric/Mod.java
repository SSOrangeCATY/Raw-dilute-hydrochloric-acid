package net.ssorangecaty.hydrochloric;

import net.ssorangecaty.hydrochloric.generation.ModItemGroupSet;
import net.ssorangecaty.hydrochloric.generation.command.CommandGen;
import net.ssorangecaty.hydrochloric.generation.item.ModItemRegister;
import net.fabricmc.api.ModInitializer;
import net.ssorangecaty.hydrochloric.network.ModServerPacket;
import net.ssorangecaty.hydrochloric.network.data.ServerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Mod implements ModInitializer {
	public static final String MOD_ID = "hydrochloric";
	public static final String VERSION = "23w14a CodeTesting 0.2 [Function Testing]";
	public static final Logger LOGGER = LoggerFactory.getLogger("Hydrochloric");
	@Override
	public void onInitialize() {
		LOGGER.info(Mod.MOD_ID+": Hello Minecraft,Mod now loading");
		ModServerPacket.register();
		ServerEvent.registerEvent();
		ModItemRegister.registerModItems();
		ModItemGroupSet.createItemGroup();
		CommandGen.registerCommand();
	}
}