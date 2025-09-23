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
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AdrenalineEffectTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}