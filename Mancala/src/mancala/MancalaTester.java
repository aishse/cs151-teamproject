package mancala;
import java.awt.*;
import javax.swing.*;

/**
 * The MancalaTester class serves as the entry point for the Mancala game.
 * It creates the game window (JFrame), sets up the game view, model, and controller,
 * and adds components to the main panel for display.
 * 
 * @author Anishka Chauhan, Jaspreet Aujla, and Ivan Selvan 

 */
public class MancalaTester {

	/**
	 * The main method initializes the Mancala game by setting up the game window,
	 * adding the view, model, and controller components, and organizing them
	 * within a panel.
	 *
	 * @param args Command-line arguments (not used).
	 */
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
	
	
		System.out.println("Select a layout (default currently selected"); 
		
		mainPanel.add(controller, BorderLayout.SOUTH); 
		mainPanel.add(view, BorderLayout.CENTER); 
	
	
		//gameframe.pack(); 
		gameframe.add(mainPanel); 
		gameframe.setVisible(true);
	}
}
