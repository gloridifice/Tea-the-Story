package roito.teastory.item.drink;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import roito.teastory.block.BlockRegister;
import roito.teastory.config.ConfigMain;
import roito.teastory.item.ItemRegister;
import roito.teastory.potion.PotionRegister;

public class YellowTea extends ItemTeaDrink
{
    public YellowTea()
    {
        super("yellow_tea");
    }

    @Override
    protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if (!world.isRemote)
        {
            int tier = itemstack.getItemDamage() / 2;
            addPotion(tier, world, entityplayer);
        }
    }

    public static void addPotion(int tier, World world, EntityPlayer entityplayer)
    {
        if (ConfigMain.general.useTeaResidueAsBoneMeal)
        {
            ItemHandlerHelper.giveItemToPlayer(entityplayer, new ItemStack(ItemRegister.tea_residue, 1, 2));
        }
        if (Potion.getPotionFromResourceLocation(ConfigMain.drink.yellowTeaDrink_Effect) != null)
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation(ConfigMain.drink.yellowTeaDrink_Effect), ConfigMain.drink.yellowTeaDrink_Time, 0));
        }
        entityplayer.addPotionEffect(new PotionEffect(PotionRegister.PotionExcitement, ConfigMain.drink.yellowTeaDrink_Time, 0));
    }

    @Override
    public Block getBlock(int meta)
    {
        switch (meta)
        {
            case 2:
                return BlockRegister.yellowtea_stone_cup;
            case 3:
                return BlockRegister.yellowtea_glass_cup;
            case 4:
                return BlockRegister.yellowtea_porcelain_cup;
            case 5:
                return BlockRegister.yellowtea_zisha_cup;
            default:
                return BlockRegister.yellowtea_wood_cup;
        }
    }
}