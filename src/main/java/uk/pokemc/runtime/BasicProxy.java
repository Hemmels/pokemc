package uk.pokemc.runtime;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class BasicProxy {

	public abstract void preInit(FMLPreInitializationEvent e);

	public void init(FMLInitializationEvent e){
		PokemonRegister.registerPokemon();
	}

	public abstract void postInit(FMLPostInitializationEvent e);
	
	public abstract void registerItemRenderer(Item item, int meta, String id);
}
