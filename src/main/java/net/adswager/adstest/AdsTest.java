package net.adswager.adstest;

import net.adswager.adstest.block.ModBlocks;
import net.adswager.adstest.item.ModItemGroups;
import net.adswager.adstest.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdsTest implements ModInitializer {
	public static final String MOD_ID = "adstest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
		FuelRegistry.INSTANCE.add(ModItems.COAL_CHUNK, 200);
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
	}
}