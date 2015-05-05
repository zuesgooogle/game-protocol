package com.simplegame.protocol;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.simplegame.protocol.codec.ClientListener;
import com.simplegame.protocol.codec.ServerListener;

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
		
		/**
		 * Message Body 
		 * 0: command 		Not Null 
		 * 1: data 			Not Null 
		 * 2: sessionId 
		 * 3: roleId
		 * 4: accountId 
		 * 5: stageId 
		 * 6: token
		 * 
		 */
		
		//Data
		JSONArray array = new JSONArray();
		array.add("1001");
		
		JSONArray data = new JSONArray();
		data.add(3);
		data.add("hellow");
		data.add(true);
		array.add(data.toArray());
		
		client.sendMessage(array.toArray());
		
		Thread.sleep(3000);
	}
	
}
