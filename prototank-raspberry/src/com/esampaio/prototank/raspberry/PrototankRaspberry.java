package com.esampaio.prototank.raspberry;

import com.esampaio.prototank.raspberry.comunication.exceptions.CommunicationException;

public class PrototankRaspberry {
	public static void main(String[] args) throws CommunicationException {
		System.out.println("initializing prototank");
		Prototank prototank = new Prototank();
		prototank.initialize();
		prototank.execute();
	}

}
