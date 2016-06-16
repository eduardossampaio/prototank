package com.esampaio.prototank.raspberry.comunication.internet;

import com.esampaio.prototank.raspberry.comunication.CommunicationException;

public abstract class Server {
	
	public abstract void start() throws CommunicationException;		
	
	public abstract void write(byte [] data) throws CommunicationException;
	
	public abstract byte [] read() throws CommunicationException;
	
	public abstract void shutdown() throws CommunicationException;
	

}
