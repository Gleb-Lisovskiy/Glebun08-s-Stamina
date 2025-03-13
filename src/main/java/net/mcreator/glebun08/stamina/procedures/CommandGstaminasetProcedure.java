package net.mcreator.glebun08.stamina.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CommandGstaminasetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		{
			GstaminaModVariables.PlayerVariables _vars = (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getData(GstaminaModVariables.PLAYER_VARIABLES);
			_vars.stamina = DoubleArgumentType.getDouble(arguments, "number");
			_vars.syncPlayerVariables((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()));
		}
	}
}
