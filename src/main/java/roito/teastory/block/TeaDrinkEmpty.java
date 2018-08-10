package roito.teastory.block;

import java.util.ArrayList;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import roito.teastory.item.ItemRegister;

public class TeaDrinkEmpty extends TeaDrink
{
	public TeaDrinkEmpty(float hardness, String name, Material materialIn, SoundType soundType, int level)
	{
		super(hardness, name, materialIn, soundType, level);
	}

	@Override
	public ArrayList getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune)
	{
		ArrayList drops = new ArrayList();
		drops.add(new ItemStack(ItemRegister.cup, 1, meta));
		return drops;
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
		items.add(new ItemStack(ItemRegister.cup, 1, meta));
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(ItemRegister.cup, 1, meta);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (playerIn.isSneaking())
		{
			ItemHandlerHelper.giveItemToPlayer(playerIn, new ItemStack(ItemRegister.cup, 1, meta));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			return true;
		}
		return false;
	}
}
