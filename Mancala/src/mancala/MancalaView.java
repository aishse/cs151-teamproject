package mancala;
import javax.swing.*; 
import java.awt.*; 

public class MancalaView extends JPanel {
	private BoardStyle layout; 
	private MancalaModel player1;
	private MancalaModel player2; 
	
	public MancalaView(BoardStyle l, MancalaModel p1, MancalaModel p2) {	
		layout = l;
		player1 = p1;
		player2 = p2; 
	}
	
	
	public void paintComponent(Graphics g) {
		layout.draw((Graphics2D) g);
	}
}
