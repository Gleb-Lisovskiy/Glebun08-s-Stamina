package net.mcreator.glebun08.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

public class HudStaminaProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "stamina: " + entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina;
	}
}
