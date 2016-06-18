package com.esampaio.prototank.raspberry.hardware.components;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

/**
 * Abstract class that represents components on the
 * robot. 
 * @author eduardo
 *
 */
public abstract class Component {
	protected GpioController factory;// = GpioFactory.getInstance();
	
	protected GpioPinDigitalOutput setupOutPin(Pin  pin){
		return setupOutPin(pin, pin.toString(), PinState.LOW);
	}
	
	protected GpioPinDigitalOutput setupOutPin(Pin  pin,String name){
		return setupOutPin(pin, name, PinState.LOW);
	}
	
	protected GpioPinDigitalOutput setupOutPin(Pin  pin,String name,PinState state){		
		GpioPinDigitalOutput digitalPin = factory.provisionDigitalOutputPin(pin, name,state);
		digitalPin.setShutdownOptions(true, PinState.LOW);		
		return digitalPin;
		//return null;
	}
}
