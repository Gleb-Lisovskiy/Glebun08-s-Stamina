
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.glebun08.stamina.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.glebun08.stamina.GstaminaMod;

public class GstaminaModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, GstaminaMod.MODID);
	public static final DeferredHolder<Potion, Potion> ADRENALINE_POTION = REGISTRY.register("adrenaline_potion", () -> new Potion(new MobEffectInstance(GstaminaModMobEffects.ADRENALINE, 3600, 0, false, true)));
}
