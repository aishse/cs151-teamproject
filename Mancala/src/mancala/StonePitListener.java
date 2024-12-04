package mancala;

/**
 * The StonePitListener interface defines a listener for handling events
 * when a StonePit is clicked. Classes that implement this interface can
 * respond to clicks on a StonePit.
 */
public interface StonePitListener {

	/**
	 * This method is called when a StonePit is clicked.
	 *
	 * @param pit The StonePit that was clicked.
	 */
	void clicked(StonePit pit); 
}
