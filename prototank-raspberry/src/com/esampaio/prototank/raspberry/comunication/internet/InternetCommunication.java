package com.esampaio.prototank.raspberry.comunication.internet;


import com.esampaio.prototank.raspberry.action.command.Command;
import com.esampaio.prototank.raspberry.action.command.CommandResult;
import com.esampaio.prototank.raspberry.comunication.Communication;
import com.esampaio.prototank.raspberry.comunication.ProtoProtocol;
import com.esampaio.prototank.raspberry.comunication.exceptions.ClientDisconnectedException;
import com.esampaio.prototank.raspberry.comunication.exceptions.CommunicationException;

public class InternetCommunication implements Communication{

	private boolean connected;
	private Server tcpServer;
	//private Server udpServer;
	
	ProtoProtocol protocol = new ProtoProtocol();
	
	public InternetCommunication(int tcpPort,int udpPort) {
		tcpServer = new TcpServer(tcpPort);
//		udpServer = new UdpServer(udpPort);		
	}
	
	@Override
	public void connect()  {
		try{	
			System.out.println("stating servers");
			System.out.println("waiting client");
			tcpServer.start();
			//udpServer.start();
			connected = true;
		}catch(CommunicationException e){
			e.printStackTrace();
			connected=false;
		}
	}

	@Override
	public void disconnect(){
		try{	
		//	if ( connected){
				this.tcpServer.shutdown();
//				this.udpServer.shutdown();
				connected = false;
			//}
		}catch(CommunicationException e){
			e.printStackTrace();
		}
	}

	@Override
	public boolean isConnected() {
		return this.connected;
	}

	@Override
	public Command receiveCommand() throws CommunicationException {
		try{
			byte[] data;
			data = tcpServer.read();
			Command command = protocol.decodeCommand(data);
			return command;
		}catch(ClientDisconnectedException e){
			this.connected = false;
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void resultCommand(CommandResult commandResult) {
		//protocol.encodeCommand(commandResult.getCommand());
	}
	
}
