package game_client;

public interface PlayerEvents {
	public void RightPressed(String id);

	public void LeftPressed(String id);

	public void UpPressed(String id);

	public void DownPressed(String id);
	
	public void BlockPressed(String id);
	
	public void None();
	
	public void UpRightPressed(String id);
	public void UpLeftPressed(String id);
	
	// public void FistPressed(String id, int coordX, int coordY,String state);
	
	
	
	
}
