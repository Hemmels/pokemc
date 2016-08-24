package uk.pokemc.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.pokemon.EntityPikachu;
import uk.pokemc.pokemon.ModelPikachu;
import uk.pokemc.pokemon.RenderPikachu;
import uk.pokemc.runtime.BasicProxy;
import uk.pokemc.runtime.PokemcMod;

@SideOnly(Side.CLIENT)
public class ClientProxy extends BasicProxy{

	@Override
	public void preInit(FMLPreInitializationEvent e) {
	}

	@Override
	public void init(FMLInitializationEvent e) {
		new ClientEventListener();
		RenderManager renderer = Minecraft.getMinecraft().getRenderManager();
		renderer.entityRenderMap.put(EntityPikachu.class, new RenderPikachu(renderer, new ModelPikachu(0.7F), 0.7F));
        EntityList.addMapping(EntityPikachu.class, "Pikachu", 255);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(PokemcMod.MODID + ":" + id, "inventory"));
	}
}
