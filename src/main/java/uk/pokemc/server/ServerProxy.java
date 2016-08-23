package uk.pokemc.server;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.runtime.BasicProxy;

@SideOnly(Side.SERVER)
public class ServerProxy extends BasicProxy{
	
	public ServerProxy(){
		System.out.println("serverproxy constructed!");
	}

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		
	}

	@Override
	public void init(FMLInitializationEvent e) {
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		
	}

}
