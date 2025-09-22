package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;

public class HudStaminaGlowingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd > 0) {
			return true;
		}
		return false;
	}
}