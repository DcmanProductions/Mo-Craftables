package net.chaselabs.Mo_Craftables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.chaselabs.Mo_Craftables.utilities.References;
import net.chaselabs.Mo_Craftables.utilities.References.LogTypes;
import net.minecraftforge.fml.common.Mod;

@Mod(References.MOD_ID)
@SuppressWarnings("all")
public class Main {
	private static final Logger logger = LogManager.getLogger();
	public static Main instance;

	public Main() {
		instance = this;
		new SideProxy();

	}

	/**
	 * 
	 * @param type - The Urgency of the Log.
	 * @param text - The Log Message.
	 */
	public static void Log(LogTypes type, String text) {
		if (type == LogTypes.Debug)
			logger.debug(text);
		if (type == LogTypes.Warn)
			logger.warn(text);
		if (type == LogTypes.Error)
			logger.error(text);
		if (type == LogTypes.Info)
			logger.info(text);
	}

}
