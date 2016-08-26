package uk.pokemc.runtime;

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
import uk.pokemc.pokemon.ModelPikachu;
import uk.pokemc.pokemon.RenderPikachu;
import uk.pokemc.pokemon.entities.EntityPikachu;

public class PokemonRegister {

    
    private static final int ENTITY_TRACKING_RANGE = 80;
    private static final int ENTITY_UPDATE_FREQ = 3;
    private static final int ENTITY_ID = 0;
    private static final boolean ENTITY_SEND_VELO_UPDATES = true;
    
	public static int modEntityID;

	public static void registerPokemon(){
		EntityRegistry.registerModEntity(EntityPikachu.class, "pikachu", ENTITY_ID, 
				PokemcMod.INSTANCE, ENTITY_TRACKING_RANGE, ENTITY_UPDATE_FREQ, ENTITY_SEND_VELO_UPDATES);
		//EntityList.addMapping(EntityPikachu.class, "Pikachu", 254);
//		EntityRegistry.addSpawn(EntityPikachu.class, 6, 1, 5, EnumCreatureType.CREATURE, 
//				normalSpawnList);
	}
}
