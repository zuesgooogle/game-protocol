package com.simplegame.protocol.codec;

import java.util.List;

import com.simplegame.protocol.proto.Message.Request;

import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月4日 上午10:43:25
 * 
 */
public class NetInitializer extends ChannelInitializer<SocketChannel> {

	private List<ChannelInboundHandler> handlers;

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		//decoder
		pipeline.addLast(new ProtobufVarint32FrameDecoder());
		pipeline.addLast(new ProtobufDecoder(Request.getDefaultInstance()));

		//encoder
		pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
		pipeline.addLast(new ProtobufEncoder());
		
		for (ChannelInboundHandler h : handlers) {
			pipeline.addLast("handler" + h.getClass().getSimpleName(), h);
		}
	}

	public void setHandlers(List<ChannelInboundHandler> handlers) {
		this.handlers = handlers;
	}

}
