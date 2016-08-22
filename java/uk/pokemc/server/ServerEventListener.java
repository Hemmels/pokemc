package uk.pokemc.server;

import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
}
