package com.esampaio.prototank.raspberry;

import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.comunication.Communication;
import com.esampaio.prototank.raspberry.comunication.CommunicationFactory;
import com.esampaio.prototank.raspberry.comunication.exceptions.ClientDisconnectedException;
import com.esampaio.prototank.raspberry.comunication.exceptions.CommunicationException;
import com.esampaio.prototank.raspberry.hardware.components.Led;
import com.esampaio.prototank.raspberry.hardware.components.Motor;

public class Prototank {
	private Communication communication = CommunicationFactory.build();
	private Motor leftMotor = new Motor();
	private Motor rightMotor = new Motor();
	private Led leds = new Led();
	
	
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
		Command command;
		
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
	}
	private void handleCommand(Command command){
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
		default:
			break;
		}
	}
	private void handleRequest(Command command){
		
	}
	
	private void moveForward(){
		System.out.println("moving forward");
	}
	private void moveBackward(){
		System.out.println("moving backward");
	}
	private void moveLeft(){
		System.out.println("moving left");
	}
	private void moveRight(){
		System.out.println("moving right");
	}
}

