package mancala;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;

public class DefaultStyle implements BoardStyle {


	public String getName() {
		// TODO Auto-generated method stub
		return "Default Style";
	}


	public void draw(Graphics2D g) {
Graphics2D g2 = (Graphics2D) g; 
		
		RoundRectangle2D boardRect = new RoundRectangle2D.Double(X_POS, Y_POS, BOARD_WIDTH, BOARD_HEIGHT, 5,5); 
		
	
		g2.setStroke(new BasicStroke(2));
		

	
		g2.setStroke(new BasicStroke(5));
		g2.draw(boardRect);
		
		g2.setFont(new Font("Arial", Font.PLAIN, 20));
		

		
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
	  
	    
	    int xpos = X_POS + 120; 
	    for (int i = 1; i <= 6; i++) {
            String text = "A" + i;
            g.drawString(text, xpos, Y_POS + BOARD_HEIGHT - 20); 
            xpos += 80; 
        }
	    
	    xpos = X_POS + 120;
	    for (int i = 1; i <= 6; i++) {
            String text = "B" + i;
            g.drawString(text, xpos, Y_POS + 40); 
            xpos += 80; 
        }

	}

}
