package net.mcreator.glebun08.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

public class AdrenalineEffectTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina + 0.35;
			entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.stamina = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
