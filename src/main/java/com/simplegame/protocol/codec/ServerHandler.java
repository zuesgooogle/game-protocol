package com.simplegame.protocol.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 上午10:48:43
 *
 */
public class ServerHandler extends SimpleChannelInboundHandler<Object[]> {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object[] msg) throws Exception {
		LOG.info("server receive message: {}", JSONObject.toJSONString(msg));
	}

}
