package net.minecraft.src;

public class mod_EthilVan extends BaseMod {

	public static Block redstoneBlock;
	public static EVBlockColoredGlass coloredGlass;
	public static EVBlockCarpet carpet;

	@Override
	public void load() {
		setupBlocks();
		setupTexture();
		setupLang();
		setupCrafts();
	}

	public void setupBlocks() {
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
	}

	public void setupCrafts() {
		ModLoader.addRecipe(new ItemStack(redstoneBlock, 1), new Object[] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Item.redstone
		});

		ModLoader.addRecipe(new ItemStack(Item.redstone, 9), new Object[] {
			"X", Character.valueOf('X'), redstoneBlock
		});

		for (int metaGlass = 0; metaGlass < 16; metaGlass++) {
			ModLoader.addRecipe(new ItemStack(coloredGlass, 4, metaGlass), new Object[] {
				" X ", "XCX", " X ", 'X', Block.glass, 'C', new ItemStack(Item.dyePowder, 1, BlockCloth.getBlockFromDye(metaGlass))
			});
		}

		for (int i = 0; i < 16; i++) {
			ModLoader.addRecipe(new ItemStack(carpet, 8, i), new Object[] {
				"XX", Character.valueOf('X'), new ItemStack(Block.cloth, 0, i)
			});
		}
		for (int i = 0; i < 16; i++) {
			for (int a = 0; a < 16; a++) {
				ModLoader.addShapelessRecipe(new ItemStack(carpet, 1, a), new Object[] {new ItemStack(carpet, 1, i), new ItemStack(Item.dyePowder, 1, BlockCloth.getDyeFromBlock(a))});
			}
		}
	}

	public void setupLang() {
		ModLoader.addName(redstoneBlock, "Bloc de Redstone");
		coloredGlass.registerName();
		carpet.registerName();
	}

	public void setupTexture() {
		redstoneBlock.blockIndexInTexture = EVTextures.redstoneBlock;
	}

	@Override
	public String getVersion() {
		return "0.0.1";
	}
}
