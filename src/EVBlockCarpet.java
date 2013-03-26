package net.minecraft.src;

import java.util.List;

public class EVBlockCarpet extends Block {

	protected EVBlockCarpet(int par1, int par2, Material par3) {
		super(par1, par2, Material.cloth);
		this.setHardness(0.8F);
		this.setStepSound(Block.soundClothFootstep);
		this.setBlockName("carpet");
		this.setLightOpacity(0);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setRequiresSelfNotify();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		float f = 0.125F;
		return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)((float)par3 + (float)f), (double)par4 + this.maxZ);
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

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

	public void registerNames() {
		ModLoader.addName(new ItemStack(this, 1, 0), "Tapis blanc");
		ModLoader.addName(new ItemStack(this, 1, 1), "Tapis orange");
		ModLoader.addName(new ItemStack(this, 1, 2), "Tapis magenta");
		ModLoader.addName(new ItemStack(this, 1, 3), "Tapis bleu clair");
		ModLoader.addName(new ItemStack(this, 1, 4), "Tapis jaune");
		ModLoader.addName(new ItemStack(this, 1, 5), "Tapis vert clair");
		ModLoader.addName(new ItemStack(this, 1, 6), "Tapis rose");
		ModLoader.addName(new ItemStack(this, 1, 7), "Tapis gris");
		ModLoader.addName(new ItemStack(this, 1, 8), "Tapis gris clair");
		ModLoader.addName(new ItemStack(this, 1, 9), "Tapis cyan");
		ModLoader.addName(new ItemStack(this, 1, 10), "Tapis violet");
		ModLoader.addName(new ItemStack(this, 1, 11), "Tapis bleu");
		ModLoader.addName(new ItemStack(this, 1, 12), "Tapis marron");
		ModLoader.addName(new ItemStack(this, 1, 13), "Tapis vert");
		ModLoader.addName(new ItemStack(this, 1, 14), "Tapis rouge");
		ModLoader.addName(new ItemStack(this, 1, 15), "Tapis noir");
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
}
