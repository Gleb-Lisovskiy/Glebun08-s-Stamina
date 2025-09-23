/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kerilom.stamina.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.kerilom.stamina.potion.AdrenalineMobEffect;
import net.mcreator.kerilom.stamina.KstaminaMod;

public class KstaminaModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, KstaminaMod.MODID);
	public static final RegistryObject<MobEffect> ADRENALINE = REGISTRY.register("adrenaline", () -> new AdrenalineMobEffect());
}