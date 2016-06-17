package com.esampaio.prototank.raspberry.comunication.exceptions;
/**
 * 
 * @author eduardo
 *
 */
public class CommunicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3940259355674422865L;
	
	public CommunicationException() {

	}
	
	public CommunicationException(Throwable exception) {
		super(exception);
	}
	
	public CommunicationException(String message){
		super(message);
	}
	public CommunicationException(String message,Throwable exception) {
		super(message,exception);
		
	}

}
