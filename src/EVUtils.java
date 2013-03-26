package net.minecraft.src;

import java.awt.Desktop;
import java.awt.Menu;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void openURL(String url) {
    	Desktop desktop = null;
		java.net.URI uri;

		try {
			uri = new java.net.URI(url);

			if (Desktop.isDesktopSupported()) {
				desktop = Desktop.getDesktop();
				desktop.browse(uri);
			}
		} catch (Exception ex) {
			Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
