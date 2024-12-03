package mancala;
import java.awt.*;
import javax.swing.*; 
import java.util.*; 
/**
 * Controls the Mancala application
 */
public class MancalaController extends JPanel{

	private MancalaModel model;
	
	MancalaController(MancalaModel model) {
	
		this.model = model; 
		int initialstones = 0;
		do {
			Scanner input = new Scanner(System.in); 
			System.out.print("Enter initial number of stones per pit (3 or 4): ");
			initialstones = input.nextInt(); 
		}
		while (initialstones != 3 && initialstones != 4); 
		model.setInitialStones(initialstones);
		model.move(0, 4);
		
	}
}
