package uk.pokemc.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import uk.pokemc.runtime.PokemcItems;

public class PokemcCrafter{
	
	private static CraftingManager craftingManager = CraftingManager.getInstance();

	public static void addRecipes(){
		craftingManager.addRecipe(new ItemStack(PokemcItems.POKEDEX, 1), new Object[] {"XX", "X#", '#', Items.BOOK, 'X', Items.REDSTONE});
		System.out.println("Try to make a pokedex!");
	}

}
