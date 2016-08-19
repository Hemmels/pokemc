package uk.pokemc.server;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.runtime.PokemcMessage;
import uk.pokemc.runtime.PokemcMod;

public class ServerSide {
	
	PokeEventHandler pokeEventHandler;
	
	@SideOnly(Side.SERVER)
	public ServerSide(){
		System.out.println("serverside constructor!");
		FMLCommonHandler fch = FMLCommonHandler.instance();
		System.out.println("fch made!");
		PokemcMod.network.sendToAll(new PokemcMessage("Server loaded and spammed to all!"));
	}
	
	public void init(){
		pokeEventHandler = new PokeEventHandler();
	}
}
