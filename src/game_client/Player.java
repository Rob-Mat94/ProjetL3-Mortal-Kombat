package game_client;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player extends Character {

	
	/* Faire en fonction de l'ID */
	/* joueur 1 -> Sub zero */
	/* joueur 2 -> Scorpio */
	
	public Player(int x, int y,String id) {
		super(x, y,id);
		if(id.equals("Player1")) {
			stand = new ImageIcon(getClass().getResource("/subZero/stand.gif")).getImage();
			walk = new ImageIcon(getClass().getResource("/subZero/walk.gif")).getImage();
			
			walk_left = new ImageIcon(getClass().getResource("/subZero/sub_zero_walk_left.gif")).getImage();
			
			duck = new ImageIcon(getClass().getResource("/subZero/lock_ducked.gif")).getImage();
			block = new ImageIcon(getClass().getResource("/subZero/sub_block.gif")).getImage();
			block_down = new ImageIcon(getClass().getResource("/subZero/sub_block_down.gif")).getImage();
			
			jump[0] = new ImageIcon(getClass().getResource("/subZero/saut1_sub_zero.gif")).getImage();
			jump[1] = new ImageIcon(getClass().getResource("/subZero/saut2_sub_zero.gif")).getImage();
			jump[2] = new ImageIcon(getClass().getResource("/subZero/saut3_sub_zero.gif")).getImage();
			
			jump_right[0] = new ImageIcon(getClass().getResource("/subZero/jump_dia_1.gif")).getImage();
			jump_right[1] = new ImageIcon(getClass().getResource("/subZero/jump_dia_2.gif")).getImage();
			jump_right[2] = new ImageIcon(getClass().getResource("/subZero/jump_dia_3.gif")).getImage();
			jump_right[3] = new ImageIcon(getClass().getResource("/subZero/jump_dia_4.gif")).getImage();
			jump_right[4] = new ImageIcon(getClass().getResource("/subZero/jump_dia_5.gif")).getImage();
			
			
		}
		else
		{	
			
			stand = new ImageIcon(getClass().getResource("/Scorpio/scorpio_stand.gif")).getImage();
			walk = new ImageIcon(getClass().getResource("/Scorpio/scorpio_walking.gif")).getImage();
			walk_left = new ImageIcon(getClass().getResource("/Scorpio/scorpio_walk_left.gif")).getImage();
			duck = new ImageIcon(getClass().getResource("/Scorpio/scorpio_ducked.gif")).getImage();
			block =  new ImageIcon(getClass().getResource("/Scorpio/scorpio_block.gif")).getImage();
			block_down = new ImageIcon(getClass().getResource("/Scorpio/scorpio_down_block.gif")).getImage();
			
			jump[0] = new ImageIcon(getClass().getResource("/Scorpio/scor_saut1.gif")).getImage();
			jump[1] = new ImageIcon(getClass().getResource("/Scorpio/scor_saut2.gif")).getImage();
			jump[2] = new ImageIcon(getClass().getResource("/Scorpio/scor_saut3.gif")).getImage();
			
			jump_right[0] = new ImageIcon(getClass().getResource("/Scorpio/Ljump_scorpio_1.gif")).getImage();
			jump_right[1] = new ImageIcon(getClass().getResource("/Scorpio/Ljump_scorpio_2.gif")).getImage();
			jump_right[2] = new ImageIcon(getClass().getResource("/Scorpio/Ljump_scorpio_3.gif")).getImage();
			jump_right[3] = new ImageIcon(getClass().getResource("/Scorpio/Ljump_scorpio_4.gif")).getImage();
			jump_right[4] = new ImageIcon(getClass().getResource("/Scorpio/Ljump_scorpio_5.gif")).getImage();
			
		}
		this.posture = stand;
	}

}
