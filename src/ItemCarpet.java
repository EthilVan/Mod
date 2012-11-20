package net.minecraft.src;

public class ItemCarpet extends ItemBlock
{
    public Block carpet;

    public ItemCarpet(int par1, Block par2)
    {
        super(par1);
        this.carpet = par2;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getIconFromDamage(int par1) {
        return this.carpet.getBlockTextureFromSideAndMetadata(0, par1);
    }

    public int getMetadata(int par1) {
        return par1;
    }

    public String getItemNameIS(ItemStack par1ItemStack) {
        int var2 = par1ItemStack.getItemDamage();

        if (var2 < 0 || var2 >= BlockCarpet.carpetType.length)
        {
            var2 = 0;
        }

        return super.getItemName() + "." + BlockCarpet.carpetType[var2];
    }
}
