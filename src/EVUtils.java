package net.minecraft.src;

import java.awt.Desktop;
import java.awt.Menu;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class EVUtils {

    public static String[] woolType = new String[] {"white", "orange", "magenta",
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

    public static void registerWoolStairsName() {
    	ModLoader.addName(mod_EthilVan.stairsWoolWhite, "Escalier de laine blanc");
        ModLoader.addName(mod_EthilVan.stairsWoolOrange, "Escalier de laine orange");
        ModLoader.addName(mod_EthilVan.stairsWoolMagenta, "Escalier de laine magenta");
        ModLoader.addName(mod_EthilVan.stairsWoolLightBlue, "Escalier de laine bleu clair");
        ModLoader.addName(mod_EthilVan.stairsWoolYellow, "Escalier de laine jaune");
        ModLoader.addName(mod_EthilVan.stairsWoolLime, "Escalier de laine vert clair");
        ModLoader.addName(mod_EthilVan.stairsWoolPink, "Escalier de laine rose");
        ModLoader.addName(mod_EthilVan.stairsWoolGray, "Escalier de laine gris");
        ModLoader.addName(mod_EthilVan.stairsWoolLightGray, "Escalier de laine gris clair");
        ModLoader.addName(mod_EthilVan.stairsWoolCyan, "Escalier de laine cyan");
        ModLoader.addName(mod_EthilVan.stairsWoolPurple, "Escalier de laine violet");
        ModLoader.addName(mod_EthilVan.stairsWoolBlue, "Escalier de laine bleu");
        ModLoader.addName(mod_EthilVan.stairsWoolBrown, "Escalier de laine marron");
        ModLoader.addName(mod_EthilVan.stairsWoolGreen, "Escalier de laine vert");
        ModLoader.addName(mod_EthilVan.stairsWoolRed, "Escalier de laine rouge");
        ModLoader.addName(mod_EthilVan.stairsWoolBlack, "Escalier de laine noir");
    }

    public static void registerWoolStairsCraft() {
    	ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolWhite, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 0)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolOrange, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 1)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolMagenta, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 2)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolLightBlue, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 3)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolYellow, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 4)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolLime, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 5)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolPink, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 6)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolGray, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 7)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolLightGray, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 8)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolCyan, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 9)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolPurple, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 10)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolBlue, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 11)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolBrown, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 12)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolGreen, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 13)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolRed, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 14)});
        ModLoader.addRecipe(new ItemStack(mod_EthilVan.stairsWoolBlack, 4), new Object[] {"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 15)});
    }

	public static boolean isWoolStairs(int id) {
		return id >= mod_EthilVan.stairsWoolWhite.blockID
				|| id <= mod_EthilVan.stairsWoolBlack.blockID;
	}
}
