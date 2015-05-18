package com.simplegame.protocol.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simplegame.protocol.proto.Message.Response;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 上午10:48:43
 *
 */
public class ClientHandler extends SimpleChannelInboundHandler<Response> {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Response msg) throws Exception {
		LOG.info("client receive msg: {}", msg.toString());
	}

}
