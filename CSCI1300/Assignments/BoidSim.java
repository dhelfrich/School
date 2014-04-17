/*
 * BoidSim
 * A simple boid simulator
 */

import java.lang.Math;

/**
 *
 * @author dana
 */
public class BoidSim 
	{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {        
        // First, create a world to draw the boids in
    	World world = new World();
        
        // We don't want the flock to simply hover in the middle of the world,
        // so we'll give each boid an initial nudge in the same direction
        
        
        // Create the 200 boids using a for loop and add them to the world
    	for(int i = 0; i < 200; i++)
    	{
    		Boid boid = new Boid(Math.random()*2000-1000,Math.random()*1400-700,Math.random()*1000-500,Math.random()*1000-500);
    		world.addBoid(boid);
    	}
        
        
        
        
        // Now run it until the user closes the window
    	while(world.isAlive())
    	{

    		long time = System.currentTimeMillis();
    		world.updateWorld();
    		
    		while(System.currentTimeMillis() - time < 4)//wait 20 ms
    		{

    		}
    	}
            
            // Wait until a total of 20 ms has passed since last time
        
       
       
    }
}
