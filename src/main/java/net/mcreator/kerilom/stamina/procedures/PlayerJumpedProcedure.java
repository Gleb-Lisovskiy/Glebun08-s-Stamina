package net.mcreator.kerilom.stamina.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;
import net.mcreator.kerilom.stamina.init.KstaminaModEnchantments;
import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerJumpedProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double stamina = 0;
		if (ConfigConfiguration.JUMP_BOOLEAN.get() == true) {
			if (entity instanceof Player && (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (ConfigConfiguration.SPRINTINGJUMP_BOOLEAN.get() == true && entity.isSprinting()) {
					stamina = (double) ConfigConfiguration.SPRINTINGJUMP.get();
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(KstaminaModEnchantments.ENDURANCE.get()) == 1) {
						stamina = (double) ConfigConfiguration.SPRINTINGJUMP_ENCHANTMENT_ENDURANCE1.get();
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(KstaminaModEnchantments.ENDURANCE.get()) == 2) {
						stamina = (double) ConfigConfiguration.SPRINTINGJUMP_ENCHANTMENT_ENDURANCE2.get();
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(KstaminaModEnchantments.ENDURANCE.get()) == 3) {
						stamina = (double) ConfigConfiguration.SPRINTINGJUMP_ENCHANTMENT_ENDURANCE3.get();
					}
					{
						double _setval = (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina - stamina;
						entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stamina = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina <= 0) {
						{
							double _setval = 0;
							entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.stamina = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else {
					stamina = (double) ConfigConfiguration.JUMP.get();
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(KstaminaModEnchantments.ENDURANCE.get()) == 1) {
						stamina = (double) ConfigConfiguration.JUMP_ENCHANTMENT_ENDURANCE1.get();
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(KstaminaModEnchantments.ENDURANCE.get()) == 2) {
						stamina = (double) ConfigConfiguration.JUMP_ENCHANTMENT_ENDURANCE2.get();
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(KstaminaModEnchantments.ENDURANCE.get()) == 3) {
						stamina = (double) ConfigConfiguration.JUMP_ENCHANTMENT_ENDURANCE3.get();
					}
					{
						double _setval = (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina - stamina;
						entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stamina = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina <= 0) {
						{
							double _setval = 0;
							entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.stamina = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina_regen_cd < (double) ConfigConfiguration.STAMINA_REGEN_CD_JUMP.get()) {
					{
						double _setval = (double) ConfigConfiguration.STAMINA_REGEN_CD_JUMP.get();
						entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stamina_regen_cd = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).tired == true) {
					{
						double _setval = (double) ConfigConfiguration.JUMP_CD.get();
						entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jump_cd = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = entity instanceof LivingEntity _livingEntity29 && _livingEntity29.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity29.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0;
						entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.default_attribute_jump = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
						_livingEntity30.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0);
				}
			}
		}
	}
}