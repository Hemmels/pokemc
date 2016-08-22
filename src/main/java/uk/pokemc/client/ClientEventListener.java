package uk.pokemc.client;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.pokemon.EntityPikachu;

public class ClientEventListener {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void playerJump(LivingJumpEvent e){
		e.getEntity().addChatMessage(new TextComponentString("You spawned cows!"));
		
		BlockPos pos = e.getEntity().getPosition();
		EntityPikachu newPika = new EntityPikachu(e.getEntity().getEntityWorld());
		ForgeEventFactory.doSpecialSpawn(newPika, e.getEntity().getEntityWorld(), pos.getX(), pos.getY() + 1, pos.getZ() + 2);
		e.getEntity().getEntityWorld().spawnEntityInWorld(newPika);
		newPika.playLivingSound();
		
		EntityCow newCow = new EntityCow(e.getEntity().getEntityWorld());
		ForgeEventFactory.doSpecialSpawn(newCow, e.getEntity().getEntityWorld(), pos.getX(), pos.getY() + 1, pos.getZ() + 2);
		e.getEntity().getEntityWorld().spawnEntityInWorld(newCow);
		newCow.playLivingSound();
	}
}
