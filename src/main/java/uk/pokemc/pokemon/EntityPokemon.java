package uk.pokemc.pokemon;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import uk.pokemc.runtime.PokemcItems;

public class EntityPokemon extends EntityAnimal {
	
	public static DamageSource INTERPOKEMON = new DamageSource("interPokemon");

	public EntityPokemon(World worldIn) {
		super(worldIn);
	}
	
	@Override
	// Pokemon can only be hurt by other pokemon
	public boolean isEntityInvulnerable(DamageSource source) {
		if (source == INTERPOKEMON){
			return true;
		}
		return false;
	}
	
	@Override
    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack)
    {
        if (stack != null && stack.getItem() == PokemcItems.POKEDEX && !player.capabilities.isCreativeMode)
        {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            // Because that should play when you add a poke-entry, definitely.

            // TODO: Add to pokedex
            if (--stack.stackSize == 0)
            {
                player.setHeldItem(hand, new ItemStack(PokemcItems.POKEDEX));
            }

            return true;
        }
        else
        {
            return super.processInteract(player, hand, stack);
        }
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
	
}
