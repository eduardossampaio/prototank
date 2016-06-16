package com.esampaio.prototank.raspberry.comunication.internet;

import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.action.command.CommandResult;
import com.esampaio.prototank.raspberry.action.request.Request;
import com.esampaio.prototank.raspberry.action.request.RequestResult;
import com.esampaio.prototank.raspberry.comunication.Communication;

public class InternetCommunication implements Communication{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command receiveCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resultCommand(CommandResult commandResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Request receiveRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resultRequest(RequestResult requestResult) {
		// TODO Auto-generated method stub
		
	}

}
