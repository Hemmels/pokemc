package uk.pokemc.pokemon;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import uk.pokemc.pokeom.interact.PokemonInteractExperience;
import uk.pokemc.pokeom.interact.PokemonInteraction;

public class PokemonInteractHelper extends PokemonHelper {
    
    private final List<PokemonInteraction> actions = new ArrayList<>();
    
    public PokemonInteractHelper(EntityPokemon pokemon) {
        super(pokemon);
        
        actions.add(new PokemonInteractExperience(pokemon));
    }
    
    public boolean interact(EntityPlayer player, ItemStack item) {
        return actions.stream().anyMatch(action -> action.interact(player, item));
    }
    
}
