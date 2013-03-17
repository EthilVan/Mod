package fr.ethilvan;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCloth;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTextureTile;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.ethilvan.blocks.BlockCarpet;
import fr.ethilvan.blocks.BlockColoredGlass;
import fr.ethilvan.blocks.BlockWallBrick;
import fr.ethilvan.blocks.BlockWallNetherBrick;
import fr.ethilvan.blocks.BlockWallSandStone;
import fr.ethilvan.blocks.BlockWallStoneBrick;
import fr.ethilvan.client.ClientProxy;
import fr.ethilvan.common.CommonProxy;

@Mod(modid = "ethilvan", name = "EthilVan", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class EthilVan {

	@Instance("Mod")
	public static EthilVan modInstance;
	@SidedProxy(clientSide="fr.ethilvan.client.ClientProxy", serverSide="fr.ethilvan.common.CommonProxy", bukkitSide="fr.ethilvan.common.CommonProxy")
	public static CommonProxy proxy;
	/* Tabs */
	public static final CreativeTabs ethilvanTabs = new CreativeEthilvanTabs();
	/* Bloc */
	public static final Block redstoneBlock = new Block(230, 0, Material.iron).setHardness(5.0F).setResistance(10.0F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("redstoneBlock").setRequiresSelfNotify()
			.setTextureFile(CommonProxy.texture).setCreativeTab(ethilvanTabs);
	public static final Block coloredGlass = new BlockColoredGlass(231, 0, Material.glass, false);
	public static final Block carpet = new BlockCarpet(232, 0, Material.cloth);
	public static final Block sandStoneWall = new BlockWallSandStone(233, Block.sandStone).setHardness(0.8F).setRequiresSelfNotify().setBlockName("sandstoneWall").setStepSound(Block.soundStoneFootstep);
	public static final Block stoneBrickWall = new BlockWallStoneBrick(234, Block.stoneBrick).setRequiresSelfNotify().setBlockName("stonebrickWall").setStepSound(Block.soundStoneFootstep);
	public static final Block brickWall = new BlockWallBrick(235, Block.brick).setRequiresSelfNotify().setBlockName("brickWall").setStepSound(Block.soundStoneFootstep);
	public static final Block netherBrickWall = new BlockWallNetherBrick(236, Block.netherBrick).setRequiresSelfNotify().setBlockName("netherbrickWall").setStepSound(Block.soundStoneFootstep);
	/* Item */

	@PreInit
	public void initConfig(FMLPreInitializationEvent event) {
		proxy.registerRenderThings();
	}

	@Init
	public void load(FMLInitializationEvent event) {
		setupBlocks();
		setupLanguages();
		setupCrafts();
	}

	private void setupBlocks() {
		GameRegistry.registerBlock(redstoneBlock, "redstoneBlock");
		GameRegistry.registerBlock(coloredGlass, "coloredGlass");
		GameRegistry.registerBlock(carpet, "carpet");
		GameRegistry.registerBlock(sandStoneWall, "sandStoneWall");
		GameRegistry.registerBlock(stoneBrickWall, "stoneBrickWall");
		GameRegistry.registerBlock(brickWall, "brickWall");
		GameRegistry.registerBlock(netherBrickWall, "netherBrickWall");
		Item.itemsList[coloredGlass.blockID] = new ItemMultiTextureTile(coloredGlass.blockID - 256, coloredGlass, BlockColoredGlass.types).setItemName("coloredGlass");
		Item.itemsList[carpet.blockID] = new ItemMultiTextureTile(carpet.blockID - 256, carpet, BlockCarpet.type).setItemName("carpet");
		Item.itemsList[sandStoneWall.blockID] = new ItemMultiTextureTile(sandStoneWall.blockID - 256, sandStoneWall, BlockWallSandStone.types);
		Item.itemsList[stoneBrickWall.blockID] = new ItemMultiTextureTile(stoneBrickWall.blockID - 256, stoneBrickWall, BlockWallStoneBrick.types);
	}

	private void setupCrafts() {
		GameRegistry.addRecipe(new ItemStack(redstoneBlock), new Object[] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Item.redstone
		});
		GameRegistry.addRecipe(new ItemStack(Item.redstone, 9), new Object[] {
			"X", Character.valueOf('X'), redstoneBlock
		});
		for (int metaGlass = 0; metaGlass < 16; metaGlass++) {
			GameRegistry.addRecipe(new ItemStack(coloredGlass, 4, metaGlass), new Object[] {
				" X ", "XCX", " X ", 'X', Block.glass, 'C', new ItemStack(Item.dyePowder, 1, BlockCloth.getBlockFromDye(metaGlass))
			});
		}
		for (int i = 0; i < 16; i++) {
			GameRegistry.addRecipe(new ItemStack(carpet, 8, i), new Object[] {
				"XX", Character.valueOf('X'), new ItemStack(Block.cloth, 0, i)
			});
		}
		for (int i = 0; i < 16; i++) {
			for (int a = 0; a < 16; a++) {
				GameRegistry.addShapelessRecipe(new ItemStack(carpet, 1, a), new Object[] {new ItemStack(carpet, 1, i), new ItemStack(Item.dyePowder, 1, BlockCloth.getDyeFromBlock(a))});
			}
		}
		GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 8, 3), new Object[] {
			"XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 0)
		});
		GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 8, 2), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 0), Character.valueOf('Y'), Item.gunpowder
		});
		GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 8, 1), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 0), Character.valueOf('Y'), Block.vine
		});
		GameRegistry.addRecipe(new ItemStack(Block.cobblestoneMossy, 8), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), Block.vine
		});
		GameRegistry.addRecipe(new ItemStack(Block.sponge, 1), new Object[] {
			"XYX", "YCY", "XYX", Character.valueOf('X'), new ItemStack(Block.cloth, 0 , 4), Character.valueOf('Y'), Block.deadBush, Character.valueOf('C'), Item.enderPearl
		});
		GameRegistry.addRecipe(new ItemStack(Block.web, 1), new Object[] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Item.silk
		});
		GameRegistry.addRecipe(new ItemStack(Block.snow, 1), new Object[] {
			"XXX", Character.valueOf('X'), Item.snowball
		});
		GameRegistry.addRecipe(new ItemStack(Block.ice, 1), new Object[] {
			"XX", "XX", Character.valueOf('X'), Block.blockSnow
		});
		GameRegistry.addRecipe(new ItemStack(sandStoneWall, 6, 0), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.sandStone, 0, 0)
		});
		GameRegistry.addRecipe(new ItemStack(sandStoneWall, 6, 1), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.sandStone, 0, 2)
		});
		GameRegistry.addRecipe(new ItemStack(stoneBrickWall, 6, 0), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 0)
		});
		GameRegistry.addRecipe(new ItemStack(stoneBrickWall, 6, 1), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 1)
		});
		GameRegistry.addRecipe(new ItemStack(stoneBrickWall, 6, 2), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 2)
		});
		GameRegistry.addRecipe(new ItemStack(stoneBrickWall, 6, 3), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.stoneBrick, 0, 3)
		});
		GameRegistry.addRecipe(new ItemStack(brickWall, 6), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), Block.brick
		});
		GameRegistry.addShapelessRecipe(new ItemStack(netherBrickWall, 1), new Object[] {new ItemStack(Block.netherFence, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.netherFence, 1), new Object[] {new ItemStack(netherBrickWall, 1)});
	}

	private void setupLanguages() {
		LanguageRegistry.addName(redstoneBlock, "Bloc de Redstone");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 0), "Vitre blanche");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 1), "Vitre orangée");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 2), "Vitre magenta");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 3), "Vitre bleu clair");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 4), "Vitre jaune");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 5), "Vitre vert clair");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 6), "Vitre rose");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 7), "Vitre grise");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 8), "Vitre grise claire");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 9), "Vitre cyan");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 10), "Vitre violette");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 11), "Vitre bleue");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 12), "Vitre marron");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 13), "Vitre verte");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 14), "Vitre rouge");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 15), "Vitre noire");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 0), "Tapis blanc");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 1), "Tapis orange");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 2), "Tapis magenta");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 3), "Tapis bleu clair");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 4), "Tapis jaune");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 5), "Tapis vert clair");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 6), "Tapis rose");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 7), "Tapis gris");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 8), "Tapis gris clair");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 9), "Tapis cyan");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 10), "Tapis violet");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 11), "Tapis bleu");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 12), "Tapis marron");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 13), "Tapis vert");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 14), "Tapis rouge");
		LanguageRegistry.addName(new ItemStack(carpet, 1, 15), "Tapis noir");
		LanguageRegistry.addName(new ItemStack(sandStoneWall, 1, 0), "Muret de grés");
		LanguageRegistry.addName(new ItemStack(sandStoneWall, 1, 1), "Muret de grés lisse");
		LanguageRegistry.addName(new ItemStack(stoneBrickWall, 1, 0), "Muret de briques de pierre");
		LanguageRegistry.addName(new ItemStack(stoneBrickWall, 1, 1), "Muret de briques de pierre moussues");
		LanguageRegistry.addName(new ItemStack(stoneBrickWall, 1, 2), "Muret de briques de pierre craquelées");
		LanguageRegistry.addName(new ItemStack(stoneBrickWall, 1, 3), "Muret de briques de pierre sculptées");
		LanguageRegistry.addName(netherBrickWall, "Muret de briques des Tréfonds");
		LanguageRegistry.addName(brickWall, "Muret de briques");
	}
}
