package game_server;

import java.io.IOException;
import java.net.InetAddress;

public class GameServerMain {
	public static void main(String[] args) {
		int PORT = 4212;
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
			GameServerCore core = new GameServerCore(PORT);
		} catch (IOException e) {
			System.out.println("Error during initialisation:" + e.toString());
		}
	}
}
