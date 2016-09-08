package uk.pokemc.pokeom.interact;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import uk.pokemc.pokemon.EntityPokemon;

public class PokemonInteractExperience extends PokemonInteraction {

	public PokemonInteractExperience(EntityPokemon pokemon) {
		super(pokemon);
	}

	@Override
	public boolean interact(EntityPlayer player, ItemStack item) {
		// if (pokemon.isServer() && pokemon.isTamedFor(player) &&
		// ItemUtils.hasEquipped(player, Items.BONE)) {
		doExperienceUpOrSomething();
		return false;
	}

	private void doExperienceUpOrSomething() {

	}
}
