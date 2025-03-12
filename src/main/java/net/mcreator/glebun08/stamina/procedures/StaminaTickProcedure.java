package net.mcreator.glebun08.stamina.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StaminaTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd <= -1) {
			if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina < 20) {
				{
					GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina + 0.03;
					_vars.syncPlayerVariables(entity);
				}
				if (!(entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D)) {
					{
						GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina + 0.02;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
			if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina > 20) {
				{
					GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina = 20;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina < 0) {
			{
				GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
				_vars.stamina = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina <= 0) {
			{
				GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
				_vars.tired = true;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina >= 10) {
			{
				GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
				_vars.tired = false;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.isSprinting()) {
			if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).tired == false) {
				if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < 50) {
					{
						GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina_regen_cd = 50;
						_vars.syncPlayerVariables(entity);
					}
				}
				if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina > 0) {
					{
						GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina - 0.02;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		if (!entity.isSprinting() || entity.getData(GstaminaModVariables.PLAYER_VARIABLES).tired == true) {
			if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd > -1) {
				{
					GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina_regen_cd = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd - 1;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina <= 0 || entity.getData(GstaminaModVariables.PLAYER_VARIABLES).tired == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 1, false, false));
		}
	}
}
