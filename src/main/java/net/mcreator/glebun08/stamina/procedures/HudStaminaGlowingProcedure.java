package net.mcreator.glebun08.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

public class HudStaminaGlowingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd > -1) {
			return true;
		}
		return false;
	}
}
