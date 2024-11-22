package mancala;
import java.awt.*;
import javax.swing.*; 

public class MancalaTester {
	public static void main(String[] args) {
		JFrame gameframe = new JFrame(); 
		JPanel mainPanel = new JPanel(); 
		
		gameframe.setTitle("Mancala Game");
		gameframe.setSize(800, 500);
		
		gameframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
				
		//gameframe.add(view); 
		
		JButton multicolor = new JButton("multicolor style"); 
		JButton defstyle = new JButton("default style"); 
		
		mainPanel.add(multicolor); 
		mainPanel.add(defstyle); 
		
		multicolor.addActionListener((event) -> {
			MancalaView view = new MancalaView(new MulticolorStyle()); 
			gameframe.add(view); 
			gameframe.remove(mainPanel);
			gameframe.revalidate();

			gameframe.repaint(); 
			view.repaint(); 
			
		});
		
		
		defstyle.addActionListener((event) -> {
			MancalaView view = new MancalaView(new DefaultStyle()); 
			gameframe.add(view); 
			gameframe.remove(mainPanel);
			gameframe.revalidate();

			gameframe.repaint(); 
			view.repaint(); 
			
		});

		//gameframe.pack(); 
		gameframe.add(mainPanel); 
		gameframe.setVisible(true);
	}
}
