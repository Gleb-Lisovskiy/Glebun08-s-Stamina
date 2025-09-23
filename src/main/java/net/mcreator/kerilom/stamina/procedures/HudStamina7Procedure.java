package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;

public class HudStamina7Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (Math.round((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina) == 7) {
			return true;
		}
		return false;
	}
}