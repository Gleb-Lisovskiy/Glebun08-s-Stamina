package net.mcreator.kerilom.stamina.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import javax.annotation.Nullable;

import net.combat_roll.api.event.ServerSideRollEvents;

@EventBusSubscriber
public class TickPlayerRollingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		ServerSideRollEvents.PLAYER_START_ROLLING.register((player, velocity) -> {
			if (entity == null)
				return;
			if (ConfigConfiguration.COMBATROLL_BOOLEAN.get()) {
				PlayerRolledProcedure.execute(entity);
			}
		});
	}
}