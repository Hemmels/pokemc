package uk.pokemc.runtime;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import uk.pokemc.pokemon.bulbasaur.EntityBulbasaur;
import uk.pokemc.pokemon.charmander.EntityCharmander;
import uk.pokemc.pokemon.entities.EntitySquirtle;
import uk.pokemc.pokemon.pikachu.EntityPikachu;

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
	public final static ResourceLocation LOOT_TABLE = new ResourceLocation(PokemcMod.MODID, "loot_tables/pokemon");

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
		LootTableList.register(LOOT_TABLE);
	}

	public static ResourceLocation getLootTable() {
		return LOOT_TABLE;
	}

}
