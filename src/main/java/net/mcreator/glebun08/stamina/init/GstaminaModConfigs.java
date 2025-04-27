package net.mcreator.glebun08.stamina.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.glebun08.stamina.configuration.ConfigConfiguration;
import net.mcreator.glebun08.stamina.GstaminaMod;

@EventBusSubscriber(modid = GstaminaMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GstaminaModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModList.get().getModContainerById("gstamina").get().registerConfig(ModConfig.Type.COMMON, ConfigConfiguration.SPEC, "glebun08's_stamina-config.toml");
		});
	}
}
