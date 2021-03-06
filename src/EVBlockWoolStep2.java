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

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return Block.cloth.getBlockTextureFromSideAndMetadata(par1, par2 + 8);
	}

	@Override
	public String getFullSlabName(int par1) {
		if (par1 < 0 || par1 >= woolType.length) {
			par1 = 0;
		}

		return super.getUnlocalizedName() + "." + woolType[par1];
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
		ModLoader.addLocalization("ev_woolStep2.lightGray", "Dalle de laine grise claire");
		ModLoader.addLocalization("ev_woolStep2.cyan", "Dalle de laine cyan");
		ModLoader.addLocalization("ev_woolStep2.purple", "Dalle de laine violette");
		ModLoader.addLocalization("ev_woolStep2.blue", "Dalle de laine bleue");
		ModLoader.addLocalization("ev_woolStep2.brown", "Dalle de laine marron");
		ModLoader.addLocalization("ev_woolStep2.green", "Dalle de laine verte");
		ModLoader.addLocalization("ev_woolStep2.red", "Dalle de laine rouge");
		ModLoader.addLocalization("ev_woolStep2.black", "Dalle de laine noire");
	}

	public static void registerCrafts() {
		for (int i = 0; i < 8; i++) {
			ModLoader.addRecipe(new ItemStack(mod_EthilVan.singleWoolStep2, 6, i + 8), new Object[] {
				"XXX", Character.valueOf('X'), new ItemStack(Block.cloth, 0, i + 8)
			});
		}
	}

    public void registerIcons(IconRegister par1IconRegister) {}
}
