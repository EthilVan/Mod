package fr.ethilvan.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.ethilvan.EthilVan;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockWallNetherBrick extends BlockWall {

	public BlockWallNetherBrick(int par1, Block par2Block) {
		super(par1, par2Block);
		this.setCreativeTab(EthilVan.ethilvanTabs);
	}

	public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return super.getBlockTextureFromSide(par1);
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
	}
}
