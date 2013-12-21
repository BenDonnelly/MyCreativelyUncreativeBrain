package mcub.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class MCUB_Potion extends Potion
{

	protected MCUB_Potion(int id, boolean par2, int colour)
	{
		super(id, par2, colour);
	}

	@Override
	public void performEffect(EntityLivingBase livingBase, int par2)
	{
		if(this.id == MCUB_Item.invertWASDPotion.id)
		{
			Minecraft.getMinecraft().gameSettings.keyBindForward = Minecraft.getMinecraft().gameSettings.keyBindBack;
		}
	}

}
