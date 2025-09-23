/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kerilom.stamina.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kerilom.stamina.KstaminaMod;

public class KstaminaModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, KstaminaMod.MODID);
	public static final RegistryObject<Potion> ADRENALINE_POTION = REGISTRY.register("adrenaline_potion", () -> new Potion(new MobEffectInstance(KstaminaModMobEffects.ADRENALINE.get(), 3600, 0, false, true)));
}