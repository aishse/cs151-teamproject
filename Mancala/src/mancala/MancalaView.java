package mancala;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * View for Mancala game. Draws the game board based off a specified board layout strategy. 
 * 
 */
public class MancalaView extends JPanel {
	private BoardStyle layout; 

	private StonePit[][] boardPits; 
	
	private MancalaPit[] playerMancalas; 

	
	public MancalaView(BoardStyle l) {	
		layout = l;
	
		boardPits = new StonePit[2][6]; 
		playerMancalas = new MancalaPit[2]; 
		this.setLayout(null); 
		int xpos = BoardStyle.X_POS + 100; 
		int ypos = BoardStyle.Y_POS + BoardStyle.BOARD_HEIGHT - 100;
		
	
		
		playerMancalas[0] = new MancalaPit(BoardStyle.X_POS + BoardStyle.BOARD_WIDTH - 70, BoardStyle.Y_POS + 10); 
		playerMancalas[1] = new MancalaPit(BoardStyle.X_POS + 20, BoardStyle.Y_POS + 10); 
		
	
		// initialize player 1 stone pits
		for (int i = 0; i < 6; i++) {
			StonePit newpit = new StonePit(xpos, ypos, 0);
			newpit.setBounds(xpos, ypos, 60, 60);
			boardPits[0][i] = newpit;
			add(newpit); 
			
			xpos += 80; 
			
		}
		
		// initialize player 2 stone pits
		xpos = BoardStyle.X_POS + 100; 
		ypos = BoardStyle.Y_POS + 50;
		for (int i = 0; i < 6; i++) {
			StonePit newpit = new StonePit(xpos, ypos, 0);
			newpit.setBounds(xpos, ypos, 60, 60);
			boardPits[1][i] = newpit;
			add(newpit); 
			
			xpos += 80; 
		}
		
		
	    this.revalidate();
	    this.repaint();
	
	}
	
	/**
	 * Sets number of stones for each stone pit
	 * @param number
	 */
	public void initializeStonePits(int number) {
		for (int i = 0; i < boardPits.length; i++) {
			for (int j = 0; j < boardPits[0].length; j++) {
				boardPits[i][j].setStoneCount(number);
			}
		}
	}
	
	/**
	 * Updates all mancala pits in the view based off model data. 
	 * 
	 * @param model
	 */
	public void updateMancalaPits(int[][] model) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				if ((i == 1 && j == 6) || (i == 0 && j == 0)) {
					playerMancalas[i].setStones(model[i][j]);
				}
				else {
					boardPits[i][j].setStoneCount(model[i][j]); 
				}
			}
		}
		
		this.repaint(); 
		
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
		
		playerMancalas[0].draw(g2);
		playerMancalas[1].draw(g2);
		// pure gui layout
		layout.draw(g2);
	
	}
	
	
	
	
}
