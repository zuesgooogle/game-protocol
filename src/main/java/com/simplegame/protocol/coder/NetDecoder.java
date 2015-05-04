package com.simplegame.protocol.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 下午3:58:15
 *
 */

public class NetDecoder extends ReplayingDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		//protocol length
		int length = in.readInt();
		
		ByteBuf data = in.readBytes(length);
		
		byte[] bytes = new byte[length];
		data.readBytes(bytes);
	
		out.add( bytes );
	}

}
