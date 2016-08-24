package uk.pokemc.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
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
		
//		if (e.getEntity() instanceof EntityPlayer){
//			EntityPikachu newPika = new EntityPikachu(e.getEntity().getEntityWorld());
//			BlockPos pos = e.getEntity().getPosition();
//			ForgeEventFactory.doSpecialSpawn(newPika, e.getEntity().getEntityWorld(), pos.getX(), pos.getY() + 1, pos.getZ() + 2);
//			e.getEntity().getEntityWorld().spawnEntityInWorld(newPika);
//			newPika.playLivingSound();
//		}
	}
}
