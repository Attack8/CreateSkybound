package com.attackeight.createskybound;

import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.List;

@Mod(CreateSkybound.MODID)
public class CreateSkybound {

    public static final String MODID = "createskybound";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static Registrate REGISTRATE = Registrate.create(MODID);
    public static final CreativeModeTab CREATIVE_TAB = new ModCreativeModeTab();


    public CreateSkybound() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        ModItems.register();
        ModVillagers.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class Events {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent e) {
            if (e.getType() == ModVillagers.WANDERING_ENCHANTER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = e.getTrades();
                ItemStack stack = new ItemStack(ModItems.ASH.get(), 2);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        stack, 10,8,0.02f));
            }
        }
    }
}
