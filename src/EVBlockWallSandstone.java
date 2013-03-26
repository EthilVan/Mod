package net.minecraft.src;

import java.util.List;

public class EVBlockWallSandstone extends BlockWall {

	public static final String[] types = new String[] {"default", "smooth"};

	public EVBlockWallSandstone(int par1, Block par2Block) {
		super(par1, par2Block);
	}

	public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return par2 == 1 ? 230 : super.getBlockTextureFromSide(par1);
	}

	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
	}

	public void registerNames() {
        ModLoader.addName(new ItemStack(this, 1, 0), "Muret de grès");
        ModLoader.addName(new ItemStack(this, 1, 1), "Muret de grès lisse");
	}

	public void registerCrafts() {
		ModLoader.addRecipe(new ItemStack(this, 6, 0), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.sandStone, 0, 0)
		});
		ModLoader.addRecipe(new ItemStack(this, 6, 1), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.sandStone, 0, 2)
		});
	}
}
