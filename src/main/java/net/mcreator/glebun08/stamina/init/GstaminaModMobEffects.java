
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.glebun08.stamina.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.glebun08.stamina.potion.AdrenalineMobEffect;
import net.mcreator.glebun08.stamina.GstaminaMod;

public class GstaminaModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GstaminaMod.MODID);
	public static final RegistryObject<MobEffect> ADRENALINE = REGISTRY.register("adrenaline", () -> new AdrenalineMobEffect());
}
