package mcub.main;

import mcub.helpers.TickHandler;
import mcub.entities.*;
import mcub.renders.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class ClientProxy extends CommonProxy
{
	
	@Override
	public void registerAll()
	{
		registerTickHandlers();
		registerRenderThings();
	}
	
	@Override
	public void registerTickHandlers()
	{
		TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
	}
	@Override
	public void registerRenderThings()
    {
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityCoalSpider.class, new OS_RenderCoalSpider());
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityDiamondSpider.class, new OS_RenderDiamondSpider());
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityObsidianSpider.class, new OS_RenderObsidianSpider());
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityEmeraldSpider.class, new OS_RenderEmeraldSpider());
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityIronSpider.class, new OS_RenderIronSpider());
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityEnderSpider.class, new OS_RenderEnderSpider());
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityGoldSpider.class, new OS_RenderGoldSpider());
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityNetherQuartzSpider.class, new OS_RenderNetherQuartzSpider());
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityLapisSpider.class, new OS_RenderLapisSpider());
		RenderingRegistry.registerEntityRenderingHandler(OS_EntityRedstoneSpider.class, new OS_RenderRedstoneSpider());
    }
	
}
