package com.esampaio.prototank.raspberry.hardware.components;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;

/**
 * The motors of the tank
 * @author eduardo
 *
 */
public class Motor extends Component {
	
	private GpioPinDigitalOutput  gpioPin1;
	private GpioPinDigitalOutput  gpioPin2;
	
	public Motor(Pin pin1,Pin pin2) {		
//		gpioPin1 = setupOutPin(pin1);
//		gpioPin2 = setupOutPin(pin2);
	}
	
	
	
	/**
	 * moves the motor forward, with 
	 * max speed
	 */	
	public void moveForward(){
//		gpioPin1.high();
//		gpioPin2.low();
	}

	public void moveBackward(){
//		gpioPin1.low();
//		gpioPin2.high();		
	}
	
	public void stop(){
//		gpioPin1.low();
//		gpioPin2.low();
	}

		
}
