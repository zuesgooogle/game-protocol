package com.simplegame.protocol.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableUtil {
	
	public static byte[] object2Bytes(Object object) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(object);
			objectOutputStream.flush();
			objectOutputStream.close();
			
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException("covert from object to bytes failed.", e);
		}
	}

	public static Object bytes2Object(byte[] bytes) {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			Object object = objectInputStream.readObject();
			objectInputStream.close();
			
			return object;
		} catch (Exception e) {
			throw new RuntimeException("covert from bytes to object failed.", e);
		}
	}

}
