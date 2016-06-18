package com.esampaio.prototank.raspberry.action.command;

import com.esampaio.prototank.raspberry.action.ResultStatus;

public class CommandResult {
	private Command command;
	private byte[] resultData;
	private ResultStatus status;
			
	public CommandResult(Command command, byte[] resultData, ResultStatus status) {
		this.command = command;
		this.resultData = resultData;
		if(this.resultData == null){
			this.resultData = new byte[0];
		}
		this.status = status;
	}
	
	public CommandResult(Command command, ResultStatus status) {
		this(command,null,status);
	}
	
	
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public ResultStatus getStatus() {
		return status;
	}
	public void setStatus(ResultStatus status) {
		this.status = status;
	}
	public byte[] getResultData() {
		return resultData;
	}
	public void setResultData(byte[] resultData) {
		this.resultData = resultData;
	}
	
	
}
