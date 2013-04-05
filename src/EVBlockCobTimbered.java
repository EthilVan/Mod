package net.minecraft.src;

import java.util.Random;

public class EVBlockCobTimbered extends Block {

	private Icon normal, timberedVertical;

	public EVBlockCobTimbered(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.getIndirectPowerOutput("cobTimbered");
	}

	public int getRenderType() {
		return 31;
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return mod_EthilVan.cob_timbered.blockID;
	}

	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		int var10 = par9 & 3;
		byte var11 = 0;

		switch (par5) {
		case 0:
		case 1:
			var11 = 0;
			break;
		case 2:
		case 3:
			var11 = 8;
			break;
		case 4:
		case 5:
			var11 = 4;
		}

		return var10 | var11;
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		int var3 = par2 & 12;
		int var4 = par2 & 3;
		return var3 == 0 && (par1 == 1 || par1 == 0) ? normal : (var3 == 4 && (par1 == 5 || par1 == 4) ? normal : (var3 == 8 && (par1 == 2 || par1 == 3) ? normal : timberedVertical));
	}

	public void registerIcons(IconRegister par1IconRegister) {
		normal = par1IconRegister.registerIcon("ev_cob");
		timberedVertical = par1IconRegister.registerIcon("ev_cobTimberedV");
	}

	public void registerCraft() {
		ModLoader.addRecipe(new ItemStack(mod_EthilVan.cob_timbered, 9), new Object[] {
			"WCW", "WCW", "WCW", Character.valueOf('C'), mod_EthilVan.cob, Character.valueOf('W'), Block.wood
		});
	}
}