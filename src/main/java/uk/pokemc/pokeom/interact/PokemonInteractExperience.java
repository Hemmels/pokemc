package uk.pokemc.pokeom.interact;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import uk.pokemc.pokemon.EntityPokemon;
import uk.pokemc.utils.ItemUtils;

public class PokemonInteractExperience extends PokemonInteraction{
	
	public PokemonInteractExperience(EntityPokemon pokemon) {
		super(pokemon);
	}
	
    @Override
    public boolean interact(EntityPlayer player, ItemStack item) {
//        if (pokemon.isServer() && pokemon.isTamedFor(player) &&
//                ItemUtils.hasEquipped(player, Items.BONE)) {
    		doExperienceUpOrSomething();
            return true;
        }

	private void doExperienceUpOrSomething() {
		
	}
}

