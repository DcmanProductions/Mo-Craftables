package net.chaselabs.Mo_Craftables.utilities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;

public class RecipeProvider {

	IRecipe<?> recipe;

	public RecipeProvider(IRecipe<?> recipe) {
		this.recipe = recipe;
	}

	RecipeProvider() {
		this.recipe = null;
	}

	public static RecipeProvider Empty() {
		return new RecipeProvider();
	}

	public List<ItemStack> getIngredients() {
		List<ItemStack> value = new ArrayList<ItemStack>();
		for (Ingredient ing : recipe.getIngredients()) {
			for (ItemStack stack : ing.getMatchingStacks()) {
				value.add(stack);
			}
		}
		return value;
	}

	public ItemStack getItem() {
		return recipe.getRecipeOutput();
	}

}
