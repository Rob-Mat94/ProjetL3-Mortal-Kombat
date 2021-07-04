package game_server;

import game_client.Character.CharacterState;

public interface GameProtocol {
	public void sendStart(String name);
	public void Time(String time);
	
	public void sendRight(String id);
	public void sendEnemyRight();
	
	public void sendLeft(String id);
	public void sendEnemyLeft();
	
	public void sendUp(String id);
	public void sendEnemyUp();
	
	public void sendDown(String id);
	public void sendEnemyDown();
	
	public void sendEnemyNoMove(String id);
	
	public void sendBlock(String id);
	public void sendEnemyBlock();
	
	public void sendUpRight(String id);
	public void sendEnemyUpRight();
	
	public void sendUpLeft(String id);
	public void sendEnemyUpLeft();
	

	

}
