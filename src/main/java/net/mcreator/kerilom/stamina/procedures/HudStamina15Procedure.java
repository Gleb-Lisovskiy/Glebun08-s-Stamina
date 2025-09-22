package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;

public class HudStamina15Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (Math.round(entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina) == 15) {
			return true;
		}
		return false;
	}
}