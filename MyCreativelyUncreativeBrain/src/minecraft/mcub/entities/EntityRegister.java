package mcub.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenEnd;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EntityRegister 
{
	static int startEntityId = 327;
	static int zombieBackGround = 0x00AFAF;
	static int zombieSpots = 0x5FA88E;
	static int whiteColour = 0xffffff;
	static int blackColour = 0x000000;
	static int grayColour = 0x424242;
	static int lightGrayColour = 0xEEEEEE;
	static int lightBlueColour = 0xAFF5FF;
	static int blueishIcyColour = 0x3EA6CF;
	static int kindaBlueColour = 0x337BC7;
	static int purpleBlueishColour = 0x6419F0;
	static int redishPinkishColour = 0xEB0E58;
	static int greenishColour = 0x99FF66;
	static int yellowishColour = 0xFFFF33;
	static int brownishColour = 0x63560A;
	static int purpleishColour = 0x6B13AD;
	static int grayishIronishColour = 0x949191;
	static int enderColour = 0xCA75EF;
	static int goldishColour = 0xF7DB5E;
	static int netherQuartzColour = 0xCACDDB;
	static int lapisishColour = 0x536CE0;
	static int redishColour = 0xDE2644;
	static int muckyGreenColour = 0x354f30;
	
	public static void registerEntities()
	{
		//COAL SPIDER
		EntityRegistry.registerGlobalEntityID(OS_EntityCoalSpider.class, "CoalSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityCoalSpider.class, blackColour, grayColour);
        EntityRegistry.addSpawn(OS_EntityCoalSpider.class, 5, 3, 4, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
        
        //DIAMOND SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityDiamondSpider.class, "DiamondSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityDiamondSpider.class, blackColour, lightBlueColour);
        EntityRegistry.addSpawn(OS_EntityDiamondSpider.class, 3, 2, 4, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
        
      	//OBSIDIAN SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityObsidianSpider.class, "ObsidianSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityObsidianSpider.class, blackColour, purpleishColour);
        EntityRegistry.addSpawn(OS_EntityObsidianSpider.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
        
        //EMERALD SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityEmeraldSpider.class, "EmeraldSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityEmeraldSpider.class, blackColour, greenishColour);
        EntityRegistry.addSpawn(OS_EntityEmeraldSpider.class, 5, 3, 4, EnumCreatureType.monster,BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge);
        
        //IRON SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityIronSpider.class, "IronSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityIronSpider.class, blackColour, grayishIronishColour);
        EntityRegistry.addSpawn(OS_EntityIronSpider.class, 6, 4, 5, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
        
        //ENDER SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityEnderSpider.class, "EnderSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityEnderSpider.class, blackColour, enderColour);
        EntityRegistry.addSpawn(OS_EntityEnderSpider.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenEnd.sky);
        
        //GOLD SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityGoldSpider.class, "GoldSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityGoldSpider.class, blackColour, goldishColour);
        EntityRegistry.addSpawn(OS_EntityGoldSpider.class, 7, 5, 6, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
        
        //NETHER QUARTZ SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityNetherQuartzSpider.class, "NetherQuartzSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityNetherQuartzSpider.class, blackColour, netherQuartzColour);
        EntityRegistry.addSpawn(OS_EntityNetherQuartzSpider.class, 10, 4, 4, EnumCreatureType.monster, BiomeGenEnd.hell);
        
        //LAPIS SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityLapisSpider.class, "LapisSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityLapisSpider.class, blackColour, lapisishColour);
        EntityRegistry.addSpawn(OS_EntityLapisSpider.class, 5, 3, 4, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
	
        //REDSTONE SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityRedstoneSpider.class, "RedstoneSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityRedstoneSpider.class, blackColour, redishColour);
        EntityRegistry.addSpawn(OS_EntityRedstoneSpider.class, 6, 4, 5, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
	
        //QUEEN SPIDER
        EntityRegistry.registerGlobalEntityID(OS_EntityQueenSpider.class, "QueenSpider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(OS_EntityQueenSpider.class, blackColour, muckyGreenColour);
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColour, int secondaryColour)
    {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColour, secondaryColour));

    }

	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		}
		while(EntityList.getStringFromID(startEntityId) != null);
		
		return startEntityId;
	}
	
}
