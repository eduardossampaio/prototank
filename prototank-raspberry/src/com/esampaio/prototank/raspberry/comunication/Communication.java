package com.esampaio.prototank.raspberry.comunication;

import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.action.command.CommandResult;
import com.esampaio.prototank.raspberry.action.request.Request;
import com.esampaio.prototank.raspberry.action.request.RequestResult;

public interface Communication {
	
	public void connect();
	
	public void disconnect();
	
	public boolean isConnected();
	
	public Command receiveCommand();
	
	public void resultCommand(CommandResult commandResult);
	
	public Request receiveRequest();
	
	public void resultRequest(RequestResult requestResult);
	
}
