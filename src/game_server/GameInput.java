 package game_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class GameInput {
	GameProtocol handler;
	InputStream in;

	public GameInput(InputStream in, GameProtocol handler) throws IOException {
		this.in = in;
		this.handler = handler;
	}

	public void doRun() throws IOException {
	
		boolean stop = false;

		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			while (!stop) {
				String line = is.readLine();
				String time,name,id;
				switch(line) {
				case "START":
					name = is.readLine();
					handler.sendStart(name);
					break;
				case "TIME":
					time = is.readLine();
					handler.Time(time);
					break;
				case "RIGHT":
					id = is.readLine();
					handler.sendRight(id);
					break;
				case "UP RIGHT JUMP":
					id = is.readLine();
					handler.sendUpRight(id);
					break;
				case "UP LEFT JUMP":
					id = is.readLine();
					handler.sendUpLeft(id);
					break;
				case "LEFT":
					id = is.readLine();
					handler.sendLeft(id);
					break;
				case "UP":
					id = is.readLine();
					handler.sendUp(id);
					break;
				case "DOWN":
					id = is.readLine();
					handler.sendDown(id);
					break;
				case "ENEMY MOVE RIGHT":
					handler.sendEnemyRight();
					break;
				case "MOVE RIGHT":
					handler.sendRight(null);
					break;
				case "MOVE UP":
					handler.sendUp(null);
					break;
				case "ENEMY MOVE UP":
					handler.sendEnemyUp();
					break;	
				case "MOVE LEFT":
					handler.sendLeft(null);
					break;
				case "ENEMY MOVE LEFT":
					handler.sendEnemyLeft();
					break;
				case "MOVE DOWN":
					handler.sendDown(null);
					break;
				case "ENEMY MOVE DOWN":
					handler.sendEnemyDown();
					break;
				case "MOVE UP RIGHT":
					handler.sendUpRight(null);
					break;
				case "ENEMY MOVE UP RIGHT":
					handler.sendEnemyUpRight();
					break;
				case "ENEMY MOVE UP LEFT":
					handler.sendEnemyUpLeft();
					break;
				case "MOVE UP LEFT":
					handler.sendUpLeft(null);
					break;
				case "BLOCK":
					id = is.readLine();
					handler.sendBlock(id);
					break;
				case "MOVE BLOCK":
					handler.sendBlock(null);
					break;
				case "ENEMY MOVE BLOCK":
					handler.sendEnemyBlock();
					break;
				case "NO MOVE":
					id = is.readLine();
					handler.sendEnemyNoMove(id);
					break;
				default:
					throw new IOException();
				}
			
				}
			}
		}
}
