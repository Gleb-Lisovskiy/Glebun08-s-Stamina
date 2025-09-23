package net.mcreator.kerilom.stamina.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;
import net.mcreator.kerilom.stamina.KstaminaMod;

@Mod.EventBusSubscriber(modid = KstaminaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KstaminaModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigConfiguration.SPEC, "kstamina-config.toml");
		});
	}
}