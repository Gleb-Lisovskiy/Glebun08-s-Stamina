package net.mcreator.glebun08.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

public class HudStamina10Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (Math.round(entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina) == 10) {
			return true;
		}
		return false;
	}
}
