package uk.pokemc.runtime;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class BasicProxy {

  // Both client and server need this information
  public abstract void preInit(FMLPreInitializationEvent e);

  public abstract void init(FMLInitializationEvent e);

  public abstract void postInit(FMLPostInitializationEvent e);

  public abstract void registerItemRenderer(Item item, int meta, String id);
}
