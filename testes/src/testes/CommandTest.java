package testes;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.esampaio.prototank.raspberry.comunication.ProtocolConstants;

public class CommandTest {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.printf("1-forward\n");
		System.out.printf("2-backward\n");
		System.out.printf("3-left\n");
		System.out.printf("4-right\n");
		System.out.printf("5-leds on\n");
		System.out.printf("6-leds off\n");
		System.out.printf("0-exit\n");
		String option="";
		
		Socket socket = new Socket("192.168.1.120", 5555);
		OutputStream outputStream = socket.getOutputStream();
		
		byte [] forwardRequest = {ProtocolConstants.COMMAND,0x00,0x01,ProtocolConstants.MOVE_FORWARD,0x00,0x00,ProtocolConstants.END_PACKAGE};
		byte [] backwardRequest = {ProtocolConstants.COMMAND,0x00,0x02,ProtocolConstants.MOVE_BACKWARD,0x00,0x00,ProtocolConstants.END_PACKAGE};
		byte [] leftRequest = {ProtocolConstants.COMMAND,0x00,0x03,ProtocolConstants.MOVE_LEFT,0x00,0x00,ProtocolConstants.END_PACKAGE};
		byte [] rightRequest = {ProtocolConstants.COMMAND,0x00,0x04,ProtocolConstants.MOVE_RIGHT,0x00,0x00,ProtocolConstants.END_PACKAGE};
		byte [] ledsOnRequest = {ProtocolConstants.COMMAND,0x00,0x05,ProtocolConstants.LEDS_ON,0x00,0x00,ProtocolConstants.END_PACKAGE};
		byte [] ledsOffRequest = {ProtocolConstants.COMMAND,0x00,0x06,ProtocolConstants.LEDS_OFF,0x00,0x00,ProtocolConstants.END_PACKAGE};
		
		do{
			option = scanner.nextLine();
			if ( option.startsWith("1")){
				
				outputStream.write(forwardRequest);
				
			}else if ( option.startsWith("2")){
				
				outputStream.write(backwardRequest);
			}else if ( option.startsWith("3")){
				
				outputStream.write(leftRequest);
			
			}else if ( option.startsWith("4")){
				outputStream.write(rightRequest);
							 
			}else if ( option.startsWith("5")){
				outputStream.write(ledsOnRequest);
						
			}else if ( option.startsWith("6")){
				outputStream.write(ledsOffRequest);		
			} 
		}while(!option.startsWith("0"));
		
		outputStream.close();
		socket.close();
	}
}
