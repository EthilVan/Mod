package net.minecraft.src;

public class mod_Ethilvan extends BaseMod {

	public static final Block redstoneBlock = (new Block(230, Material.iron).setHardness(5.0F).setResistance(10.0F)
    		.setStepSound(Block.soundMetalFootstep).setBlockName("redstoneBlock"));
    public static final Block coloredGlass = (new BlockColoredGlass(231, 0, Material.glass, true).setHardness(0.3F)
    		.setStepSound(Block.soundGlassFootstep).setBlockName("coloredGlass"));
	public static final int white = ModLoader.addOverride("/terrain.png", "/ethilvan/block/redstoneBlock.png");

	public static final int whiteGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/white.png");
	public static final int orangeGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/orange.png");
	public static final int magentaGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/magenta.png");
	public static final int lightblueGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/lightBlue.png");
	public static final int yellowGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/yellow.png");
	public static final int limeGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/lime.png");
	public static final int pinkGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/pink.png");
	public static final int grayGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/grey.png");
	public static final int lightgrayGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/silver.png");
	public static final int cyanGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/cyan.png");
	public static final int purpleGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/purple.png");
	public static final int blueGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/blue.png");
	public static final int brownGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/brown.png");
	public static final int greenGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/green.png");
	public static final int redGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/red.png");
	public static final int blackGl = ModLoader.addOverride("/terrain.png", "/ethilvan/block/glass/black.png");

	@Override
	public void load() {
		ModLoader.registerBlock(redstoneBlock);
		ModLoader.registerBlock(coloredGlass);
		Item.itemsList[coloredGlass.blockID] = new ItemColoredGlass(coloredGlass.blockID - 256, coloredGlass);
		redstoneBlock.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/ethilvan/block/redstoneBlock.png");
		redstoneBlock.setCreativeTab(CreativeTabs.tabBlock);
		ModLoader.addName(redstoneBlock, "Bloc de Redstone");
		///////////////////////////////////////////
		ModLoader.addName(new ItemStack(coloredGlass, 1, 0), "Vitre blanche");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 1), "Vitre orangée");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 2), "Vitre magenta");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 3), "Vitre bleue clair");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 4), "Vitre jaune");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 5), "Vitre vert clair");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 6), "Vitre rose");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 7), "Vitre grise");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 8), "Vitre grise clair");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 9), "Vitre cyan");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 10), "Vitre violete");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 11), "Vitre bleue");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 12), "Vitre marron");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 13), "Vitre verte");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 14), "Vitre rouge");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 15), "Vitre noire");
        /////////////////////////////////////////////
        ColoredGlassCraft craft = new ColoredGlassCraft();
        
	}

	@Override
	public String getVersion() {
		return "0.1";
	}
}
