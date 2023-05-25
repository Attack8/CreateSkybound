package com.attackeight.createskybound.util;

import com.attackeight.createskybound.ModItems;
import com.attackeight.createskybound.ModTags;
import com.simibubi.create.AllTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProviderHelper implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeConsumer) {
        /*

        shapedRecipe(ModItems.ASH.get(), "AA -AA -   ", recipeConsumer, List.of(Items.DRIED_KELP),
                "has_dried_kelp", inventoryTrigger(ItemPredicate.Builder.item().of(Items.DRIED_KELP.asItem()).build()));

         */

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModTags.BURNABLES),
                ModItems.ASH.get(), 0.1f, 100)
                .unlockedBy("has_burnable", inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.BURNABLES).build()))
                .save(recipeConsumer, new ResourceLocation("createskybound", "blasting/ash_from_blasting"));

    }

}
