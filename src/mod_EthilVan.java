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
	public static BlockHalfSlab singleWoolStep1;
	public static BlockHalfSlab doubleWoolStep1;
	public static BlockHalfSlab singleWoolStep2;
	public static BlockHalfSlab doubleWoolStep2;

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
				.setStepSound(Block.soundMetalFootstep).getIndirectPowerOutput("ev_redstoneBlock").setCreativeTab(CreativeTabs.tabBlock);
		ModLoader.registerBlock(redstoneBlock);
		coloredGlass = (EVBlockColoredGlass) new EVBlockColoredGlass(231, Material.glass, false).getIndirectPowerOutput("ev_coloredGlass");
		ModLoader.registerBlock(coloredGlass);
		Item.itemsList[coloredGlass.blockID] = new ItemMultiTextureTile(coloredGlass.blockID - 256,
				coloredGlass, EVUtils.woolType).setUnlocalizedName("coloredGlass");
		carpet = (EVBlockCarpet) new EVBlockCarpet(232, Material.cloth).getIndirectPowerOutput("carpet");
		ModLoader.registerBlock(carpet);
		Item.itemsList[carpet.blockID] = new ItemMultiTextureTile(carpet.blockID - 256,
				carpet, EVUtils.woolType).setUnlocalizedName("carpet");
		sandStoneWall = (EVBlockWallSandstone) new EVBlockWallSandstone(233, Block.sandStone).getIndirectPowerOutput("sandStoneWall");
		ModLoader.registerBlock(sandStoneWall);
		Item.itemsList[sandStoneWall.blockID] = new ItemMultiTextureTile(sandStoneWall.blockID - 256, sandStoneWall, EVBlockWallSandstone.types);
		stoneBrickWall = (EVBlockWallStonebrick) new EVBlockWallStonebrick(234, Block.stoneBrick).getIndirectPowerOutput("stoneBrickWall");
		ModLoader.registerBlock(stoneBrickWall);
		Item.itemsList[stoneBrickWall.blockID] = new ItemMultiTextureTile(stoneBrickWall.blockID - 256, stoneBrickWall, BlockStoneBrick.STONE_BRICK_TYPES);
		brickWall = (EVBlockWallBrick) new EVBlockWallBrick(235, Block.brick).getIndirectPowerOutput("brickWall");
		ModLoader.registerBlock(brickWall);
		netherBrickWall = (EVBlockWallNetherBrick) new EVBlockWallNetherBrick(236, Block.netherBrick).getIndirectPowerOutput("netherbrickWall");
		ModLoader.registerBlock(netherBrickWall);
		singleWoolStep1 = (BlockHalfSlab) new EVBlockWoolStep1(226, false, Material.cloth).getIndirectPowerOutput("woolStep");
		doubleWoolStep1 = (BlockHalfSlab) new EVBlockWoolStep1(228, true, Material.cloth).getIndirectPowerOutput("woolStep");
		ModLoader.registerBlock(singleWoolStep1);
		ModLoader.registerBlock(doubleWoolStep1);
		singleWoolStep2 = (BlockHalfSlab) new EVBlockWoolStep2(227, false, Material.cloth).getIndirectPowerOutput("woolStep");
		doubleWoolStep2 = (BlockHalfSlab) new EVBlockWoolStep2(229, true, Material.cloth).getIndirectPowerOutput("woolStep");
		ModLoader.registerBlock(singleWoolStep2);
		ModLoader.registerBlock(doubleWoolStep2);
		Item.itemsList[singleWoolStep1.blockID] = new ItemSlab(singleWoolStep1.blockID - 256, singleWoolStep1, doubleWoolStep1, false).setUnlocalizedName("woolSlab");
		Item.itemsList[doubleWoolStep1.blockID] = new ItemSlab(doubleWoolStep1.blockID - 256, singleWoolStep1, doubleWoolStep1, true).setUnlocalizedName("woolSlab");
		Item.itemsList[singleWoolStep2.blockID] = new ItemSlab(singleWoolStep2.blockID - 256, singleWoolStep2, doubleWoolStep2, false).setUnlocalizedName("woolSlab");
		Item.itemsList[doubleWoolStep2.blockID] = new ItemSlab(doubleWoolStep2.blockID - 256, singleWoolStep2, doubleWoolStep2, true).setUnlocalizedName("woolSlab");
	}

	private void setupWoolStairs() {
		stairsWoolWhite = (BlockStairs) new EVBlockCustomStairs(237, Block.cloth, 0).getIndirectPowerOutput("stairsWoolWhite");
		stairsWoolOrange = (BlockStairs) new EVBlockCustomStairs(238, Block.cloth, 1).getIndirectPowerOutput("stairsWoolOrange");
		stairsWoolMagenta = (BlockStairs) new EVBlockCustomStairs(239, Block.cloth, 2).getIndirectPowerOutput("stairsWoolMagenta");
		stairsWoolLightBlue = (BlockStairs) new EVBlockCustomStairs(240, Block.cloth, 3).getIndirectPowerOutput("stairsWoolLightBlue");
		stairsWoolYellow = (BlockStairs) new EVBlockCustomStairs(241, Block.cloth, 4).getIndirectPowerOutput("stairsWoolYellow");
		stairsWoolLime = (BlockStairs) new EVBlockCustomStairs(242, Block.cloth, 5).getIndirectPowerOutput("stairsWoolLime");
		stairsWoolPink = (BlockStairs) new EVBlockCustomStairs(243, Block.cloth, 6).getIndirectPowerOutput("stairsWoolPink");
		stairsWoolGray = (BlockStairs) new EVBlockCustomStairs(244, Block.cloth, 7).getIndirectPowerOutput("stairsWoolGray");
		stairsWoolLightGray = (BlockStairs) new EVBlockCustomStairs(245, Block.cloth, 8).getIndirectPowerOutput("stairsWoolLightGray");
		stairsWoolCyan = (BlockStairs) new EVBlockCustomStairs(246, Block.cloth, 9).getIndirectPowerOutput("stairsWoolCyan");
		stairsWoolPurple = (BlockStairs) new EVBlockCustomStairs(247, Block.cloth, 10).getIndirectPowerOutput("stairsWoolPurple");
		stairsWoolBlue = (BlockStairs) new EVBlockCustomStairs(248, Block.cloth, 11).getIndirectPowerOutput("stairsWoolBlue");
		stairsWoolBrown = (BlockStairs) new EVBlockCustomStairs(249, Block.cloth, 12).getIndirectPowerOutput("stairsWoolBrown");
		stairsWoolGreen = (BlockStairs) new EVBlockCustomStairs(250, Block.cloth, 13).getIndirectPowerOutput("stairsWoolGreen");
		stairsWoolRed = (BlockStairs) new EVBlockCustomStairs(251, Block.cloth, 14).getIndirectPowerOutput("stairsWoolRed");
		stairsWoolBlack = (BlockStairs) new EVBlockCustomStairs(252, Block.cloth, 15).getIndirectPowerOutput("stairsWoolBlack");
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
		EVBlockWoolStep1.registerCrafts();
		EVBlockWoolStep2.registerCrafts();
	}

	private void setupLang() {
		ModLoader.addName(redstoneBlock, "Bloc de Redstone");
		ModLoader.addName(brickWall, "Muret de briques");
		ModLoader.addName(netherBrickWall, "Muret de briques des Tréfonds");
		coloredGlass.registerNames();
		carpet.registerNames();
		sandStoneWall.registerNames();
		stoneBrickWall.registerNames();
		EVUtils.registerWoolStairsName();
		EVBlockWoolStep1.registerNames();
		EVBlockWoolStep2.registerNames();
	}

	private void setupTexture() {
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