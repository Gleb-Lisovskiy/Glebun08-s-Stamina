package net.mcreator.kerilom.stamina.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

public class CheckWeaponPointBlankProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		String modid = "";
		Entity entity_ = null;
		entity_ = entity;
		modid = "pointblank";
		if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "glock17")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "glock18")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m9")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m1911a1")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "tti_viper")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "p30l")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "mk23")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "deserteagle")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "rhino")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m4a1")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m4a1mod1")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "star15")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m4sopmodii")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m16a1")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "hk416")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "scarl")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "xm7")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "g36c")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "g36k")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "aug")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "g41")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "ak47")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "ak74")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "ak12")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "an94")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "ar57")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "xm29")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "mp5")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "mp7")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "ro635")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "ro635")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "ump45")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "vector")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "p90")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m950")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "tmp")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "sl8")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "mk14ebr")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "uar10")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "g3")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "wa2000")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "c14")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "ballista")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "gm6lynx")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m590")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m870")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "spas12")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m1014")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "aa12")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "citoricxs")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "hs12")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "lamg")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "mk48")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m249")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m32mgl")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "smaw")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "at4")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "javelin")).toLowerCase(java.util.Locale.ENGLISH)))
				|| (entity_ instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((modid + ":" + "m134minigun")).toLowerCase(java.util.Locale.ENGLISH)))) {
			return true;
		}
		return false;
	}
}