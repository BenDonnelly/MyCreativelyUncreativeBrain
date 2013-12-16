package mcub.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class OS_EntityNetherQuartzSpider extends EntitySpider
{
	
	public OS_EntityNetherQuartzSpider(World world) 
	{
		super(world);
		this.isImmuneToFire = true;
	}
	

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.800000011920929D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(32.0D);
	}
	
	/**
    * Returns the item ID for the item the mob drops on death.
    */	
	@Override
    protected int getDropItemId()
    {
    	return this.isBurning() ? 0 :  Item.silk.itemID;
    }
	
	/**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
	@Override
	protected void dropFewItems(boolean hitByPlayer, int lootEnchantLevel)
	{
		super.dropFewItems(hitByPlayer, lootEnchantLevel);
		int ranNum, amountToDrop, amountToDropWithLootEnchant;
		ranNum = this.rand.nextInt(2);
		amountToDrop = this.rand.nextInt(3 + 1);
		amountToDropWithLootEnchant = (lootEnchantLevel + 1) * amountToDrop;
		
		if(! (this.isBurning()))
		{
			if(amountToDrop != 0)
			{
				if(lootEnchantLevel == 0)
				{
					if(ranNum == 1)
					{
						this.dropItem(Item.netherQuartz.itemID, amountToDrop);
					}
					this.dropItem(Item.spiderEye.itemID, 1);
				}
				else
				{
					this.dropItem(Item.netherQuartz.itemID, amountToDropWithLootEnchant);
					this.dropItem(Item.spiderEye.itemID, amountToDropWithLootEnchant);
				}
			}
		}
	}

	
	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	@Override
	public boolean attackEntityAsMob(Entity ent)
    {
		if (super.attackEntityAsMob(ent))
        {
			if(ent instanceof EntityLivingBase)
			{
				((EntityLivingBase) ent).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
			}
			return true;
        }
		else
		{
			return false;
		}
    }
	
}
