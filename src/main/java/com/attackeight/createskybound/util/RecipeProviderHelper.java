package com.attackeight.createskybound.util;

import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class RecipeProviderHelper extends RecipeProvider {
    public RecipeProviderHelper(DataGenerator p_125973_) {
        super(p_125973_);
    }


    public static void shapedRecipe(ItemLike outputItem, String pattern, Consumer<FinishedRecipe> consumer,
                                    List<ItemLike> inputItems, String unlockedByName, CriterionTriggerInstance trigger) {
        String[] patternList = pattern.split("-");
        List<Character> alphabet = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        if (patternList.length != 3) {
            return;
        }
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(outputItem);

        for (int i = 0; i < inputItems.size(); i++) {
            builder.define(alphabet.get(i), inputItems.get(i));
        }

        builder.pattern(patternList[0])
                .pattern(patternList[1])
                .pattern(patternList[2]);

        builder.unlockedBy(unlockedByName, trigger).save(consumer);

    }

    public static void shapedRecipe(ItemLike outputItem, String pattern, Consumer<FinishedRecipe> consumer,
                                    TagKey<Item> inputItem, String unlockedByName, CriterionTriggerInstance trigger) {
        String[] patternList = pattern.split("-");
        if (patternList.length != 3) {
            return;
        }
        ShapedRecipeBuilder.shaped(outputItem)
                .define('A', inputItem)
                .pattern(patternList[0])
                .pattern(patternList[1])
                .pattern(patternList[2])
                .unlockedBy(unlockedByName, trigger)
                .save(consumer);

    }

    public static void shapelessRecipe(ItemLike outputItem, Consumer<FinishedRecipe> consumer,
                                    ItemLike inputItem, String unlockedByName, CriterionTriggerInstance trigger) {

        ShapelessRecipeBuilder.shapeless(outputItem)
                .requires(inputItem)
                .unlockedBy(unlockedByName, trigger)
                .save(consumer);

    }
}
