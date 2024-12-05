package mancala;
import java.awt.*;
import javax.swing.*; 
import java.util.*; 
/**
 * Controls the Mancala application
 */
public class MancalaController extends JPanel implements MancalaListener {

	private MancalaModel model;
	private JButton undo = new JButton ("undo"); 
	MancalaController(MancalaModel model) {
		JButton multicolor = new JButton("multicolor style"); 
		JButton defstyle = new JButton("default style");
		
		System.out.println("Select a board style (default currently selected)"); 
		
		this.model = model; 
		
		model.addMancalaListener(this);
		
		multicolor.addActionListener((event) -> {
			
			model.setViewLayout(new MulticolorStyle()); 
			model.setGameState(true); 
			
			revalidate();		
			repaint(); 

		});
		
		defstyle.addActionListener((event) -> {
			
			model.setViewLayout(new DefaultStyle()); 
			model.setGameState(true); 
			
			revalidate();		
			repaint(); 

		});
		
		add(multicolor); 
		add(defstyle); 

	
		
		
	}

	@Override
	/**
	 * Called when a stone in a pit is clicked.
	 *
	 * @param pit the {@code StonePit} that was clicked
	 */
	public void onStoneClicked(StonePit pit) {
	
		// run the mancala game here
	}

	/**
	 * Called when the game starts or stops.
	 *
	 * @param b {@code true} if the game has started, {@code false} otherwise
	 */
	
	@Override
	public void gameStarted(Boolean b) {
		
		removeAll(); 
		this.repaint(); 
		add(undo); 
		undo.addActionListener((event) -> {
			model.undoMove();
			System.out.println("undone"); 
			this.repaint(); 
			
		});
		// gets the intial stones from the user 
		int initialstones = 0;
		do {
			Scanner input = new Scanner(System.in); 
			System.out.print("Enter initial number of stones per pit (3 or 4): ");
			initialstones = input.nextInt(); 
		}
		while (initialstones != 3 && initialstones != 4); 
		
		model.setInitialStones(initialstones);
		
	
		
	}

	

	
}
