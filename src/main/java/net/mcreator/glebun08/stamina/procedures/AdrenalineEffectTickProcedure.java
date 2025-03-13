package net.mcreator.glebun08.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

public class AdrenalineEffectTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
			_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina + 0.35;
			_vars.syncPlayerVariables(entity);
		}
	}
}
