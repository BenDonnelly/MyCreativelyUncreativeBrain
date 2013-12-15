package mcub.recipes;

import mcub.item.MCUB_Item;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipes 
{

	public static void initRecipes()
	{
		osRecipes();
	}
	
	public static void osRecipes()
	{
		 GameRegistry.addRecipe(new ItemStack(Item.diamond), new Object[] {"XXX" , "X X" , "XXX" , Character.valueOf('X') , MCUB_Item.diamondNugget});
	}
}
