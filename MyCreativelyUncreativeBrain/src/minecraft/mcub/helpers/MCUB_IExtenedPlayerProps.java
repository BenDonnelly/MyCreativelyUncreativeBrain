package mcub.helpers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class MCUB_IExtenedPlayerProps implements IExtendedEntityProperties
{

	public final static String EXT_PROP_NAME = "PlayerProps";
	private final EntityPlayer player;
	private final TemperatureHandler tempHelper;
	
	public MCUB_IExtenedPlayerProps(EntityPlayer thePlayer)
	{
		player = thePlayer;
		tempHelper = new TemperatureHandler();
	}

	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(MCUB_IExtenedPlayerProps.EXT_PROP_NAME, new MCUB_IExtenedPlayerProps(player));
	}

	public static final MCUB_IExtenedPlayerProps get(EntityPlayer player)
	{
		return (MCUB_IExtenedPlayerProps) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();
		
		properties.setInteger("CURRENT_TEMP", tempHelper.currentTemp);
		compound.setTag(EXT_PROP_NAME, properties);
		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		tempHelper.currentTemp = properties.getInteger("CURRENT_TEMP");
		System.out.println("[MCUB] Temp from NBT: " + tempHelper.currentTemp + "/" + tempHelper.maxTemp);

	}

	@Override
	public void init(Entity entity, World world)
	{

	}

}
