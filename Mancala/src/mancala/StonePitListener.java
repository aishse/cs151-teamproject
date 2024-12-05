package mancala;

/**
 * The StonePitListener interface defines a listener for handling events
 * when a StonePit is clicked. Classes that implement this interface can
 * respond to clicks on a StonePit.
 * 
 * @author Anishka Chauhan, Jaspreet Aujla, and Ivan Selvan 

 */
public interface StonePitListener {

	/**
	 * This method is called when a StonePit is clicked.
	 *
	 * @param pit The StonePit that was clicked.
	 */
	void clicked(StonePit pit); 
}
