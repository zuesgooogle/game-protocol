package com.simplegame.protocol.codec;

import com.simplegame.protocol.utils.SerializableUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 下午10:45:52 
 *
 */
public class NetEncoder extends MessageToByteEncoder<Object[]> {

	@Override
	protected void encode(ChannelHandlerContext ch, Object[] msg, ByteBuf out) throws Exception {
		byte[] data = SerializableUtil.object2Bytes(msg);
		
		int dataLength = data.length;
		
		out.writeInt(dataLength);
		out.writeBytes(data);
	}

}
