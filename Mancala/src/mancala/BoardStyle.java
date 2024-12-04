package mancala;
import java.awt.*;
import java.awt.geom.*;

/**
 * This is the code for BoardStyle interface that is used to define different styles for the Mancala board.
 * It has fixed dimensions and position for the board and methods to
 * get the style's name and draw the board.
 */

public interface BoardStyle {
	public final int BOARD_WIDTH = 650;
	public final int BOARD_HEIGHT = 300;
	public final int X_POS = 75;
	public final int Y_POS = 80;
	String getName();
	void draw(Graphics2D g);
}
