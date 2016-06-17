package com.esampaio.prototank.raspberry.comunication;

import com.esampaio.prototank.raspberry.comunication.internet.InternetCommunication;

public class CommunicationFactory {
	public static Communication build(){
		return new InternetCommunication(5555,6666);
	}
}	
