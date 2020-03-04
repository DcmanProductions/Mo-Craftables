package net.chaselabs.Mo_Craftables.utilities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class RecipesCache {

	public List<RecipeProvider> recipes;

	public RecipesCache() {
		recipes = new ArrayList<RecipeProvider>();
	}

	public RecipeProvider getRecipeByItemStack(ItemStack stack) {

		for (RecipeProvider provider : recipes) {
			if (provider.getItem().equals(stack, false)) {
				return provider;
			}
		}
		return RecipeProvider.Empty();
	}

	public boolean hasRecipe(ItemStack stack) {
		for (RecipeProvider provider : recipes) {
			if (stack.equals(provider.getItem(), false)) {
				return true;
			}
		}
		return false;
	}

}
