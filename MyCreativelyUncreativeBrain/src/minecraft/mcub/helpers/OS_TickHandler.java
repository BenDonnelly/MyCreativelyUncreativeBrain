package mcub.helpers;

import java.util.EnumSet;

import mcub.item.MCUB_Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class OS_TickHandler implements ITickHandler
{

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		//testPotion((EntityPlayer) tickData[0]);
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{}

	public void testPotion(EntityPlayer player)
	{
		player.addPotionEffect(new PotionEffect(MCUB_Item.invertWASDPotion.id, 100, 0 ));
	}
	
	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel()
	{
		return "Ore Spiders Tick Handler";
	}

}
