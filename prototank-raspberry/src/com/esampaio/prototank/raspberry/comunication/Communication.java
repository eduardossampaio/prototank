package com.esampaio.prototank.raspberry.comunication;

import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.action.command.CommandResult;
import com.esampaio.prototank.raspberry.comunication.exceptions.CommunicationException;

public interface Communication {
	
	public void connect() throws CommunicationException;
	
	public void disconnect() throws CommunicationException;
	
	public boolean isConnected();
	
	public Command receiveCommand()throws CommunicationException;
	
	public void resultCommand(CommandResult commandResult)throws CommunicationException;
		
	
}
