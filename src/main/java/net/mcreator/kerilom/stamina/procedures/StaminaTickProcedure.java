package net.mcreator.kerilom.stamina.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;
import net.mcreator.kerilom.stamina.init.KstaminaModEnchantments;
import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

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
		double stamina = 0;
		if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina_regen_cd > 0) {
			{
				double _setval = (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina_regen_cd - 1;
				entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stamina_regen_cd = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:regenstaminacd
		} else if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina_regen_cd <= 0
				&& (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina < (double) ConfigConfiguration.MAXSTAMINA.get()) {
			{
				double _setval = (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina + (double) ConfigConfiguration.REGENSTAMINA.get();
				entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:regenstamina
		}
		if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina > (double) ConfigConfiguration.MAXSTAMINA.get()) {
			{
				double _setval = (double) ConfigConfiguration.MAXSTAMINA.get();
				entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity.isSprinting() && (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina > 0) {
			stamina = (double) ConfigConfiguration.SPRINTING.get();
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(KstaminaModEnchantments.ENDURANCE.get()) == 1) {
				stamina = (double) ConfigConfiguration.SPRINTING_ENCHANTMENT_ENDURANCE1.get();
			} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(KstaminaModEnchantments.ENDURANCE.get()) == 2) {
				stamina = (double) ConfigConfiguration.SPRINTING_ENCHANTMENT_ENDURANCE2.get();
			} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantmentLevel(KstaminaModEnchantments.ENDURANCE.get()) == 3) {
				stamina = (double) ConfigConfiguration.SPRINTING_ENCHANTMENT_ENDURANCE3.get();
			}
			{
				double _setval = (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina - stamina;
				entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina_regen_cd < (double) ConfigConfiguration.STAMINA_REGEN_CD_SPRINTING.get()) {
				{
					double _setval = (double) ConfigConfiguration.STAMINA_REGEN_CD_SPRINTING.get();
					entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stamina_regen_cd = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:sprinting
		}
		if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).tired == false
				&& (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina <= 0) {
			{
				boolean _setval = true;
				entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tired = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:tired
		} else if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).tired == true
				&& (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina >= Math.round((double) ConfigConfiguration.MAXSTAMINA.get() / 4)) {
			{
				boolean _setval = false;
				entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tired = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:nontired
		}
		if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).tired == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10, 1, false, false));
		}
		if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).tired == true
				&& (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).jump_cd > 0) {
			{
				double _setval = (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).jump_cd - 1;
				entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jump_cd = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			assert Boolean.TRUE; //#dbg:StaminaTick:jumpcd
		} else if ((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).tired == true
				&& (entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).jump_cd <= 0
				&& (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity21.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) == 0) {
			assert Boolean.TRUE; //#dbg:StaminaTick:canjump
			if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
				_livingEntity22.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(((entity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).default_attribute_jump));
		}
	}
}