package io.github.lyem_one;

import io.github.lyem_one.init.InitHandheldItem;
import io.github.lyem_one.init.InitItem;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LykAdventime implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("LykAdventime");
	public static final String MOD_ID = "lyk-adventime";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	@Override
	public void onInitialize() {
		LOGGER.info("Loading...");
		Identifier id = Identifier.of("lyk-adventime", "custom_item"); // Test de la méthode
		InitItem.load();
		InitHandheldItem.load();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path); // Use new Identifier instead of Identifier.of()
	}

}