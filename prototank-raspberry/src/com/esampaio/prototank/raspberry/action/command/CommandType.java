package com.esampaio.prototank.raspberry.action.command;

import com.esampaio.prototank.raspberry.comunication.ProtocolConstants;

public enum CommandType {
	COMMAND(ProtocolConstants.COMMAND),
	REQUEST(ProtocolConstants.REQUEST),
	RESULT(ProtocolConstants.RESULT);

	private CommandType(byte b) {
		this.protocolByte = b;
	}
	
	private byte protocolByte;
	
	public byte getProtocolByte() {
		return protocolByte;
	}
	
	public static CommandType getCommandType(byte protocolByte){
		for (CommandType type : values()) {
			if ( type.protocolByte == protocolByte)
				return type;
		}
		return null;
	}
}
