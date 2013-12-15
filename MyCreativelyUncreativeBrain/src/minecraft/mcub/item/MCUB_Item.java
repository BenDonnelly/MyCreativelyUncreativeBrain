package mcub.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import mcub.main.Strings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MCUB_Item extends Item
{

	public MCUB_Item(int id) 
	{
		super(id);
	}
	
	public static void initItems()
	{
		osItems();
	}
	
	public static Item diamondNugget;
	
	public static void osItems()
	{
	diamondNugget = (new Item(3001)).setUnlocalizedName("diamondNugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Strings.MOD_ID  + ":Ore Spiders/diamond_nugget");
	
	LanguageRegistry.addName(diamondNugget, "Diamond Nugget");
	}
}
