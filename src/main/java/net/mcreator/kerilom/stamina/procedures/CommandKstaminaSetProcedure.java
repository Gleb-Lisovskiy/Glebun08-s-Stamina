package net.mcreator.kerilom.stamina.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CommandKstaminaSetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		{
			KstaminaModVariables.PlayerVariables _vars = (commandParameterEntity(arguments, "player")).getData(KstaminaModVariables.PLAYER_VARIABLES);
			_vars.stamina = DoubleArgumentType.getDouble(arguments, "number");
			_vars.syncPlayerVariables((commandParameterEntity(arguments, "player")));
		}
	}

	private static Entity commandParameterEntity(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return EntityArgument.getEntity(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}