package net.mcreator.kerilom.stamina.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.GameType;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;
import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerHitEntityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (ConfigConfiguration.HITTED_ENTITY_BOOLEAN.get() == true) {
			if (sourceentity instanceof Player && (getEntityGameType(sourceentity) == GameType.SURVIVAL || getEntityGameType(sourceentity) == GameType.ADVENTURE)) {
				if (((entity instanceof LivingEntity _entUseItem4 ? _entUseItem4.getUseItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
						|| (entity instanceof LivingEntity _entUseItem6 ? _entUseItem6.getUseItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem
						|| (entity instanceof LivingEntity _entUseItem8 ? _entUseItem8.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem
						|| (entity instanceof LivingEntity _entUseItem10 ? _entUseItem10.getUseItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
						|| (entity instanceof LivingEntity _entUseItem12 ? _entUseItem12.getUseItem() : ItemStack.EMPTY).getItem() instanceof HoeItem)
						&& sourceentity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < (double) ConfigConfiguration.STAMINA_REGEN_CD_HITTED_ENTITY.get() / 1.65) {
					{
						KstaminaModVariables.PlayerVariables _vars = sourceentity.getData(KstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina_regen_cd = (double) ConfigConfiguration.STAMINA_REGEN_CD_HITTED_ENTITY.get() / 1.65;
						_vars.syncPlayerVariables(sourceentity);
					}
				} else if (sourceentity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd < (double) ConfigConfiguration.STAMINA_REGEN_CD_HITTED_ENTITY.get()) {
					{
						KstaminaModVariables.PlayerVariables _vars = sourceentity.getData(KstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina_regen_cd = (double) ConfigConfiguration.STAMINA_REGEN_CD_HITTED_ENTITY.get();
						_vars.syncPlayerVariables(sourceentity);
					}
				}
				{
					KstaminaModVariables.PlayerVariables _vars = sourceentity.getData(KstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina = sourceentity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina - (double) ConfigConfiguration.HITTED_ENTITY.get() / 1.3;
					_vars.syncPlayerVariables(sourceentity);
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}