package uk.pokemc.client;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientEventListener {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void playerJump(LivingJumpEvent e){
		System.out.println("Server reckons player jumped");
		e.getEntity().addChatMessage(new TextComponentString("You jumped!"));
	}
}
