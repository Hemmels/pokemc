package uk.pokemc.pokemon;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.EntityDataManager;

public abstract class PokemonHelper {

    protected final EntityPokemon pokemon;
    protected final EntityDataManager dataWatcher;
    protected final Random rand;

    public PokemonHelper(EntityPokemon pokemon) {
        this.pokemon = pokemon;
        this.dataWatcher = pokemon.getDataManager();
        this.rand = pokemon.getRNG();
    }
    
    public void writeToNBT(NBTTagCompound nbt) {}
    public void readFromNBT(NBTTagCompound nbt) {}
    public void applyEntityAttributes() {}
    public void onLivingUpdate() {}
    public void onDeathUpdate() {}
    public void onDeath() {}
}
