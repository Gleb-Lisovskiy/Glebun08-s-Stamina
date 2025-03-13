package net.mcreator.glebun08.stamina.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

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
		if (entity instanceof Player && (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if ((!(world.getBlockFloorHeight(BlockPos.containing(x, y, z)) > 0) || blockstate.canBeReplaced()) && broken == false) {
				broken = true;
				{
					GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina - 0.25;
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
					_vars.stamina = entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina - 0.85;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.getData(GstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < 25) {
					{
						GstaminaModVariables.PlayerVariables _vars = entity.getData(GstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina_regen_cd = 30;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
