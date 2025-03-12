package net.mcreator.glebun08.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

public class HudstaminaregencdProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "stamina_regen_cd: " + entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd;
	}
}
