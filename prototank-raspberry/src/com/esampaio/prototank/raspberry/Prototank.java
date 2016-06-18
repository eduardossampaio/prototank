package com.esampaio.prototank.raspberry;

import com.esampaio.prototank.raspberry.action.ResultStatus;
import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.action.command.CommandResult;
import com.esampaio.prototank.raspberry.comunication.Communication;
import com.esampaio.prototank.raspberry.comunication.CommunicationFactory;
import com.esampaio.prototank.raspberry.comunication.exceptions.ClientDisconnectedException;
import com.esampaio.prototank.raspberry.comunication.exceptions.CommunicationException;
import com.esampaio.prototank.raspberry.hardware.components.Led;
import com.esampaio.prototank.raspberry.hardware.components.Motor;
import com.pi4j.io.gpio.RaspiPin;

public class Prototank {
	private Communication communication = CommunicationFactory.build();
	private Motor leftMotor = new Motor(RaspiPin.GPIO_00,RaspiPin.GPIO_01);
	private Motor rightMotor = new Motor(RaspiPin.GPIO_02,RaspiPin.GPIO_03);
	private Led leds = new Led(RaspiPin.GPIO_04);
	
	
	private boolean finallize;	
	
	public void initialize(){
		finallize = false;
	}
	
	public void execute() throws CommunicationException{
		while(!finallize){
			try{
				if (!communication.isConnected()){
					communication.connect();
				}			
				handleAction();
			}catch(ClientDisconnectedException e){
				System.err.println("client disconnected");
				e.printStackTrace();
				communication.disconnect();
			}catch(CommunicationException e){
				System.err.println("error");
				e.printStackTrace();
			}
		}
	}
	
	
	private void handleAction() throws CommunicationException{
		Command command = null;		
		try{
			command = communication.receiveCommand();
				
			switch (command.getType()) {
			case COMMAND:
				handleCommand(command);
				break;
			case REQUEST:
				handleRequest(command);
				break;
			default:
				break;
			}
		}catch(Exception e){
			if ( command!=null){
				this.communication.resultCommand(new CommandResult(command, ResultStatus.ERROR));
			}
			throw e;
		}
	}
	private void handleCommand(Command command) throws CommunicationException{
		switch (command.getAction()) {
		case MOVE_FORWARD:
			moveForward();
			break;
		case MOVE_BACKWARD:
			moveBackward();
			break;
		case TURN_LEFT:
			moveLeft();
			break;
		case TURN_RIGHT:
			moveRight();
			break;
		case LEDS_ON:
			System.out.println("leds on");
			leds.on();
			break;
		case LEDS_OFF:
			System.out.println("leds off");
			leds.off();
			break;
		default:
			break;
		}
		CommandResult commandResult = new CommandResult(command, ResultStatus.OK);
		this.communication.resultCommand(commandResult);
	}
	private void handleRequest(Command command){
		
	}
	
	private void moveForward(){
		System.out.println("moving forward");
		leftMotor.moveForward();
		rightMotor.moveForward();
	}
	private void moveBackward(){
		System.out.println("moving backward");
		leftMotor.moveBackward();
		rightMotor.moveBackward();
	}
	private void moveLeft(){
		System.out.println("moving left");
		leftMotor.moveForward();		
		rightMotor.moveBackward();
	}
	private void moveRight(){
		System.out.println("moving right");
		leftMotor.moveBackward();
		rightMotor.moveForward();
	}
}

