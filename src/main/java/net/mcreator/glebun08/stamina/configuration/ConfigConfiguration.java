package net.mcreator.glebun08.stamina.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> MAXSTAMINA;
	public static final ModConfigSpec.ConfigValue<Double> REGENSTAMINA;
	public static final ModConfigSpec.ConfigValue<Double> REGENSTAMINA1;
	public static final ModConfigSpec.ConfigValue<Double> SPRINTING;
	public static final ModConfigSpec.ConfigValue<Double> JUMP;
	public static final ModConfigSpec.ConfigValue<Double> DBLOCK;
	public static final ModConfigSpec.ConfigValue<Double> DBLOCK1;
	public static final ModConfigSpec.ConfigValue<Double> HITTED_ENTITY;
	public static final ModConfigSpec.ConfigValue<Double> CRITED_ENTITY;
	static {
		MAXSTAMINA = BUILDER.define("Max Stamina", (double) 20);
		REGENSTAMINA = BUILDER.define("Regen Stamina", (double) 0.05);
		REGENSTAMINA1 = BUILDER.define("Regen Stamina (No moving)", (double) 0.05);
		BUILDER.push("Actions");
		SPRINTING = BUILDER.define("Sprinting", (double) 0.06);
		JUMP = BUILDER.define("Jump", (double) 0.55);
		DBLOCK = BUILDER.define("Destroyed Block", (double) 0.85);
		DBLOCK1 = BUILDER.comment("(if block non-collision or can replaced)").define("Destroyed Block 1", (double) 0.25);
		HITTED_ENTITY = BUILDER.define("Hitted Entity", (double) 0.7);
		CRITED_ENTITY = BUILDER.define("Crited Entity", (double) 0.5);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
