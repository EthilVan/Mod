package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class EVBlockWoolStep1 extends BlockHalfSlab {

	public static final String[] woolType = new String[] { "white", "orange", "magenta","lightBlue", "yellow", "lime", "pink", "gray" };

	public EVBlockWoolStep1(int par1, boolean par2, Material par3Material) {
		super(par1, par2, par3Material);
		this.useNeighborBrightness[par1] = true;
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(Block.soundClothFootstep);
		this.setHardness(0.8F);
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
		switch (par2 & 7) {
		case 1:
			return 210;
		case 2:
			return 194;
		case 3:
			return 178;
		case 4:
			return 162;
		case 5:
			return 146;
		case 6:
			return 130;
		case 7:
			return 114;
		default:
			return 64;
		}
	}

	/**
	 * Returns the block texture based on the side being looked at.  Args: side
	 */
	public int getBlockTextureFromSide(int par1) {
		return mod_EthilVan.singleWoolStep1.getBlockTextureFromSideAndMetadata(par1, 0);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3) {
		return mod_EthilVan.singleWoolStep1.blockID;
	}

	/**
	 * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
	 * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
	 */
	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(mod_EthilVan.singleWoolStep1, 2, par1 & 7);
	}

	/**
	 * Returns the slab block name with step type.
	 */
	public String getFullSlabName(int par1) {
		if (par1 < 0 || par1 >= woolType.length) {
			par1 = 0;
		}

		return super.getBlockName() + "." + woolType[par1];
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		if (par1 != mod_EthilVan.doubleWoolStep1.blockID) {
			for (int var4 = 0; var4 < 8; ++var4) {
				par3List.add(new ItemStack(par1, 1, var4));
			}
		} 
	}

	private static boolean isBlockSingleSlab(int par0) {
		return par0 == mod_EthilVan.singleWoolStep1.blockID;
	}

	public int idPicked(World par1World, int par2, int par3, int par4) {
		return mod_EthilVan.singleWoolStep1.blockID;
	}

	public static void registerNames() {
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep1, 1, 0), "Dalle de laine blanche");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep1, 1, 1), "Dalle de laine orange");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep1, 1, 2), "Dalle de laine magenta");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep1, 1, 3), "Dalle de laine bleue claire");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep1, 1, 4), "Dalle de laine jaune");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep1, 1, 5), "Dalle de laine vert claire");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep1, 1, 6), "Dalle de laine rose");
		ModLoader.addName(new ItemStack(mod_EthilVan.singleWoolStep1, 1, 7), "Dalle de laine gris");
	}

	public static void registerCrafts() {
		for (int i = 0; i < 8; i++) {
			ModLoader.addRecipe(new ItemStack(mod_EthilVan.singleWoolStep1, 6, i), new Object[] {
				"XXX", Character.valueOf('X'), new ItemStack(Block.cloth, 0, i)
			});
		}
	}
}
