import org.junit.Test;

import uk.pokemc.pokemon.entities.ModelPokemon;

public class ModelPokemonTest {

  @Test
  public void testCreateModelFromJSON() {
    System.out.println(ModelPokemon.createModelFromJson("pikachu").size());
  }

}
