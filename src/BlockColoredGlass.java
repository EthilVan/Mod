package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockColoredGlass extends BlockBreakable
{
    public static final String[] coloredGlassType = new String[] {"white", "orange", "magenta",
            "light_blue", "yellow", "lime",
            "pink", "gray", "light_gray",
            "cyan", "purple", "blue",
            "brown", "green", "red", "black"};

    protected BlockColoredGlass(int par1, int par2, Material par3Material, boolean par4) {
        super(par1, par2, par3Material, par4);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public int quantityDropped(Random par1Random) {
        return 0;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int getRenderBlockPass() {
        return 1;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
        switch (metadata) {
            case 0:
                return mod_Ethilvan.whiteGl;

            case 1:
                return mod_Ethilvan.orangeGl;

            case 2:
                return mod_Ethilvan.magentaGl;

            case 3:
                return mod_Ethilvan.lightblueGl;

            case 4:
                return mod_Ethilvan.yellowGl;

            case 5:
                return mod_Ethilvan.limeGl;

            case 6:
                return mod_Ethilvan.pinkGl;

            case 7:
                return mod_Ethilvan.grayGl;

            case 8:
                return mod_Ethilvan.lightgrayGl;

            case 9:
                return mod_Ethilvan.cyanGl;

            case 10:
                return mod_Ethilvan.purpleGl;

            case 11:
                return mod_Ethilvan.blueGl;

            case 12:
                return mod_Ethilvan.brownGl;

            case 13:
                return mod_Ethilvan.greenGl;

            case 14:
                return mod_Ethilvan.redGl;

            case 15:
                return mod_Ethilvan.blackGl;
        }

        return metadata;
    }

    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int var4 = 0; var4 < 16; ++var4) {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }

    protected boolean canSilkHarvest() {
        return true;
    }
}
