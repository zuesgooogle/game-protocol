package com.simplegame.protocol;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.simplegame.protocol.encrypt.SimpleEncrypt;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月3日 下午3:04:27 
 *
 */
public class JSONTest {

	@Test
	public void test() {
		JSONArray array = new JSONArray();
		array.add(1);
		array.add("test");
		array.add(2);
		
		
		JSONArray inner = new JSONArray();
		inner.add(3);
		inner.add("hellow");
		inner.add(true);
		
		array.add(inner.toArray());
		System.out.println(array.toJSONString());
		
		String ticket = "TEST";
		SimpleEncrypt encrypt = new SimpleEncrypt(SimpleEncrypt.getKey(), ticket);
		
		byte[] bytes = encrypt.encode(array.toJSONString().getBytes());
		System.out.println( new String(bytes) );
		
		bytes = encrypt.decode(bytes);
		String back = new String(bytes);
		System.out.println( back );
		
		array = JSONArray.parseArray(back);
		System.out.println(array);
	}

}
