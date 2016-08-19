package uk.pokemc.runtime;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = PokemcMod.MODID, updateJSON = "https://github.com/Hemmels/pokemc", name = "pokemc", version=PokemcMod.MODVER)
public class PokemcMod {
	public static final String MODID  = "pokemc";
	public static final String MODNAME  = "Pokemon Go for Minecraft";
	public static final String MODVER = "0.0.1-alpha";

    public static SimpleNetworkWrapper network;
    
	@SidedProxy(clientSide="uk.pokemc.client.ClientProxy", serverSide="uk.pokemc.server.ServerProxy")
	public static BasicProxy proxy;
	
	@Instance(value = PokemcMod.MODID)
	public static PokemcMod instance;
	
	public PokemcMod(){
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.preInit(e);
		network = NetworkRegistry.INSTANCE.newSimpleChannel("pokemcChannel");
		network.registerMessage(PokeMessageHandler.class, PokemcMessage.class, 0, Side.SERVER);
		System.out.println(MODID + " (" + MODVER + ") is loading!");
		PokemcItems.init();
		PokemcBlocks.init();
	}
   
	@EventHandler
	public void init(FMLInitializationEvent e){
		proxy.init(e);
	}
   
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		proxy.postInit(e);
		System.out.println(MODID + " loaded! It's " + MODNAME);
	}
}
