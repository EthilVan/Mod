package fr.ethilvan.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fr.ethilvan.EthilVan;
import fr.ethilvan.common.CommonProxy;

public class BlockCobTimbered2 extends Block {

	public static String[] faces = {"0", "1", "2", "3"};

	public BlockCobTimbered2(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setCreativeTab(EthilVan.ethilvanTabs);
		this.setBlockName("cobTimbered2");
		this.setTextureFile(CommonProxy.texture);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (var6 == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0);
		}

		if (var6 == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
		}

		if (var6 == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1);
		}

		if (var6 == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
		}
	}

	public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
		if (par1 == 0 || par1 == 1) {
			return 17;
		}
		switch (par2) {
		case 0:
			if (par1 == 4 || par1 == 5) {
				return 17;
			} else  if (par1 == 3){ 
				return 20;
			} else {
				return 18;
			}
		case 1:
			if (par1 == 2 || par1 == 3) {
				return 17;
			} else if (par1 == 4){
				return 20;
			} else {
				return 18;
			}
		case 2:
			if (par1 == 4 || par1 == 5) {
				return 17;
			} else if (par1 == 2) {
				return 20;
			} else {
				return 18;
			}
		case 3:
			if (par1 == 2 || par1 == 3) {
				return 17;
			} else if (par1 == 5){
				return 20;
			} else {
				return 18;
			}
		}
		return 0;
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return EthilVan.cobTimbered2.blockID;
	}
}
