package net.ssorangecaty.hydrochloric;

import net.ssorangecaty.hydrochloric.generation.item.HydrochloricItemGroupSet;
import net.ssorangecaty.hydrochloric.generation.command.HydrochloricCommandGen;
import net.ssorangecaty.hydrochloric.generation.effect.HydrochloricEffectRegister;
import net.ssorangecaty.hydrochloric.generation.item.HydrochloricItemRegister;
import net.fabricmc.api.ModInitializer;
import net.ssorangecaty.hydrochloric.generation.screen.HydrochloricScreenRegister;
import net.ssorangecaty.hydrochloric.network.HydrochloricServerPacket;
import net.ssorangecaty.hydrochloric.network.data.HydrochloricEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Hydrochloric implements ModInitializer {
	public static final String MOD_ID = "hydrochloric";
	public static final String VERSION = "2023/4/24/Demo build";
	public static final Logger LOGGER = LoggerFactory.getLogger("Hydrochloric");

	@Override
	public void onInitialize() {
		LOGGER.info("Hydrochloric now loading");
		HydrochloricServerPacket.register();
		HydrochloricScreenRegister.register();
		HydrochloricEvents.registerEvent();
		HydrochloricItemRegister.registerModItems();
		HydrochloricItemGroupSet.createItemGroup();
		HydrochloricCommandGen.registerCommand();
		HydrochloricEffectRegister.register();
	}
}