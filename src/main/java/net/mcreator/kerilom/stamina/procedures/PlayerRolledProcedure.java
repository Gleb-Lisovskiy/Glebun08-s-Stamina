package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;
import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

public class PlayerRolledProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double stamina = 0;
		if (ConfigConfiguration.COMBATROLL_BOOLEAN.get()) {
			{
				double _setval = (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).combatroll_staminaset;
				entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina_regen_cd < (double) ConfigConfiguration.COMBATROLL_STAMINA_REGEN_CD.get()) {
				{
					double _setval = (double) ConfigConfiguration.COMBATROLL_STAMINA_REGEN_CD.get();
					entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stamina_regen_cd = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}