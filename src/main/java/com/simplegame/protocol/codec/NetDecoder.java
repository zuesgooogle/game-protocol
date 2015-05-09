package com.simplegame.protocol.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import com.simplegame.protocol.utils.SerializableUtil;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 下午3:58:15
 *
 */

public class NetDecoder extends LengthFieldBasedFrameDecoder {

	public static final int MAX_FRAME_LENGTH = 1024 * 1024; //1KB  
	
	public NetDecoder() {
		super(MAX_FRAME_LENGTH, 0, 4);
	}
	
	public NetDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
	}
	
    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        if (frame == null) {
            return null;
        }

        byte[] decoded = new byte[frame.readInt()];
        frame.readBytes(decoded);
        
        Object object = SerializableUtil.bytes2Object(decoded);
        
        return object;
    }
}
