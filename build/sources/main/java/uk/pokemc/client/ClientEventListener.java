package uk.pokemc.client;

import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientEventListener {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void playerJump(LivingJumpEvent e) {
		// System.out.println("Weeeee!");
	}
}
