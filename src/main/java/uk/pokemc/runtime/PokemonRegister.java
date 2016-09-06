package uk.pokemc.runtime;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import uk.pokemc.items.ItemBase;
import uk.pokemc.pokemon.entities.EntityPikachu;

public class PokemonRegister {

  public static final ItemBase POK_PIKACHU = new ItemBase("pikachu", true);

  private static final int ENTITY_TRACKING_RANGE = 80;
  private static final int ENTITY_UPDATE_FREQ = 3;
  private static final boolean ENTITY_SEND_VELO_UPDATES = true;

  // TODO: Are pokemon variations of this Pokemon entity?
  private static final int ENTITY_ID = 254;

  public static int modEntityID;

  /**
   * Simply "registers" what a pokemon entity is
   */
  public static void registerPokemon() {
    EntityRegistry.registerModEntity(EntityPikachu.class, "pikachu", ENTITY_ID, PokemcMod.INSTANCE,
        ENTITY_TRACKING_RANGE, ENTITY_UPDATE_FREQ, ENTITY_SEND_VELO_UPDATES);
    System.out.println(PokemcMod.MODID + ":pikachu" + " added under " + ENTITY_ID);
  }

}
