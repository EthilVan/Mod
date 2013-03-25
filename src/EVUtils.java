package net.minecraft.src;

import java.util.ArrayList;

public class EVUtils {
    public static final String[] woolType = new String[] {"white", "orange", "magenta",
        "light_blue", "yellow", "lime",
        "pink", "gray", "light_gray",
        "cyan", "purple", "blue",
        "brown", "green", "red", "black"};

    public static void removeRecipe(ItemStack resultItem) {
		ItemStack recipeResult = null;
		ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

		for (int scan = 0; scan < recipes.size(); scan++){
			IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
			recipeResult = tmpRecipe.getRecipeOutput();

			if (ItemStack.areItemStacksEqual(resultItem, recipeResult)) {
				System.out.println("[EthilVan] Removed Recipe for : " + recipeResult.getDisplayName());
				recipes.remove(scan);
			}
		}
	}
}
