package game_client;

import game_client.Character.CharacterState;

public class EnemyGesture {

	public synchronized void EnemyMoveBlock(Enemy enemy) {
		enemy.setPosture(enemy.getBlock());
		enemy.setY(GamePanel.ENEMY_Y);
	}

	public synchronized void EnemyMoveUp(Enemy enemy) {
		if (enemy.getStatement() == CharacterState.UP)
			return;
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				enemy.setStatement(CharacterState.UP);
				enemy.setPosture(enemy.getJump()[0]);

				GamePanel.Sleep(100);

				enemy.setY(enemy.getY() - 70);
				enemy.setPosture(enemy.getJump()[1]);

				GamePanel.Sleep(100);
				enemy.setY(enemy.getY() - 140);

				GamePanel.Sleep(100);

				enemy.setPosture(enemy.getJump()[2]);
				enemy.setY(GamePanel.ENEMY_Y);

				enemy.setPosture(enemy.getStand());
				enemy.setStatement(CharacterState.NONE);
			}
		});
		t.start();
	}
	
	public synchronized void EnemyMoveUpRight(Enemy enemy) {
		if(enemy.getStatement() == CharacterState.UP)return;
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				enemy.setStatement(CharacterState.UP);
				enemy.setPosture(enemy.getJump_right()[0]);
				
				GamePanel.Sleep(100);
				enemy.setY(enemy.getY()-100);
				enemy.setX(enemy.getX()-50);
				enemy.setPosture(enemy.getJump_right()[1]);
				GamePanel.Sleep(100);
				enemy.setY(enemy.getY()-100);
				enemy.setX(enemy.getX()-50);
				enemy.setPosture(enemy.getJump_right()[2]);
				GamePanel.Sleep(100);
				enemy.setY(enemy.getY());
				enemy.setX(enemy.getX()-50);
				enemy.setPosture(enemy.getJump_right()[3]);
				GamePanel.Sleep(100);
				enemy.setX(enemy.getX()-50);
				enemy.setPosture(enemy.getJump_right()[4]);
				
				GamePanel.Sleep(100);
				enemy.setPosture(enemy.getJump_right()[3]);
				enemy.setX(enemy.getX()-100);
				enemy.setY(GamePanel.PLAYER_Y);
				
				GamePanel.Sleep(100);
				enemy.setPosture(enemy.getStand());
				enemy.setStatement(CharacterState.NONE);
				
			}
		});
		
		t.start();
	}
	
	public synchronized void EnemyMoveUpLeft(Enemy enemy) {
		if(enemy.getStatement() == CharacterState.UP)return;
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				enemy.setStatement(CharacterState.UP);
				enemy.setPosture(enemy.getJump_right()[0]);
				
				GamePanel.Sleep(100);
				enemy.setY(enemy.getY()-100);
				enemy.setX(enemy.getX()+50);
				enemy.setPosture(enemy.getJump_right()[1]);
				GamePanel.Sleep(100);
				enemy.setY(enemy.getY()-100);
				enemy.setX(enemy.getX()+50);
				enemy.setPosture(enemy.getJump_right()[2]);
				GamePanel.Sleep(100);
				enemy.setY(enemy.getY());
				enemy.setX(enemy.getX()+50);
				enemy.setPosture(enemy.getJump_right()[3]);
				GamePanel.Sleep(100);
				enemy.setX(enemy.getX()+50);
				enemy.setPosture(enemy.getJump_right()[4]);
				
				GamePanel.Sleep(100);
				enemy.setPosture(enemy.getJump_right()[3]);
				enemy.setX(enemy.getX()+100);
				enemy.setY(GamePanel.PLAYER_Y);
				
				GamePanel.Sleep(100);
				enemy.setPosture(enemy.getStand());
				enemy.setStatement(CharacterState.NONE);
				
			}
		});
		
		t.start();
	}
	public synchronized void EnemyMoveLeft(Enemy enemy) {
		enemy.setPosture(enemy.getWalk_left());
		enemy.setX(enemy.getX() + GamePanel.SCALE);
		enemy.setY(GamePanel.ENEMY_Y);

	}

	public synchronized void EnemyMoveRight(Enemy enemy) {
		enemy.setPosture(enemy.getWalk());
		enemy.setX(enemy.getX() - GamePanel.SCALE);
		enemy.setY(GamePanel.ENEMY_Y);

	}

	public synchronized void EnemyMoveDown(Enemy enemy) {
		enemy.setPosture(enemy.getDuck());
		enemy.setY(GamePanel.ENEMY_Y);

	}

	public synchronized void noEnemyMove(Enemy enemy) {
		enemy.setPosture(enemy.getStand());
		enemy.setY(GamePanel.ENEMY_Y);
	}
}
