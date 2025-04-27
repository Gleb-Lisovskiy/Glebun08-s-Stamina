
package net.mcreator.glebun08.stamina.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.glebun08.stamina.procedures.AdrenalineEffectTickProcedure;

import java.util.Set;

public class AdrenalineMobEffect extends MobEffect {
	public AdrenalineMobEffect() {
		super(MobEffectCategory.NEUTRAL, -205);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		AdrenalineEffectTickProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
