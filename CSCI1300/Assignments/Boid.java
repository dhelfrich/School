/*
 * Boid
 * 
 * Individual boid objects, capable of avoiding others and flocking
 */

import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.AffineTransformOp;
import java.awt.geom.AffineTransform;
import java.awt.Color;
import java.lang.Math;
import java.io.File;

/**
 *
 * @author dana
 */
public class Boid {

    private double x;
    private double y;
    private double vx;
    private double vy;
    

    private BufferedImage boidImage;
    
    /**
     * calcCenter
     * Determine the center of mass for the boids
     * @param boids
     * @param numBoids
     * @return 
     */
    public static double[] calcCenter(Boid[] boids, int numBoids)
    {
        // Start off assuming the center is at zero
         double centerX = 0;
         double centerY = 0;
         
         // Add all the boid position to the position
         for(int i=0; i<numBoids; i++)
         {
             Boid boid = boids[i];
             centerX = centerX + boid.getX();
             centerY = centerY + boid.getY();
         }
         
         // Divide by the number of boids
         centerX = centerX / numBoids;
         centerY = centerY / numBoids;
         
         // Put the results in an array and return
         double[] center = {centerX, centerY};
         return center;
    }
    
    
    /**
     * calcGroupVelocity
     * Determine the group velocity of the boids
     * @param boids
     * @param numBoids
     * @return 
     */
    public static double[] calcGroupVelocity(Boid[] boids, int numBoids)
    {
        // Start off assuming the group doesn't move
         double groupVx = 0;
         double groupVy = 0;
         
         // Add all the individual boid velocities
         for(int i=0; i<numBoids; i++)
         {
             Boid boid = boids[i];
             groupVx = groupVx + boid.getVx();
             groupVy = groupVy + boid.getVy();
         }
         
         // Divide by the number of boids to get the average velocity
         groupVx = groupVx / numBoids;
         groupVy = groupVy / numBoids;
         
         // Put this in an array and return
         double[] groupVelocity = {groupVx, groupVy};
         return groupVelocity;
    }
     
    
    /**
     * Boid(double x, double y, double vx, double vy)
     * A constructor for the boid which sets its initial position to (x,y), and
     * initial velocity to (vx, vy)
     */
     public Boid(double x, double y, double vx, double vy)
     {
         this.x = x;
         this.y = y;
         this.vx = vx;
         this.vy = vy;
         
         // Load the boidImage
         try 
         {
             this.boidImage = ImageIO.read(new File("boid.png"));
         }
         catch(Exception e)
         {
             System.out.println("Couldn't load the boid image!");
             System.out.println(e.getMessage());
         }
     }
     
     
     /**
      * getX
      * Get this boid's x position
      * @return 
      */
     public double getX()
     {
         return this.x;
     }
     
     
     /**
      * getY
      * Get this boid's y position
      * @return 
      */
     public double getY()
     {
         return this.y;
     }

     
     /**
      * setX
      * Set this boid's x position, making sure that it doesn't pass the edge 
      * of the world
      * @param x 
      */
     public void setX(double x)
     {
         this.x = x;
         if(this.x < -1000)
         {
             this.x = -1000;
         }
         if(this.x > 1000)
         {
             this.x = 1000;
         }
     }

     
     /**
      * setY
      * Set this boid's y position, making sure it doesn't pass the edge of the
      * world
      * @param y 
      */
     public void setY(double y)
     {
         this.y = y;
         if(this.y < -1000)
         {
             this.y = -1000;
         }
         if(this.y > 1000)
         {
             this.y = 1000;
         }
     }

     
     /**
      * getVx
      * Get this boid's velocity in the x direction
      * @return 
      */
     public double getVx()
     {
         return this.vx;
     }
     
     
     /**
      * getVy
      * Get this boid's velocity in the y direction
      * @return 
      */
     public double getVy()
     {
         return this.vy;
     }
     
     /**
      * setVx
      * Set this boid's x velocity, making sure it doesn't exceed 5
      * @param vx 
      */
     public void setVx(double vx)
     {
         this.vx = vx;
         if(this.vx < -5)
         {
             this.vx = -5;
         }
         if(this.vx > 5)
         {
             this.vx = 5;
         }
     }

     /**
      * Set this boid's velocity in the y direction, making sure it doesn't 
      * exceed 5
      * @param vy 
      */
     public void setVy(double vy)
     {
         this.vy = vy;
         if(this.vy < -5)
         {
             this.vy = -5;
         }
         if(this.vy > 5)
         {
             this.vy = 5;
         }
     }

     
     /**
      * Change this boid's position, by avoiding other boids 
      * @param boids 
      */
     private void avoid(Boid[] boids, int numBoids)
     {
         double avoidVx = 0;
         double avoidVy = 0;
         
         for(int i=0; i<numBoids; i++)
         {
             double powerX = Math.pow(boids[i].getX() - this.x, 2);
             double powerY = Math.pow(boids[i].getY() - this.y, 2);
             double distance = Math.sqrt(powerX + powerY);
         
             if(distance < 60)
             {
                 avoidVx = avoidVx - (this.x - boids[i].getX());
                 avoidVy = avoidVy - (this.y - boids[i].getY());
             }
         }
         
         this.setVx(this.vx - avoidVx);
         this.setVy(this.vy - avoidVy);
     }
     
     
     /**
      * Change this boid's position, by flocking towards the other boids
      * @param boids 
      */
     private void flock(double centerX, double centerY)
     {
         this.setVx(this.vx + (centerX - this.x)/1000);
         this.setVy(this.vy + (centerY - this.y)/1000);         
     }
     
     
     /**
      * Change this boid's velocity to try to match the other boid's velocity
      * @param boids 
      */
     private void matchVelocity(double groupVx, double groupVy)
     {
         this.setVx(this.vx + groupVx / 8);
         this.setVy(this.vy + groupVy / 8);         
     }
     
     
     /**
      * Change the velocity by a random amount
      */
     private void swerve()
     {
         double randomVx = vx*(Math.random()-0.5)/10;
         double randomVy = vy*(Math.random()-0.5)/10;
         
         this.setVx(this.vx + randomVx);
         this.setVy(this.vy + randomVy);
     }
     
     
     /**
      * Make sure the boid stays within the bounds of this world
      * @param world 
      */
     private void avoidWalls()
     {
         double leftWallDistance = Math.abs(this.x + 1000);
         double rightWallDistance = Math.abs(this.x - 1000);
         double upperWallDistance = Math.abs(this.y + 1000);
         double lowerWallDistance = Math.abs(this.y - 1000);
         
         if(leftWallDistance < 100)
         {
             this.setVx(this.vx + (120-leftWallDistance)/20);
         }
         if(rightWallDistance < 100)
         {
             this.setVx(this.vx - (120-rightWallDistance)/20);             
         }
         if(upperWallDistance < 100)
         {
             this.setVy(this.vy + (120-upperWallDistance)/20);             
         }
         if(lowerWallDistance < 100)
         {
             this.setVy(this.vy - (120-lowerWallDistance)/20);             
         }
     }
     
     
     /**
      * Update the position and velocity of this boid
      * @param boids
      * @param world 
      */
     public void update(double[] center, double[] groupVelocity, Boid[] boids, int numBoids, double [] mouseLoc)
     {
         // Calculate the various changes in velocity by calling the appropriate method
         // The boid wants to flock towards the center of the flock
         this.flock(center[0], center[1]);
         // The boid wants to move in the general direction of the group
         this.matchVelocity(groupVelocity[0], groupVelocity[1]);
         // The boid doesn't want to get too close to other boids
         this.avoid(boids, numBoids);
         // The boid doesn't want to hit the wall
         this.avoidWalls();
         // The boid may randomly swerve
         this.swerve();
                  
         // Change the boid's position by its velocity
         this.setX(this.x + this.vx);
         this.setY(this.y + this.vy);
         
         //move away from mouse
         setVx((mouseLoc[0] - this.x)*-.15 + this.vx);
         setVy((mouseLoc[1] - this.y)*-.15 + this.vy);
     }
     
     
     /**
      * draw
      * Draw the boid on the canvas provided
      */
     public void draw(Graphics2D canvas)
     {
         // First, convert the x and y coordinates to pixel locations on the 
         // canvas.  
         
         // World position to canvas position conversion:
         // i = SCREEN_WIDTH/2 + x*(SCREEN_WIDTH/2)/WORLD_WIDTH
         // j = SCREEN_HEIGHT/2 + y*(SCREEN_HEIGHT/2)/WORLD_HEIGHT
         int i = (int) (500 + this.x*500/1000);
         int j = (int) (350 + this.y*350/1000);
    
         // The boid needs to be rotated based on the velocity
         double theta = Math.atan2(this.vy, this.vx);
         AffineTransform rotation = new AffineTransform();
         rotation.setToRotation(theta, 20, 32.5);
         AffineTransformOp rotator = new AffineTransformOp(rotation, AffineTransformOp.TYPE_BICUBIC);
         
         // Draw the boid image
         canvas.drawImage(boidImage, rotator, i, j);
         
     }
}
