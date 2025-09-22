/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kerilom.stamina.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.kerilom.stamina.potion.AdrenalineMobEffect;
import net.mcreator.kerilom.stamina.KstaminaMod;

public class KstaminaModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, KstaminaMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> ADRENALINE = REGISTRY.register("adrenaline", () -> new AdrenalineMobEffect());
}