package ch14pc06;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author frank
 */
public class Box extends JApplet {
    // Variables
    private int xCoord, yCoord;
    private final int width = 100;
    private final int height = 100;
    private boolean showCircle;
    
    // Constructor
    /**
     * Construct the box
     * @param x int The x coordinate to begin drawing the box
     * @param y int The y coordinate to begin drawing the box
     * @param drawCircle boolean The value to draw the circle or not
     */
    public Box(int x, int y, Graphics g, boolean drawCircle) {
        xCoord = x;
        yCoord = y;
        showCircle = drawCircle;
        paint(g);
    }
    
    /**
     * Method to draw the box and optionally the circle
     * @param g 
     */
    public void paint(Graphics g) {
        super.paint(g);
        
        g.setColor(Color.BLACK);
        g.drawRect(xCoord, yCoord, width, height);
        
        if (showCircle) {
            g.setColor(Color.ORANGE);
            g.fillOval(xCoord + 5, yCoord + 5, width - 10, height - 10);
        }
        repaint();
    }
}
