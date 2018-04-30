package roito.teastory.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import roito.teastory.common.CreativeTabsLoader;

public class ClayKettle extends Kettle
{
	public ClayKettle(String name)
	{
		super(name, Material.CLAY);
		this.setHardness(0.6F);
		this.setSoundType(SoundType.GROUND);
		this.setCreativeTab(CreativeTabsLoader.tabDrink);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer)
	{
		IBlockState origin = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
		return origin.withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
}
