package uk.pokemc.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.pokemon.entities.EntityBulbasaur;
import uk.pokemc.pokemon.entities.EntityPikachu;
import uk.pokemc.pokemon.entities.EntitySquirtle;

/**
 * Handles server-side events
 * 
 * @author grigsbm
 *
 */
public class ServerEventListener {

	@SideOnly(Side.SERVER)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onPlayerPickupXP(PlayerPickupXpEvent e) {
		e.getOrb().xpValue *= 5;
	}

	@SideOnly(Side.SERVER)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onPlayerJumpEvent(LivingJumpEvent e) {
		EntityBulbasaur newBulba;
		EntityPikachu newPika;
		EntitySquirtle newSq;
		if (e.getEntity() instanceof EntityPlayer) {
			BlockPos pos = e.getEntity().getPosition();

			newPika = new EntityPikachu(e.getEntity().getEntityWorld());
			newPika.setPosition(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 4);
			e.getEntity().getEntityWorld().spawnEntityInWorld(newPika);
			newPika.playLivingSound();

			newBulba = new EntityBulbasaur(e.getEntity().getEntityWorld());
			newBulba.setPosition(pos.getX() + 1, pos.getY() + 1, pos.getZ() - 2);
			e.getEntity().getEntityWorld().spawnEntityInWorld(newBulba);
			newBulba.playLivingSound();

			newSq = new EntitySquirtle(e.getEntity().getEntityWorld());
			newSq.setPosition(pos.getX() - 4, pos.getY() + 1, pos.getZ() - 2);
			e.getEntity().getEntityWorld().spawnEntityInWorld(newSq);
			newSq.playLivingSound();
		}
	}
}
