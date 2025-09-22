package net.mcreator.kerilom.stamina.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;
import net.mcreator.kerilom.stamina.KstaminaMod;

@EventBusSubscriber(modid = KstaminaMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class KstaminaModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModList.get().getModContainerById("kstamina").get().registerConfig(ModConfig.Type.COMMON, ConfigConfiguration.SPEC, "kstamina-config.toml");
		});
	}
}