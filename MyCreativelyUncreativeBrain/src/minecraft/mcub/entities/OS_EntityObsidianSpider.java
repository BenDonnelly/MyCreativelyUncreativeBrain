package mcub.entities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class OS_EntityObsidianSpider extends EntitySpider
{
	
	public OS_EntityObsidianSpider(World world) 
	{
		super(world);
		this.isImmuneToFire = true;
	}

	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(60.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.600000011920929D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(22.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(1.0);
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */	
	@Override
	protected int getDropItemId()
	{
		return Item.silk.itemID;
	}
		
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
	 * lootEnchantLevel - Level of Looting used to kill this mob.
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
						this.dropItem(Block.obsidian.blockID, amountToDrop);
					}
					this.dropItem(Item.spiderEye.itemID, 1);
				}
				else
				{
					this.dropItem(Block.obsidian.blockID, amountToDropWithLootEnchant);
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
				((EntityLivingBase) ent).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 0));
			}
			return true;
        }
		else
		{
			return false;
		}
    }		

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
	@Override
    public boolean getCanSpawnHere()
    {

        for(int x = 0; x < 16; x++)
        {
                for(int y = 0; y < 8; y++)
                {
                        for(int z = 0; z < 16; z++)
                        {
                                int x1 = MathHelper.floor_double(this.posX + x - 8);
                                int y1 = MathHelper.floor_double(this.posY + y - 4);
                                int z1 = MathHelper.floor_double(this.posZ + z - 8);

                                if(this.worldObj.getBlockId(x1, y1, z1) == Block.obsidian.blockID && super.getCanSpawnHere())
                                {
                                		System.out.println("Spawning Obsidian Spider:" + "X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
                                        return true;
                                }
                        }
                }
        }
		return false;
    }
	
}
