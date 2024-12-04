package mancala;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * View for Mancala game. Draws the game board based off a specified board layout strategy. 
 * 
 */
public class MancalaView extends JPanel implements StonePitListener {
	private BoardStyle layout; 

	private StonePit[][] boardPits; 
	
	private MancalaPit[] playerMancalas;
	private MancalaModel model;


	
	/**
	 * Constructor for MancalaView.
	 * It sets up the board layout, initializes the pits for both players, and adds them to the panel.
	 *
	 * @param l The BoardStyle to define the layout of the game board.
	 */
	public MancalaView() {	
		layout = null; 
	
	
		boardPits = new StonePit[2][6]; 
		playerMancalas = new MancalaPit[2]; 
		playerMancalas[0] = new MancalaPit(BoardStyle.X_POS + BoardStyle.BOARD_WIDTH - 70, BoardStyle.Y_POS + 10); 
		playerMancalas[1] = new MancalaPit(BoardStyle.X_POS + 20, BoardStyle.Y_POS + 10); 
		model = new MancalaModel(this);
	
	}
	
	/**
	 * Sets number of stones for each stone pit
	 * @param number
	 */
	public void initializeStonePits(int number) {
		this.setLayout(null); 
		int xpos = BoardStyle.X_POS + 100; 
		int ypos = BoardStyle.Y_POS + BoardStyle.BOARD_HEIGHT - 100;
		model.setStones(number);
	
		
		
	
		// initialize player 1 stone pits
		for (int i = 0; i < 6; i++) {
			StonePit newpit = new StonePit(xpos, ypos, 0, i, 0);
			newpit.setBounds(xpos, ypos, 60, 60);
			boardPits[0][i] = newpit;
			add(newpit); 
			newpit.addStonePitListener(this);
			xpos += 80; 
			
		}
		
		// initialize player 2 stone pits
		xpos = BoardStyle.X_POS + 100; 
		ypos = BoardStyle.Y_POS + 50;
		for (int i = 0; i < 6; i++) {
			StonePit newpit = new StonePit(xpos, ypos, 1, i, 0);
			newpit.setBounds(xpos, ypos, 60, 60);
			boardPits[1][i] = newpit;
			add(newpit); 
			newpit.addStonePitListener(this);
			
			xpos += 80; 
		}
		
		
	    
	    
		for (int i = 0; i < boardPits.length; i++) {
			for (int j = 0; j < boardPits[0].length; j++) {
				boardPits[i][j].setStoneCount(number);
	
			}
		}
		
		this.revalidate();
	    this.repaint();
	    
	
	}
	
	/**
	 * Initializes layout of the mancala board. 
	 * @param l
	 */
	public void setBoardStyle(BoardStyle l) {
		layout = l; 
		System.out.println("model layout is set1"); 
		this.repaint(); 
	}
	
	/**
	 * Updates all mancala pits in the view based off model data. 
	 * 
	 * @param model
	 */
	public void updateMancalaPits(int[][] model) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				if ((i == 0 && j == 6) || (i == 1 && j == 0)) {
					playerMancalas[i].setStones(model[i][j]);
				}
				else {
					boardPits[i][j].setStoneCount(model[i][j]); 
				}
			}
		}
		
		this.repaint(); 
		
	}
	public void updateMancalaPits() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				if ((i == 0 && j == 6) || (i == 1 && j == 0)) {
					playerMancalas[i].setStones(model.getValue(i, j));
				}
				else {
					if(i==0) {
						boardPits[i][j].setStoneCount(model.getValue(i, j));
					}
					else {
					boardPits[i][j-1].setStoneCount(model.getValue(i, j));
					}
				}
			}
		}
		
		this.repaint(); 
		
	}
	/**
	 * Customizes how the game board is drawn.
	 * This method is automatically called when the panel is refreshed.
	 *
	 * @param g The Graphics object used to draw components.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		if (layout != null) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g; 
			
			playerMancalas[0].draw(g2);
			playerMancalas[1].draw(g2);
			// pure gui layout
			
			layout.draw(g2);
		}

	}

	@Override
	public void clicked(StonePit pit) { 
		  System.out.println("Pit clicked!" + pit.getPlayer() + " " + pit.getColumn());
		  if (pit.getPlayer() == 0) {
			  model.move(0, pit.getColumn());
		  }
		  else {
			  model.move(1, pit.getColumn()+1);
		  }
		  updateMancalaPits();
	}
	
	
	
}
