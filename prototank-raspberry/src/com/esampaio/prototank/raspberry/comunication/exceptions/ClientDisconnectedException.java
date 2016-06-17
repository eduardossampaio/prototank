package com.esampaio.prototank.raspberry.comunication.exceptions;

public class ClientDisconnectedException extends CommunicationException{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6822921466887107102L;
	
	
	public ClientDisconnectedException() {

	}
	
	public ClientDisconnectedException(Throwable exception) {
		super(exception);
	}
	
	public ClientDisconnectedException(String message){
		super(message);
	}
	public ClientDisconnectedException(String message,Throwable exception) {
		super(message,exception);
		
	}
}
