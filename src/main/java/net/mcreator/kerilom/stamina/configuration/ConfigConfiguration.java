package net.mcreator.kerilom.stamina.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> MAXSTAMINA;
	public static final ModConfigSpec.ConfigValue<Double> REGENSTAMINA;

	public static final ModConfigSpec.ConfigValue<Boolean> SPRINTING_BOOLEAN;
	public static final ModConfigSpec.ConfigValue<Double> SPRINTING;
	public static final ModConfigSpec.ConfigValue<Double> STAMINA_REGEN_CD_SPRINTING;

	public static final ModConfigSpec.ConfigValue<Double> SPRINTING_ENCHANTMENT_ENDURANCE1;
	public static final ModConfigSpec.ConfigValue<Double> SPRINTING_ENCHANTMENT_ENDURANCE2;
	public static final ModConfigSpec.ConfigValue<Double> SPRINTING_ENCHANTMENT_ENDURANCE3;

	public static final ModConfigSpec.ConfigValue<Boolean> SPRINTINGJUMP_BOOLEAN;
	public static final ModConfigSpec.ConfigValue<Double> SPRINTINGJUMP;
	public static final ModConfigSpec.ConfigValue<Boolean> JUMP_BOOLEAN;
	public static final ModConfigSpec.ConfigValue<Double> JUMP;
	public static final ModConfigSpec.ConfigValue<Double> JUMP_CD;
	public static final ModConfigSpec.ConfigValue<Double> STAMINA_REGEN_CD_JUMP;

	public static final ModConfigSpec.ConfigValue<Double> SPRINTINGJUMP_ENCHANTMENT_ENDURANCE1;
	public static final ModConfigSpec.ConfigValue<Double> JUMP_ENCHANTMENT_ENDURANCE1;

	public static final ModConfigSpec.ConfigValue<Double> SPRINTINGJUMP_ENCHANTMENT_ENDURANCE2;
	public static final ModConfigSpec.ConfigValue<Double> JUMP_ENCHANTMENT_ENDURANCE2;

	public static final ModConfigSpec.ConfigValue<Double> SPRINTINGJUMP_ENCHANTMENT_ENDURANCE3;
	public static final ModConfigSpec.ConfigValue<Double> JUMP_ENCHANTMENT_ENDURANCE3;

	public static final ModConfigSpec.ConfigValue<Boolean> DBLOCK_ANCIENT_DEBRIS_BOOLEAN;
	public static final ModConfigSpec.ConfigValue<Double> DBLOCK_ANCIENT_DEBRIS;
	public static final ModConfigSpec.ConfigValue<Double> STAMINA_REGEN_CD_DBLOCK_ANCIENT_DEBRIS;
	public static final ModConfigSpec.ConfigValue<Boolean> DBLOCK_PLANTS_BOOLEAN;
	public static final ModConfigSpec.ConfigValue<Double> DBLOCK_PLANTS;
	public static final ModConfigSpec.ConfigValue<Double> STAMINA_REGEN_CD_DBLOCK_PLANTS;
	public static final ModConfigSpec.ConfigValue<Double> DBLOCK_NONSOLID;
	public static final ModConfigSpec.ConfigValue<Double> STAMINA_REGEN_CD_DBLOCK_NONSOLID;
	public static final ModConfigSpec.ConfigValue<Boolean> DBLOCK_BOOLEAN;
	public static final ModConfigSpec.ConfigValue<Double> DBLOCK;
	public static final ModConfigSpec.ConfigValue<Double> STAMINA_REGEN_CD_DBLOCK;
	public static final ModConfigSpec.ConfigValue<Boolean> HITTED_ENTITY_BOOLEAN;
	public static final ModConfigSpec.ConfigValue<Double> HITTED_ENTITY;
	public static final ModConfigSpec.ConfigValue<Double> STAMINA_REGEN_CD_HITTED_ENTITY;
	public static final ModConfigSpec.ConfigValue<Boolean> CRITED_ENTITY_BOOLEAN;
	public static final ModConfigSpec.ConfigValue<Double> CRITED_ENTITY;
	public static final ModConfigSpec.ConfigValue<Double> STAMINA_REGEN_CD_CRITED_ENTITY;
	static {
		MAXSTAMINA = BUILDER.define("Max Stamina", (double) 20);
		REGENSTAMINA = BUILDER.comment("Every Tick").define("Regen Stamina", (double) 0.125);
		BUILDER.push("Actions");
		BUILDER.push("Sprinting");
		SPRINTING_BOOLEAN = BUILDER.define("Enabled", true);
		SPRINTING = BUILDER.comment("Every Tick").define("Stamina Cost", (double) 0.045);
		STAMINA_REGEN_CD_SPRINTING = BUILDER.comment("Every Tick").define("Stamina Regen Cooldown", (double) 35);
		BUILDER.push("Enchantment Endurance");
		BUILDER.push("Level 1");
		SPRINTING_ENCHANTMENT_ENDURANCE1 = BUILDER.define("Stamina Cost", (double) 0.028);
		BUILDER.pop();
		BUILDER.push("Level 2");
		SPRINTING_ENCHANTMENT_ENDURANCE2 = BUILDER.define("Stamina Cost", (double) 0.02);
		BUILDER.pop();
		BUILDER.push("Level 3");
		SPRINTING_ENCHANTMENT_ENDURANCE3 = BUILDER.define("Stamina Cost", (double) 0.009);
		BUILDER.pop();
		BUILDER.pop();
		BUILDER.pop();
		BUILDER.push("Jump");
		BUILDER.push("Sprinting Jump");
		SPRINTINGJUMP_BOOLEAN = BUILDER.define("Enabled", true);
		SPRINTINGJUMP = BUILDER.comment("Every Jump When Sprinting").define("Stamina Cost", (double) 0.2);
		BUILDER.pop();
		JUMP_BOOLEAN = BUILDER.define("Enabled", true);
		JUMP = BUILDER.comment("Every Jump").define("Stamina Cost", (double) 0.35);
		JUMP_CD = BUILDER.comment("Jump Cooldown When Tired").define("Jump Cooldown", (double) 20);
		STAMINA_REGEN_CD_JUMP = BUILDER.comment("Every Jump").define("Stamina Regen Cooldown", (double) 35);
		BUILDER.push("Enchantment Endurance");
		BUILDER.push("Level 1");
		BUILDER.push("Sprinting Jump");
		SPRINTINGJUMP_ENCHANTMENT_ENDURANCE1 = BUILDER.comment("Every Jump When Sprinting").define("Reduced stamina consumption", (double) 0.12);
		BUILDER.pop();
		JUMP_ENCHANTMENT_ENDURANCE1 = BUILDER.comment("Every Jump").define("Reduced stamina consumption", (double) 0.24);
		BUILDER.pop();
		BUILDER.push("Level 2");
		BUILDER.push("Sprinting Jump");
		SPRINTINGJUMP_ENCHANTMENT_ENDURANCE2 = BUILDER.comment("Every Jump When Sprinting").define("Reduced stamina consumption", (double) 0.09);
		BUILDER.pop();
		JUMP_ENCHANTMENT_ENDURANCE2 = BUILDER.comment("Every Jump").define("Reduced stamina consumption", (double) 0.19);
		BUILDER.pop();
		BUILDER.push("Level 3");
		BUILDER.push("Sprinting Jump");
		SPRINTINGJUMP_ENCHANTMENT_ENDURANCE3 = BUILDER.comment("Every Jump When Sprinting").define("Reduced stamina consumption", (double) 0.03);
		BUILDER.pop();
		JUMP_ENCHANTMENT_ENDURANCE3 = BUILDER.comment("Every Jump").define("Reduced stamina consumption", (double) 0.11);
		BUILDER.pop();
		BUILDER.pop();
		BUILDER.pop();
		BUILDER.push("Destroyed Block");
		BUILDER.push("Blocks");
		BUILDER.push("Ancient Debris");
		DBLOCK_ANCIENT_DEBRIS_BOOLEAN = BUILDER.define("Enabled", true);
		DBLOCK_ANCIENT_DEBRIS = BUILDER.define("Stamina Cost", (double) 24.25);
		STAMINA_REGEN_CD_DBLOCK_ANCIENT_DEBRIS = BUILDER.define("Stamina Regen Cooldown", (double) 70);
		BUILDER.pop();
		BUILDER.push("Plants");
		DBLOCK_PLANTS_BOOLEAN = BUILDER.define("Enabled", true);
		DBLOCK_PLANTS = BUILDER.define("Stamina Cost", (double) 0.5);
		STAMINA_REGEN_CD_DBLOCK_PLANTS = BUILDER.define("Stamina Regen Cooldown", (double) 12);
		BUILDER.pop();
		BUILDER.push("Non Solid Blocks");
		DBLOCK_NONSOLID = BUILDER.define("Stamina Cost", (double) 0.6);
		STAMINA_REGEN_CD_DBLOCK_NONSOLID = BUILDER.define("Stamina Regen Cooldown", (double) 25);
		BUILDER.pop();
		BUILDER.pop();
		DBLOCK_BOOLEAN = BUILDER.define("Enabled", true);
		DBLOCK = BUILDER.define("Stamina Cost", (double) 1.1);
		STAMINA_REGEN_CD_DBLOCK = BUILDER.define("Default Stamina Regen Cooldown", (double) 30);
		BUILDER.pop();
		BUILDER.push("Hitted Entity");
		HITTED_ENTITY_BOOLEAN = BUILDER.define("Enabled", true);
		HITTED_ENTITY = BUILDER.comment("Every Hit").define("Stamina Cost", (double) 0.5);
		STAMINA_REGEN_CD_HITTED_ENTITY = BUILDER.comment("Every Hit").define("Stamina Regen Cooldown", (double) 35);
		BUILDER.pop();
		BUILDER.push("Crited Entity");
		CRITED_ENTITY_BOOLEAN = BUILDER.define("Enabled", true);
		CRITED_ENTITY = BUILDER.comment("Every Crit").define("Stamina Cost", (double) 0.85);
		STAMINA_REGEN_CD_CRITED_ENTITY = BUILDER.comment("Every Crit").define("Stamina Regen Cooldown", (double) 35);
		BUILDER.pop();
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}