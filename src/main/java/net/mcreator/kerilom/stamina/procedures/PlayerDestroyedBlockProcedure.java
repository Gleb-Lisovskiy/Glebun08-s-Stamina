package net.mcreator.kerilom.stamina.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.kerilom.stamina.network.KstaminaModVariables;
import net.mcreator.kerilom.stamina.configuration.ConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerDestroyedBlockProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double staminacost = 0;
		double stamina_regen_cd = 0;
		boolean canset_src = false;
		canset_src = false;
		stamina_regen_cd = 0;
		if (ConfigConfiguration.DBLOCK_BOOLEAN.get() == true) {
			if (entity instanceof Player && (getEntityGameType(entity) == GameType.SURVIVAL || getEntityGameType(entity) == GameType.ADVENTURE)) {
				if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() == true) {
					if ((double) ConfigConfiguration.STAMINA_REGEN_CD_DBLOCK.get() > entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd) {
						stamina_regen_cd = (double) ConfigConfiguration.STAMINA_REGEN_CD_DBLOCK.get();
						canset_src = true;
					}
					staminacost = (double) ConfigConfiguration.DBLOCK.get();
				} else {
					if ((double) ConfigConfiguration.STAMINA_REGEN_CD_DBLOCK_NONSOLID.get() > entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd) {
						stamina_regen_cd = (double) ConfigConfiguration.STAMINA_REGEN_CD_DBLOCK_NONSOLID.get();
						canset_src = true;
					}
					staminacost = (double) ConfigConfiguration.DBLOCK_NONSOLID.get();
				}
				if (ConfigConfiguration.DBLOCK_PLANTS_BOOLEAN.get() == true && ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SHORT_GRASS
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_SAPLING || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SPRUCE_SAPLING
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BIRCH_SAPLING || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.JUNGLE_SAPLING
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ACACIA_SAPLING || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DARK_OAK_SAPLING
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.MANGROVE_PROPAGULE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CHERRY_SAPLING
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SUGAR_CANE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.MOSS_CARPET
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEAD_BUSH || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FERN
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DANDELION || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.POPPY
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BLUE_ORCHID || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ALLIUM
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AZURE_BLUET || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.RED_TULIP
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ORANGE_TULIP || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WHITE_TULIP
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.PINK_TULIP || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OXEYE_DAISY
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CORNFLOWER || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LILY_OF_THE_VALLEY
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TORCHFLOWER || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.PINK_PETALS
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SUNFLOWER || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LILAC
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TALL_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LARGE_FERN
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ROSE_BUSH || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.PEONY
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.PITCHER_PLANT || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BROWN_MUSHROOM
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.RED_MUSHROOM || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WARPED_FUNGUS
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CRIMSON_FUNGUS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WHEAT
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHER_WART || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.PUMPKIN_STEM
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ATTACHED_PUMPKIN_STEM || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SWEET_BERRY_BUSH
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.VINE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.GLOW_LICHEN
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LILY_PAD || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEETROOTS
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CARROTS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.POTATOES
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TORCHFLOWER_CROP || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.HAY_BLOCK
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.KELP || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.KELP_PLANT
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SEAGRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TALL_SEAGRASS
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BAMBOO_SAPLING || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BAMBOO
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DRIED_KELP_BLOCK || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WARPED_ROOTS
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHER_SPROUTS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WEEPING_VINES
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WEEPING_VINES_PLANT || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TWISTING_VINES
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TWISTING_VINES_PLANT || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CRIMSON_ROOTS
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CAVE_VINES || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CAVE_VINES_PLANT
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SPORE_BLOSSOM || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AZALEA
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWERING_AZALEA || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BIG_DRIPLEAF
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BIG_DRIPLEAF_STEM || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SMALL_DRIPLEAF
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.HANGING_ROOTS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SCULK_VEIN)) {
					if ((double) ConfigConfiguration.STAMINA_REGEN_CD_DBLOCK_PLANTS.get() > entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd) {
						stamina_regen_cd = (double) ConfigConfiguration.STAMINA_REGEN_CD_DBLOCK_PLANTS.get();
						canset_src = true;
					}
					staminacost = (double) ConfigConfiguration.DBLOCK_PLANTS.get();
				}
				if ((BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).equals("minecraft:ancient_debris") && ConfigConfiguration.DBLOCK_ANCIENT_DEBRIS_BOOLEAN.get() == true) {
					if ((double) ConfigConfiguration.STAMINA_REGEN_CD_DBLOCK_ANCIENT_DEBRIS.get() > entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd) {
						stamina_regen_cd = (double) ConfigConfiguration.STAMINA_REGEN_CD_DBLOCK_ANCIENT_DEBRIS.get();
						canset_src = true;
					}
					staminacost = (double) ConfigConfiguration.DBLOCK_ANCIENT_DEBRIS.get();
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WOODEN_AXE
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WOODEN_SHOVEL
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WOODEN_PICKAXE
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WOODEN_SWORD
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WOODEN_HOE) {
					if (stamina_regen_cd / 1.8 > entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd) {
						stamina_regen_cd = stamina_regen_cd / 1.8;
						canset_src = true;
					}
					staminacost = staminacost / 1.8;
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof HoeItem) {
					if (stamina_regen_cd / 2.4 > entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd) {
						stamina_regen_cd = stamina_regen_cd / 2.4;
						canset_src = true;
					}
					staminacost = staminacost / 3.6;
				}
				if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY)) != 0) == true) {
					if (stamina_regen_cd / (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY)) > entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina_regen_cd) {
						stamina_regen_cd = stamina_regen_cd
								/ (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY));
						canset_src = true;
					}
					staminacost = staminacost
							/ (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY));
				}
				if (canset_src == true) {
					{
						KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
						_vars.stamina_regen_cd = stamina_regen_cd;
						_vars.syncPlayerVariables(entity);
					}
				}
				{
					KstaminaModVariables.PlayerVariables _vars = entity.getData(KstaminaModVariables.PLAYER_VARIABLES);
					_vars.stamina = entity.getData(KstaminaModVariables.PLAYER_VARIABLES).stamina - staminacost;
					_vars.syncPlayerVariables(entity);
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