package net.minecraft.src;

public class mod_Ethilvan extends BaseMod {

    /** Colored Glass Block**/
    public static final Block coloredGlass = (new BlockColoredGlass(231, 0, Material.glass, false).setHardness(0.3F)
            .setStepSound(Block.soundGlassFootstep).setBlockName("coloredGlass").setRequiresSelfNotify());
    /** Colored Glass Block Texture**/
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

    /** Redstone Block**/
    public static final Block redstoneBlock = (new Block(230, Material.iron).setHardness(5.0F).setResistance(10.0F)
            .setStepSound(Block.soundMetalFootstep).setBlockName("redstoneBlock").setRequiresSelfNotify());

    /** Tapis Block **/
    public static final Block carpet = (new BlockCarpet(232, 0, Material.cloth).setHardness(0.5F)
            .setStepSound(Block.soundClothFootstep).setBlockName("carpet").setLightOpacity(0).setRequiresSelfNotify());

    @Override
    public void load() {
        /** Bloc **/
        ModLoader.registerBlock(carpet);
        ModLoader.registerBlock(redstoneBlock);
        ModLoader.registerBlock(coloredGlass);
        /** Bloc avec Meta-Data **/
        Item.itemsList[coloredGlass.blockID] = new ItemColoredGlass(coloredGlass.blockID - 256, coloredGlass);
        Item.itemsList[carpet.blockID] = new ItemCarpet(carpet.blockID - 256, carpet);
        redstoneBlock.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/ethilvan/block/redstoneBlock.png");
        redstoneBlock.setCreativeTab(CreativeTabs.tabBlock);
        ModLoader.addName(redstoneBlock, "Bloc de Redstone");
        /** Nom des blocs de verres **/
        ModLoader.addName(new ItemStack(coloredGlass, 1, 0), "Vitre blanche");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 1), "Vitre orangée");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 2), "Vitre magenta");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 3), "Vitre bleu clair");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 4), "Vitre jaune");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 5), "Vitre vert clair");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 6), "Vitre rose");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 7), "Vitre grise");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 8), "Vitre grise claire");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 9), "Vitre cyan");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 10), "Vitre violette");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 11), "Vitre bleue");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 12), "Vitre marron");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 13), "Vitre verte");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 14), "Vitre rouge");
        ModLoader.addName(new ItemStack(coloredGlass, 1, 15), "Vitre noire");
        /** Nom des tapis **/
        ModLoader.addName(new ItemStack(carpet, 1, 0), "Tapis blanc");
        ModLoader.addName(new ItemStack(carpet, 1, 1), "Tapis orange");
        ModLoader.addName(new ItemStack(carpet, 1, 2), "Tapis magenta");
        ModLoader.addName(new ItemStack(carpet, 1, 3), "Tapis bleu clair");
        ModLoader.addName(new ItemStack(carpet, 1, 4), "Tapis jaune");
        ModLoader.addName(new ItemStack(carpet, 1, 5), "Tapis vert clair");
        ModLoader.addName(new ItemStack(carpet, 1, 6), "Tapis rose");
        ModLoader.addName(new ItemStack(carpet, 1, 7), "Tapis gris");
        ModLoader.addName(new ItemStack(carpet, 1, 8), "Tapis gris clair");
        ModLoader.addName(new ItemStack(carpet, 1, 9), "Tapis cyan");
        ModLoader.addName(new ItemStack(carpet, 1, 10), "Tapis violet");
        ModLoader.addName(new ItemStack(carpet, 1, 11), "Tapis bleu");
        ModLoader.addName(new ItemStack(carpet, 1, 12), "Tapis marron");
        ModLoader.addName(new ItemStack(carpet, 1, 13), "Tapis vert");
        ModLoader.addName(new ItemStack(carpet, 1, 14), "Tapis rouge");
        ModLoader.addName(new ItemStack(carpet, 1, 15), "Tapis noir");

        ///////////////////////////////////////////////
        for (int i = 0; i < 16; i++) {
            ModLoader.addRecipe(new ItemStack(mod_Ethilvan.carpet, 8, i), new Object[] {
                        "XX", Character.valueOf('X'), new ItemStack(Block.cloth, 0, i)
                    });
        }

        ModLoader.addRecipe(new ItemStack(mod_Ethilvan.redstoneBlock, 1), new Object[] {
            "XXX", "XXX", "XXX", Character.valueOf('X'), Item.redstone
        });


        ModLoader.addRecipe(new ItemStack(Item.redstone, 9), new Object[] {
            "X", Character.valueOf('X'), redstoneBlock
        });

        ColoredGlassCraft craft = new ColoredGlassCraft();

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

        ModLoader.addRecipe(new ItemStack(Block.ice, 1), new Object[] {
        	"XX", "XX", Character.valueOf('X'), Block.blockSnow
        });
    }

    @Override
    public String getVersion() {
        return "0.1";
    }
}
