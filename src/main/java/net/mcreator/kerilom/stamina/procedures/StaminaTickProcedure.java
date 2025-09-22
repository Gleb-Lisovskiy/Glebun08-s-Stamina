package net.mcreator.kerilom.stamina.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;
import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StaminaTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double stamina = 0;
		if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd > 0) {
			{
				KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
				_vars.stamina_regen_cd = entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd - 1;
				_vars.syncPlayerVariables(entity);
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:regenstaminacd
		} else if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd <= 0 && entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina < (double) ConfigConfiguration.MAXSTAMINA.get()) {
			{
				KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
				_vars.stamina = entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina + (double) ConfigConfiguration.REGENSTAMINA.get();
				_vars.syncPlayerVariables(entity);
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:regenstamina
		}
		if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina > (double) ConfigConfiguration.MAXSTAMINA.get()) {
			{
				KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
				_vars.stamina = (double) ConfigConfiguration.MAXSTAMINA.get();
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.isSprinting() && entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina > 0) {
			stamina = (double) ConfigConfiguration.SPRINTING.get();
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kstamina:endurance")))) == 1) {
				stamina = (double) ConfigConfiguration.SPRINTING_ENCHANTMENT_ENDURANCE1.get();
			} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kstamina:endurance")))) == 2) {
				stamina = (double) ConfigConfiguration.SPRINTING_ENCHANTMENT_ENDURANCE2.get();
			} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kstamina:endurance")))) == 3) {
				stamina = (double) ConfigConfiguration.SPRINTING_ENCHANTMENT_ENDURANCE3.get();
			}
			{
				KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
				_vars.stamina = entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina - stamina;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < (double) ConfigConfiguration.STAMINA_REGEN_CD_SPRINTING.get()) {
				{
					KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina_regen_cd = (double) ConfigConfiguration.STAMINA_REGEN_CD_SPRINTING.get();
					_vars.syncPlayerVariables(entity);
				}
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:sprinting
		}
		if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).tired == false && entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina <= 0) {
			{
				KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
				_vars.tired = true;
				_vars.syncPlayerVariables(entity);
			}
			{
				KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
				_vars.stamina = 0;
				_vars.syncPlayerVariables(entity);
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:tired
		} else if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).tired == true && entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina >= Math.round((double) ConfigConfiguration.MAXSTAMINA.get() / 4)) {
			{
				KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
				_vars.tired = false;
				_vars.syncPlayerVariables(entity);
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:nontired
		}
		if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).tired == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10, 1, false, false));
		}
		if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).tired == true && entity.getData(KstaminaModVariables.PLAYER_VARIABLES).jump_cd > 0) {
			{
				KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
				_vars.jump_cd = entity.getData(KstaminaModVariables.PLAYER_VARIABLES).jump_cd - 1;
				_vars.syncPlayerVariables(entity);
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:jumpcd
		} else if (entity.getData(KstaminaModVariables.PLAYER_VARIABLES).tired == true && entity.getData(KstaminaModVariables.PLAYER_VARIABLES).jump_cd <= 0
				&& (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity21.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) == 0) {
			assert Boolean.TRUE; //#dbg:StaminaTick:canjump
			if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
				_livingEntity22.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(entity.getData(KstaminaModVariables.PLAYER_VARIABLES).default_attribute_jump);
		}
	}
}