package com.simplegame.protocol.codec;

import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月4日 上午10:43:25
 * 
 */
public class NetInitializer extends ChannelInitializer<SocketChannel> {

	private ChannelInboundHandler handler;

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		pipeline.addLast("decoder", new NetDecoder());
		pipeline.addLast("encoder", new NetEncoder());

		pipeline.addLast("handler", handler);
	}

	public void setHandler(ChannelInboundHandler handler) {
		this.handler = handler;
	}

}
