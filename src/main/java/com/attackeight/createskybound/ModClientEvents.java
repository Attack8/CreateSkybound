package com.attackeight.createskybound;

import com.attackeight.createskybound.projectilecast.TpArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CreateSkybound.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value= Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void doSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.TP_PROJECTILE.get(), TpArrowRenderer::new);
    }
}
