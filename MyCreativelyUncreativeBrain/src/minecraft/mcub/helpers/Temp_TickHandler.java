package mcub.helpers;

import java.util.EnumSet;

import mcub.lib.Debug;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class Temp_TickHandler implements ITickHandler
{

	public static int tick;
	private TemperatureHandler tempHelper;
	private int startTime;

	public Temp_TickHandler()
	{
		tempHelper = new TemperatureHandler();
		startTime = 0;
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		//countTick();
	    //changeTemperature();
		//TemperatureHandler.tempTimer(0, 100, TemperatureHandler.currentTemp += 5);
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	public void countTick()
	{
		tick++;
		if(tick == 1) tick = 0;
	}
	
	public void changeTemperature()
	{	
		Debug.out("Temperature:" + tempHelper.getTemp());
	}
	
	/*public void decreaseTemperature(EntityPlayer player)
	{
		startTime++;
		if(player.isInsideOfMaterial(Material.water) && startTime ==  ) 
		if(startTime == 450) //450 = 45 secs. 300 ticks = 30 secs, 150 ticks = 15 secs 
			tempHelper.alterTemperature(- 1);
			startTime = 0;
		
	}
*/
	@Override
	public String getLabel()
	{
		return "Temperature Tick Handler Server";
	}

}
