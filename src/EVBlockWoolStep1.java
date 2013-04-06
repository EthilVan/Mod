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
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return Block.cloth.getBlockTextureFromSideAndMetadata(par1, par2);
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

		return super.getUnlocalizedName() + "." + woolType[par1];
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
		ModLoader.addLocalization("ev_woolStep1.white", "Dalle de laine blanche");
		ModLoader.addLocalization("ev_woolStep1.orange", "Dalle de laine orangée");
		ModLoader.addLocalization("ev_woolStep1.magenta", "Dalle de laine magenta");
		ModLoader.addLocalization("ev_woolStep1.lightBlue", "Dalle de laine bleu clair");
		ModLoader.addLocalization("ev_woolStep1.yellow", "Dalle de laine jaune");
		ModLoader.addLocalization("ev_woolStep1.lime", "Dalle de laine vert clair");
		ModLoader.addLocalization("ev_woolStep1.pink", "Dalle de laine rose");
		ModLoader.addLocalization("ev_woolStep1.gray", "Dalle de laine grise");
	}

	public static void registerCrafts() {
		for (int i = 0; i < 8; i++) {
			ModLoader.addRecipe(new ItemStack(mod_EthilVan.singleWoolStep1, 6, i), new Object[] {
				"XXX", Character.valueOf('X'), new ItemStack(Block.cloth, 0, i)
			});
		}
	}

    public void registerIcons(IconRegister par1IconRegister) {}
}
