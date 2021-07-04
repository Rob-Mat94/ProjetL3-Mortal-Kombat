package game_server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import game_client.PlayerEvents;

public class GameOutput implements GameProtocol,PlayerEvents {
	PrintWriter os;

	public GameOutput(OutputStream out) throws IOException {
		this.os = new PrintWriter(out, true);
	}

	@Override
	public synchronized void sendStart(String name) {
		os.println("START");
		os.println(name);
		
	}

	@Override
	public synchronized void Time(String time) {
		os.println("TIME");
		os.println(time);
		
	}

	@Override
	public synchronized void RightPressed(String id) {
		os.println("RIGHT");
		os.println(id);
	}

	@Override
	public synchronized void LeftPressed(String id) {
		os.println("LEFT");
		os.println(id);
		
	}

	@Override
	public synchronized void UpPressed(String id) {
		os.println("UP");
		os.println(id);
		
	}

	@Override
	public synchronized void DownPressed(String id) {
		os.println("DOWN");
		os.println(id);
		
	}
	
	@Override
	public synchronized void BlockPressed(String id) {
		os.println("BLOCK");
		os.println(id);
		
	}
	
	@Override
	public void UpRightPressed(String id) {
		os.println("UP RIGHT JUMP");
		os.println(id);
		
	}
	
	@Override
	public void UpLeftPressed(String id) {
		os.println("UP LEFT JUMP");
		os.println(id);
		
	}
	
	
	@Override
	public synchronized void sendEnemyRight() {
		os.println("ENEMY MOVE RIGHT");
		
	}
	
	
	@Override
	public synchronized void sendRight(String id) {
		os.println("MOVE RIGHT");
	}
	
	@Override
	public synchronized void sendEnemyNoMove(String id) {
		os.println("NO MOVE");
		os.println(id);
	}

	@Override
	public synchronized void sendLeft(String id) {
		os.println("MOVE LEFT");
		
	}

	@Override
	public synchronized void sendEnemyLeft() {
		os.println("ENEMY MOVE LEFT");
		
	}
	
	@Override
	public synchronized void sendBlock(String id) {
		os.println("MOVE BLOCK");
		
	}

	@Override
	public synchronized void sendEnemyBlock() {
		os.println("ENEMY MOVE BLOCK");
		
	}
	
	@Override
	public synchronized void sendUp(String id) {
		os.println("MOVE UP");
		
	}

	@Override
	public synchronized void sendEnemyUp() {
		os.println("ENEMY MOVE UP");
		
	}

	@Override
	public synchronized void sendDown(String id) {
		os.println("MOVE DOWN");
		
	}

	@Override
	public synchronized void sendEnemyDown() {
		os.println("ENEMY MOVE DOWN");
		
	}
	
	@Override
	public void sendUpRight(String id) {
		os.println("MOVE UP RIGHT");
		
	}

	@Override
	public void sendEnemyUpRight() {
		os.println("ENEMY MOVE UP RIGHT");
		
	}
	
	@Override
	public void sendUpLeft(String id) {
		os.println("MOVE UP LEFT");
		
	}

	@Override
	public void sendEnemyUpLeft() {
		os.println("ENEMY MOVE UP LEFT");		
	}
	
	@Override
	public synchronized void None() {
		// TODO Auto-generated method stub
		
	}

	



	


	

	


	

	





	
}
	
	
	
	
	




	


	

	


	

	





	

