package com.attackeight.createskybound.util;

import com.attackeight.createskybound.ModItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

public class ModProcessingRecipes{

    public ModProcessingRecipes(DataGenerator generator){
        generator.addProvider(true, new ModCompactingRecipes(generator));
    }

    public static class ModCompactingRecipes extends ProcessingRecipeGen {

        GeneratedRecipe

                TUFF = create(new ResourceLocation("createskybound", "tuff_from_ash"), b -> b.require(ModItems.ASH.get())
                .require(ModItems.ASH.get())
                .require(ModItems.ASH.get())
                .require(ModItems.ASH.get())
                .requiresHeat(HeatCondition.SUPERHEATED)
                .output(Blocks.TUFF));

        public ModCompactingRecipes(DataGenerator generator) {
            super(generator);
        }

        @Override
        protected IRecipeTypeInfo getRecipeType() {
            return AllRecipeTypes.COMPACTING;
        }

    }
}
