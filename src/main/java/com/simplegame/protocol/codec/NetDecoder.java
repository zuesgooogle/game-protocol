package com.simplegame.protocol.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import com.simplegame.protocol.message.Message;
import com.simplegame.protocol.utils.SerializableUtil;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 下午3:58:15
 *
 */

public class NetDecoder extends ByteToMessageDecoder {

	//private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Override
	protected void decode(ChannelHandlerContext ch, ByteBuf in, List<Object> out) throws Exception {
		if(in.readableBytes() < 4) {
			return;
		}
		
		in.markReaderIndex();
		
		int dataLength = in.readInt();
		if(in.readableBytes() < dataLength) {
			in.resetReaderIndex();
			return;
		}
		
		byte[] decoded = new byte[dataLength];
		in.readBytes(decoded);
		
		Object object = SerializableUtil.bytes2Object(decoded);
		out.add( new Message((Object[])object));

	}
}
