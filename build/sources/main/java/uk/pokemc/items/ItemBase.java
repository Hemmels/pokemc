package uk.pokemc.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import uk.pokemc.runtime.PokemcMod;

public class ItemBase extends Item {

	// Must be the name of the <model>.json
	protected String name;
	protected boolean entity;

	public ItemBase(String name, boolean entity) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setEntity(entity);
	}

	private void setEntity(boolean entity) {
		this.entity = entity;
	}

	public boolean getEntity() {
		return entity;
	}

	public void registerItemModel(boolean entityRender) {
		PokemcMod.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}
