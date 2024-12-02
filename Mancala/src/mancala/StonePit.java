package mancala;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class StonePit {
    private int x, y;
    private int width, height;
    private int stoneCount;

    public StonePit(int x, int y,  int initialStones) {
        this.x = x;
        this.y = y;
        this.width = 55;
        this.height = 55;
        this.stoneCount = initialStones;
    }

    // Draw the pit and stones
    public void draw(Graphics2D g) {
        // Draw the pit
        Ellipse2D pit = new Ellipse2D.Double(x, y, width, height);
        g.setColor(Color.LIGHT_GRAY);
        g.fill(pit);
        g.setColor(Color.BLACK);
        g.draw(pit);


        int stoneRadius = 10;
        int maxStonesPerRow = width / (stoneRadius + 5);
        int row = 1, col = 1;

        for (int i = 0; i < stoneCount; i++) {
            int stoneX = x + col * (stoneRadius + 5);
            int stoneY = y +  row * (stoneRadius + 5);


            Ellipse2D stone = new Ellipse2D.Double(stoneX, stoneY, stoneRadius, stoneRadius);
            g.setColor(Color.BLUE);
            g.fill(stone);
            g.setColor(Color.BLACK);
            g.draw(stone);


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
