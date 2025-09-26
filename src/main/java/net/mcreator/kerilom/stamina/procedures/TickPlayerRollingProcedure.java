package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import net.combatroll.api.event.ServerSideRollEvents;

public class TickPlayerRollingProcedure {
	public static void execute(Entity entity) {
		ServerSideRollEvents.PLAYER_START_ROLLING.register((player, velocity) -> {
			if (ConfigConfiguration.COMBATROLL_BOOLEAN.get()) {
				PlayerRolledProcedure.execute(player);
			}
		});
	}
}