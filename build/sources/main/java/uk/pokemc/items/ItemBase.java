package uk.pokemc.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import uk.pokemc.runtime.PokemcMod;

public class ItemBase extends Item {

	// Must be the name of the <model>.json
	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public void registerItemModel() {
		PokemcMod.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}

