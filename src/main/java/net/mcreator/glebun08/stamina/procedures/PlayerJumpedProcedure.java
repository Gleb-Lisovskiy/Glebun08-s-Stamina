package net.mcreator.glebun08.stamina.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerJumpedProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			{
				GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
				_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina - 2;
				_vars.syncPlayerVariables(entity);
			}
			{
				GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
				_vars.stamina_regen_cd = 50;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
