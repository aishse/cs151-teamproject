package mancala;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class MancalaView extends JPanel {
	private BoardStyle layout; 
	private MancalaModel model;
	private StonePit[][] boardPits; 
	
	private MancalaPit player1Mancala; 
	private MancalaPit player2Mancala; 
	
	public MancalaView(BoardStyle l, MancalaModel m) {	
		layout = l;
		model = m;
		boardPits = new StonePit[2][6]; 
		
		this.setLayout(null); 
		int xpos = BoardStyle.X_POS + 100; 
		int ypos = BoardStyle.Y_POS + BoardStyle.BOARD_HEIGHT - 100;
		int numstones = 0; 
		
		do {
			Scanner input = new Scanner(System.in); 
			System.out.print("Enter number of stones to start (3 or 4): "); 
			
			numstones = input.nextInt(); 
		}
		while(numstones != 3 && numstones != 4); 
		
		player1Mancala = new MancalaPit(BoardStyle.X_POS + BoardStyle.BOARD_WIDTH - 70, BoardStyle.Y_POS + 10); 
		player2Mancala = new MancalaPit(BoardStyle.X_POS + 20, BoardStyle.Y_POS + 10); 

		// initialize player 1 stone pits
		for (int i = 0; i < 6; i++) {
			StonePit newpit = new StonePit(xpos, ypos, numstones);
			newpit.setBounds(xpos, ypos, 60, 60);
			boardPits[0][i] = newpit;
			add(newpit); 
			
			xpos += 80; 
			
		}
		
		// initialize player 2 stone pits
		xpos = BoardStyle.X_POS + 100; 
		ypos = BoardStyle.Y_POS + 50;
		for (int i = 0; i < 6; i++) {
			StonePit newpit = new StonePit(xpos, ypos, numstones);
			newpit.setBounds(xpos, ypos, 60, 60);
			boardPits[1][i] = newpit;
			add(newpit); 
			
			xpos += 80; 
		}
		
		
	    this.revalidate();
	    this.repaint();
		boolean endgame = false; 
		
		// GAME LOOP GOES HERE
	
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
		
		player1Mancala.draw(g2);
		player2Mancala.draw(g2);
		// pure gui layout
		layout.draw(g2);
	
	}
	
	
	
	
}
