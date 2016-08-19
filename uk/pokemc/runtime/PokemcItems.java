package uk.pokemc.runtime;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.pokemc.items.ItemBase;

public class PokemcItems {
	
	public static ItemBase pikachu;
	
	public static void init() {
		pikachu = register(new ItemBase("pikachu").setCreativeTab(CreativeTabs.TOOLS));
	}

	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);

		if (item instanceof ItemBase) {
			((ItemBase)item).registerItemModel();
		}

		return item;
	}
}