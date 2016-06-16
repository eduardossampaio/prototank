package com.esampaio.prototank.raspberry.comunication;

import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.action.request.Request;

public class ProtoProtocol {
	public static final byte COMMAND = (byte) 0xCC;
	public static final byte REQUEST = (byte) 0xAA;
	public static final byte RESULT  = (byte) 0xBB;
	
	public static final byte MOVE_FORWARD 		= (byte) 0xC1;
	public static final byte MOVE_BACKWARD 		= (byte) 0xC2;
	public static final byte MOVE_RIGHT 		= (byte) 0xC3;
	public static final byte MOVE_LEFT 			= (byte) 0xC4;
	public static final byte LEDS_ON 			= (byte) 0xC5;
	public static final byte LEDS_OFF 			= (byte) 0xC6;
	
	public static final byte REQUEST_CAMERA		= (byte) 0xA1;
	public static final byte REQUEST_WIFI		= (byte) 0xA2;
	public static final byte REQUEST_BATTERY	= (byte) 0xA3;
		
	public static final byte RESULT_OK			= (byte) 0xB1;
	public static final byte RESULT_ERROR		= (byte) 0xB2;
	
		
	public byte[] encodeCommand(Command command){
		return null;
	}
	public Command decodeCommand(byte [] command){
		return null;
	}
	
	public byte[] encondeRequest(Request request){
		return null;
	}
	
	public Request decodeRequest(byte [] request){
		return null;
	}
	
}
