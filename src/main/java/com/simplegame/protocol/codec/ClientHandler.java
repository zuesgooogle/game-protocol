package com.simplegame.protocol.codec;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.simplegame.protocol.proto.Message.Response;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 上午10:48:43
 *
 */
@Sharable
public class ClientHandler extends SimpleChannelInboundHandler<Response> {

    private Logger LOG = LogManager.getLogger(getClass());
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Response msg) throws Exception {
		LOG.info("client receive msg: {}", msg.toString());
	}

}
