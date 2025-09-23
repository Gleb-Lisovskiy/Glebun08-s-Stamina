package net.mcreator.kerilom.stamina.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

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
import net.minecraft.client.Minecraft;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;
import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerHitEntityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
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
			if (sourceentity instanceof Player && (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(sourceentity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
					}
					return false;
				}
			}.checkGamemode(sourceentity))) {
				if (((entity instanceof LivingEntity _entUseItem4 ? _entUseItem4.getUseItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
						|| (entity instanceof LivingEntity _entUseItem6 ? _entUseItem6.getUseItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem
						|| (entity instanceof LivingEntity _entUseItem8 ? _entUseItem8.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem
						|| (entity instanceof LivingEntity _entUseItem10 ? _entUseItem10.getUseItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
						|| (entity instanceof LivingEntity _entUseItem12 ? _entUseItem12.getUseItem() : ItemStack.EMPTY).getItem() instanceof HoeItem)
						&& (sourceentity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina_regen_cd < (double) ConfigConfiguration.STAMINA_REGEN_CD_HITTED_ENTITY.get()
								/ 1.65) {
					{
						double _setval = (double) ConfigConfiguration.STAMINA_REGEN_CD_HITTED_ENTITY.get() / 1.65;
						sourceentity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stamina_regen_cd = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if ((sourceentity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina_regen_cd < (double) ConfigConfiguration.STAMINA_REGEN_CD_HITTED_ENTITY.get()) {
					{
						double _setval = (double) ConfigConfiguration.STAMINA_REGEN_CD_HITTED_ENTITY.get();
						sourceentity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stamina_regen_cd = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
				{
					double _setval = (sourceentity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KstaminaModVariables.PlayerVariables())).stamina - (double) ConfigConfiguration.HITTED_ENTITY.get() / 1.3;
					sourceentity.getCapability(KstaminaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stamina = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		}
	}
}