package mcub.item;

import mcub.helpers.TemperatureHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Temp_Heatpack extends Item
{

	public Temp_Heatpack(int par1)
	{
		super(par1);
		this.maxStackSize = 16;
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(! world.isRemote && TemperatureHandler.getTemp() != 100)
		{

			if(TemperatureHandler.getTemp() <= 85)
			{
				TemperatureHandler.alterTemperature(+15);
			}
			else
			{
				TemperatureHandler.currentTemp  = TemperatureHandler.maxTemp;
			}
			if(! player.capabilities.isCreativeMode)
			{
				stack.stackSize--;
			}
		}

		return stack;
	}
}
