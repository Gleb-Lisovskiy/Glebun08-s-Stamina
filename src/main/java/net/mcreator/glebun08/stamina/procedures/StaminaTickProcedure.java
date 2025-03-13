package net.mcreator.glebun08.stamina.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

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
					_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina + 0.05;
					_vars.syncPlayerVariables(entity);
				}
				if (!(entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D)) {
					{
						GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina + 0.05;
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
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if (entity.isSprinting()) {
				if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina > 0) {
					{
						GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina - 0.06;
						_vars.syncPlayerVariables(entity);
					}
				}
				if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).tired == false) {
					if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < 50) {
						{
							GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
							_vars.stamina_regen_cd = 50;
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
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 1, true, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2, 1, true, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, true, false));
			}
			if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).jump_cd > -1) {
				{
					GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
					_vars.jump_cd = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).jump_cd - 1;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).default_attribute_jump == 0) {
					{
						GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
						_vars.default_attribute_jump = entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity8.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0;
						_vars.syncPlayerVariables(entity);
					}
				}
				if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
					_livingEntity9.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0);
			} else if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).default_attribute_jump != 0) {
				if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
					_livingEntity10.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(entity.getData(GstaminaModVariables.PLAYER_VARIABLES).default_attribute_jump);
				{
					GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
					_vars.default_attribute_jump = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
