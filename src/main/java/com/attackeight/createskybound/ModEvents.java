package com.attackeight.createskybound;

import com.attackeight.createskybound.util.ModProcessingRecipes;
import com.attackeight.createskybound.util.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateSkybound.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper fileHelper = e.getExistingFileHelper();

        generator.addProvider(true, new ModRecipeProvider(generator));
        new ModProcessingRecipes(generator);
    }
}
