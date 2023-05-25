package com.attackeight.createskybound;


import com.simibubi.create.AllTags.AllItemTags;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import static com.attackeight.createskybound.CreateSkybound.CREATIVE_TAB;
import static com.attackeight.createskybound.CreateSkybound.REGISTRATE;

public class ModItems {

    static {
        REGISTRATE.creativeModeTab(() -> CREATIVE_TAB).addLang("itemGroup",
                new ResourceLocation("createskybound", "createskybound"), "Create: Skybound");
    }

    public static final ItemEntry<Item> ASH =
            REGISTRATE.item("ash", Item::new)
                    .tag(AllItemTags.UPRIGHT_ON_BELT.tag)
                    .register();

    public static void register() {}
}
