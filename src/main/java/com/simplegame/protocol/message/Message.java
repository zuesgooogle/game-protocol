package com.simplegame.protocol.message;

import com.alibaba.fastjson.JSONArray;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月3日 下午10:03:06
 * 
 */
public class Message {

	/**
	 * Message Body 
	 * 0: command 		Not Null 
	 * 1: data 			Not Null 
	 * 2: dest type     消息目标通道
	 * 3： from type		消息来源通道
	 * 4: route			消息路由
	 * 5: sessionId 
	 * 6: roleId
	 * 7: accountId 
	 * 8: stageId 
	 * 9: token
	 * 
	 */
	private Object[] msgSource;

	public Message(Object[] msgSource) {
		this.msgSource = msgSource;
	}

	public String getCommand() {
		return (String) this.msgSource[0];
	}

	public <T> T getData() {
		return (T) this.msgSource[1];
	}

	public int getRoute() {
		return (Integer)this.msgSource[4];
	}
	
	public long getSessionId() {
		Object sessionId = this.msgSource[5];
		if (null != sessionId) {
			return ((Long) sessionId).longValue();
		}
		return 0L;
	}

	public String getRoleId() {
		return (String) this.msgSource[6];
	}

	public String getAccountId() {
		return (String) this.msgSource[7];
	}

	public String getStageId() {
		Object stageId = this.msgSource[8];
		if (null != stageId) {
			return (String) stageId;
		}
		return "";
	}

	public Object[] getToken() {
		Object stageId = this.msgSource[9];
		if (null != stageId) {
			return (Object[]) stageId;
		}
		return null;
	}

	public Object[] getMsgSource() {
		return this.msgSource;
	}

	@Override
	public String toString() {
		return JSONArray.toJSONString(this.msgSource);
	}

}
