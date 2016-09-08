package uk.pokemc.runtime;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.pokemc.blocks.BlockBase;

public class PokemcBlocks {

	public static void init() {
		// pikachu = register(new BlockBase(Material.WOOD,
		// "pikachu").setCreativeTab(CreativeTabs.MATERIALS));
	}

	private static <T extends Block> T register(T block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		GameRegistry.register(itemBlock);

		if (block instanceof BlockBase) {
			((BlockBase) block).registerItemModel(itemBlock);
		}

		return block;
	}

	@SuppressWarnings("unused")
	@Deprecated
	/**
	 * Unused, might be later
	 * 
	 * @param block
	 * @return
	 */
	private static <T extends Block> T register(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return register(block, itemBlock);
	}
}
