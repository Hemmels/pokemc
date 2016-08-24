package uk.pokemc.runtime;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import uk.pokemc.client.ClientEventListener;
import uk.pokemc.pokemon.EntityPikachu;
import uk.pokemc.pokemon.ModelPikachu;
import uk.pokemc.pokemon.RenderPikachu;
import uk.pokemc.recipes.PokemcCrafter;
import uk.pokemc.server.ServerEventListener;

@Mod(modid = PokemcMod.MODID, updateJSON = "https://github.com/Hemmels/pokemc", name = "pokemc", version=PokemcMod.MODVER)
public class PokemcMod {
	public static final String MODID  = "pokemc";
	public static final String MODNAME  = "Pokemon Go for Minecraft";
	public static final String MODVER = "0.0.1-alpha";
	
	@Instance
	public static PokemcMod instance = new PokemcMod();
    
	@SidedProxy(clientSide="uk.pokemc.client.ClientProxy", serverSide="uk.pokemc.server.ServerProxy")
	public static BasicProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.preInit(e);
		System.out.println(MODID + " (" + MODVER + ") is loading!");
		PokemcBlocks.init();
		PokemcCrafter.addRecipes();
		MinecraftForge.EVENT_BUS.register(new ClientEventListener());
		MinecraftForge.EVENT_BUS.register(new ServerEventListener());
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
