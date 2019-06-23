package ch14pc06;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Applet to draw a 4x4 grid and to toggle filled circles within the grid
 * 
 * @author frank
 */
public class Ch14pc06 extends JApplet implements MouseListener {
    // Variables
    private Box[][] grid = new Box[4][4];
    private boolean[][] drawCircle = new boolean[4][4]; // All values default to false
    
    /**
     * Initialize the applet
     */
    public void init() {
        // add the MouseListener
        addMouseListener(this);
    }
    
    /**
     * Method to draw the grid
     * @param g Graphics
     */
    public void paint(Graphics g) {
        super.paint(g);
        int xCoordinate = 0;
        int yCoordinate = 0;
        
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new Box(xCoordinate, yCoordinate, g, drawCircle[i][j]);
                xCoordinate += 100;
            }
            xCoordinate = 0;
            yCoordinate += 100;
        }
    }
    
    /**
     * Listener for the Mouse Click event
     * @param e MouseEvent The event caused by left-clicking on the mouse
     */
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int row;
        int column;
        
        if (x <= 100)
            row = 0;
        else if (x > 100 && x <= 200)
            row = 1;
        else if (x > 200 && x <= 300)
            row = 2;
        else if (x > 300 && x <= 400)
            row = 3;
        else
            return;
        
        if (y <= 100)
            column = 0;
        else if (y > 100 && y <= 200)
            column = 1;
        else if (y > 200 && y <= 300)
            column = 2;
        else if (y > 300 && y <= 400)
            column = 3;
        else
            return;
        
        drawCircle[column][row] = !drawCircle[column][row];
        repaint();
    }
    
    // Non-applicable mouse motion listeners
    public void mouseMoved(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
