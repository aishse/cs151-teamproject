package mancala;

import java.awt.*;
import java.awt.event.*;

import java.awt.geom.Ellipse2D;
import javax.swing.*; 

public class StonePit extends JPanel {
    private int x, y;
    private int width, height;
    private int stoneCount;
    
    public StonePit(int x, int y,  int initialStones) {
        this.x = x;
        this.y = y;
        this.width = 55;
        this.height = 55;
        this.stoneCount = initialStones;
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Pit clicked!");
       
               
            }
        });
        
    }

    // Draw the pit and stones
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g); 
    	Graphics2D g2 = (Graphics2D) g; 
    	
        // Draw the pit
    	g2.setStroke(new BasicStroke(2));
    	
        Ellipse2D pit = new Ellipse2D.Double(0,0,width, height);
        g2.setColor(Color.LIGHT_GRAY);
        g2.fill(pit);
        g2.setColor(Color.BLACK);
        g2.draw(pit);


        int stoneRadius = 10;
        int maxStonesPerRow = width / (stoneRadius + 5);
        int row = 1, col = 1;

        for (int i = 0; i < stoneCount; i++) {
            int stoneX = col * (stoneRadius + 5);
            int stoneY = row * (stoneRadius + 5);


            Ellipse2D stone = new Ellipse2D.Double(stoneX, stoneY, stoneRadius, stoneRadius);
            g2.setColor(Color.BLUE);
            g2.fill(stone);
            g2.setColor(Color.BLACK);
            g2.draw(stone);


            col++;
            if (col == maxStonesPerRow) {
                col = 1;
                row++;
            }
        }
    }


    public void addStone(int count) {
        stoneCount += count;
    }


    public int removeAllStones() {
        int removed = stoneCount;
        stoneCount = 0;
        return removed;
    }


    public int getStoneCount() {
        return stoneCount;
    }


    public void setStoneCount(int count) {
        stoneCount = count;
    }
}
