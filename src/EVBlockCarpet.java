package net.minecraft.src;

import java.util.List;

public class EVBlockCarpet extends Block {

	protected EVBlockCarpet(int par1, Material par3) {
		super(par1, Material.cloth);
		this.setHardness(0.8F);
		this.setStepSound(Block.soundClothFootstep);
		this.setLightOpacity(0);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		float f = 0.125F;
		return AxisAlignedBB.getAABBPool().getAABB((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)((float)par3 + (float)f), (double)par4 + this.maxZ);
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public Icon getBlockTextureFromSideAndMetadata(int side, int metadata) {
		return Block.cloth.getBlockTextureFromSideAndMetadata(side, metadata);
	}
	

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
			par1World.setBlockToAir(par2, par3, par4);
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

	public void registerNames() {
		ModLoader.addLocalization("ev_coloredGlass.white", "Tapis blanc");
		ModLoader.addLocalization("ev_coloredGlass.orange", "Tapis orangé");
		ModLoader.addLocalization("ev_coloredGlass.magenta", "Tapis magenta");
		ModLoader.addLocalization("ev_coloredGlass.light_blue", "Tapis bleu clair");
		ModLoader.addLocalization("ev_coloredGlass.yellow", "Tapis jaune");
		ModLoader.addLocalization("ev_coloredGlass.lime", "Tapis vert clair");
		ModLoader.addLocalization("ev_coloredGlass.pink", "Tapis rose");
		ModLoader.addLocalization("ev_coloredGlass.gray", "Tapis gris");
		ModLoader.addLocalization("ev_coloredGlass.light_gray", "Tapis gris clair");
		ModLoader.addLocalization("ev_coloredGlass.cyan", "Tapis cyan");
		ModLoader.addLocalization("ev_coloredGlass.purple", "Tapis violet");
		ModLoader.addLocalization("ev_coloredGlass.blue", "Tapis bleu");
		ModLoader.addLocalization("ev_coloredGlass.brown", "Tapis marron");
		ModLoader.addLocalization("ev_coloredGlass.green", "Tapis vert");
		ModLoader.addLocalization("ev_coloredGlass.red", "Tapis rouge");
		ModLoader.addLocalization("ev_coloredGlass.black", "Tapis noir");
	}

	public void registerCrafts() {
		for (int i = 0; i < 16; i++) {
			ModLoader.addRecipe(new ItemStack(this, 8, i), new Object[] {
				"XX", Character.valueOf('X'), new ItemStack(Block.cloth, 0, i)
			});
		}
		for (int i = 0; i < 16; i++) {
			for (int a = 0; a < 16; a++) {
				ModLoader.addShapelessRecipe(new ItemStack(this, 1, a),
						new Object[] {new ItemStack(this, 1, i), new ItemStack(Item.dyePowder, 1, BlockCloth.getDyeFromBlock(a))});
			}
		}
	}

    public void registerIcons(IconRegister par1IconRegister) {}
}
