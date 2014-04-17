/*
 * World
 * A world object for the boids to live in
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author dana
 */
public class World extends JPanel {
	// class World inherits from class JPanel

    private JFrame window;
    private Boid[] boids;
    private int numBoids;
    
    
    /**
     * The World constructor creates a new window to draw the boids on
     */
    public World()
    {
        // Initialize the boid array, and start out with 0 boids
        this.boids = new Boid[200];
        this.numBoids = 0;
        
        // Create a new window and add the world on it
        this.window = new JFrame("BoidWorld");
        this.window.add(this);                 
        this.window.setSize(1000,700);
        this.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        // And show it
        this.window.setVisible(true);
    }
    
    /**
     * Add a boid to this world
     * @param boid 
     */
    public void addBoid(Boid boid)
    {
        this.boids[this.numBoids] = boid;
        this.numBoids = this.numBoids + 1;
    }
    
    
    public double[] getMouseLocation()
    {
        double[] location = new double[2];
        
        // Get the mouse position and convert to the world coordinate system
        Point mousePoint = this.getMousePosition();
        if (mousePoint != null)
        {
            location[0] = (double) (1000.0*mousePoint.getX()/500 - 1000);
            location[1] = (double) (1000.0*mousePoint.getY()/350 - 1000);
        }
        else
        {
            location[0] = 0;
            location[1] = 0;
        }
        
        return location;
    }
    
    
    /**
     * 
     */
    public void updateWorld()
    {
        // What's the group's center and group velocity?
        double[] center = Boid.calcCenter(boids, numBoids);
        double[] groupVelocity = Boid.calcGroupVelocity(boids, numBoids);
        //mouse
		double [] mouseLoc = this.getMouseLocation();
        // Change each boid's position and velocity
        for(int i=0; i<this.numBoids; i++)
        {
            this.boids[i].update(center, groupVelocity, this.boids, this.numBoids, mouseLoc);
        }
        
        // And redraw the canvas
        // it will call method paint
        this.repaint();
    }
    
        
    public boolean isAlive()
    {
        return this.window.isVisible();
    }
    
    @Override
    public void paint(Graphics g)
    {
        Graphics2D canvas = (Graphics2D) g;

        Color background = new Color(0,64,128);
        canvas.setColor(background);
        canvas.fillRect(0, 0, 1000, 700);
        
        for(int i=0; i<numBoids; i++)
        {
            boids[i].draw(canvas);
        }
    }
}
