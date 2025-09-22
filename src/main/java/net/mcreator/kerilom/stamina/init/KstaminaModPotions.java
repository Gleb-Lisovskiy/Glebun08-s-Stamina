/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kerilom.stamina.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.kerilom.stamina.KstaminaMod;

public class KstaminaModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, KstaminaMod.MODID);
	public static final DeferredHolder<Potion, Potion> ADRENALINE_POTION = REGISTRY.register("adrenaline_potion", () -> new Potion(new MobEffectInstance(KstaminaModMobEffects.ADRENALINE, 3600, 0, false, true)));
}