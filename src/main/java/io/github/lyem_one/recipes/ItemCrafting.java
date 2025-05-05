package io.github.lyem_one.recipes;

import io.github.lyem_one.init.InitHandheldItem;
import io.github.lyem_one.init.InitItem;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class ItemCrafting extends FabricRecipeProvider {
    public ItemCrafting(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.MISC, InitItem.INFLAMED_STONE, 1)
                        .pattern("lcl")
                        .input('l', Items.BLAZE_ROD) // 'l' = blaze rod quoi
                        .input('c', Items.COBBLESTONE) // 'o' = Cobble
                        .group("multi_bench") // Put it in a group called "multi_bench" - groups are shown in one slot in the recipe book
                        .criterion(hasItem(Items.FIRE_CHARGE), conditionsFromItem(Items.FIRE_CHARGE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, InitHandheldItem.FIRE_SWORD, 1)
                        .pattern(" l ")
                        .pattern(" l ")
                        .pattern("obo")
                        .input('l', InitItem.INFLAMED_STONE) // 'l' = blaze rod quoi
                        .input('o', Items.FIRE_CHARGE) // 'o' = Fire Charge
                        .input('b', Items.STICK) // 'b' = baton
                        .group("multi_bench") // Put it in a group called "multi_bench" - groups are shown in one slot in the recipe book
                        .criterion(hasItem(Items.FIRE_CHARGE), conditionsFromItem(Items.FIRE_CHARGE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ItemCrafting";
    }

}
