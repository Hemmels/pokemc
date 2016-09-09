package uk.pokemc.runtime;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import uk.pokemc.pokemon.charmander.EntityCharmander;
import uk.pokemc.pokemon.entities.EntityBulbasaur;
import uk.pokemc.pokemon.entities.EntityPikachu;
import uk.pokemc.pokemon.entities.EntitySquirtle;

/**
 * Used by server and client to understand what our PokemonEntities will be,
 * i.e. how we use their POKEIDs to match their classes. (And some other stuff we dont care about)
 * @author Matt
 *
 */
public class PokemonRegister {

	private static final int ENTITY_TRACKING_RANGE = 80;
	private static final int ENTITY_UPDATE_FREQ = 3;
	private static final boolean ENTITY_SEND_VELO_UPDATES = true;

	public static int modEntityID;

	/**
	 * Simply "registers" what a pokemon entity is
	 */
	public static void registerPokemon() {
		EntityRegistry.registerModEntity(EntityPikachu.class, "pikachu", EntityPikachu.POKEID, PokemcMod.INSTANCE, ENTITY_TRACKING_RANGE,
				ENTITY_UPDATE_FREQ, ENTITY_SEND_VELO_UPDATES);
		EntityRegistry.registerModEntity(EntityBulbasaur.class, "bulbasaur", EntityBulbasaur.POKEID, PokemcMod.INSTANCE, ENTITY_TRACKING_RANGE,
				ENTITY_UPDATE_FREQ, ENTITY_SEND_VELO_UPDATES);
		EntityRegistry.registerModEntity(EntitySquirtle.class, "squirtle", EntitySquirtle.POKEID, PokemcMod.INSTANCE, ENTITY_TRACKING_RANGE,
				ENTITY_UPDATE_FREQ, ENTITY_SEND_VELO_UPDATES);
		EntityRegistry.registerModEntity(EntityCharmander.class, "charmander", EntityCharmander.POKEID, PokemcMod.INSTANCE, ENTITY_TRACKING_RANGE,
				ENTITY_UPDATE_FREQ, ENTITY_SEND_VELO_UPDATES);
	}

}
