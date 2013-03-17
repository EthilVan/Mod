package fr.ethilvan;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.StringTranslate;

public class CreativeEthilvanTabs extends CreativeTabs {

	public CreativeEthilvanTabs() {
		super("EthilVan");
	}

    public String getTranslatedTabLabel() {
        return "EthilVan";
    }

    public int getTabIconItemIndex() {
        return EthilVan.redstoneBlock.blockID;
    }
}

