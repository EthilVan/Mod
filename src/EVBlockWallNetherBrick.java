package net.minecraft.src;

import java.util.List;

public class EVBlockWallNetherBrick extends BlockWall {

	public EVBlockWallNetherBrick(int par1, Block par2Block) {
		super(par1, par2Block);
	}

    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
    	return Block.netherBrick.getBlockTextureFromSideAndMetadata(par1, 0);
    }

    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
}
