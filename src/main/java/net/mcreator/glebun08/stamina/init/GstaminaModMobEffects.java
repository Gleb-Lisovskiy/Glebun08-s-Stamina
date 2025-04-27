
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.glebun08.stamina.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.glebun08.stamina.potion.AdrenalineMobEffect;
import net.mcreator.glebun08.stamina.GstaminaMod;

public class GstaminaModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, GstaminaMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> ADRENALINE = REGISTRY.register("adrenaline", () -> new AdrenalineMobEffect());
}
