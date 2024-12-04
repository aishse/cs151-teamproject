package mancala;
import java.awt.*;
import javax.swing.*; 
import java.util.*; 
/**
 * Controls the Mancala application
 */
public class MancalaController extends JPanel implements MancalaListener{

	private MancalaModel model;
	
	MancalaController(MancalaModel model) {
		JButton multicolor = new JButton("multicolor style"); 
		JButton defstyle = new JButton("default style");
		System.out.println("Select a layout (default currently selected"); 
		
		this.model = model; 

		model.addMancalaListener(this);
		
		multicolor.addActionListener((event) -> {
			
			model.setViewLayout(new MulticolorStyle()); 
			model.setGameState(true); 
			
			revalidate();		
			repaint(); 

		});
		
		defstyle.addActionListener((event) -> {
			
			model.setViewLayout(new MulticolorStyle()); 
			model.setGameState(true); 
			
			revalidate();		
			repaint(); 

		});
		
		add(multicolor); 
		add(defstyle); 
		
	
		
		
	}

	@Override
	public void onStoneClicked(StonePit pit) {
	
		// run the mancala game here
	}

	@Override
	public void gameStarted(Boolean b) {
		JButton undo = new JButton ("undo"); 
		removeAll(); 
		this.repaint(); 
		add(undo); 
		
		// gets the intial stones from teh user 
		int initialstones = 0;
		do {
			Scanner input = new Scanner(System.in); 
			System.out.print("Enter initial number of stones per pit (3 or 4): ");
			initialstones = input.nextInt(); 
		}
		while (initialstones != 3 && initialstones != 4); 
		
		
		
		model.setInitialStones(initialstones);
		
	}

	@Override
	public void onPlayer1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPlayer2() {
		// TODO Auto-generated method stub
		
	}
}
