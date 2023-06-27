package com.attackeight.createskybound;

import com.attackeight.createskybound.projectilecast.TpProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> PROJECTILE_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CreateSkybound.MODID);

    public static final RegistryObject<EntityType<TpProjectile>> TP_PROJECTILE = PROJECTILE_TYPES.register("tp_projectile",
            () -> EntityType.Builder.of(TpProjectile::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).build("tp_projectile"));

    public static void register(IEventBus eventBus){
        PROJECTILE_TYPES.register(eventBus);
    }
}
