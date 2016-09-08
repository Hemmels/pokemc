package uk.pokemc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import uk.pokemc.runtime.PokemcMod;

public class BlockBase extends Block {

	protected String name;

	/**
	 * Used to create a BLock, with a registered name and renderer.
	 * 
	 * @param material
	 * @param name
	 */
	public BlockBase(Material material, String name) {
		super(material);

		this.name = name;

		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public void registerItemModel(ItemBlock itemBlock) {
		PokemcMod.proxy.registerItemRenderer(itemBlock, 0, name);
	}

	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}
