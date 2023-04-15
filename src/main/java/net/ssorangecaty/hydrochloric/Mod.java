package net.ssorangecaty.hydrochloric;

import net.ssorangecaty.hydrochloric.generation.ModItemGroupSet;
import net.ssorangecaty.hydrochloric.generation.command.CommandGen;
import net.ssorangecaty.hydrochloric.generation.effect.EffectRegister;
import net.ssorangecaty.hydrochloric.generation.item.ModItemRegister;
import net.fabricmc.api.ModInitializer;
import net.ssorangecaty.hydrochloric.generation.screen.ScreenRegister;
import net.ssorangecaty.hydrochloric.network.ModServerPacket;
import net.ssorangecaty.hydrochloric.network.data.ModEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Mod implements ModInitializer {
	public static final String MOD_ID = "hydrochloric";
	public static final String VERSION = "23w14a CodeTesting 0.2 [Function Testing]";
	public static final Logger LOGGER = LoggerFactory.getLogger("Hydrochloric");

	@Override
	public void onInitialize() {
		LOGGER.info("Hydrochloric now loading");
		ModServerPacket.register();
		ScreenRegister.register();
		ModEvents.registerEvent();
		ModItemRegister.registerModItems();
		ModItemGroupSet.createItemGroup();
		CommandGen.registerCommand();
		EffectRegister.register();
	}
}