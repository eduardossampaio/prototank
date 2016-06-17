package com.esampaio.prototank.raspberry.comunication.internet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import com.esampaio.prototank.raspberry.comunication.exceptions.ClientDisconnectedException;
import com.esampaio.prototank.raspberry.comunication.exceptions.CommunicationException;

public class TcpServer extends Server{
	private int port;
	
	private ServerSocket serverSocket;
	private Socket client;
	private InputStream clientInputStream;
	private OutputStream clientOutputStream;
	
	private boolean isConnected ;
	public TcpServer(int port) {
		this.port = port;
		this.isConnected  = false;
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	
	public void start() throws CommunicationException{
		try{
			
			this.client = serverSocket.accept();
			
			this.clientOutputStream = client.getOutputStream();			
			this.clientInputStream = client.getInputStream();
			
			this.isConnected = true;
		}catch(IOException e){
			e.printStackTrace();
			throw new CommunicationException(e);
		}
	}
	
	public void write(byte [] data) throws CommunicationException{
		try {
			this.clientOutputStream.write(data);
		} catch (IOException e) {
			e.printStackTrace();
			throw new CommunicationException(e);
		}
	}
	
	public byte [] read() throws CommunicationException{
		try{
			byte [] buffer = new byte[256];
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			int len = this.clientInputStream.read(buffer);
			if ( len < 0){
				this.isConnected = false;
				
			}
			outputStream.write(buffer, 0, len);
			
			return outputStream.toByteArray();
		}catch(SocketException e){
			this.isConnected = false;
			throw new ClientDisconnectedException("Client disconnected",e);
			
		}catch(IOException e){
			e.printStackTrace();
			throw new CommunicationException(e);
		}
	}

	@Override
	public void shutdown() {
		try{			
//			serverSocket.close();
			client.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
}
