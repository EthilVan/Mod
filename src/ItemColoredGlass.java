package net.minecraft.src;

public class ItemColoredGlass extends ItemBlock
{
    private Block coloredGlass;

    public ItemColoredGlass(int par1, Block par2)
    {
        super(par1);
        this.coloredGlass = par2;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getIconFromDamage(int par1)
    {
        return this.coloredGlass.getBlockTextureFromSideAndMetadata(0, par1);
    }

    public int getMetadata(int par1)
    {
        return par1;
    }

    public String getItemNameIS(ItemStack par1ItemStack)
    {
        int var2 = par1ItemStack.getItemDamage();

        if (var2 < 0 || var2 >= BlockColoredGlass.coloredGlassType.length)
        {
            var2 = 0;
        }

        return super.getItemName() + "." + BlockColoredGlass.coloredGlassType[var2];
    }
}
