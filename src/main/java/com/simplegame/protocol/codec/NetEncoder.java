package com.simplegame.protocol.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 下午10:45:52 
 *
 */
public class NetEncoder extends MessageToByteEncoder<byte[]> {

	@Override
	protected void encode(ChannelHandlerContext ch, byte[] msg, ByteBuf out) throws Exception {
		
		int msgLength = msg.length;
		
		out.writeInt(msgLength);
		out.writeBytes(msg);
	}

}
