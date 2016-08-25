package uk.pokemc.client;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.pokemon.EntityPikachu;
import uk.pokemc.pokemon.ModelPikachu;
import uk.pokemc.pokemon.RenderPikachu;
import uk.pokemc.runtime.PokemcMod;

@SideOnly(Side.CLIENT)
public class PokemonRegister {
	
	public static int modEntityID;

	public static void registerPokemon(){
		RenderManager renderer = Minecraft.getMinecraft().getRenderManager();
		renderer.entityRenderMap.put(EntityPikachu.class, new RenderPikachu(renderer, new ModelPikachu(0.5F), 0.5F));
		int[] normalBiomes = new int[]{1, 3, 4, 5, 10, 23, 128};
		Biome[] normalSpawnList = new Biome[normalBiomes.length];
		for (int i = 0; i < normalBiomes.length; i++){
			normalSpawnList[i] = Biome.getBiome(i);
		}
		EntityRegistry.registerModEntity(EntityPikachu.class, "pikachu", ++modEntityID, 
				PokemcMod.INSTANCE, 64, 201, true);
		//EntityList.addMapping(EntityPikachu.class, "Pikachu", 254);
//		EntityRegistry.addSpawn(EntityPikachu.class, 6, 1, 5, EnumCreatureType.CREATURE, 
//				normalSpawnList);
	}
}
