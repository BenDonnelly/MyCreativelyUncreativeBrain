package mcub.item;

import mcub.entities.OS_EntityQueenSpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OS_ItemQueenPotion extends ItemPotion
{

	public OS_ItemQueenPotion(int id)
	{
		super(id);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(! player.capabilities.isCreativeMode)
		{
			--itemStack.stackSize;
		}

		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if(! world.isRemote)
		{
			world.spawnEntityInWorld(new EntityPotion(world, player, itemStack));
			world.spawnEntityInWorld(new OS_EntityQueenSpider(world));
		}

		return itemStack;
	}

}
