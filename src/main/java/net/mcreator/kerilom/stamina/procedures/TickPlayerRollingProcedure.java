package net.mcreator.kerilom.stamina.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import javax.annotation.Nullable;

import net.combatroll.api.event.ServerSideRollEvents;

@Mod.EventBusSubscriber
public class TickPlayerRollingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		ServerSideRollEvents.PLAYER_START_ROLLING.register((player, velocity) -> {
			if (ConfigConfiguration.COMBATROLL_BOOLEAN.get()) {
				PlayerRolledProcedure.execute(player);
			}
		});
	}
}