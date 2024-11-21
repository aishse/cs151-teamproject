package mancala;
import java.awt.Frame;

import javax.swing.*; 

public class MancalaTester {
	public static void main(String[] args) {
		JFrame gameframe = new JFrame(); 
		gameframe.setTitle("Mancala Game");
		gameframe.setSize(800, 500);
		
		gameframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// add the mancala game panel here 
		MancalaView view = new MancalaView(new DefaultStyle()); 
		
		gameframe.add(view); 
		
		
		//gameframe.pack(); 
		gameframe.setVisible(true);
	}
}
