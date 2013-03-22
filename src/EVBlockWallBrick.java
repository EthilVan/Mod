package net.minecraft.src;

import java.util.List;

public class EVBlockWallBrick extends BlockWall {

	public EVBlockWallBrick(int par1, Block par2Block) {
		super(par1, par2Block);
	}

    public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
    	return super.getBlockTextureFromSide(par1);
    }

    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
}
