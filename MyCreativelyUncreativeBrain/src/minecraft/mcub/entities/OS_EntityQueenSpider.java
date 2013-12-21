package mcub.entities;

import mcub.helpers.ForgeEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class OS_EntityQueenSpider extends EntitySpider implements IBossDisplayData
{

	private int healAtDifferentDifficulties;

	public OS_EntityQueenSpider(World world)
	{
		super(world);
		this.setSize(2.8F, 1.5F);
		this.isImmuneToFire = true;
		this.experienceValue = 100;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(1.99900011920929D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(9.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(1.0);
	}

	private void playHealthEffect()
	{

		for(int i = 0; i < 4; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("heart", this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1,
					d2);
		}
	}

	@Override
	public void onLivingUpdate()
	{
		switch(Minecraft.getMinecraft().gameSettings.difficulty)
		{
		case 1:
			healAtDifferentDifficulties = 20;
			break;
		case 2:
			healAtDifferentDifficulties = 40;
			break;
		case 3:
			healAtDifferentDifficulties = 60;
			break;
		}
		if(this.getHealth() < healAtDifferentDifficulties && this.ticksExisted % 20 == 0)
		{
			this.heal(2.0F);
			playHealthEffect();
		}
		super.onLivingUpdate();
	}

	@Override
	public void onDeath(DamageSource damageSource)
	{
		OS_EntityEnderSpider enderSpider = new OS_EntityEnderSpider(this.worldObj);
		enderSpider.setPosition(this.posX, this.posY, this.posZ);
		this.worldObj.spawnEntityInWorld(enderSpider);
	}
}
