package com.esampaio.prototank.raspberry.comunication;

import com.esampaio.prototank.raspberry.comunication.internet.InternetCommunication;

public class CommunicationFactory {
	public Communication build(){
		return new InternetCommunication();
	}
}	
