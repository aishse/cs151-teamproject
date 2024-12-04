package mancala;

import java.awt.*;
import java.awt.geom.*;

/**
 * The MulticolorStyle class defines a colorful style for the Mancala board.
 * It implements the BoardStyle interface and provides methods to draw the board
 * with multiple colors.
 */
public class MulticolorStyle implements BoardStyle {

	@Override
	public String getName() {
		
		return "Multicolor Style";
	}

	@Override
	public void draw(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g; 
		
		RoundRectangle2D boardRect = new RoundRectangle2D.Double(X_POS, Y_POS, BOARD_WIDTH, BOARD_HEIGHT, 5,5); 
		
		g2.setColor(Color.blue);
		g2.setStroke(new BasicStroke(2));
		
		

		g2.setColor(Color.green);
		g2.setStroke(new BasicStroke(5));
		g2.draw(boardRect);
		
		g2.setFont(new Font("Arial", Font.PLAIN, 20));
		g2.setColor(Color.BLACK);

		
	    AffineTransform original = g2.getTransform();

	    g2.translate(X_POS - 10, Y_POS + BOARD_HEIGHT/2); 
	    g2.rotate(-Math.PI / 2);

	    // Draw the string
	    g2.drawString("MANCALA B", 0, 0);

	    g2.setTransform(original);
	  
		
		
	    g2.translate(X_POS + BOARD_WIDTH + 10, Y_POS + BOARD_HEIGHT/2); 
	    g2.rotate(Math.PI / 2);
	   
	    g2.drawString("MANCALA A", 0, 0);

	    
	    g2.setTransform(original);
	    
	    g2.setColor(Color.BLUE);
	   
	    
	    int xpos = X_POS + 120; 
	    for (int i = 1; i <= 6; i++) {
            String text = "A" + i;
            g.drawString(text, xpos, Y_POS + BOARD_HEIGHT - 20); 
            xpos += 80; 
        }
	    
	    g2.setColor(Color.PINK);
	    xpos = X_POS + 120;
	   
	    for (int i = 1; i <= 6; i++) {
            String text = "B" + i;
            g.drawString(text, xpos, Y_POS + 40); 
            xpos += 80; 
        }
	  
		
		
	}

}
