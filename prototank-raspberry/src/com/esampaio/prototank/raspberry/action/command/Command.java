package com.esampaio.prototank.raspberry.action.command;

public class Command {
	private CommandType type;
	private int commandId;
	private Action action;
	private byte[] data;
	
	
	public Command(CommandType type, int commandId, Action action, byte[] data) {
		this.type = type;
		this.commandId = commandId;
		this.action = action;
		this.data = data;
		if( this.data == null){
			this.data = new byte[0];
		}
	}
	
	public CommandType getType() {
		return type;
	}
	public void setType(CommandType type) {
		this.type = type;
	}
	public int getCommandId() {
		return commandId;
	}
	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	
}
