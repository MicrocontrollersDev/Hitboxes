package gq.noxiuam.hitboxes.mixin;

import cc.polyfrost.oneconfig.config.core.OneColor;
import gq.noxiuam.hitboxes.HitBoxes;
import gq.noxiuam.hitboxes.config.HitBoxesConfig;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_LINE_STIPPLE;

@Mixin(RenderManager.class)
public class RenderManagerMixin {

    @Inject(method = "doRenderEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/Render;doRender(Lnet/minecraft/entity/Entity;DDDFF)V"))
    public void overrideHitboxRendering(Entity entityIn, double x, double y, double z, float entityYaw, float partialTicks, boolean p_147939_10_, CallbackInfoReturnable<Boolean> cir) {

        HitBoxesConfig config = HitBoxes.INSTANCE.config;

        boolean showPlayerHitbox = config.showPlayerHitbox && entityIn instanceof AbstractClientPlayer;
        boolean showMobHitbox = config.showMobHitbox
                && (!(entityIn instanceof AbstractClientPlayer)
                && !(entityIn instanceof EntityItem)
                && !(entityIn instanceof EntityThrowable)
                && !(entityIn instanceof EntityXPOrb)
        );
        boolean showItemHitbox = config.showItemHitbox && entityIn instanceof EntityItem;
        boolean showProjectileHitbox = config.showProjectileHitbox && (entityIn instanceof EntityThrowable || entityIn instanceof EntityArrow);
        boolean showXPOrbHitbox = config.showXPOrbHitbox && entityIn instanceof EntityXPOrb;

        if (showPlayerHitbox) {
            renderHitbox(entityIn, x, y, z, partialTicks,
                    config.dashedPlayerHitbox, config.playerOutlineColor, config.playerEyeHeightColor, config.playerLookVectorColor);
        } else if (showMobHitbox) {
            renderHitbox(entityIn, x, y, z, partialTicks,
                    config.dashedMobHitbox, config.mobOutlineColor, config.mobEyeHeightColor, config.mobLookVectorColor);
        } else if (showItemHitbox) {
            renderHitbox(entityIn, x, y, z, partialTicks,
                    config.dashedItemHitbox, config.itemOutlineColor, config.itemEyeHeightColor, config.itemLookVectorColor);
        } else if (showProjectileHitbox) {
            renderHitbox(entityIn, x, y, z, partialTicks,
                    config.dashedProjectileHitbox, config.projectileOutlineColor, config.projectileEyeHeightColor, config.projectileLookVectorColor);
        } else if (showXPOrbHitbox) {
            renderHitbox(entityIn, x, y, z, partialTicks,
                    config.dashedXPOrbHitbox, config.xpOrbOutlineColor, config.xpOrbEyeHeightColor, config.xpOrbLookVectorColor);
        }

    }

    @Inject(method = "renderDebugBoundingBox", at = @At(value = "HEAD"), cancellable = true)
    public void cancelVanillaHitboxes(CallbackInfo ci) {
        ci.cancel();
    }

    private void renderHitbox(Entity entityIn, double x, double y, double z, float partialTicks, boolean dashed, OneColor outlineColor, OneColor eyeHeightColor, OneColor lookVectorColor) {

        boolean[] options = HitBoxes.INSTANCE.config.getEntityBooleanOptions(entityIn);

        boolean showOutline = options[0];
        boolean showEyeHeight = options[1];
        boolean showLookVector = options[2];

        GlStateManager.depthMask(false);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.disableBlend();
        float f = entityIn.width / 2.0f;
        AxisAlignedBB axisalignedbb = entityIn.getEntityBoundingBox();

        if (dashed) {
            GL11.glPushAttrib(8192);
            GL11.glLineStipple(5, (short) 0xAAAA);
            GL11.glEnable(GL_LINE_STIPPLE);
            GL11.glBegin(GL_LINES);
            GL11.glEnd();
        }

        if (showOutline) {
            AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(axisalignedbb.minX - entityIn.posX + x, axisalignedbb.minY - entityIn.posY + y, axisalignedbb.minZ - entityIn.posZ + z, axisalignedbb.maxX - entityIn.posX + x, axisalignedbb.maxY - entityIn.posY + y, axisalignedbb.maxZ - entityIn.posZ + z);
            RenderGlobal.drawOutlinedBoundingBox(axisalignedbb1, outlineColor.getRed(), outlineColor.getGreen(), outlineColor.getBlue(), outlineColor.getAlpha());
        }

        if (showEyeHeight) {
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(x - (double)f, y + (double)entityIn.getEyeHeight() - (double)0.01f, z - (double)f, x + (double)f, y + (double)entityIn.getEyeHeight() + (double)0.01f, z + (double)f),
                    eyeHeightColor.getRed(), eyeHeightColor.getGreen(), eyeHeightColor.getBlue(), eyeHeightColor.getAlpha());
        }

        if (dashed) {
            GL11.glPopAttrib();
        }

        if (showLookVector) {
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            Vec3 vec3 = entityIn.getLook(partialTicks);
            worldrenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
            worldrenderer.pos(x, y + (double)entityIn.getEyeHeight(), z).color(lookVectorColor.getRed(), lookVectorColor.getGreen(), lookVectorColor.getBlue(), lookVectorColor.getAlpha()).endVertex();
            worldrenderer.pos(x + vec3.xCoord * 2.0, y + (double)entityIn.getEyeHeight() + vec3.yCoord * 2.0, z + vec3.zCoord * 2.0).color(0, 0, 255, 255).endVertex();
            tessellator.draw();
        }

        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);

    }

}
