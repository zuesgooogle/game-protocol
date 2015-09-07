package com.simplegame.protocol;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.simplegame.protocol.codec.ClientListener;
import com.simplegame.protocol.proto.Message.Request;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月4日 上午11:52:53
 *
 */

public class ClientLinstenerTest extends BasicTest {

    private String roleId = "fu0UR1-74-0-1";
    
    private ClientListener client;
    
    @Before
    public void init() {
        client = ctx.getBean(ClientListener.class);
        client.start();
    }
	
    /**
     * 账号进入，获取角色列表 
     * 
     */
	@Test
	public void in() throws InterruptedException {
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
		
		createRole();
		
		Thread.sleep(30000);
	}
	
	/**
	 * 创建角色
	 * 
	 */
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
	
	/**
	 * 角色登录 
	 * 
	 */
	@Test
	public void login() throws InterruptedException {
        
        //Data
        JSONArray array = new JSONArray();
        array.add(roleId);      //roleId
        
        Request.Builder builder = Request.newBuilder();
        builder.setCommand("10003")
               .setData(array.toJSONString());
        
        client.sendMessage(builder);
        
        Thread.sleep(10000);
        applyChangeMap();
        
        Thread.sleep(10000);
        changeMap();
        
        Thread.sleep(30000);
	}
	
	/**
	 * 
	 * 请求进入场景
	 * 
	 */
	@Test
	public void applyChangeMap() throws InterruptedException {
	    //Data
        JSONArray array = new JSONArray();
        
        Request.Builder builder = Request.newBuilder();
        builder.setCommand("20000")
               .setData(array.toJSONString());
        
        client.sendMessage(builder);
        
        
	}
	
	 /**
     * 
     * 进入场景
     * 
     */
    @Test
    public void changeMap() throws InterruptedException {
        //Data
        JSONArray array = new JSONArray();
        
        Request.Builder builder = Request.newBuilder();
        builder.setCommand("21000")
               .setData(array.toJSONString());
        
        client.sendMessage(builder);
        
    }
}
