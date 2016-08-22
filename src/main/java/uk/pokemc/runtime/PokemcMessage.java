package uk.pokemc.runtime;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PokemcMessage implements IMessage {

	private int sendInt;
    private String text;

    public PokemcMessage() { }

    public PokemcMessage(int num) {
        this.setSendInt(num);
    }

    public PokemcMessage(String text) {
        this.setText(text);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        setText(ByteBufUtils.readUTF8String(buf)); // this class is very useful in general for writing more complex objects
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, getText());
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getSendInt() {
		return sendInt;
	}

	public void setSendInt(int sendInt) {
		this.sendInt = sendInt;
	}
    
}
