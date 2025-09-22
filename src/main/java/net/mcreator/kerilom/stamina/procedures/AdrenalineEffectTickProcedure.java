package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;

public class AdrenalineEffectTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
			_vars.stamina = entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina + 0.25;
			_vars.syncPlayerVariables(entity);
		}
	}
}