package com.esampaio.prototank.raspberry.action.command;

import com.esampaio.prototank.raspberry.action.ResultStatus;

public class CommandResult {
	private Command command;
	private ResultStatus status;
	
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
	
	
}
