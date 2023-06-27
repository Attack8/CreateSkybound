package com.attackeight.createskybound.projectilecast;

import com.attackeight.createskybound.CreateSkybound;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class TpArrowRenderer extends ArrowRenderer<TpProjectile> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(CreateSkybound.MODID, "textures/entity/tp_arrow.png");
    public TpArrowRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(TpProjectile p_114482_) {
        return TEXTURE;
    }
}
