package game_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.istack.internal.logging.Logger;

public class GameServer extends Thread {

	private final static int PORT = 3340;
	private final static int PLAYER_MAX = 2;
	private static int nb_player = 0;
	private boolean stop = false;
	private boolean gamestarted = false;
	ServerSocket serveur;

	@Override
	public void run() {
		try (ServerSocket serveur = new ServerSocket(PORT)) {
			while (!stop) {
				if (nb_player < PLAYER_MAX) {
					Socket player = serveur.accept();
					System.out.println("Player connected -> "+player.toString());
					nb_player++;
					new Thread(new HandlePlayer(player)).start();
				}
				else if(nb_player == PLAYER_MAX && !gamestarted) {
					GameModel.SendStart();
					gamestarted = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public synchronized static int getNbPlayer() {
		return nb_player;
	}

	public synchronized static int DecNbPlayer() {
		return nb_player--;
	}
}
