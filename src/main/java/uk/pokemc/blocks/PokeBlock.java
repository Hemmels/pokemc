package uk.pokemc.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PokeBlock extends BlockBase{
	
	String name;

	public PokeBlock(String name) {
		super(Material.WOOD, name);
		
		setHardness(1f);
		setResistance(1f);
	}

	@Override
	public PokeBlock setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	

}
