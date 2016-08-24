package uk.pokemc.server;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.pokemon.EntityPikachu;

/**
 * Handles server-side events
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
		if (e.getEntity() instanceof EntityPlayer){
//			EntityRabbit newCow = new EntityRabbit(e.getEntity().getEntityWorld());
			BlockPos pos = e.getEntity().getPosition();
//			newCow.setPosition(pos.getX(), pos.getY() + 1, pos.getZ() + 1);
//			e.getEntity().getEntityWorld().spawnEntityInWorld(newCow);
//			newCow.playLivingSound();
			
			EntityPikachu newPika = new EntityPikachu(e.getEntity().getEntityWorld());
			System.out.println("Pika is a id " + newPika.getEntityId() + " and uuid " + newPika.getUniqueID());
			pos = e.getEntity().getPosition();
			newPika.setPosition(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 4);
			e.getEntity().getEntityWorld().spawnEntityInWorld(newPika);
			newPika.playLivingSound();
		}
	}
}
