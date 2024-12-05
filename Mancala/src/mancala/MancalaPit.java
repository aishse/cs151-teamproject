package mancala;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Represents a pit in the Mancala board game.
 * A pit contains a number of stones and has a position on the board.
 * This class handles the visual representation of the pit and its stones.
 * 
 * @author Anishka Chauhan, Jaspreet Aujla, and Ivan Selvan 

 */
public class MancalaPit {
	// number of stones in the pit
	int stoneCount; 
	int x;
	int y;
	int width;

	/**
	 * Constructs a MancalaPit with the specified position.
	 * Initially, the pit contains zero stones.
	 *
	 * @param x the x-coordinate of the pit
	 * @param y the y-coordinate of the pit
	 */
	public MancalaPit(int x, int y) {
		stoneCount = 0; 
		this.x = x;
		this.y = y; 
		
	}

	/**
	 * Draws the pit and its stones on the board.
	 *
	 * @param g the {@code Graphics2D} object used to draw the pit and stones
	 */
	  public void draw(Graphics2D g) {
	        // Draw the pit
			RoundRectangle2D pit = new RoundRectangle2D.Double(x, y, 50, BoardStyle.BOARD_HEIGHT-20, 40, 60); 

	        g.setColor(Color.LIGHT_GRAY);
	        g.fill(pit);
	        g.setColor(Color.BLACK);
	        g.draw(pit);


	        int stoneRadius = 10;
	        int stoneX = x + (stoneRadius + 5);
	        
	        int row = 1; 

	        for (int i = 0; i < stoneCount; i++) {
	       
	            int stoneY = y + row * (stoneRadius + 5);


	            Ellipse2D stone = new Ellipse2D.Double(stoneX, stoneY, stoneRadius, stoneRadius);
	            g.setColor(Color.BLUE);
	            g.fill(stone);
	            g.setColor(Color.BLACK);
	            g.draw(stone);
	            row++; 

	        }
	    }


	/**
	 * Sets the number of stones in the pit.
	 *
	 * @param amount the number of stones to place in the pit
	 */
    public void setStones(int amount) {
        stoneCount = amount;
    }


	/**
	 * Retrieves the number of stones in the pit.
	 *
	 * @return the number of stones in the pit
	 */
 
    public int getStoneCount() {
        return stoneCount;
    }
	    
}


