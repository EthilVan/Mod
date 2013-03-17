package fr.ethilvan.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.ethilvan.EthilVan;

public class BlockWallStoneBrick extends BlockWall {

	public static final String[] types = new String[] {"default", "mossy", "cracked", "chiseled"};

	public BlockWallStoneBrick(int par1, Block par2Block) {
		super(par1, par2Block);
		this.setCreativeTab(EthilVan.ethilvanTabs);
	}

	public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
    	return par2 == 1 ? 100 : par2 == 2 ? 101 : par2 == 3 ? 213 : super.getBlockTextureFromSide(par1);
    }

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1 , 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
    	return true;
    }
}
