package com.esampaio.prototank.raspberry.comunication;

import java.util.Arrays;

import com.esampaio.prototank.raspberry.action.command.CommandType;
import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.action.command.CommandResult;
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
		
		return build(command);
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
		
	
	
	
	
	public byte[] encodeResult(CommandResult commandResult){
		byte[] encodedResult = new byte[7+commandResult.getResultData().length];
		
		encodedResult[0] = ProtocolConstants.RESULT;
		
		encodedResult[1] = (byte) ( (commandResult.getCommand().getCommandId() >> 8) & 0xFF);
		encodedResult[2] = (byte) (commandResult.getCommand().getCommandId() & 0xFF);							
		
		encodedResult[3] = (byte) ( (commandResult.getResultData().length >> 8) & 0xFF);
		encodedResult[4] = (byte) (commandResult.getResultData().length & 0xFF);
		
		for(int i=0;i<commandResult.getResultData().length;i++){
			encodedResult[i+5] = commandResult.getResultData()[i];
		}
		encodedResult[encodedResult.length-2] = commandResult.getStatus().getProtocolByte();
		encodedResult[encodedResult.length-1] = ProtocolConstants.END_PACKAGE;
		
		return encodedResult;
	}
	
	public CommandResult decodeResult(byte[] bytes){
		return null;
	}
	
	private Package build(byte [] bytes){
		
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
	
	private byte[] build(Command command){
		byte[] encoded = new byte[7+command.getData().length];
		encoded[0] = command.getType().getProtocolByte();
		
		encoded[1] = (byte) ( (command.getCommandId() >> 8) & 0xFF);
		encoded[2] = (byte) (command.getCommandId() & 0xFF);
		
		encoded[3] = command.getAction().getProtocolByte();
				
		
		encoded[4] = (byte) ( (command.getData().length >> 8) & 0xFF);
		encoded[5] = (byte) (command.getData().length & 0xFF);
		
		for(int i=0;i<command.getData().length;i++){
			encoded[i+6] = command.getData()[i];
		}
		
		encoded[encoded.length-1] = ProtocolConstants.END_PACKAGE;
		
		return encoded;
	}
	
	public static void main(String[] args) {
//		byte[] bytes = {(byte) 0xAA, 0x00,(byte) 0x01,(byte) 0xAF,0x00,0x03,(byte) 0xAA,(byte) 0xBB,(byte) 0xCC,(byte) 0xF0};
		byte [] forwardRequest = {ProtocolConstants.COMMAND,0x00,0x01,ProtocolConstants.MOVE_FORWARD,0x00,0x03,(byte) 0xAA,(byte) 0xBB,(byte) 0xCC,ProtocolConstants.END_PACKAGE};
		//Package package1 = 
		Command command = new ProtoProtocol().decodeCommand(forwardRequest);
		
		byte [] decodef = new ProtoProtocol().encodeCommand(command);
		
		for (byte b : decodef) {
			System.out.printf("%02X ", b);
		}
	}
	
	
	
}


