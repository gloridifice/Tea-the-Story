package roito.teastory.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roito.teastory.TeaStory;

public class PotionPhotosynthesis extends Potion
{
    private static final ResourceLocation res = new ResourceLocation(TeaStory.MODID + ":" + "textures/gui/potion.png");

    public PotionPhotosynthesis()
    {
        super(false, 0xff9900);
        this.setBeneficial();
        this.setPotionName("teastory.potion.photosynthesis");
        this.setRegistryName(TeaStory.MODID, "photosynthesis");
    }

    @Override
    public boolean isReady(int duration, int amplifier)
    {
        return duration % 60 == 0;
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_)
    {
        if (this == PotionRegister.PotionPhotosynthesis)
        {
            boolean isDaytime = entityLivingBaseIn.getEntityWorld().getWorldTime() % 24000L < 12000L;
            BlockPos pos = entityLivingBaseIn.getPosition();
            if ((!entityLivingBaseIn.getEntityWorld().isRainingAt(pos)) && ((isDaytime && (entityLivingBaseIn.getEntityWorld().getLight(pos) >= 13 - 2 * p_76394_2_)) || ((!isDaytime) && (entityLivingBaseIn.getEntityWorld().getLightFor(EnumSkyBlock.BLOCK, pos) >= 13 - 2 * p_76394_2_))))
            {
                entityLivingBaseIn.heal(4);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc)
    {
        mc.getTextureManager().bindTexture(PotionPhotosynthesis.res);
        mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 18, 0, 18, 18);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha)
    {
        mc.getTextureManager().bindTexture(PotionPhotosynthesis.res);
        Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 18, 0, 18, 18, 256, 256);
    }
}
