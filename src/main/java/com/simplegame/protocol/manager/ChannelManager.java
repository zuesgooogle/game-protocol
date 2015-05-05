package com.simplegame.protocol.manager;

import io.netty.channel.Channel;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月5日 下午4:11:04
 *
 */

public class ChannelManager {
	
	/**
	 * key  :	role_id
	 * value:	Channel
	 */
	private static final ConcurrentMap<String, Channel> sessions = new ConcurrentHashMap<String, Channel>();

	private ChannelManager() {
		
	}
	
	public static void pubChannel(String key, Channel channel) {
		sessions.put(key, channel);
	}
	
	public static void removeChannel(String key) {
		sessions.remove(key);
	}
	
	public static Channel getChannel(String key) {
		return sessions.get(key);
	}
	
	public static int getSessionCount() {
		return sessions.size();
	}

	public static ConcurrentMap<String, Channel> getSessions() {
		return sessions;
	}

	public static Collection<String> getOnlineRoleIds() {
		return sessions.keySet();
	}
}
