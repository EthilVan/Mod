package net.minecraft.src;

import java.util.List;

public class EVBlockWallStonebrick extends BlockWall {

	Icon mossy, cracked, chiseled;

	public EVBlockWallStonebrick(int par1, Block par2Block) {
		super(par1, par2Block);
		this.useNeighborBrightness[par1] = true;
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return par2 == 1 ? mossy : par2 == 2 ? cracked : par2 == 3 ? chiseled : Block.stoneBrick.getBlockTextureFromSideAndMetadata(par1, par2);
	}

	public void registerIcons(IconRegister par1IconRegister) {
		chiseled = par1IconRegister.registerIcon("stonebricksmooth_carved");
		mossy = par1IconRegister.registerIcon("stonebricksmooth_mossy");
		cracked = par1IconRegister.registerIcon("stonebricksmooth_cracked");
    }

	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < 4; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}
	}

	public void registerNames() {
		ModLoader.addName(new ItemStack(mod_EthilVan.stoneBrickWall, 1, 0), "Muret de briques de pierre");
		ModLoader.addName(new ItemStack(mod_EthilVan.stoneBrickWall, 1, 1), "Muret de briques de pierre moussues");
		ModLoader.addName(new ItemStack(mod_EthilVan.stoneBrickWall, 1, 2), "Muret de briques de pierre craquelées");
		ModLoader.addName(new ItemStack(mod_EthilVan.stoneBrickWall, 1, 3), "Muret de briques de pierre sculptées");
	}

	public void registerCrafts() {
		for (int i = 0; i < 4; i++) {
			ModLoader.addRecipe(new ItemStack(this, 6, i), new Object[] {
				"XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, i)
			});
		}
	}
}
