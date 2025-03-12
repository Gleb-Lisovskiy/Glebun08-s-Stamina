package net.mcreator.glebun08.stamina.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.glebun08.stamina.network.GstaminaModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerDestroyedBlockProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		boolean broken = false;
		if (entity instanceof Player) {
			if ((!(world.getBlockFloorHeight(BlockPos.containing(x, y, z)) > 0) || blockstate.canBeReplaced()) && broken == false) {
				broken = true;
				{
					GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina - 0.5;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < 15) {
					{
						GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina_regen_cd = 15;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
			if (!(Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) && broken == false) {
				broken = true;
				{
					GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina - 2;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < 25) {
					{
						GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina_regen_cd = 25;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
