package com.esampaio.prototank.raspberry.comunication;

import java.util.Arrays;

import com.esampaio.prototank.raspberry.action.command.CommandType;
import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.action.command.Action;

public class ProtoProtocol {
	
	private class Package{
		private byte requestType;		
		private int requestId;		
		private byte requestByte;		
		private int requestDataLen;		
		private byte[] requestData;		
		private byte endRequestByte;
		
		public Package() {
		}
		
		@Override
		public String toString() {
			 String arr = "";
			 arr = arr + "action byte: "+String.format("%02X", requestType)+"\n";
			 arr = arr + "request id :" +requestId+"\n";
			 arr = arr + "request byte: "+String.format("%02X", requestByte)+"\n";
			 arr = arr + "request data len:" +requestDataLen+"\n";
			 arr = arr + "end requestByte byte: "+String.format("%02X", endRequestByte)+"\n";			 
			 return arr;
		}
		
	}
		
	public byte[] encodeCommand(Command command){
		return null;
	}
	public Command decodeCommand(byte [] command){
		Package package_ = build(command);
		CommandType type = CommandType.getCommandType(package_.requestType);
		int commandId = package_.requestId;
		Action action = Action.getAction(package_.requestByte);
		byte [] requestData = package_.requestData;
		Command command2 = new Command(type, commandId, action, requestData);
		return command2;
	}
		
	
	public Package build(byte [] bytes){
		
		try{
			Package packageToBuild = new Package();
			packageToBuild.requestType = bytes[0];
			
			packageToBuild.requestId = ((bytes[1] & 0xFF) << 8) | (bytes[2] & 0xFF);
			
			packageToBuild.requestByte = bytes[3];
			
			packageToBuild.requestDataLen = ((bytes[4] & 0xFF) << 8) | (bytes[5] & 0xFF);
			
			if (packageToBuild.requestDataLen != 0){
				packageToBuild.requestData =Arrays.copyOfRange(bytes, 6, 6+packageToBuild.requestDataLen);
				
			}
			packageToBuild.endRequestByte = bytes[bytes.length-1];								
			return packageToBuild;			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		
	}
	
	public static void main(String[] args) {
		byte[] bytes = {(byte) 0xAA, 0x00,(byte) 0x01,(byte) 0xAF,0x00,0x03,(byte) 0xAA,(byte) 0xBB,(byte) 0xCC,(byte) 0xF0};
		Package package1 = new ProtoProtocol().build(bytes);
		System.out.println(package1);
	}
	
	
	
}


