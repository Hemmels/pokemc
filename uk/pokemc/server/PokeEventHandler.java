package uk.pokemc.server;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.pokemc.runtime.PokemcMessage;
import uk.pokemc.runtime.PokemcMod;

public class PokeEventHandler {
		
	@SubscribeEvent
	public void playerJump(LivingJumpEvent e){
		System.out.println("Server reckons player jumped");
		e.getEntity().addChatMessage(new TextComponentString("You jumped!"));
		PokemcMod.network.sendTo(new PokemcMessage("test text message"), (EntityPlayerMP) e.getEntity());
		PokemcMod.network.sendToAll(new PokemcMessage("Someone jumped omg omg!"));
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
    public void onPlayerPickupXP(PlayerPickupXpEvent e) {
		PokemcMod.network.sendTo(new PokemcMessage("Massive XP boost!!"), (EntityPlayerMP) e.getEntity());
        e.getOrb().xpValue *= 5;
    }
}
