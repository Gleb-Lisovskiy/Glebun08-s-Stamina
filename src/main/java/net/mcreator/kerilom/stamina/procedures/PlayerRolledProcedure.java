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
				KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
				_vars.stamina = entity.getData(KstaminaModVariables.PLAYER_VARIABLES).CombatRoll_staminaset;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < (double) ConfigConfiguration.COMBATROLL_STAMINA_REGEN_CD.get()) {
				{
					KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina_regen_cd = (double) ConfigConfiguration.COMBATROLL_STAMINA_REGEN_CD.get();
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}