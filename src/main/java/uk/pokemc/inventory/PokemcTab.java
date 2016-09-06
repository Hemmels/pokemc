package uk.pokemc.inventory;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.runtime.PokemcItems;
import uk.pokemc.runtime.PokemcMod;

public class PokemcTab extends CreativeTabs {

  public static final CreativeTabs POKEMON = new PokemcTab();

  private PokemcTab() {
    super(PokemcMod.MODID);
  }

  public static CreativeTabs getInstance() {
    return POKEMON;
  }

  @Override
  @SideOnly(Side.CLIENT)
  public Item getTabIconItem() {
    return PokemcItems.PIKACHU;
  }

}
