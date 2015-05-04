package com.simplegame.protocol.coder;

import java.nio.charset.Charset;

import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月4日 上午10:43:25
 * 
 */
public class NetInitializer extends ChannelInitializer<SocketChannel> {

	private static final int FRAME_LENGTH = 16384; //16KB
	
	private Charset charset = Charset.forName("UTF-8");

	private ChannelInboundHandler handler;

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		pipeline.addLast("framer", new DelimiterBasedFrameDecoder(FRAME_LENGTH, Delimiters.lineDelimiter()));

		pipeline.addLast("decoder", new StringDecoder(charset));
		pipeline.addLast("encoder", new StringEncoder(charset));

		pipeline.addLast("handler", handler);
	}

	public void setHandler(ChannelInboundHandler handler) {
		this.handler = handler;
	}

}
