package net.minecraft.src;

import java.util.Random;

public class EVBlockCobTimbered2 extends Block {

	public static String[] faces = {"0", "1", "2", "3"};
	private Icon normal, timberedDiagonal, timberedDiagonalInversed;

	public EVBlockCobTimbered2(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.getIndirectPowerOutput("cobTimbered2");
	}

	@Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
		int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (var6 == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0x02);
		}

		if (var6 == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 0x02);
		}

		if (var6 == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 0x02);
		}

		if (var6 == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 0x02);
		}
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		if (par1 == 0 || par1 == 1) {
			return normal;
		}
		switch (par2) {
		case 0:
			if (par1 == 4 || par1 == 5) {
				return normal;
			} else  if (par1 == 3){ 
				return timberedDiagonalInversed;
			} else {
				return timberedDiagonal;
			}
		case 1:
			if (par1 == 2 || par1 == 3) {
				return normal;
			} else if (par1 == 4){
				return timberedDiagonalInversed;
			} else {
				return timberedDiagonal;
			}
		case 2:
			if (par1 == 4 || par1 == 5) {
				return normal;
			} else if (par1 == 2) {
				return timberedDiagonalInversed;
			} else {
				return timberedDiagonal;
			}
		case 3:
			if (par1 == 2 || par1 == 3) {
				return normal;
			} else if (par1 == 5){
				return timberedDiagonalInversed;
			} else {
				return timberedDiagonal;
			}
		}
		return Block.dirt.blockIcon;
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return mod_EthilVan.cob_timbered2.blockID;
	}

	public void registerIcons(IconRegister par1IconRegister) {
		normal = par1IconRegister.registerIcon("ev_cob");
		timberedDiagonal = par1IconRegister.registerIcon("ev_cobTimbered");
		timberedDiagonalInversed = par1IconRegister.registerIcon("ev_cobTimbered2");
	}

	public void registerCraft() {
		ModLoader.addRecipe(new ItemStack(mod_EthilVan.cob_timbered2, 9), new Object[] {
			"CWC", "WCW", "CWC", Character.valueOf('C'), mod_EthilVan.cob, Character.valueOf('W'), Block.wood
		});
	}
}