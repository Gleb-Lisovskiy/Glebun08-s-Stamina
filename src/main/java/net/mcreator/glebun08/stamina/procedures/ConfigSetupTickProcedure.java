package net.mcreator.glebun08.stamina.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;
import net.mcreator.glebun08.stamina.configuration.ConfigcommonConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ConfigSetupTickProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		GstaminaModVariables.WorldVariables.get(world).configcommon_maxstamina = (double) ConfigcommonConfiguration.MAXSTAMINA.get();
		GstaminaModVariables.WorldVariables.get(world).syncData(world);
		GstaminaModVariables.WorldVariables.get(world).configcommon_actions_sprinting = (double) ConfigcommonConfiguration.SPRINTING.get();
		GstaminaModVariables.WorldVariables.get(world).syncData(world);
		GstaminaModVariables.WorldVariables.get(world).configcommon_actions_jump = (double) ConfigcommonConfiguration.JUMP.get();
		GstaminaModVariables.WorldVariables.get(world).syncData(world);
		GstaminaModVariables.WorldVariables.get(world).configcommon_actions_dblock = (double) ConfigcommonConfiguration.DBLOCK.get();
		GstaminaModVariables.WorldVariables.get(world).syncData(world);
		GstaminaModVariables.WorldVariables.get(world).configcommon_actions_dblock1 = (double) ConfigcommonConfiguration.DBLOCK1.get();
		GstaminaModVariables.WorldVariables.get(world).syncData(world);
		GstaminaModVariables.WorldVariables.get(world).configcommon_actions_hittedentity = (double) ConfigcommonConfiguration.HITTED_ENTITY.get();
		GstaminaModVariables.WorldVariables.get(world).syncData(world);
		GstaminaModVariables.WorldVariables.get(world).configcommon_actions_critedentity = (double) ConfigcommonConfiguration.CRITED_ENTITY.get();
		GstaminaModVariables.WorldVariables.get(world).syncData(world);
		GstaminaModVariables.WorldVariables.get(world).configcommon_regenstamina = (double) ConfigcommonConfiguration.REGENSTAMINA.get();
		GstaminaModVariables.WorldVariables.get(world).syncData(world);
		GstaminaModVariables.WorldVariables.get(world).configcommon_regenstamina1 = (double) ConfigcommonConfiguration.REGENSTAMINA1.get();
		GstaminaModVariables.WorldVariables.get(world).syncData(world);
	}
}
