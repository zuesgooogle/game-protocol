package com.simplegame.protocol.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.simplegame.protocol.message.Message;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 上午10:48:43
 *
 */
public class ServerHandler extends SimpleChannelInboundHandler<Message> {

    private Logger LOG = LogManager.getLogger(getClass());
	
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		ctx.channel().attr(AttributeKey.valueOf("role_id")).set("11223344");
		
		LOG.info("role_id: {}", ctx.channel().attr(AttributeKey.valueOf("role_id")).get());
		
		LOG.info("server receive message: {}", JSONObject.toJSONString(msg.getData()));
	}

}
