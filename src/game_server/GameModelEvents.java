package game_server;

public interface GameModelEvents {
	public void Rightsent();
	public void Downsent();
	public void Upsent();
	public void Leftsent();
	
	
	public void BlockSent();
	
	public void EnemyRightSent();
	public void EnemyLeftSent();
	public void EnemyUpSent();
	public void EnemyDownSent();
	
	public void EnemyBlockSent();
	
	public void EnemyNoMoveSent();
	
	public void UpRightSent();
	public void EnemyUpRightSent();
	
	public void UpLeftSent();
	public void EnemyUpLeftSent();
}
