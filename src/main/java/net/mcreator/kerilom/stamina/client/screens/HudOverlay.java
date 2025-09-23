package net.mcreator.kerilom.stamina.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.kerilom.stamina.procedures.IsPlayerInCreativeProcedure;
import net.mcreator.kerilom.stamina.procedures.HudStaminaGlowingProcedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina9Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina8Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina7Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina6Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina5Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina4Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina3Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina2Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina20Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina1Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina19Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina18Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina17Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina16Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina15Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina14Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina13Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina12Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina11Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina10Procedure;
import net.mcreator.kerilom.stamina.procedures.HudStamina0Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class HudOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (IsPlayerInCreativeProcedure.execute(entity)) {
			if (HudStamina0Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_0.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_1.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_2.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_3.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_4.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_5.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_6.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_7.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_8.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_9.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_10.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_11.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_12.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_13.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_14.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_15.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_16.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina17Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_17.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina18Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_18.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina19Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_19.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStamina20Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/stamina_20.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
			if (HudStaminaGlowingProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("kstamina:textures/screens/icon_stamina_glow.png"), w / 2 + 93, h - 40, 0, 0, 16, 16, 16, 16);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}