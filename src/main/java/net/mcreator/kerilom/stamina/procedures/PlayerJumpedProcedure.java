package net.mcreator.kerilom.stamina.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;
import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
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
			if (entity instanceof Player && (getEntityGameType(entity) == GameType.SURVIVAL || getEntityGameType(entity) == GameType.ADVENTURE)) {
				if (ConfigConfiguration.SPRINTINGJUMP_BOOLEAN.get() == true && entity.isSprinting()) {
					stamina = (double) ConfigConfiguration.SPRINTINGJUMP.get();
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kstamina:endurance")))) == 1) {
						stamina = (double) ConfigConfiguration.SPRINTINGJUMP_ENCHANTMENT_ENDURANCE1.get();
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kstamina:endurance")))) == 2) {
						stamina = (double) ConfigConfiguration.SPRINTINGJUMP_ENCHANTMENT_ENDURANCE2.get();
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kstamina:endurance")))) == 3) {
						stamina = (double) ConfigConfiguration.SPRINTINGJUMP_ENCHANTMENT_ENDURANCE3.get();
					}
					{
						KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina = entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina - stamina;
						_vars.syncPlayerVariables(entity);
					}
					if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina <= 0) {
						{
							KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
							_vars.stamina = 0;
							_vars.syncPlayerVariables(entity);
						}
					}
				} else {
					stamina = (double) ConfigConfiguration.JUMP.get();
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kstamina:endurance")))) == 1) {
						stamina = (double) ConfigConfiguration.JUMP_ENCHANTMENT_ENDURANCE1.get();
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kstamina:endurance")))) == 2) {
						stamina = (double) ConfigConfiguration.JUMP_ENCHANTMENT_ENDURANCE2.get();
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kstamina:endurance")))) == 3) {
						stamina = (double) ConfigConfiguration.JUMP_ENCHANTMENT_ENDURANCE3.get();
					}
					{
						KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina = entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina - stamina;
						_vars.syncPlayerVariables(entity);
					}
					if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina <= 0) {
						{
							KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
							_vars.stamina = 0;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
				if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < (double) ConfigConfiguration.STAMINA_REGEN_CD_JUMP.get()) {
					{
						KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina_regen_cd = (double) ConfigConfiguration.STAMINA_REGEN_CD_JUMP.get();
						_vars.syncPlayerVariables(entity);
					}
				}
				if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).tired == true) {
					{
						KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
						_vars.jump_cd = (double) ConfigConfiguration.JUMP_CD.get();
						_vars.syncPlayerVariables(entity);
					}
					{
						KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
						_vars.default_attribute_jump = entity instanceof LivingEntity _livingEntity29 && _livingEntity29.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH)
								? _livingEntity29.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue()
								: 0;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
						_livingEntity30.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0);
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}