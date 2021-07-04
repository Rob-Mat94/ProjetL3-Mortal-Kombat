package game_client;

import java.awt.Image;

abstract public class Character {

	public enum CharacterState {
		UP("UpState"), DOWN("DownState"), RIGHT("RightState"), LEFT("LeftState"), NONE("None"), BLOCK("blockstate");

		private String state;

		private CharacterState(String state) {
			this.state = state;
		}

		public String getState() {
			return this.state;
		}
	}
	
	protected CharacterState statement = CharacterState.NONE;
	
	private int life = 100;
	private int x, y;

	protected Image posture;

	protected Image walk;
	protected Image walk_left;
	protected Image duck;
	protected Image stand;
	
	protected Image poing;

	protected Image[] jump = new Image[3];
	
	protected Image[] jump_right = new Image[5];

	protected Image block;
	protected Image block_down;

	protected String id;

	protected Character(int x, int y, String id) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public synchronized int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public synchronized int getY() {
		return y;
	}

	public synchronized void setY(int y) {
		this.y = y;
	}

	public synchronized int getLife() {
		return life;
	}

	public synchronized void setLife(int life) {
		this.life = life;
	}

	public synchronized Image getPosture() {
		return posture;
	}

	public synchronized Image getWalk() {
		return walk;
	}

	public synchronized Image getStand() {
		return stand;
	}

	public synchronized void setPosture(Image posture) {
		this.posture = posture;
	}

	public synchronized Image getWalk_left() {
		return walk_left;
	}

	public synchronized Image getDuck() {
		return duck;
	}

	public synchronized Image getBlock() {
		return block;
	}

	public synchronized Image getBlock_down() {
		return block_down;
	}

	public synchronized Image[] getJump() {
		return jump;
	}
	
	public synchronized CharacterState getStatement() {
		return statement;
	}

	public synchronized void setStatement(CharacterState statement) {
		this.statement = statement;
	}

	public synchronized Image[] getJump_right() {
		return jump_right;
	}

	public synchronized Image getPoing() {
		return poing;
	}

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}
}
