package net.chaselabs.Mo_Craftables.utilities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.IRecipe;

public class Cache {

	static List<RecipeProvider> recipes;

	protected Cache() {
	}

	public static void Init() {
		CacheRecipes();
	}

	static void CacheRecipes() {
		recipes = new ArrayList<RecipeProvider>();
		for (IRecipe<?> recipe : Minecraft.getInstance().world.getRecipeManager().getRecipes()) {
			new RecipesCache().recipes.add(new RecipeProvider(recipe));
		}
	}

	public static List<RecipeProvider> GetRecipes() {
		if (recipes == null)
			CacheRecipes();
		return recipes;
	}

}
