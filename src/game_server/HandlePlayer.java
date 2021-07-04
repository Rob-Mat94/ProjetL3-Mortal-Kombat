package game_server;

import java.io.IOException;
import java.net.Socket;

public class HandlePlayer implements Runnable, GameProtocol,GameModelEvents {

	private final Socket player;
	private GameInput in;
	private GameOutput out;

	private boolean running = false;

	public HandlePlayer(Socket player) {
		this.player = player;
		GameModel.AddPlayer(GameServer.getNbPlayer(), this);
	}

	@Override
	public void run() {
		try {
			in = new GameInput(this, player.getInputStream());
			out = new GameOutput(player.getOutputStream());
			in.ReadRun();

		} catch (IOException e) {
			if(!running)
				finish();
		}

	}

	public synchronized void finish() {
		if (!running) {
			running = true;
			try {
				player.close();
				GameServer.DecNbPlayer();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}

	@Override
	public void sendStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void sendPlayer1() {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void sendPlayer2() {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void sendPlayer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Right() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Left() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Up() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Down() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RightSent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LeftSent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpSent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DownSent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void StartSent() {
		out.sendStart();
	}

}
