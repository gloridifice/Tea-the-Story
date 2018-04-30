package roito.teastory.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TSItem extends Item
{
	public TSItem(String name, int maxStack, CreativeTabs creativeTab)
	{
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStack);
		this.setCreativeTab(creativeTab);
	}
}
