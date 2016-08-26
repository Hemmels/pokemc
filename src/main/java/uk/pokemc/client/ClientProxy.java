package uk.pokemc.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.pokemon.RenderPikachu;
import uk.pokemc.pokemon.entities.EntityPikachu;
import uk.pokemc.runtime.BasicProxy;
import uk.pokemc.runtime.PokemcMod;

@SideOnly(Side.CLIENT)
public class ClientProxy extends BasicProxy{

	@Override
	public void preInit(FMLPreInitializationEvent e) {
        RenderingRegistry.registerEntityRenderingHandler(
                EntityPikachu.class, RenderPikachu::new);
		int[] normalBiomes = new int[]{1, 3, 4, 5, 10, 23, 128};
		Biome[] normalSpawnList = new Biome[normalBiomes.length];
		for (int i = 0; i < normalBiomes.length; i++){
			normalSpawnList[i] = Biome.getBiome(i);
		}
        ModelResourceLocation pikachuModelLoc = new ModelResourceLocation(PokemcMod.MODID + "entities/pikachu");
        Item pickachuModel = Item.REGISTRY.getObject(pikachuModelLoc);
        //ModelLoader.setCustomModelResourceLocation(pickachuModel, 0, pikachuModelLoc);
		
	}

	@Override
	public void init(FMLInitializationEvent e) {
		new ClientEventListener();
        RenderManager renderer = Minecraft.getMinecraft().getRenderManager();
		renderer.entityRenderMap.put(EntityPikachu.class, new RenderCow(renderer, new ModelCow(), 0.5F));
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(PokemcMod.MODID + ":" + id, "inventory"));
	}
}
