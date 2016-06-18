package com.esampaio.prototank.raspberry.action;

import com.esampaio.prototank.raspberry.comunication.ProtocolConstants;

public enum ResultStatus {
	OK(ProtocolConstants.RESULT_OK),
	ERROR(ProtocolConstants.RESULT_ERROR);
	
	private byte protocolByte;
	private ResultStatus(byte protocolByte) {
		this.protocolByte = protocolByte;
	}
	
	public byte getProtocolByte() {
		return protocolByte;
	}
}
