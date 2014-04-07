/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;

/**
 *
 * @author user
 */
public class Turtle {

    private double x,y;
    private double angle;
            
    
    public Turtle(double x0, double y0, double a0)
    {
        this.x = x0;
        this.y = y0;
        this.angle = a0;
        StdDraw.filledCircle(this.x, this.y, .01);
        
    }
    
    public void turnLeft(double delta)
    {
    	this.angle += delta;
    }
    
    public void goForward(double step)
    {
        double oldx = this.x;
        double oldy = this.y;
        this.x += step * Math.cos(Math.toRadians(this.angle));
        this.y += step * Math.sin(Math.toRadians(this.angle));
        StdDraw.setPenRadius(.001);
        
        StdDraw.line(oldx, oldy, this.x, this.y);
        StdDraw.show(50);
        
                        
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double angle = 360.0/N;
        double step = Math.sin(Math.toRadians(angle/2));
        Turtle turtle = new Turtle(0.5, .0, angle/2);
        for(int i = 0; i < N; i++)
        {
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
    }
}
