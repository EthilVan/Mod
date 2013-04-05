package net.minecraft.src;

import java.util.List;
import java.util.Random;

import org.lwjgl.Sys;

public class EVBlockColoredGlass extends BlockBreakable {

    private Icon[] icon;

	protected EVBlockColoredGlass(int par1, Material par3Material, boolean par4) {
		super(par1, "", par3Material, par4);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundGlassFootstep);
	}

	public int quantityDropped(Random par1Random) {
		return 0;
	}

	public int getRenderBlockPass() {
		return 1;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void registerIcons(IconRegister par1IconRegister)
    {
	    icon = new Icon[16];
	    for (int i = 0; i < EVUtils.woolType.length; i++) {
	    	this.icon[i] = par1IconRegister.registerIcon("ev_glass_" + EVUtils.woolType[i]);
	    }
    }

	public Icon getBlockTextureFromSideAndMetadata(int side, int metadata) {
		return icon[metadata];
	}

	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int var4 = 0; var4 < 16; ++var4) {
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}

	protected boolean canSilkHarvest() {
		return true;
	}



	public void registerNames() {
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 0), "Vitre blanche");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 1), "Vitre orangée");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 2), "Vitre magenta");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 3), "Vitre bleu clair");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 4), "Vitre jaune");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 5), "Vitre vert clair");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 6), "Vitre rose");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 7), "Vitre grise");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 8), "Vitre grise claire");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 9), "Vitre cyan");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 10), "Vitre violette");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 11), "Vitre bleue");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 12), "Vitre marron");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 13), "Vitre verte");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 14), "Vitre rouge");
		ModLoader.addName(new ItemStack(mod_EthilVan.coloredGlass, 1, 15), "Vitre noire");
	}

	@Override
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return mod_EthilVan.coloredGlass.blockID;
	}

	@Override
	public int damageDropped(int par1) {
		return par1;
	}

	public void registerCrafts() {
		for (int metaGlass = 0; metaGlass < 16; metaGlass++) {
			ModLoader.addRecipe(new ItemStack(this, 4, metaGlass), new Object[] {
				" X ", "XCX", " X ", 'X', Block.glass, 'C', new ItemStack(Item.dyePowder, 1, BlockCloth.getBlockFromDye(metaGlass))
			});
		}
	}
}