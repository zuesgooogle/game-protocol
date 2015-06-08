package com.simplegame.protocol;

import java.util.Arrays;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.simplegame.protocol.codec.ClientListener;
import com.simplegame.protocol.codec.ServerListener;
import com.simplegame.protocol.proto.Message.Request;
import com.simplegame.protocol.utils.SerializableUtil;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 上午11:52:53
 *
 */

public class ClientLinstenerTest extends BasicTest {

	@Test
	public void proto() {
		//Data
		
		Request.Builder builder = Request.newBuilder();
		builder.setCommand("10001")
		       .setData("123456");		
		
		byte[] bytes = builder.build().toByteArray();
		System.out.println( Arrays.toString(bytes) );
	}
	
	@Test
	public void in() throws InterruptedException {
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
		array.add("vip1"); //userId
		array.add("1");    //serverId
		
		/**
		 * 中心服务器生成
		 */
		array.add(System.currentTimeMillis() + ""); //timestamp
		array.add("signXXX");	//sign
		
		Request.Builder builder = Request.newBuilder();
		builder.setCommand("10001")
		       .setData(array.toJSONString());
		
		client.sendMessage(builder);
		
		Thread.sleep(30000);
	}
	
	@Test
	public void createRole() throws InterruptedException {
		ClientListener client = ctx.getBean(ClientListener.class);
		client.start();
		
		//Data
		JSONArray array = new JSONArray();
		array.add("vip1"); 		//userId
		array.add("1");    		//serverId
		array.add("我是VIP"); 	//name
		array.add("A"); 		//job A, B, C, D
		array.add(1); 			//sex  1:man, 0: woman
		array.add("B");			//face A, B, C, D
		array.add("qzone");		//platform
		
		Request.Builder builder = Request.newBuilder();
		builder.setCommand("10002")
		       .setData(array.toJSONString());
		
		client.sendMessage(builder);
		
		Thread.sleep(30000);
	}
	
}
