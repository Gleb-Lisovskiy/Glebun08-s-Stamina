package net.mcreator.glebun08.stamina.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigcommonConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> MAXSTAMINA;
	public static final ForgeConfigSpec.ConfigValue<Double> REGENSTAMINA;
	public static final ForgeConfigSpec.ConfigValue<Double> REGENSTAMINA1;
	public static final ForgeConfigSpec.ConfigValue<Double> SPRINTING;
	public static final ForgeConfigSpec.ConfigValue<Double> JUMP;
	public static final ForgeConfigSpec.ConfigValue<Double> DBLOCK;
	public static final ForgeConfigSpec.ConfigValue<Double> DBLOCK1;
	public static final ForgeConfigSpec.ConfigValue<Double> HITTED_ENTITY;
	public static final ForgeConfigSpec.ConfigValue<Double> CRITED_ENTITY;
	static {
		MAXSTAMINA = BUILDER.define("Max Stamina", (double) 20);
		REGENSTAMINA = BUILDER.define("Regen Stamina", (double) 0.05);
		REGENSTAMINA1 = BUILDER.define("Regen Stamina (if player not moving)", (double) 0.05);
		BUILDER.push("Actions");
		SPRINTING = BUILDER.define("Sprinting", (double) 0.06);
		JUMP = BUILDER.define("Jump", (double) 0.55);
		DBLOCK = BUILDER.define("Destroyed Block", (double) 0.85);
		DBLOCK1 = BUILDER.define("Destroyed Block (if non-collision or block can replaced)", (double) 0.25);
		HITTED_ENTITY = BUILDER.define("Hitted Entity", (double) 0.7);
		CRITED_ENTITY = BUILDER.define("Crited Entity", (double) 0.5);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
