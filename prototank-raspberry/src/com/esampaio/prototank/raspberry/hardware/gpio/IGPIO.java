package com.esampaio.prototank.raspberry.hardware.gpio;

public interface IGPIO {
	
	public int readPin(int pin);
	
	public void writePin(int pin,int value);
}
