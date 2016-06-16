package com.esampaio.prototank.raspberry.comunication.internet;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.esampaio.prototank.raspberry.comunication.CommunicationException;

public class UdpServer extends Server{
	private int port;
	private DatagramSocket serverSocket;
	private InetAddress IPAddress;
	private int clientPort;
	public UdpServer(int port) {
		this.port = port;
	}
	
	@Override
	public void start() throws CommunicationException {
		try {
			serverSocket = new DatagramSocket(port);
		} catch (SocketException e) {
			throw new CommunicationException(e);
		}		
		
	}

	@Override
	public void write(byte[] data) throws CommunicationException {
		try {
			serverSocket.send(new DatagramPacket(data, data.length,IPAddress,clientPort));
		} catch (IOException e) {
			throw new CommunicationException(e);
		}
		
	}

	@Override
	public byte[] read() throws CommunicationException {
		try {
			DatagramPacket packet = new DatagramPacket(new byte[256], 256);
			serverSocket.receive(packet);
			IPAddress = packet.getAddress();
			clientPort = packet.getPort();
			return packet.getData();
		} catch (IOException e) {
			throw new CommunicationException(e);
		}
	}

	@Override
	public void shutdown() throws CommunicationException {
		// TODO Auto-generated method stub
		
	}
	
	


}
