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
		ModLoader.addLocalization("ev_coloredGlass.white", "Vitre blanche");
		ModLoader.addLocalization("ev_coloredGlass.orange", "Vitre orangée");
		ModLoader.addLocalization("ev_coloredGlass.magenta", "Vitre magenta");
		ModLoader.addLocalization("ev_coloredGlass.light_blue", "Vitre bleu clair");
		ModLoader.addLocalization("ev_coloredGlass.yellow", "Vitre jaune");
		ModLoader.addLocalization("ev_coloredGlass.lime", "Vitre vert clair");
		ModLoader.addLocalization("ev_coloredGlass.pink", "Vitre rose");
		ModLoader.addLocalization("ev_coloredGlass.gray", "Vitre grise");
		ModLoader.addLocalization("ev_coloredGlass.light_gray", "Vitre grise claire");
		ModLoader.addLocalization("ev_coloredGlass.cyan", "Vitre cyan");
		ModLoader.addLocalization("ev_coloredGlass.purple", "Vitre violette");
		ModLoader.addLocalization("ev_coloredGlass.blue", "Vitre bleue");
		ModLoader.addLocalization("ev_coloredGlass.brown", "Vitre marron");
		ModLoader.addLocalization("ev_coloredGlass.green", "Vitre verte");
		ModLoader.addLocalization("ev_coloredGlass.red", "Vitre rouge");
		ModLoader.addLocalization("ev_coloredGlass.black", "Vitre noire");
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