/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kerilom.stamina.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.kerilom.stamina.enchantment.EnduranceEnchantment;
import net.mcreator.kerilom.stamina.KstaminaMod;

public class KstaminaModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, KstaminaMod.MODID);
	public static final RegistryObject<Enchantment> ENDURANCE = REGISTRY.register("endurance", () -> new EnduranceEnchantment());
}