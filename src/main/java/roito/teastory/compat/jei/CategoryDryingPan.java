package roito.teastory.compat.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import roito.teastory.TeaStory;

public class CategoryDryingPan implements IRecipeCategory<IRecipeWrapper>
{

    protected final IDrawable background;

    public CategoryDryingPan(IGuiHelper helper)
    {
        ResourceLocation backgroundTexture = new ResourceLocation(TeaStory.MODID, "textures/gui/container/gui_recipe.png");
        background = helper.createDrawable(backgroundTexture, 5, 32, 166, 22);
    }

    @Override
    public String getUid()
    {
        return "teastory.dryingpan";
    }

    @Override
    public String getTitle()
    {
        return I18n.format("jei.teastory.category.dryingpan");
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper)
    {
        IGuiItemStackGroup items = recipeLayout.getItemStacks();
        items.init(0, true, 2, 2);
        items.set(0, ((RecipeDryingPan) recipeWrapper).getStep1Inputs());
        items.init(1, true, 38, 2);
        items.set(1, ((RecipeDryingPan) recipeWrapper).getStep2Inputs());
        items.init(2, true, 74, 2);
        items.set(2, ((RecipeDryingPan) recipeWrapper).getOutputs());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients)
    {
        setRecipe(recipeLayout, recipeWrapper);
    }

    @Override
    public String getModName()
    {
        return "TeaStory";
    }
}
