/*************************************************************************
 *  Compilation:  javac Charge.java
 *  Execution:    java Charge x y
 *
 *************************************************************************/


public class Charge {
    private double rx, ry;   // position
    private double q;        // charge
    private double vx;      //velocity in x direction
    private double vy;      //velocity in y direction
    private int canvasSize;
    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q  = q0;
        vx = .005;
        vy = .003;
       
    }
    //new constructor with different x,y velocities
    
    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        /*The divisor 2.0e10 is not part of Coloumbs Law,
         * it is used to make the display scale nicely.
         */
        return (k * q / Math.sqrt(dx*dx + dy*dy))/2.0e10;
    }

    public String toString() {
        return q + " at " + "(" + rx + ", " + ry + ")";
    }
    public void move(){
        if (Math.abs(rx+vx) >= .99) vx = -vx;
        if (Math.abs(ry+vy) >= .99) vy = -vy;
        if(rx+vx <= 0.0) vx = -vx;
        if(ry+vy <= 0.0) vy = -vy;
        
        rx = rx + vx;
        ry = ry + vy;
        
    }
    /*This is called a setter, it's how you set private instance variables that aren't set in the constructor, or if you wnat to change them 
     * after they've been set in the constructor.
     */
    public void setVX(double VXin)
    {
        vx = VXin;
    }
    public void setVY(double VYin)
    {
        vy = VYin;
    }
    /*This is called a getter, it's how you retrieve private instance variables from a class is you need to use/view them outside of the class*/
    public double getVX()
    {
        return vx;
    }
    
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        Charge c1 = new Charge(.51, .63, 21.3);
        Charge c2 = new Charge(.13, .94, 81.9);
        System.out.println(c1);
        System.out.println(c2);
        double v1 = c1.potentialAt(x, y);
        double v2 = c2.potentialAt(x, y);
        System.out.println(v1+v2);
    }
}
