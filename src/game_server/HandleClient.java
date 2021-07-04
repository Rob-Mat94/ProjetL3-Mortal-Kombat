package game_server;

import java.io.IOException;
import java.net.Socket;

public class HandleClient implements Runnable, GameProtocol,GameModelEvents {
	
	private final Socket s;
    private GameOutput go;
    private GameInput gi;
	private String name = "";
	
	private boolean stop = false;

	
	public HandleClient(Socket s, String name) throws IOException {
		this.s = s;
		this.name = name;
		GameModel.clientList.put(name,this);
	}
	
	@Override
	public void run() {
		try (Socket s1 = s) {
			go = new GameOutput(s1.getOutputStream());
			gi = new GameInput(s1.getInputStream(), this);
			gi.doRun();
		} catch (IOException ex) {
			if (!stop) {
				finish();
			}
		}
		
	}
	
	public synchronized void finish() {
		if (!stop) {
			stop = true;
			try {
				s.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void sendStart(String name) {
		go.sendStart(this.name);
	}

	@Override
	public synchronized void Time(String time) {
		go.Time(time);
		
	}
	
	@Override
	public synchronized void sendEnemyNoMove(String id) {
		GameModel.sendNoMove(id);
	}
	
	@Override
	public void EnemyNoMoveSent() {
		go.sendEnemyNoMove(this.name);
		
	}
	
	@Override
	public synchronized void sendRight(String id) {
		GameModel.sendRight(id);
		
	}
	
	@Override
	public synchronized void sendLeft(String id) {
		GameModel.sendLeft(id);
		
	}
	
	@Override
	public synchronized void sendUp(String id) {
		GameModel.sendUp(id);
		
	}
	
	@Override
	public synchronized void sendDown(String id) {
		GameModel.sendDown(id);
		
	}
	
	@Override
	public synchronized void sendBlock(String id) {
		GameModel.sendBlock(id);
		
	}
	
	@Override
	public void sendUpRight(String id) {
		GameModel.sendUpRight(id);
		
	}
	
	@Override
	public void sendUpLeft(String id) {
		GameModel.sendUpLeft(id);
		
	}
	@Override
	public void sendEnemyUpRight() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public synchronized void Rightsent() {
		go.sendRight(null);
		
	}

	@Override
	public synchronized void EnemyRightSent() {
		go.sendEnemyRight();
	}
	
	@Override
	public synchronized void BlockSent() {
		go.sendBlock(null);
		
	}

	@Override
	public synchronized void EnemyBlockSent() {
		go.sendEnemyBlock();
		
	}
	
	@Override
	public synchronized void Leftsent() {
		go.sendLeft(null);
		
	}
	
	@Override
	public synchronized void EnemyLeftSent() {
		go.sendEnemyLeft();
		
	}

	@Override
	public synchronized void EnemyUpSent() {
		go.sendEnemyUp();
		
	}

	@Override
	public synchronized void Upsent() {
		go.sendUp(null);
		
	}
	
	@Override
	public synchronized void EnemyDownSent() {
		go.sendEnemyDown();
		
	}
	
	@Override
	public synchronized void Downsent() {
		go.sendDown(null);
		
	}

	
	@Override
	public synchronized void UpRightSent() {
		go.sendUpRight(null);
		
	}

	@Override
	public synchronized void EnemyUpRightSent() {
		go.sendEnemyUpRight();
		
	}
	
	
	@Override
	public synchronized  void UpLeftSent() {
		go.sendUpLeft(null);
		
	}

	@Override
	public synchronized void EnemyUpLeftSent() {
		go.sendEnemyUpLeft();
	}
	
	
	
	
	/*******************************************/
	/******************************************/
	
	@Override
	public synchronized void sendEnemyRight() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void sendEnemyLeft() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void sendEnemyUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEnemyDown() {
		// TODO Auto-generated method stub
		
	}

	

	

	@Override
	public void sendEnemyBlock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEnemyUpLeft() {
		// TODO Auto-generated method stub
		
	}

	

	

	



	

	



	


	

	

}
