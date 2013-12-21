package mcub.helpers;

import java.util.Random;

import mcub.entities.OS_EntityCoalSpider;
import mcub.entities.OS_EntityDiamondSpider;
import mcub.entities.OS_EntityEmeraldSpider;
import mcub.entities.OS_EntityQueenSpider;
import mcub.lib.Strings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.SpecialSpawn;

public class ForgeEvents
{
	public static final ForgeEvents INSTANCE = new ForgeEvents();
	private Random rand;
	private World world;
	private EntityLivingBase queenSpider;
	private int queenSpiderHealth;
	private int randNum_1;

	public ForgeEvents()
	{
		rand = new Random();
	}

	@ForgeSubscribe
	public void renderGameOverlay(RenderGameOverlayEvent.Post event)
	{
		renderTemperatureBar();
	}

	public static void renderTemperatureBar()
	{
		Minecraft mc = Minecraft.getMinecraft();

		mc.getTextureManager().bindTexture(new ResourceLocation(Strings.MOD_ID, "textures/Temperature/gui/temperature_bar.png"));
		GuiIngame gui = mc.ingameGUI;
		gui.drawTexturedModalRect(5, 5, 0, 6, 80, 6);
		gui.drawTexturedModalRect(5, 5, 0, 0, TemperatureHandler.getTemp() * 80 / TemperatureHandler.maxTemp, 6);
		mc.getTextureManager().bindTexture(Gui.icons);

	}

	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event)
	{
		if(event.entity instanceof EntityPlayer && MCUB_IExtenedPlayerProps.get((EntityPlayer) event.entity) == null)
		{
			MCUB_IExtenedPlayerProps.register((EntityPlayer) event.entity);
		}

		if(event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(MCUB_IExtenedPlayerProps.EXT_PROP_NAME) == null)
		{
			event.entity.registerExtendedProperties(MCUB_IExtenedPlayerProps.EXT_PROP_NAME, new MCUB_IExtenedPlayerProps((EntityPlayer) event.entity));
		}
	}

	@ForgeSubscribe
	public void queenSpiderHealthHandling(LivingHurtEvent event)
	{
		queenSpider = event.entityLiving;
		world = queenSpider.worldObj;
	
		double x, y, z;
		x = queenSpider.posX;
		y = queenSpider.posY;
		z = queenSpider.posZ;
		
		if(event.entityLiving instanceof OS_EntityQueenSpider)
		{
			randNum_1 = rand.nextInt(2);
			//Gets the health of the entityliving, rounds it, then converts to int. 
			queenSpiderHealth = (int) (Math.round(queenSpider.getHealth()));
			//Array of EntityLivingbase, randomSpider takes a random index of that array
			EntityLivingBase mobArr[] = {new OS_EntityCoalSpider(world) , new OS_EntityDiamondSpider(world) , new OS_EntityEmeraldSpider(world)};
			EntityLivingBase randomSpider = mobArr[rand.nextInt(mobArr.length)];

			if(queenSpiderHealth < 80 && randNum_1 == 1 || queenSpiderHealth < 5)
			{
				randomSpider.setPosition(x, y, z);
				randomSpider.worldObj.spawnEntityInWorld(randomSpider);
				for(int i = 0; i < 10; ++i)
				{
					double d0 = this.rand.nextGaussian() * 0.02D;
					double d1 = this.rand.nextGaussian() * 0.02D;
					double d2 = this.rand.nextGaussian() * 0.02D;
				    Minecraft.getMinecraft().theWorld.spawnParticle("flame", x + (double) (this.rand.nextFloat() * queenSpider.width * 2.0F) - (double) queenSpider.width, y + 0.5D + (double) (this.rand.nextFloat() * queenSpider.height), z + (double) (this.rand.nextFloat() * queenSpider.width * 2.0F) - (double) queenSpider.width, d0, d1, d2);
				    Minecraft.getMinecraft().theWorld.spawnParticle("smoke", x + (double) (this.rand.nextFloat() * queenSpider.width * 2.0F) - (double) queenSpider.width, y + 0.5D + (double) (this.rand.nextFloat() * queenSpider.height), z + (double) (this.rand.nextFloat() * queenSpider.width * 2.0F) - (double) queenSpider.width, d0, d1, d2);
				}

			}
		}

	}

}
