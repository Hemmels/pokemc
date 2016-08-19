package uk.pokemc.runtime;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public final class PokeMessageHandler implements IMessageHandler<PokemcMessage, IMessage> {
	
    @Override
    public IMessage onMessage(final PokemcMessage message, final MessageContext ctx) {
    	System.out.println("PMH got message");
    	// This is the player the packet was sent to the server from
        EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
        // The value that was sent
//        int amount = message.getSendInt();
        serverPlayer.addChatMessage(new TextComponentString("faceplant"));
        // No response packet
        return null;
    }
}
