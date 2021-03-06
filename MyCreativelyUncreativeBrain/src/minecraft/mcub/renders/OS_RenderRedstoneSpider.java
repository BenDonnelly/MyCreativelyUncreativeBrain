package mcub.renders;

import mcub.entities.OS_EntityRedstoneSpider;
import mcub.lib.Strings;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class OS_RenderRedstoneSpider extends RenderSpider
{
 
   private static final ResourceLocation redstoneSpider = new ResourceLocation(Strings.MOD_ID, "textures/mobs/Ore Spiders/Redstone Spider/redstone_spider.png");
   private static final ResourceLocation redstoneSpiderEyes = new ResourceLocation(Strings.MOD_ID, "textures/mobs/Ore Spiders/Redstone Spider/redstone_spider_eyes.png");

	public OS_RenderRedstoneSpider()
	{
		super();
	}


	 /**
     * Sets the spider's glowing eyes
     */
	protected int setOreSpiderEyes(OS_EntityRedstoneSpider oreSpider, int par2, float par3)
    {
		if (par2 != 0)
		{
            return -1;
        }
        else
        {
            this.bindTexture(redstoneSpiderEyes);
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

            if (oreSpider.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }
	
    /**
     * Queries whether should render the specified pass or not.
     */
	@Override
    protected int shouldRenderPass(EntityLivingBase livingBase, int par2, float par3)
    {
        return this.setOreSpiderEyes((OS_EntityRedstoneSpider)livingBase, par2, par3);
    }
	
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
	@Override
	protected ResourceLocation getEntityTexture(Entity ent)
    {
        return redstoneSpider;
    }
}

