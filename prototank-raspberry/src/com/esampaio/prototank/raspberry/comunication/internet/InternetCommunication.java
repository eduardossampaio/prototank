package com.esampaio.prototank.raspberry.comunication.internet;


import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.action.command.CommandResult;
import com.esampaio.prototank.raspberry.comunication.Communication;
import com.esampaio.prototank.raspberry.comunication.CommunicationException;
import com.esampaio.prototank.raspberry.comunication.ProtoProtocol;

public class InternetCommunication implements Communication{

	private boolean connected;
	private Server tcpServer;
	private Server udpServer;
	
	ProtoProtocol protocol = new ProtoProtocol();
	
	public InternetCommunication(int tcpPort,int udpPort) {
		tcpServer = new TcpServer(tcpPort);
		udpServer = new UdpServer(udpPort);		
	}
	
	@Override
	public void connect() {
		try{
			tcpServer.start();
			udpServer.start();
			
			connected = true;
		}catch(CommunicationException e){
			e.printStackTrace();
			connected = false;
		}
	}

	@Override
	public void disconnect() {
		try{
			if ( connected){
				this.tcpServer.shutdown();
				this.udpServer.shutdown();
				connected = false;
			}
		}catch(CommunicationException e){
			e.printStackTrace();
		}
	}

	@Override
	public boolean isConnected() {
		return this.connected;
	}

	@Override
	public Command receiveCommand() {
		byte[] data;
		try {
			data = tcpServer.read();
			Command command = protocol.decodeCommand(data);
			return command;
		} catch (CommunicationException e) {
			e.printStackTrace();
			return null;
		}
		

	}

	@Override
	public void resultCommand(CommandResult commandResult) {
		protocol.encodeCommand(commandResult.getCommand());
	}
	
}
