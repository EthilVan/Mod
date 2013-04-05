package net.minecraft.src;

public class EVBlockCustomStairs extends BlockStairs {

	protected EVBlockCustomStairs(int par1, Block par2Block, int par3) {
		super(par1, par2Block, par3);
		this.useNeighborBrightness[par1] = true;
	}
}
