package mancala;
/**
 * Defines the listener interface for handling events in the Mancala game.
 * Classes implementing this interface will respond to game events such as
 * a stone being clicked, the game starting, or a player's turn.
 *
 * @author Anishka Chauhan, Jaspreet Aujla, and Ivan Selvan 

 */
public interface MancalaListener {

	/**
	 * Called when a stone in a pit is clicked.
	 *
	 * @param pit the {@code StonePit} that was clicked
	 */
	void onStoneClicked(StonePit pit);

	/**
	 * Called when the game starts or stops.
	 *
	 * @param b {@code true} if the game has started, {@code false} otherwise
	 */
	void gameStarted(Boolean b);
}
	
	

