package game_client;

import java.io.IOException;
import java.net.Socket;

import game_client.Character.CharacterState;
import game_server.GameInput;
import game_server.GameOutput;
import game_server.GameProtocol;

public class ClientHandleConnection extends Thread implements GameProtocol, PlayerEvents {

	private Socket player;
	private GameInput in;
	private GameOutput out;
	private GameContent content;
	private GamePanel panel;
	private String id = "";

	public ClientHandleConnection(Socket player) {
		super();
		this.player = player;
	}

	@Override
	public void run() {
		try (Socket s1 = player) {
			in = new GameInput(s1.getInputStream(), this);
			out = new GameOutput(s1.getOutputStream());

			in.doRun();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void sendStart(String name) {
		this.id = name;
		this.panel = new GamePanel(id);
		content = new GameContent(this, this, id, this.panel);

	}

	@Override
	public synchronized void Time(String time) {
		GamePanel.setRoundTime(time);

	}

	@Override
	public synchronized void RightPressed(String id) {
		if (GamePanel.getPlayer().getStatement() == CharacterState.RIGHT)
			return;
		if (GamePanel.getPlayer().getStatement() == CharacterState.UP)
			return;

		GamePanel.getPlayer().setStatement(CharacterState.RIGHT);
		out.RightPressed(this.id);
	}

	@Override
	public synchronized void LeftPressed(String id) {
		if (GamePanel.getPlayer().getStatement() == CharacterState.LEFT)
			return;
		if (GamePanel.getPlayer().getStatement() == CharacterState.UP)
			return;

		GamePanel.getPlayer().setStatement(CharacterState.LEFT);
		out.LeftPressed(this.id);

	}

	@Override
	public void UpLeftPressed(String id) {
		out.UpLeftPressed(this.id);

	}

	@Override
	public synchronized void UpPressed(String id) {
		if (GamePanel.getPlayer().getStatement() == CharacterState.DOWN)
			return;
		out.UpPressed(this.id);

	}

	@Override
	public synchronized void DownPressed(String id) {
		if (GamePanel.getPlayer().getStatement() == CharacterState.DOWN)
			return;
		if (GamePanel.getPlayer().getStatement() == CharacterState.UP)
			return;
		GamePanel.getPlayer().setStatement(CharacterState.DOWN);
		out.DownPressed(this.id);

	}

	@Override
	public synchronized void BlockPressed(String id) {
		if (GamePanel.getPlayer().getStatement() == CharacterState.BLOCK)
			return;
		if (GamePanel.getPlayer().getStatement() == CharacterState.UP)
			return;

		GamePanel.getPlayer().setStatement(CharacterState.BLOCK);
		out.BlockPressed(this.id);

	}

	@Override
	public void UpRightPressed(String id) {
		out.UpRightPressed(this.id);

	}
	
	/*
	@Override
	public void FistPressed(String id, int coordX, int coordY,String state) {
		out.FistPressed(this.id, GamePanel.getPlayer().getX(), GamePanel.getPlayer().getY(), GamePanel.getPlayer().getStatement().getState());
		
	}
	*/

	@Override
	public synchronized void sendRight(String id) {
		this.panel.MoveRight();
		GamePanel.getPlayer().setStatement(CharacterState.NONE);

	}

	@Override
	public synchronized void sendEnemyRight() {
		GamePanel.getEnemy().setStatement(CharacterState.RIGHT);
		this.panel.EnemyMoveRight();

	}

	/*************************************/
	@Override
	public synchronized void None() {
		panel.noMove();
		// out.sendEnemyNoMove(this.id);
	}

	/*************************************/

	@Override
	public synchronized void sendEnemyNoMove(String id) {
		GamePanel.getEnemy().setStatement(CharacterState.NONE);
		panel.noEnemyMove();

	}

	@Override
	public synchronized void sendLeft(String id) {
		this.panel.MoveLeft();
		GamePanel.getPlayer().setStatement(CharacterState.NONE);

	}

	@Override
	public synchronized void sendEnemyLeft() {
		GamePanel.getEnemy().setStatement(CharacterState.LEFT);
		this.panel.EnemyMoveLeft();

	}

	@Override
	public synchronized void sendDown(String id) {
		this.panel.MoveDown();
		GamePanel.getPlayer().setStatement(CharacterState.NONE);

	}

	@Override
	public synchronized void sendEnemyDown() {
		GamePanel.getEnemy().setStatement(CharacterState.DOWN);
		this.panel.EnemyMoveDown();

	}

	@Override
	public synchronized void sendBlock(String id) {
		this.panel.MoveBlock();
		GamePanel.getPlayer().setStatement(CharacterState.NONE);

	}

	@Override
	public synchronized void sendEnemyBlock() {
		GamePanel.getEnemy().setStatement(CharacterState.BLOCK);
		this.panel.EnemyMoveBlock();

	}

	@Override
	public synchronized void sendUp(String id) {
		this.panel.MoveUp();

	}

	@Override
	public synchronized void sendEnemyUp() {
		this.panel.EnemyMoveUp();

	}

	@Override
	public void sendUpRight(String id) {
		this.panel.MoveUpRight();

	}

	@Override
	public void sendEnemyUpRight() {
		this.panel.EnemyMoveUpRight();

	}

	@Override
	public void sendUpLeft(String id) {
		this.panel.MoveUpLeft();
	}

	@Override
	public void sendEnemyUpLeft() {
		this.panel.EnemyMoveUpLeft();

	}

}
