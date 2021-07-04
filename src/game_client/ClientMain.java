package game_client;

import java.net.InetAddress;
import java.net.Socket;

public class ClientMain {
	
	private final static int  PORT =  4212;
	public static void main(String[] args) {
		try
		{	
			InetAddress dest = InetAddress.getByAddress(new byte[] {(byte)192,(byte)168,(byte)0,(byte)40});
			Socket sock = new Socket(dest,PORT);
			ClientHandleConnection h = new ClientHandleConnection(sock);
			h.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
