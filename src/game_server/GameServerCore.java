package game_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

public class GameServerCore extends Thread {
	private int port;
	ServerSocket ss;
	private boolean stop = false;
	
	private boolean gamestarted = false;
	private int nb_player = 1;
	private String player_name;

	public GameServerCore(int port) throws IOException {
		this.port = port;
		this.start();
	}

	@Override
	public void run() {
		try (ServerSocket ss = new ServerSocket(port)) {
			ss.setSoTimeout(1000);
			while (!stop) {	
				try {
					
					if(nb_player <= 2) {
						Socket s = ss.accept();
						System.out.println("New Player --> "+s.toString());
					
						new Thread(new HandleClient(s,"Player"+Integer.toString(nb_player))).start();
						
						nb_player++;
					}
					else if(nb_player == 3 && !gamestarted) {
						GameModel.StartGame();
						gamestarted = true;
						new Thread(new Runnable() {
							@Override
							public void run() {
								int i = 300;
								while(true) {
									try
									{	
										GameModel.Timer(i);
										Thread.sleep(1000);
										i = i - 1;
										
									}
									catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
							
						}).start();
					}
				
				
				
					
				} catch (SocketTimeoutException ex) {
									}
			}
		} catch (IOException e) {
			System.out.println("Could not bind port " + port);
			Logger.getLogger(GameServerCore.class.getName(), null).log(Level.SEVERE, null, e);
		}
	}

}
