package game_client;

import game_client.Character.CharacterState;

public class PlayerGesture {
	
	
	public synchronized void MoveUpRight(Player player) {
		if(player.getStatement() == CharacterState.UP)return;
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				player.setStatement(CharacterState.UP);
				player.setPosture(player.getJump_right()[0]);
				
				GamePanel.Sleep(100);
				player.setY(player.getY()-100);
				player.setX(player.getX()+50);
				player.setPosture(player.getJump_right()[1]);
				GamePanel.Sleep(100);
				player.setY(player.getY()-100);
				player.setX(player.getX()+50);
				player.setPosture(player.getJump_right()[2]);
				GamePanel.Sleep(100);
				player.setY(player.getY());
				player.setX(player.getX()+50);
				player.setPosture(player.getJump_right()[3]);
				GamePanel.Sleep(100);
				player.setX(player.getX()+50);
				player.setPosture(player.getJump_right()[4]);
				
				GamePanel.Sleep(100);
				player.setPosture(player.getJump_right()[3]);
				player.setX(player.getX()+100);
				player.setY(GamePanel.PLAYER_Y);
				
				GamePanel.Sleep(100);
				player.setPosture(player.getStand());
				player.setStatement(CharacterState.NONE);
				
			}
		});
		
		t.start();
	}
	
	public synchronized void MoveUpLeft(Player player) {
		if(player.getStatement() == CharacterState.UP)return;
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				player.setStatement(CharacterState.UP);
				player.setPosture(player.getJump_right()[0]);
				
				GamePanel.Sleep(100);
				player.setY(player.getY()-100);
				player.setX(player.getX()-50);
				player.setPosture(player.getJump_right()[1]);
				GamePanel.Sleep(100);
				player.setY(player.getY()-100);
				player.setX(player.getX()-50);
				player.setPosture(player.getJump_right()[2]);
				GamePanel.Sleep(100);
				player.setY(player.getY());
				player.setX(player.getX()-50);
				player.setPosture(player.getJump_right()[3]);
				GamePanel.Sleep(100);
				player.setX(player.getX()-50);
				player.setPosture(player.getJump_right()[4]);
				
				GamePanel.Sleep(100);
				player.setPosture(player.getJump_right()[3]);
				player.setX(player.getX()-100);
				player.setY(GamePanel.PLAYER_Y);
				
				GamePanel.Sleep(100);
				player.setPosture(player.getStand());
				player.setStatement(CharacterState.NONE);
				
			}
		});
		
		t.start();
	}
	
	public synchronized void MoveRight(Player player) {
		player.setPosture(player.getWalk());
		player.setX(player.getX()+GamePanel.SCALE);
		player.setY(GamePanel.PLAYER_Y);
	
	}
	
	public synchronized void MoveDown(Player player) {
		player.setPosture(player.getDuck());
		player.setY(GamePanel.PLAYER_Y);
	}
	
	public synchronized void MoveLeft(Player player) {
		player.setPosture(player.getWalk_left());
		player.setX(player.getX()-GamePanel.SCALE);
		player.setY(GamePanel.PLAYER_Y);
	
	}
	
	public synchronized void MoveBlock(Player player) {
		player.setPosture(player.getBlock());
		player.setY(GamePanel.PLAYER_Y);
	}
	
	public synchronized void MoveUp(Player player) {
		if(player.getStatement() == CharacterState.UP)return;
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				player.setStatement(CharacterState.UP);
				player.setPosture(player.getJump()[0]);
				
				GamePanel.Sleep(100);
				player.setY(player.getY()-70);
				player.setPosture(player.getJump()[1]);
				
				GamePanel.Sleep(100);
				player.setY(player.getY()-140);
				
				GamePanel.Sleep(100);
				
				player.setPosture(player.getJump()[2]);
				player.setY(GamePanel.PLAYER_Y);
				
				player.setPosture(player.getStand());
				player.setStatement(CharacterState.NONE);
			}
		});
		t.start();
		
	}
	
	public synchronized void noMove(Player player) {
		player.setPosture(player.getStand());
		
	}
}
