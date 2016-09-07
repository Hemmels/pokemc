package uk.pokemc.runtime;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import uk.pokemc.items.ItemBase;
import uk.pokemc.pokemon.entities.EntityBulbasaur;
import uk.pokemc.pokemon.entities.EntityPikachu;

public class PokemonRegister {

  public static final ItemBase POK_PIKACHU = new ItemBase("pikachu", true);
  public static final ItemBase POK_BULBASAUR = new ItemBase("bulbasaur", true);

  private static final int ENTITY_TRACKING_RANGE = 80;
  private static final int ENTITY_UPDATE_FREQ = 3;
  private static final boolean ENTITY_SEND_VELO_UPDATES = true;

  public static int modEntityID;

  /**
   * Simply "registers" what a pokemon entity is
   */
  public static void registerPokemon() {
    EntityRegistry.registerModEntity(EntityPikachu.class, "pikachu", EntityPikachu.POKEID, PokemcMod.INSTANCE,
        ENTITY_TRACKING_RANGE, ENTITY_UPDATE_FREQ, ENTITY_SEND_VELO_UPDATES);
    EntityRegistry.registerModEntity(EntityBulbasaur.class, "bulbasaur", EntityBulbasaur.POKEID, PokemcMod.INSTANCE,
        ENTITY_TRACKING_RANGE, ENTITY_UPDATE_FREQ, ENTITY_SEND_VELO_UPDATES);
  }

}
