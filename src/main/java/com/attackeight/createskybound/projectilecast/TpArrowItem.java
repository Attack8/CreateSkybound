package com.attackeight.createskybound.projectilecast;

import com.attackeight.createskybound.ModEntities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TpArrowItem extends ArrowItem {
    public TpArrowItem(Properties props) {
        super(props);
    }

    @Override
    public AbstractArrow createArrow(Level world, ItemStack ammoStack, LivingEntity shooter) {
        return new TpProjectile(ModEntities.TP_PROJECTILE.get(), shooter, world);
    }

}
