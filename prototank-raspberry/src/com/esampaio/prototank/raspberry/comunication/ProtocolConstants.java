package com.esampaio.prototank.raspberry.comunication;

public interface ProtocolConstants {
	byte COMMAND 			= (byte) 0xCC;
	byte REQUEST 			= (byte) 0xAA;
	byte RESULT 			= (byte) 0xBB;

	byte MOVE_FORWARD 		= (byte) 0xC1;
	byte MOVE_BACKWARD 		= (byte) 0xC2;
	byte MOVE_RIGHT 		= (byte) 0xC3;
	byte MOVE_LEFT		 	= (byte) 0xC4;
	byte LEDS_ON 			= (byte) 0xC5;
	byte LEDS_OFF			= (byte) 0xC6;
	byte MOVE_CAMERA		= (byte) 0xC7;

	byte REQUEST_CAMERA 	= (byte) 0xA1;
	byte REQUEST_WIFI 		= (byte) 0xA2;
	byte REQUEST_BATTERY 	= (byte) 0xA3;

	byte RESULT_OK 			= (byte) 0xB1;
	byte RESULT_ERROR 		= (byte) 0xB2;
	
	byte END_PACKAGE		= (byte) 0xF0;
}
