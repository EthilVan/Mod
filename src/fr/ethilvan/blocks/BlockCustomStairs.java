package fr.ethilvan.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import fr.ethilvan.EthilVan;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCustomStairs extends BlockStairs {
	public BlockCustomStairs(int par1, Block par2Block, int par3) {
		super(par1, par2Block, par3);
		this.useNeighborBrightness[par1] = true;
		this.setCreativeTab(EthilVan.ethilvanTabs);
	}
}
