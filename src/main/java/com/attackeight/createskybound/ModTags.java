package com.attackeight.createskybound;

import com.simibubi.create.AllTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTags {

    public static TagKey<Item> BURNABLES = AllTags.optionalTag(ForgeRegistries.ITEMS, new ResourceLocation("createskybound", "burnables"));
}
