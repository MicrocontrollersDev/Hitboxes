package gq.noxiuam.hitboxes.mixin;

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
    public void redirect(Entity entityIn, double x, double y, double z, float entityYaw, float partialTicks, boolean p_147939_10_, CallbackInfoReturnable<Boolean> cir) {

        if (HitBoxesConfig.showPlayerHitbox && entityIn instanceof AbstractClientPlayer) {
            GlStateManager.depthMask(false);
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            float f = entityIn.width / 2.0f;
            AxisAlignedBB axisalignedbb = entityIn.getEntityBoundingBox();

            if (HitBoxesConfig.dashedPlayerHitbox) {
                GL11.glPushAttrib(8192);
                GL11.glLineStipple(5, (short) 0xAAAA);
                GL11.glEnable(GL_LINE_STIPPLE);
                GL11.glBegin(GL_LINES);
                GL11.glEnd();
            }

            AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(axisalignedbb.minX - entityIn.posX + x, axisalignedbb.minY - entityIn.posY + y, axisalignedbb.minZ - entityIn.posZ + z, axisalignedbb.maxX - entityIn.posX + x, axisalignedbb.maxY - entityIn.posY + y, axisalignedbb.maxZ - entityIn.posZ + z);
            RenderGlobal.drawOutlinedBoundingBox(axisalignedbb1, 255, 255, 255, 255);
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(x - (double)f, y + (double)entityIn.getEyeHeight() - (double)0.01f, z - (double)f, x + (double)f, y + (double)entityIn.getEyeHeight() + (double)0.01f, z + (double)f), 255, 0, 0, 255);

            if (HitBoxesConfig.dashedPlayerHitbox) {
                GL11.glPopAttrib();
            }

            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            Vec3 vec3 = entityIn.getLook(partialTicks);
            worldrenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
            worldrenderer.pos(x, y + (double)entityIn.getEyeHeight(), z).color(0, 0, 255, 255).endVertex();
            worldrenderer.pos(x + vec3.xCoord * 2.0, y + (double)entityIn.getEyeHeight() + vec3.yCoord * 2.0, z + vec3.zCoord * 2.0).color(0, 0, 255, 255).endVertex();
            tessellator.draw();

            GlStateManager.enableTexture2D();
            GlStateManager.enableLighting();
            GlStateManager.enableCull();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
        }

    }

    @Inject(method = "renderDebugBoundingBox", at = @At(value = "HEAD"), cancellable = true)
    public void cancelVanillaHitboxes(CallbackInfo ci) {
        ci.cancel();
    }

}
