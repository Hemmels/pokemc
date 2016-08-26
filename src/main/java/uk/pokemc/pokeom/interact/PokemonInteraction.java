package uk.pokemc.pokeom.interact;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import uk.pokemc.pokemon.EntityPokemon;

public abstract class PokemonInteraction {
    
    protected final EntityPokemon pokemon;
    
    public PokemonInteraction(EntityPokemon pokemon) {
        this.pokemon = pokemon;
    }
    
    public abstract boolean interact(EntityPlayer player, ItemStack item);
}
