package mcub.item;

import mcub.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
	public static Item heatpack;
	public static Item queenSpiderEye;
	public static ItemPotion queenSpiderPotion;
	public static Potion invertWASDPotion;

	public static void osItems()
	{
		diamondNugget = (new Item(3001)).setUnlocalizedName("diamondNugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Strings.MOD_ID + ":Ore Spiders/diamond_nugget");
		heatpack = (new Temp_Heatpack(3002)).setUnlocalizedName("heatpack").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Strings.MOD_ID + ":Temperature/heatpack");
		queenSpiderEye = (new Item(3003)).setUnlocalizedName("greenSpiderEye").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Strings.MOD_ID + ":Ore Spiders/queen_spider_eye");
		queenSpiderPotion = (ItemPotion) (new OS_ItemQueenPotion(3004)).setUnlocalizedName("queenSpiderPotion").setCreativeTab(CreativeTabs.tabBrewing);
		invertWASDPotion = new MCUB_Potion(27, true, 0x354f30).setIconIndex(2, 2).setPotionName("invert_wasd");
		
		GameRegistry.registerItem(diamondNugget, "Diamond_Nugget");
		GameRegistry.registerItem(heatpack, "Heatpack");
		GameRegistry.registerItem(queenSpiderEye, "Queen_Spider_Eye");
		GameRegistry.registerItem(queenSpiderPotion, "Queen_Spider_Potion");

		LanguageRegistry.addName(diamondNugget, "Diamond Nugget");
		LanguageRegistry.addName(heatpack, "Heatpack");
		LanguageRegistry.addName(queenSpiderEye, "Queen Spider Eye");
		LanguageRegistry.addName(queenSpiderPotion, "Queen Spider Potion");
	}
}
