package net.minecraft.src;

public class BlockCustomStairs extends BlockStairs {

	protected BlockCustomStairs(int par1, Block par2Block, int par3) {
		super(par1, par2Block, par3);
		this.useNeighborBrightness[par1] = true;
		this.setRequiresSelfNotify();
	}

}
