package com.attackeight.createskybound;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab extends CreativeModeTab {
    public ModCreativeModeTab() {
        super("createskybound.createskybound");
    }

    @Override
    public ItemStack makeIcon() {
        return ModItems.ASH.asStack();
    }
}
