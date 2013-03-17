package fr.ethilvan.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.ethilvan.EthilVan;

public class BlockCarpet extends Block {

	public static final String[] type = new String[] {"white", "orange", "magenta",
		"light_blue", "yellow", "lime",
		"pink", "gray", "light_gray",
		"cyan", "purple", "blue",
		"brown", "green", "red", "black" };

	public BlockCarpet(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
		this.setHardness(0.8F);
		this.setStepSound(Block.soundClothFootstep);
		this.setBlockName("carpet");
		this.setLightOpacity(0);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.setTickRandomly(true);
		this.setCreativeTab(EthilVan.ethilvanTabs);
		this.setRequiresSelfNotify();
	}

    @Override
	public boolean isOpaqueCube() {
		return false;
	}

    @Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        float f = 0.125F;
        return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)((float)par3 + (float)f), (double)par4 + this.maxZ);
	}

    @Override
	public boolean renderAsNormalBlock() {
		return false;
	}

    @Override
	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
		switch (metadata) {
		case 0:
			return 64;

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

		case 8:
			return 225;

		case 9:
			return 209;

		case 10:
			return 193;

		case 11:
			return 177;

		case 12:
			return 161;

		case 13:
			return 145;

		case 14:
			return 129;

		case 15:
			return 113;
		}

		return metadata;
	}

	@SideOnly(Side.CLIENT)
    @Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int var4 = 0; var4 < 16; ++var4) {
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) || BlockFence.isIdAFence(par1World.getBlockId(par2, par3 - 1, par4));
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		boolean var6 = false;

		if (!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && !BlockFence.isIdAFence(par1World.getBlockId(par2, par3 - 1, par4))) {
			var6 = true;
		}

		if (var6) {
			this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.setBlockWithNotify(par2, par3, par4, 0);
		}
	}

	@Override
	public int damageDropped(int par1) {
		return par1;
	}

	@Override
	public int getMobilityFlag() {
		return 1;
	}

	@Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
        return true;
    }

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face){
        return 150;
    }
}
