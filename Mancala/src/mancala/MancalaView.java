package mancala;
import javax.swing.*; 
import java.awt.*; 
import java.util.*;

public class MancalaView extends JPanel {
	private BoardStyle layout; 
	private MancalaModel model;
	private ArrayList<StonePit> player1Pits; 
	private ArrayList<StonePit> player2Pits; 
	private MancalaPit player1Mancala; 
	private MancalaPit player2Mancala; 
	
	public MancalaView(BoardStyle l, MancalaModel m) {	
		layout = l;
		model = m;
		
		int xpos = BoardStyle.X_POS + 100; 
		int ypos = BoardStyle.Y_POS + BoardStyle.BOARD_HEIGHT - 100;
		
		
		player1Pits = new ArrayList<StonePit>(); 
		player2Pits = new ArrayList<StonePit>(); 
		
		player1Mancala = new MancalaPit(BoardStyle.X_POS + BoardStyle.BOARD_WIDTH - 70, BoardStyle.Y_POS + 10); 
		player2Mancala = new MancalaPit(BoardStyle.X_POS + 20, BoardStyle.Y_POS + 10); 

		// initialize player 1 stone pits
		for (int i = 0; i < 6; i++) {
			player1Pits.add(new StonePit(xpos, ypos, 0));
			xpos += 80; 
		}
		
		// initialize player 2 stone pits
		xpos = BoardStyle.X_POS + 100; 
		ypos = BoardStyle.Y_POS + 50;
		for (int i = 0; i < 6; i++) {
			player2Pits.add(new StonePit(xpos, ypos, 0));
			xpos += 80; 
		}
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; 
		StonePit pit = new StonePit(10,10, 3);
		

		for (StonePit p : player1Pits) {
			p.draw(g2);
		}
		
		for (StonePit p : player2Pits) {
			p.draw(g2);
		}
		
		player1Mancala.draw(g2);
		player2Mancala.draw(g2);
		// pure gui layout
		layout.draw(g2);
		
	}
	
	
	
	
}
