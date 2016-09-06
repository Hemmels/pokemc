package uk.pokemc.pokemon.entities;

public class PokemcModel {

  public static final ModelPokemon PIKACHU = createByName("pikachu");

  private static ModelPokemon createByName(String string) {
    return new ModelPokemon(ModelPokemon.PIKACHU);
  }

}
