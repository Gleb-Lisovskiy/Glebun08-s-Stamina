package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;

public class AdrenalineEffectTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina + 0.25;
			entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.stamina = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}