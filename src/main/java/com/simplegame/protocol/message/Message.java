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
	 * 
	 * 0: command Not Null 
	 * 1: data Not Null 
	 * 2: dest type 消息目标通道
	 * 3：from type 消息来源通道 
	 * 4: route 消息路由
	 * 5: sessionId 
	 * 6: roleId 
	 * 7: userId 
	 * 8: stageId 
	 * 9: token
	 *10: ip 
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
		return (Integer) this.msgSource[4];
	}

	public String getSessionId() {
		return (String)this.msgSource[5];
	}

	public String getRoleId() {
		return (String) this.msgSource[6];
	}

	public String getUserId() {
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
	
    public String getIp() {
        return (String) this.msgSource[10];
    }

	public Object[] getMsgSource() {
		return this.msgSource;
	}

	@Override
	public String toString() {
		return JSONArray.toJSONString(this.msgSource);
	}

	public enum FromType {

		CLIENT(1),

		BUS(2),

		STAGE(3),

		STAGE_CONTROL(4),

		;

		private final int value;

		private FromType(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public static FromType findType(int type) {
			switch (type) {
			case 1:
				return CLIENT;
			case 2:
				return BUS;
			case 3:
				return STAGE;
			case 4:
			    return STAGE_CONTROL;
			default:
				throw new IllegalArgumentException("invalid frome type.");
			}

		}
	}

	public enum DestType {

		CLIENT(0),

		BUS(1),

		STAGE_CONTROL(2),

		STAGE(3),
		
		INOUT(4),

		BUS_INIT(5),

		PUBLIC(6),
		
		INNER_SYSTEM(7),

		;

		private final int value;

		private DestType(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public static DestType findType(int type) {
			switch (type) {
			case 0:
				return CLIENT;
			case 1:
				return BUS;
			case 2:
				return STAGE_CONTROL;
			case 3:
				return STAGE;
			case 4:
				return INOUT;
			case 5:
				return BUS_INIT;
			case 6:
			    return PUBLIC;
			case 7:
			    return INNER_SYSTEM;
			default:
				throw new IllegalArgumentException("invalid frome type.");
			}

		}
	}

}
