package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class EVBlockWoolStep2 extends BlockHalfSlab {

	public static final String[] woolType = new String[] { "lightGray", "cyan", "purple", "blue", "brown", "green", "red", "black" };

	public EVBlockWoolStep2(int par1, boolean par2, Material par3) {
		super(par1, par2, par3);
		this.useNeighborBrightness[par1] = true;
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(Block.soundClothFootstep);
		this.setHardness(0.8F);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return mod_EthilVan.singleWoolStep2.blockID;
	}

	@Override
	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(mod_EthilVan.singleWoolStep2.blockID, 2, par1 & 7);
	}

	public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
		switch (par2 & 7) {
		case 0:
			return 225;

		case 1:
			return 209;

		case 2:
			return 193;

		case 3:
			return 177;

		case 4:
			return 161;

		case 5:
			return 145;

		case 6:
			return 129;

		case 7:
			return 113;
		}
		return 0;
	}

	/**
	 * Returns the block texture based on the side being looked at.  Args: side
	 */
	public int getBlockTextureFromSide(int par1) {
		return mod_EthilVan.singleWoolStep2.getBlockTextureFromSideAndMetadata(par1, 0);
	}

	@Override
	public String getFullSlabName(int par1) {
		if (par1 < 0 || par1 >= woolType.length) {
			par1 = 0;
		}

		return super.getBlockName() + "." + woolType[par1];
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		if (par1 != mod_EthilVan.doubleWoolStep2.blockID) {
			for (int var4 = 0; var4 < 8; ++var4) {
				par3List.add(new ItemStack(par1, 1, var4));
			}
		}
	}

	private static boolean isBlockSingleSlab(int par0) {
		return par0 == mod_EthilVan.singleWoolStep2.blockID;
	}

	@Override
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return mod_EthilVan.singleWoolStep2.blockID;
	}

	public static void registerNames() {
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep2, 1, 0), "Dalle de laine gris claire");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep2, 1, 1), "Dalle de laine cyan");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep2, 1, 2), "Dalle de laine violet");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep2, 1, 3), "Dalle de laine bleue");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep2, 1, 4), "Dalle de laine marron");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep2, 1, 5), "Dalle de laine verte");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep2, 1, 6), "Dalle de laine rouge");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep2, 1, 7), "Dalle de laine noire");
	}

	public static void registerCrafts() {
		for (int i = 0; i < 8; i++) {
			ModLoader.addRecipe(new ItemStack(mod_EthilVan.singleWoolStep2, 6, i + 8), new Object[] {
				"XXX", Character.valueOf('X'), new ItemStack(Block.cloth, 0, i + 8)
			});
		}
	}
}
