package com.esampaio.prototank.raspberry.action.command;

public class Command {
	private Action action;
	private byte[] data;
	
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
