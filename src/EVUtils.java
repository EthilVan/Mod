package net.minecraft.src;

import java.awt.Desktop;
import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
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
		ModLoader.addLocalization("ev_stairsWoolWhite", "Escalier blanc");
		ModLoader.addLocalization("ev_stairsWoolOrange", "Escalier orangé");
		ModLoader.addLocalization("ev_stairsWoolMagenta", "Escalier magenta");
		ModLoader.addLocalization("ev_stairsWoolLight_blue", "Escalier bleu clair");
		ModLoader.addLocalization("ev_stairsWoolYellow", "Escalier jaune");
		ModLoader.addLocalization("ev_stairsWoolLime", "Escalier vert clair");
		ModLoader.addLocalization("ev_stairsWoolPink", "Escalier rose");
		ModLoader.addLocalization("ev_stairsWoolGray", "Escalier gris");
		ModLoader.addLocalization("ev_stairsWoolLight_gray", "Escalier gris clair");
		ModLoader.addLocalization("ev_stairsWoolCyan", "Escalier cyan");
		ModLoader.addLocalization("ev_stairsWoolPurple", "Escalier violet");
		ModLoader.addLocalization("ev_stairsWoolBlue", "Escalier bleu");
		ModLoader.addLocalization("ev_stairsWoolBrown", "Escalier marron");
		ModLoader.addLocalization("ev_stairsWoolGreen", "Escalier vert");
		ModLoader.addLocalization("ev_stairsWoolRed", "Escalier rouge");
		ModLoader.addLocalization("ev_stairsWoolBlack", "Escalier noir");
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

	public static boolean isWoolStep(int id) {
		return id == mod_EthilVan.singleWoolStep1.blockID || id == mod_EthilVan.doubleWoolStep1.blockID
				|| id == mod_EthilVan.singleWoolStep2.blockID || id == mod_EthilVan.doubleWoolStep2.blockID;
	}

	public static boolean isWool(int id) {
		return isWoolStairs(id) || isWoolStep(id);
	}

	public static String getSplashText() {
		BufferedReader var1 = null;

        try
        {
            ArrayList var2 = new ArrayList();
            var1 = new BufferedReader(new InputStreamReader(GuiMainMenu.class.getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8")));
            String var3;

            while ((var3 = var1.readLine()) != null)
            {
                var3 = var3.trim();

                if (var3.length() > 0)
                {
                    var2.add(var3);
                }
            }

            do
            {
                return (String)var2.get(new Random().nextInt(var2.size()));
            }
            while (var2.get(new Random().nextInt(var2.size())).hashCode() == 125780783);
        }
        catch (IOException var12)
        {
            ;
        }
        finally
        {
            if (var1 != null)
            {
                try
                {
                    var1.close();
                }
                catch (IOException var11)
                {
                    ;
                }
            }
        }
		return null;
	}
}
