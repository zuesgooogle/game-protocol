package com.simplegame.protocol;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.simplegame.protocol.coder.ClientListener;
import com.simplegame.protocol.coder.ServerListener;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 上午11:52:53
 *
 */

public class ServerLinstenerTest extends BasicTest {

	@Test
	public void start() throws InterruptedException {
		ServerListener server = ctx.getBean(ServerListener.class);
		server.start();
		
		ClientListener client = ctx.getBean(ClientListener.class);
		client.start();
		
		//Data
		JSONArray array = new JSONArray();
		array.add(1);
		array.add("test");
		array.add(2);
		
		JSONArray inner = new JSONArray();
		inner.add(3);
		inner.add("hellow");
		inner.add(true);
		array.add(inner.toArray());
		
		client.sendMessage(array.toString() + "\r\n");
		
		Thread.sleep(5000);
	}
	
}
