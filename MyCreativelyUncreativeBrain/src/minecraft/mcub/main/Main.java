package mcub.main;

import mcub.entities.EntityRegister;
import mcub.helpers.ForgeEvents;
import mcub.item.MCUB_Item;
import mcub.lib.Strings;
import mcub.recipes.CraftingRecipes;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Strings.MOD_ID, name = Strings.MOD_NAME, version = Strings.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true)

public class Main
{
	@SidedProxy(clientSide = Strings.CLIENT_PROXY , serverSide = Strings.COMMON_PROXY)	
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.registerAll();
		MCUB_Item.initItems();
		CraftingRecipes.initRecipes();
		EntityRegister.registerEntities();
		MinecraftForge.EVENT_BUS.register(new ForgeEvents());
	}

	@EventHandler
	public void init(FMLInitializationEvent event){}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){}
	
}
