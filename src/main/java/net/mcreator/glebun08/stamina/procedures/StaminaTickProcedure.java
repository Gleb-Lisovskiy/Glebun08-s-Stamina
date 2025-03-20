package net.mcreator.glebun08.stamina.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.Minecraft;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StaminaTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina_regen_cd <= -1) {
			if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina < GstaminaModVariables.WorldVariables.get(world).configcommon_maxstamina) {
				{
					double _setval = (entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina + GstaminaModVariables.WorldVariables.get(world).configcommon_regenstamina;
					entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stamina = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!(new Object() {
					public boolean getValue() {
						boolean retBool = Minecraft.getInstance().options.keyUp.isDown();
						if (retBool) {
							if (Minecraft.getInstance().options.keyUp.getKeyModifier().toString().equals("SHIFT")) {
								retBool = Screen.hasShiftDown();
							} else if (Minecraft.getInstance().options.keyUp.getKeyModifier().toString().equals("CONTROL")) {
								retBool = Screen.hasControlDown();
							} else if (Minecraft.getInstance().options.keyUp.getKeyModifier().toString().equals("ALT")) {
								retBool = Screen.hasAltDown();
							}
						}
						return retBool;
					}
				}.getValue() || new Object() {
					public boolean getValue() {
						boolean retBool = Minecraft.getInstance().options.keyDown.isDown();
						if (retBool) {
							if (Minecraft.getInstance().options.keyDown.getKeyModifier().toString().equals("SHIFT")) {
								retBool = Screen.hasShiftDown();
							} else if (Minecraft.getInstance().options.keyDown.getKeyModifier().toString().equals("CONTROL")) {
								retBool = Screen.hasControlDown();
							} else if (Minecraft.getInstance().options.keyDown.getKeyModifier().toString().equals("ALT")) {
								retBool = Screen.hasAltDown();
							}
						}
						return retBool;
					}
				}.getValue() || new Object() {
					public boolean getValue() {
						boolean retBool = Minecraft.getInstance().options.keyLeft.isDown();
						if (retBool) {
							if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("SHIFT")) {
								retBool = Screen.hasShiftDown();
							} else if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("CONTROL")) {
								retBool = Screen.hasControlDown();
							} else if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("ALT")) {
								retBool = Screen.hasAltDown();
							}
						}
						return retBool;
					}
				}.getValue() || new Object() {
					public boolean getValue() {
						boolean retBool = Minecraft.getInstance().options.keyRight.isDown();
						if (retBool) {
							if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("SHIFT")) {
								retBool = Screen.hasShiftDown();
							} else if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("CONTROL")) {
								retBool = Screen.hasControlDown();
							} else if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("ALT")) {
								retBool = Screen.hasAltDown();
							}
						}
						return retBool;
					}
				}.getValue())) {
					{
						double _setval = (entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina
								+ GstaminaModVariables.WorldVariables.get(world).configcommon_regenstamina1;
						entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stamina = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina > GstaminaModVariables.WorldVariables.get(world).configcommon_maxstamina) {
				{
					double _setval = GstaminaModVariables.WorldVariables.get(world).configcommon_maxstamina;
					entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stamina = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina < 0) {
			{
				double _setval = 0;
				entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina <= 0) {
			{
				boolean _setval = true;
				entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tired = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina >= 10) {
			{
				boolean _setval = false;
				entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tired = _setval;
					capability.syncPlayerVariables(entity);
				});
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
				if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina > 0) {
					{
						double _setval = (entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina
								- GstaminaModVariables.WorldVariables.get(world).configcommon_actions_sprinting;
						entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stamina = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).tired == false) {
					if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina_regen_cd < 50) {
						{
							double _setval = 50;
							entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.stamina_regen_cd = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if (!entity.isSprinting() || (entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).tired == true) {
				if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina_regen_cd > -1) {
					{
						double _setval = (entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina_regen_cd - 1;
						entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stamina_regen_cd = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).stamina <= 0
					|| (entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).tired == true) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2, 1, true, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2, 1, true, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, true, false));
			}
			if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).jump_cd > -1) {
				{
					double _setval = (entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).jump_cd - 1;
					entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jump_cd = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).default_attribute_jump == 0) {
					{
						double _setval = entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity11.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0;
						entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.default_attribute_jump = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
					_livingEntity12.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0);
			} else if ((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).default_attribute_jump != 0) {
				if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
					_livingEntity13.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(((entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GstaminaModVariables.PlayerVariables())).default_attribute_jump));
				{
					double _setval = 0;
					entity.getCapability(GstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.default_attribute_jump = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
