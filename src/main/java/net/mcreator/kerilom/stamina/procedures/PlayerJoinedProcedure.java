package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;

public class PlayerJoinedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity0.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0;
			entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.default_attribute_jump = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}