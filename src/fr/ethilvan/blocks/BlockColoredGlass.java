package fr.ethilvan.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fr.ethilvan.EthilVan;
import fr.ethilvan.common.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockColoredGlass extends BlockBreakable
{
    public static final String[] types = new String[] {"white", "orange", "magenta",
            "light_blue", "yellow", "lime",
            "pink", "gray", "light_gray",
            "cyan", "purple", "blue",
            "brown", "green", "red", "black"};

    public BlockColoredGlass(int par1, int par2, Material par3Material, boolean par4) {
        super(par1, par2, par3Material, par4);
        this.setCreativeTab(EthilVan.ethilvanTabs);
        this.setHardness(0.3F);
        this.setStepSound(Block.soundGlassFootstep);
        this.setBlockName("coloredGlass");
        this.setRequiresSelfNotify();
        this.setTextureFile(CommonProxy.texture);
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
        switch (metadata) {
            case 0:
                return 1;

            case 1:
                return 2;

            case 2:
                return 3;

            case 3:
                return 4;

            case 4:
                return 5;

            case 5:
                return 6;

            case 6:
                return 7;

            case 7:
                return 8;

            case 8:
                return 9;

            case 9:
                return 10;

            case 10:
                return 11;

            case 11:
                return 12;

            case 12:
                return 13;

            case 13:
                return 14;

            case 14:
                return 15;

            case 15:
                return 16;
        }

        return metadata;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int var4 = 0; var4 < 16; ++var4) {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
    	return true;
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
    	return true;
    }
}