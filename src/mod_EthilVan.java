package net.minecraft.src;

public class mod_EthilVan extends BaseMod {

	public static Block redstoneBlock;
	public static EVBlockColoredGlass coloredGlass;
	public static EVBlockCarpet carpet;
	public static EVBlockWallSandstone sandStoneWall;
	public static EVBlockWallStonebrick stoneBrickWall;
	public static EVBlockWallNetherBrick netherBrickWall;
	public static EVBlockWallBrick brickWall;
	public static BlockStairs stairsWoolWhite;
	public static BlockStairs stairsWoolOrange;
	public static BlockStairs stairsWoolMagenta;
	public static BlockStairs stairsWoolLightBlue;
	public static BlockStairs stairsWoolYellow;
	public static BlockStairs stairsWoolLime;
	public static BlockStairs stairsWoolPink;
	public static BlockStairs stairsWoolGray;
	public static BlockStairs stairsWoolLightGray;
	public static BlockStairs stairsWoolCyan;
	public static BlockStairs stairsWoolPurple;
	public static BlockStairs stairsWoolBlue;
	public static BlockStairs stairsWoolBrown;
	public static BlockStairs stairsWoolGreen;
	public static BlockStairs stairsWoolRed;
	public static BlockStairs stairsWoolBlack;

	@Override
	public void load() {
		setupBlocks();
		setupTexture();
		setupLang();
		setupCrafts();
	}

	private void setupBlocks() {
		setupWoolStairs();
		redstoneBlock = new Block(230, Material.iron).setHardness(5.0F).setResistance(10.0F)
				.setStepSound(Block.soundMetalFootstep).setBlockName("redstoneBlock").setCreativeTab(CreativeTabs.tabBlock);
		ModLoader.registerBlock(redstoneBlock);
		coloredGlass = new EVBlockColoredGlass(231, 0, Material.glass, false);
		ModLoader.registerBlock(coloredGlass);
		Item.itemsList[coloredGlass.blockID] = new ItemMultiTextureTile(coloredGlass.blockID - 256,
				coloredGlass, EVUtils.woolType).setItemName("coloredGlass");
		carpet = new EVBlockCarpet(232, 0, Material.cloth);
		ModLoader.registerBlock(carpet);
		Item.itemsList[carpet.blockID] = new ItemMultiTextureTile(carpet.blockID - 256,
				carpet, EVUtils.woolType).setItemName("carpet");
		sandStoneWall = (EVBlockWallSandstone) new EVBlockWallSandstone(233, Block.sandStone).setBlockName("sandStoneWall");
		ModLoader.registerBlock(sandStoneWall);
		Item.itemsList[sandStoneWall.blockID] = new ItemMultiTextureTile(sandStoneWall.blockID - 256, sandStoneWall, EVBlockWallSandstone.types);
		stoneBrickWall = (EVBlockWallStonebrick) new EVBlockWallStonebrick(234, Block.stoneBrick).setBlockName("stoneBrickWall");
		ModLoader.registerBlock(stoneBrickWall);
		Item.itemsList[stoneBrickWall.blockID] = new ItemMultiTextureTile(stoneBrickWall.blockID - 256, stoneBrickWall, BlockStoneBrick.STONE_BRICK_TYPES);
		brickWall = (EVBlockWallBrick) new EVBlockWallBrick(235, Block.brick).setBlockName("brickWall");
		ModLoader.registerBlock(brickWall);
		netherBrickWall = (EVBlockWallNetherBrick) new EVBlockWallNetherBrick(236, Block.netherBrick).setBlockName("netherbrickWall");
		ModLoader.registerBlock(netherBrickWall);
	}

	private void setupWoolStairs() {
		stairsWoolWhite = (BlockStairs) new BlockCustomStairs(237, Block.cloth, 0).setBlockName("stairsWoolWhite");
		stairsWoolOrange = (BlockStairs) new BlockCustomStairs(238, Block.cloth, 1).setBlockName("stairsWoolOrange");
		stairsWoolMagenta = (BlockStairs) new BlockCustomStairs(239, Block.cloth, 2).setBlockName("stairsWoolMagenta");
		stairsWoolLightBlue = (BlockStairs) new BlockCustomStairs(240, Block.cloth, 3).setBlockName("stairsWoolLightBlue");
		stairsWoolYellow = (BlockStairs) new BlockCustomStairs(241, Block.cloth, 4).setBlockName("stairsWoolYellow");
		stairsWoolLime = (BlockStairs) new BlockCustomStairs(242, Block.cloth, 5).setBlockName("stairsWoolLime");
		stairsWoolPink = (BlockStairs) new BlockCustomStairs(243, Block.cloth, 6).setBlockName("stairsWoolPink");
		stairsWoolGray = (BlockStairs) new BlockCustomStairs(244, Block.cloth, 7).setBlockName("stairsWoolGray");
		stairsWoolLightGray = (BlockStairs) new BlockCustomStairs(245, Block.cloth, 8).setBlockName("stairsWoolLightGray");
		stairsWoolCyan = (BlockStairs) new BlockCustomStairs(246, Block.cloth, 9).setBlockName("stairsWoolCyan");
		stairsWoolPurple = (BlockStairs) new BlockCustomStairs(247, Block.cloth, 10).setBlockName("stairsWoolPurple");
		stairsWoolBlue = (BlockStairs) new BlockCustomStairs(248, Block.cloth, 11).setBlockName("stairsWoolBlue");
		stairsWoolBrown = (BlockStairs) new BlockCustomStairs(249, Block.cloth, 12).setBlockName("stairsWoolBrown");
		stairsWoolGreen = (BlockStairs) new BlockCustomStairs(250, Block.cloth, 13).setBlockName("stairsWoolGreen");
		stairsWoolRed = (BlockStairs) new BlockCustomStairs(251, Block.cloth, 14).setBlockName("stairsWoolRed");
		stairsWoolBlack = (BlockStairs) new BlockCustomStairs(252, Block.cloth, 15).setBlockName("stairsWoolBlack");
		ModLoader.registerBlock(stairsWoolWhite);
		ModLoader.registerBlock(stairsWoolOrange);
		ModLoader.registerBlock(stairsWoolMagenta);
		ModLoader.registerBlock(stairsWoolLightBlue);
		ModLoader.registerBlock(stairsWoolYellow);
		ModLoader.registerBlock(stairsWoolLime);
		ModLoader.registerBlock(stairsWoolPink);
		ModLoader.registerBlock(stairsWoolGray);
		ModLoader.registerBlock(stairsWoolLightGray);
		ModLoader.registerBlock(stairsWoolCyan);
		ModLoader.registerBlock(stairsWoolPurple);
		ModLoader.registerBlock(stairsWoolBlue);
		ModLoader.registerBlock(stairsWoolBrown);
		ModLoader.registerBlock(stairsWoolGreen);
		ModLoader.registerBlock(stairsWoolRed);
		ModLoader.registerBlock(stairsWoolBlack);
	}

	private void setupCrafts() {
		EVUtils.removeRecipe(new ItemStack(Block.sandStone));
		ModLoader.addRecipe(new ItemStack(redstoneBlock, 1), new Object[] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Item.redstone
		});
		ModLoader.addRecipe(new ItemStack(Item.redstone, 9), new Object[] {
			"X", Character.valueOf('X'), redstoneBlock
		});
		ModLoader.addRecipe(new ItemStack(brickWall, 6), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), Block.brick
		});
		ModLoader.addShapelessRecipe(new ItemStack(netherBrickWall, 1), new Object[] {new ItemStack(Block.netherFence, 1)});
		ModLoader.addShapelessRecipe(new ItemStack(Block.netherFence, 1), new Object[] {new ItemStack(netherBrickWall, 1)});
		ModLoader.addRecipe(new ItemStack(Block.sandStone, 2), new Object[] {
			"XX", "XX", Character.valueOf('X'), Block.sand
		});
		EVUtils.registerWoolStairsCraft();
		coloredGlass.registerCrafts();
		carpet.registerCrafts();
		sandStoneWall.registerCrafts();
		stoneBrickWall.registerCrafts();
	}

	private void setupLang() {
		ModLoader.addName(redstoneBlock, "Bloc de Redstone");
		ModLoader.addName(brickWall, "Muret de briques");
		ModLoader.addName(netherBrickWall, "Muret de briques des Tr�fonds");
		coloredGlass.registerNames();
		carpet.registerNames();
		sandStoneWall.registerNames();
		stoneBrickWall.registerNames();
		EVUtils.registerWoolStairsName();
	}

	private void setupTexture() {
		redstoneBlock.blockIndexInTexture = EVTextures.redstoneBlock;
	}

	private void registerCraft() {
		ModLoader.addRecipe(new ItemStack(Block.stoneBrick, 8, 3), new Object[] {
			"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 0)
		});

		ModLoader.addRecipe(new ItemStack(Block.stoneBrick, 8, 2), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 0), Character.valueOf('Y'), Item.gunpowder
		});

		ModLoader.addRecipe(new ItemStack(Block.stoneBrick, 8, 1), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 0), Character.valueOf('Y'), Block.vine
		});

		ModLoader.addRecipe(new ItemStack(Block.cobblestoneMossy, 8), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), Block.vine
		});

		ModLoader.addRecipe(new ItemStack(Block.sponge, 1), new Object[] {
			"XYX", "YCY", "XYX", Character.valueOf('X'), new ItemStack(Block.cloth, 0 , 4), Character.valueOf('Y'), Block.deadBush, Character.valueOf('C'), Item.enderPearl
		});

		ModLoader.addRecipe(new ItemStack(Block.web, 1), new Object[] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Item.silk
		});

		ModLoader.addRecipe(new ItemStack(Block.snow, 1), new Object[] {
			"XXX", Character.valueOf('X'), Item.snowball
		});
	}

	@Override
	public String getVersion() {
		return "0.0.1";
	}
}