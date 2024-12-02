package mancala;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class MancalaPit {
	// number of stones in the pit
	int stoneCount; 
	int x;
	int y;
	int width;
	
	public MancalaPit(int x, int y) {
		stoneCount = 0; 
		this.x = x;
		this.y = y; 
		
	}
	
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


	    public void addStone(int count) {
	        stoneCount += count;
	    }


	 
	    public int getStoneCount() {
	        return stoneCount;
	    }
	    
}


