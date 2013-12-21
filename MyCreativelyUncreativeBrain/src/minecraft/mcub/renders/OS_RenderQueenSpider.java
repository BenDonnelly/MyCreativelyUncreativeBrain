package mcub.renders;

import mcub.entities.OS_EntityQueenSpider;
import mcub.lib.Strings;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class OS_RenderQueenSpider extends RenderSpider
{
 
   private static final ResourceLocation queenSpider = new ResourceLocation(Strings.MOD_ID, "textures/mobs/Ore Spiders/Queen Spider/queen_spider.png");
   private static final ResourceLocation queenSpiderEyes = new ResourceLocation(Strings.MOD_ID, "textures/mobs/Ore Spiders/Queen Spider/queen_spider_eyes.png");

	public OS_RenderQueenSpider()
	{
		super();
	}


	 /**
     * Sets the spider's glowing eyes
     */
	protected int setOreSpiderEyes(OS_EntityQueenSpider oreSpider, int par2, float par3)
    {
		if (par2 != 0)
		{
            return -1;
        }
        else
        {
            this.bindTexture(queenSpiderEyes);
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

	private void scaleQueenSpider(OS_EntityQueenSpider queenSpider, float par2)
    {
        GL11.glScalef(1.7F, 1.7F, 1.7F);
    }
	
    public void renderBossBar(OS_EntityQueenSpider queenSpider, double par2, double par4, double par6, float par8, float par9)
    {
        BossStatus.setBossStatus(queenSpider, true);
        super.doRenderLiving(queenSpider, par2, par4, par6, par8, par9);
    }
	
	@Override
    public void renderPlayer(EntityLivingBase livingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBossBar((OS_EntityQueenSpider)livingBase, par2, par4, par6, par8, par9);
    }
    
    /**
     * Queries whether should render the specified pass or not.
     */
	@Override
    protected int shouldRenderPass(EntityLivingBase livingBase, int par2, float par3)
    {
        return this.setOreSpiderEyes((OS_EntityQueenSpider)livingBase, par2, par3);
    }
	
	@Override
    public void doRenderLiving(EntityLiving entLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBossBar((OS_EntityQueenSpider)entLiving, par2, par4, par6, par8, par9);
    }

	@Override
    public void doRender(Entity ent, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBossBar((OS_EntityQueenSpider)ent, par2, par4, par6, par8, par9);
    }

	@Override
    protected void preRenderCallback(EntityLivingBase livingBase, float par2)
    {
        this.scaleQueenSpider((OS_EntityQueenSpider)livingBase, par2);
    }

	
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
	@Override
	protected ResourceLocation getEntityTexture(Entity ent)
    {
        return queenSpider;
    }
}

