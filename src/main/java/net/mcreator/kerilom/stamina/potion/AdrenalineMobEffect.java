package net.mcreator.kerilom.stamina.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kerilom.stamina.procedures.AdrenalineEffectTickProcedure;

public class AdrenalineMobEffect extends MobEffect {
	public AdrenalineMobEffect() {
		super(MobEffectCategory.NEUTRAL, -205);
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