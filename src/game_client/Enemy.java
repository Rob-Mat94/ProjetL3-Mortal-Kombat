package game_client;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy extends Character {
	
	/* Faire en fonction de l'ID */
	/* joueur 1 -> Sub zero */
	/* joueur 2 -> Scorpio */
	
	public Enemy(int x, int y,String id) {
		super(x, y,id);
		if(id.equals("Player1")) {
			
			stand = new ImageIcon(getClass().getResource("/Scorpio/scorpio_reverse_stand.gif")).getImage();
			walk =  new ImageIcon(getClass().getResource("/Scorpio/scorpio_reverse_walking.gif")).getImage();
			walk_left =  new ImageIcon(getClass().getResource("/Scorpio/scorpio_walk_left_reverse.gif")).getImage();
			duck =  new ImageIcon(getClass().getResource("/Scorpio/scorpio_ducked_reverse.gif")).getImage();
			block = new ImageIcon(getClass().getResource("/Scorpio/scorpio_block_reverse.gif")).getImage();
			block_down = new ImageIcon(getClass().getResource("/Scorpio/scorpio_down_block_reverse.gif")).getImage();
			
			jump[0] = new ImageIcon(getClass().getResource("/Scorpio/scor_saut1_reverse.gif")).getImage();
			jump[1] = new ImageIcon(getClass().getResource("/Scorpio/scor_saut2_reverse.gif")).getImage();
			jump[2] = new ImageIcon(getClass().getResource("/Scorpio/scor_saut3_reverse.gif")).getImage();
			
			jump_right[0] = new ImageIcon(getClass().getResource("/Scorpio/reverse_Ljump_scorpio_1.gif")).getImage();
			jump_right[1] = new ImageIcon(getClass().getResource("/Scorpio/reverse_Ljump_scorpio_2.gif")).getImage(); 
			jump_right[2] = new ImageIcon(getClass().getResource("/Scorpio/reverse_Ljump_scorpio_3.gif")).getImage(); 
			jump_right[3] = new ImageIcon(getClass().getResource("/Scorpio/reverse_Ljump_scorpio_4.gif")).getImage(); 
			jump_right[4] = new ImageIcon(getClass().getResource("/Scorpio/reverse_Ljump_scorpio_5.gif")).getImage(); 
			
		
		}
		else
		{	
			
			stand = new ImageIcon(getClass().getResource("/subZero/standReverse.gif")).getImage();
			walk =  new ImageIcon(getClass().getResource("/subZero/walk_reverse.gif")).getImage();
			walk_left = new ImageIcon(getClass().getResource("/subZero/sub_zero_walk_left _reverse.gif")).getImage();
			duck = new ImageIcon(getClass().getResource("/subZero/lock_ducked_reverse.gif")).getImage();
			block = new ImageIcon(getClass().getResource("/subZero/sub_block_reverse.gif")).getImage();
			block_down = new ImageIcon(getClass().getResource("/subZero/sub_block_down_revserse.gif")).getImage();
			
			jump[0] = new ImageIcon(getClass().getResource("/subZero/saut1_sub_zero_reverse.gif")).getImage();
			jump[1] = new ImageIcon(getClass().getResource("/subZero/saut2_sub_zero_reverse.gif")).getImage();
			jump[2] = new ImageIcon(getClass().getResource("/subZero/saut3_sub_zero_reverse.gif")).getImage();
			
			jump_right[0] = new ImageIcon(getClass().getResource("/subZero/reverse_jump_dia_1.gif")).getImage();
			jump_right[1] = new ImageIcon(getClass().getResource("/subZero/reverse_jump_dia_2.gif")).getImage(); 
			jump_right[2] = new ImageIcon(getClass().getResource("/subZero/reverse_jump_dia_3.gif")).getImage(); 
			jump_right[3] = new ImageIcon(getClass().getResource("/subZero/reverse_jump_dia_4.gif")).getImage(); 
			jump_right[4] = new ImageIcon(getClass().getResource("/subZero/reverse_jump_dia_5.gif")).getImage(); 
			
		
		}
		
		this.posture = stand;
	}

}
