package mancala;
import java.awt.*;
import java.awt.geom.*;

public interface BoardStyle {
	public final int BOARD_WIDTH = 650;
	public final int BOARD_HEIGHT = 300;
	public final int X_POS = 75;
	public final int Y_POS = 80;
	String getName();
	void draw(Graphics2D g);
}
