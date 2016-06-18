package com.esampaio.prototank.raspberry.hardware.components;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;

/**
 * 
 * @author eduardo
 *
 */
public class Led extends Component{
	
	private GpioPinDigitalOutput  gpioPin;
	
	public Led(Pin pin) {		
		gpioPin = setupOutPin(pin);
	}
	
	
	/**
	 * turns the led on
	 */
	public void on(){
		gpioPin.high();
	}
	/**
	 * turns the led off
	 */
	public void off(){
		gpioPin.low();
	}
}
