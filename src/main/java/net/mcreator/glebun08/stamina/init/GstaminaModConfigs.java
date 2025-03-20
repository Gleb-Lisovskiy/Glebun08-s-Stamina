package net.mcreator.glebun08.stamina.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.glebun08.stamina.configuration.ConfigcommonConfiguration;
import net.mcreator.glebun08.stamina.GstaminaMod;

@Mod.EventBusSubscriber(modid = GstaminaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GstaminaModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigcommonConfiguration.SPEC, "glebun08's_stamina-config.toml");
		});
	}
}
