package com.simplegame.protocol.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 下午3:58:15
 *
 */

public class NetDecoder extends ByteToMessageDecoder {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

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
		
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(decoded));
        try {
            Object object = ois.readObject();
            
            out.add(object);
        } catch (Exception e) {
            LOG.error("", e);
        }
	}

	

}
