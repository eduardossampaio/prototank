package com.esampaio.prototank.raspberry.action.command;

import com.esampaio.prototank.raspberry.comunication.ProtocolConstants;

public enum Action {
	MOVE_FORWARD(ProtocolConstants.MOVE_FORWARD),
	MOVE_BACKWARD(ProtocolConstants.MOVE_BACKWARD),
	TURN_RIGHT(ProtocolConstants.MOVE_RIGHT),
	TURN_LEFT(ProtocolConstants.MOVE_LEFT),
	LEDS_ON(ProtocolConstants.LEDS_ON),
	LEDS_OFF(ProtocolConstants.LEDS_OFF),
	MOVE_CAMERA(ProtocolConstants.MOVE_CAMERA),	
	
	CAMERA_CAPTURE(ProtocolConstants.REQUEST_CAMERA),
	WIFI_SIGNAL(ProtocolConstants.REQUEST_WIFI),
	BATTERY_STATUS(ProtocolConstants.REQUEST_BATTERY);
	
	private Action(byte b) {
		this.protocolByte = b;
	}
	
	private byte protocolByte;
	
	public byte getProtocolByte() {
		return protocolByte;
	}
	
	public static Action getAction(byte protocolByte){
		for (Action action : values()) {
			if ( action.protocolByte == protocolByte)
				return action;
		}
		return null;
	}
}
