package uk.pokemc.runtime;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.pokemc.items.ItemBase;

public class PokemcItems {

	public static final Item POKEBALL = register(new ItemBase("pokeball", false).setCreativeTab(CreativeTabs.TOOLS));
	public static final Item POKEDEX = register(new ItemBase("pokedex", false).setCreativeTab(CreativeTabs.TOOLS));
	public static final ItemBase PIKACHU = register(new ItemBase("pikachu", false).setCreativeTab(CreativeTabs.TOOLS));

	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);

		if (item instanceof ItemBase) {
			((ItemBase) item).registerItemModel(((ItemBase) item).getEntity());
		}

		return item;
	}
}
