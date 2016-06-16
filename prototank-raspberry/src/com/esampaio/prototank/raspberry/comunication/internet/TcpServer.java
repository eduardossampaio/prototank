package com.esampaio.prototank.raspberry.comunication.internet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.esampaio.prototank.raspberry.comunication.CommunicationException;

public class TcpServer extends Server{
	private int port;
	
	private ServerSocket serverSocket;
	private Socket client;
	private InputStream clientInputStream;
	private OutputStream clientOutputStream;
	public TcpServer(int port) {
		this.port = port;
	}
	
	public void start() throws CommunicationException{
		try{
			this.serverSocket = new ServerSocket(port);
			this.client = serverSocket.accept();
			
			this.clientOutputStream = client.getOutputStream();			
			this.clientInputStream = client.getInputStream();
			
			
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
			outputStream.write(buffer, 0, len);
			
			return outputStream.toByteArray();
		}catch(IOException e){
			e.printStackTrace();
			throw new CommunicationException(e);
		}
	}

	@Override
	public void shutdown() {
		try{
			client.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
}
