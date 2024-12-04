package mancala;
import java.awt.*;
import javax.swing.*;

/**
 * The MancalaTester class is the main entry point for the Mancala game.
 * It creates the game window (JFrame) and lets the player choose between
 * two board styles: "multicolor style" or "default style."
 */
public class MancalaTester {
	public static void main(String[] args) {
		JFrame gameframe = new JFrame(); 
		JPanel mainPanel = new JPanel(); 
		
		gameframe.setTitle("Mancala Game");
		gameframe.setSize(800, 500);
		mainPanel.setLayout(new BorderLayout());
		gameframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		

		MancalaView view = new MancalaView(); 
		
		MancalaModel model = new MancalaModel(view); 
		MancalaController controller = new MancalaController(model);  
	
	
	
		
		mainPanel.add(controller, BorderLayout.SOUTH); 
		mainPanel.add(view, BorderLayout.CENTER); 
	
	
		//gameframe.pack(); 
		gameframe.add(mainPanel); 
		gameframe.setVisible(true);
	}
}
