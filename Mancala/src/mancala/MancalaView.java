package mancala;
import javax.swing.*; 
import java.awt.*; 

public class MancalaView extends JPanel {
	private BoardStyle layout; 
	public MancalaView(BoardStyle l) {	
		layout = l;
	}
	
	
	public void paintComponent(Graphics g) {
		layout.draw((Graphics2D) g);
	}
}
