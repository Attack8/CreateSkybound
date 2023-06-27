package com.attackeight.createskybound;

import com.attackeight.createskybound.CreateSkybound;
import com.google.common.collect.ImmutableSet;
import com.tterrag.registrate.util.entry.EntityEntry;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

import static com.attackeight.createskybound.CreateSkybound.REGISTRATE;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, CreateSkybound.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, CreateSkybound.MODID);

    public static final RegistryObject<PoiType> ENCHANTER_POI = POI_TYPES.register("enchanter_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.ENCHANTING_TABLE.getStateDefinition().getPossibleStates()),
                    1,1));

    public static final RegistryObject<VillagerProfession> WANDERING_ENCHANTER = VILLAGER_PROFESSIONS.register("wandering_enchanter",
            () -> new VillagerProfession("wadering_enchanter", x -> x.get() == ENCHANTER_POI.get(),
                    x -> x.get() == ENCHANTER_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.ENCHANTMENT_TABLE_USE));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, ENCHANTER_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
