package game_client;

import javax.swing.JFrame;

import game_server.GameProtocol;

public class GameContent extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameProtocol handler;
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 800;
	private GamePanel panel;
	private PlayerEvents pe;
	private String id;

	public GameContent(GameProtocol handler,PlayerEvents pe,String id,GamePanel panel) {
		this.pe = pe;
		this.panel = panel;
		this.handler = handler;
		this.setTitle("MK Multiplayer / "+id);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(panel);
		new Thread(panel).start();
		this.addKeyListener(new KeyController(handler,pe));

	}

	public synchronized GamePanel getPanel() {
		return panel;
	}


	

}
