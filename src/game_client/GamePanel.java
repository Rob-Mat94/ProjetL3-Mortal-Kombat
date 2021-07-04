package game_client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import game_client.Character.CharacterState;

public class GamePanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* PLAYER GESTURE ET ENEMY GESTURE A FACTORISER */
	PlayerGesture pGesture;
	EnemyGesture eGesture;
	
	public final static int PLAYER_X = GameContent.WIDTH/20;
	public final static int PLAYER_Y = GameContent.HEIGHT - GameContent.HEIGHT/3;
	public final static int ENEMY_X = GameContent.WIDTH -GameContent.WIDTH/7;
	public final static int ENEMY_Y = GameContent.HEIGHT - GameContent.HEIGHT/3;
	
	private static String RoundTime = "300";
	private String id;
	Font timer_font = new Font("Arial", Font.BOLD, 50);
	
	private static Player player;
	private static Enemy enemy ;
	private Image map = new ImageIcon(getClass().getResource("/map.png")).getImage();
	
	public final static int SCALE = 10;

	public static synchronized void setRoundTime(String roundTime) {
		RoundTime = roundTime;
	}

	public GamePanel(String playerId) {
		this.id = playerId;
		player = new Player(PLAYER_X,PLAYER_Y,id);
		enemy = new Enemy(ENEMY_X,ENEMY_Y,id);
	}
	
	
	@Override
	public synchronized void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(map,0,0,GameContent.WIDTH,GameContent.HEIGHT,this);
		drawProps(g2);
		g2.drawImage(player.getPosture(),player.getX(),player.getY(),150,150,this);
		g2.drawImage(enemy.getPosture(),enemy.getX(),enemy.getY(),150,150,this);
	}

	
	public synchronized void drawProps(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(timer_font);
		g.drawString(RoundTime, GameContent.WIDTH / 2 - GameContent.WIDTH / 20 , GameContent.HEIGHT / 6);
		g.setColor(Color.DARK_GRAY);
		g.drawString(Integer.toString(player.getLife()), 5, 40);
		g.drawString(Integer.toString(enemy.getLife()), GameContent.WIDTH - 100, 40);

	}
	
	public synchronized void MoveRight() {
		pGesture.MoveRight(player);
	
	}
	
	public synchronized void MoveDown() {
		pGesture.MoveDown(player);
	}
	
	public synchronized void MoveLeft() {
		pGesture.MoveLeft(player);
	
	}
	
	public synchronized void MoveBlock() {
		pGesture.MoveBlock(player);
	}
	
	public synchronized void EnemyMoveBlock() {
		eGesture.EnemyMoveBlock(enemy);
	}
	
	/**********************************/
	
	public synchronized void EnemyMoveUp() {
		eGesture.EnemyMoveUp(enemy);
	}
	
	public synchronized static Enemy getEnemy() {
		return enemy;
	}

	public synchronized void MoveUp() {
		
		pGesture.MoveUp(player);
	}
	
	public synchronized void MoveUpRight() {
		
		pGesture.MoveUpRight(player);
	}
	
	public synchronized void EnemyMoveUpRight() {
		
		eGesture.EnemyMoveUpRight(enemy);
	}
	
	public synchronized void MoveUpLeft() {
		pGesture.MoveUpLeft(player);
	}
	
	public synchronized void EnemyMoveUpLeft() {
		eGesture.EnemyMoveUpLeft(enemy);
	}
	
	/*****************************************/
	
	public synchronized void EnemyMoveLeft() {
		eGesture.EnemyMoveLeft(enemy);
		
	}
	
	
	public synchronized void EnemyMoveRight() {
		eGesture.EnemyMoveRight(enemy);
		
	}
	
	public synchronized void EnemyMoveDown() {
		eGesture.EnemyMoveDown(enemy);
		
	}
	
	public synchronized void noMove() {
		pGesture.noMove(player);
		
	}
	
	public synchronized void noEnemyMove() {
		eGesture.noEnemyMove(enemy);
	}
	
	@Override
	public void run() {
		eGesture = new EnemyGesture();
		pGesture = new PlayerGesture();
		while (true) {
			try {
				repaint();
				Thread.sleep(1000 / 60l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
	
	public synchronized static Player getPlayer() {
		return player;
	}

	public static synchronized void Sleep(int timer) {
		try {
			Thread.sleep(timer);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
