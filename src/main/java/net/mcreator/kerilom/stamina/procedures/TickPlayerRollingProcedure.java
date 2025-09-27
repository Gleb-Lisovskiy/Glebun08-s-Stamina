package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import net.combat_roll.api.event.ServerSideRollEvents;

public class TickPlayerRollingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ServerSideRollEvents.PLAYER_START_ROLLING.register((player, velocity) -> {
			if (ConfigConfiguration.COMBATROLL_BOOLEAN.get()) {
				PlayerRolledProcedure.execute(entity);
			}
		});
	}
}