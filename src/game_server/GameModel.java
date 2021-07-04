package game_server;

import java.util.TreeMap;

import game_client.Character.CharacterState;
import game_client.Player;


/* A FACTORISER */

public class GameModel {
	public static final TreeMap<String, HandleClient> clientList = new TreeMap<>();
	

	public static synchronized void StartGame() {
		clientList.values().forEach(c -> c.sendStart(null));
	}

	public static synchronized void Timer(int time) {
		clientList.values().forEach(c -> c.Time(Integer.toString(time)));
	}
	
	public static synchronized void sendRight(String id) {
		if (id.equals("Player1")) {
			clientList.get(id).Rightsent();
			clientList.get("Player2").EnemyRightSent();
		} else {
			clientList.get(id).Rightsent();
			clientList.get("Player1").EnemyRightSent();
		}
	}
	
	public static synchronized void sendUpRight(String id) {
		if (id.equals("Player1")) {
			clientList.get(id).UpRightSent();
			clientList.get("Player2").EnemyUpRightSent();
		} else {
			clientList.get(id).UpRightSent();
			clientList.get("Player1").EnemyUpRightSent();
		}
	}
	
	public static synchronized void sendUpLeft(String id) {
		if (id.equals("Player1")) {
			clientList.get(id).UpLeftSent();
			clientList.get("Player2").EnemyUpLeftSent();
		} else {
			clientList.get(id).UpLeftSent();
			clientList.get("Player1").EnemyUpLeftSent();
		}
	}
	
	
	public static synchronized void sendUp(String id) {
		if (id.equals("Player1")) {
			clientList.get(id).Upsent();
			clientList.get("Player2").EnemyUpSent();
		} else {
			clientList.get(id).Upsent();
			clientList.get("Player1").EnemyUpSent();
		}
	}
	
	public static synchronized void sendDown(String id) {
		if (id.equals("Player1")) {
			clientList.get(id).Downsent();
			clientList.get("Player2").EnemyDownSent();
		} else {
			clientList.get(id).Downsent();
			clientList.get("Player1").EnemyDownSent();
		}
	}
	
	public static synchronized void sendBlock(String id) {
		if (id.equals("Player1")) {
			clientList.get(id).BlockSent();
			clientList.get("Player2").EnemyBlockSent();
		} else {
			clientList.get(id).BlockSent();
			clientList.get("Player1").EnemyBlockSent();
		}
	}
	
	public static synchronized void sendLeft(String id) {
		if (id.equals("Player1")) {
			clientList.get(id).Leftsent();
			clientList.get("Player2").EnemyLeftSent();
		} else {
			clientList.get(id).Leftsent();
			clientList.get("Player1").EnemyLeftSent();
		}
	}

	public static synchronized void sendNoMove(String id) {
		if (id.equals("Player1")) {
			clientList.get(id).EnemyNoMoveSent();

		} else {
			clientList.get("Player2").EnemyNoMoveSent();
		}
	}

}
























