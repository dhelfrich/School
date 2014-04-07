/*
 * Today we're going to look more at objects and how to create 
 * multiple objects, and arrays of objects, of the same type.
 * To do this, we'll be using another third-party class called 
 * Turtle.java. This Turtle class is a reference to a famous 
 * programming language called Logo developed at MIT in the 1960s.
 * Logo featured creatures called "Turtles" that could be 
 * programmed to move around on the screen. There were commands
 * for go forward, go right, go left, etc. The Turtles were 
 * simplistic by today's standards, but this was a big deal at
 * the time. One of the attractions of Logo was that, even 
 * though the commands were simple, watching the turtles actions
 * over time revealed how simple actions could result in complex
 * patterns. This idea of complexity emerging from simple actions
 * is the hallmark of complex systems, and languages such as Logo
 * and the Turtles made it possible to do computational simulations
 * of complex systems and reveal details about the world that were
 * previously unknown.
 * 
 * In the Turtle.java class we're using, there isn't a turtle icon, 
 * we're actually just drawing a lines from a starting to an ending 
 * point at a given angle. These lines represent the path of the 
 * Turtle. Also, if you're ever at a party with other computer 
 * scientists and you want to show that you know something about
 * computer science history and don't want to discuss code, 
 * just start talking about Turtles, they'll know what you mean.
 * 
 * We'll be using the Turtle class to discuss the concept of 
 * object arrays. Just like with integer, doubles, and Strings,
 * we can create arrays of objects, such as Turtles, and then index
 * the Turtle arrays the same way we would an integer, double, or
 * String array.
 * 
 * The drawing of the Turtles is handled with another class called
 * StdDraw that is also third-party. Both of these files, the 
 * Turtles.java and StdDraw.java need to be added to your project
 * for this code today to work.
 */

/**
 *
 * @author user
 */
public class Lecture33TurtleObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*create a new instance of Turtle, called t, and give it
         * the values defined here to initialize class variables
         * by way of the constructor. We can look at the Turtle.java
         * code and see that the constructor takes three arguments, 
         * an x,y position on the screen, and an initial direction
         * that the turtle is facing. These variables are all private,
         * their state is maintained in the Turtle instance.
         * The methods in Turtle.java modify them.
         */
        double x0 = 0.5;
        double y0 = 0.0;
        double a0 = 60.0;
 
    	Turtle t = new Turtle(x0, y0, a0);
        /* We now have a Turtle, called t, and he has a position
         * on the screen. The scale on the canvas is between 0 
         * and 1.0. Putting something at the middle of the screen
         * would be 0.5, 0.5. There are two methods in Turtle, one
         * to go forward and one to turn left. We can use those
         * methods to move the turtle across the screen. We should
         * see a line between the original and end location.
         * 
         */
        double step = .10;
        t.goForward(step);

    	int x = 0;
        /*Turtle go all the way across the screen, taking 10 steps
         * all in the same direction.
         * */
        
        while(x < 10)
        {
            /*here, our instance of Turtle moves forward. The method 
             * goForward takes one argument, and if we look at 
             * that goForward method, we see that it updates the x and 
             * y variables in the class using the current position
             * and the angle and the step.
             */
        
            t.goForward(step);
            x = x + 1;
        }    
        //clear the screen of any evidence of turtles

        StdDraw.clear();

        double xT = 0.5;
        double yT = 0.5;
        double aT1 = 120.0;
        double aT2 = 240.0;
        /*With the Picture objects we saw that you could
         * create multiple instances of Picture, each with
         * its own set of properties. The same is true for 
         * the Turtle objects, you can create more than one 
         * Turtle by creating multiple instances of Turtle 
         * and giving them different names*/
        
        /*At no point do we have to keep track of where these
         * Turtles are on the screen, that is all handled in 
         * the individual instance for each Turtle.
         */

        Turtle turtle1 = new Turtle(xT, yT, aT1);
        Turtle turtle2 = new Turtle(xT, yT, aT2);
        step = 0.05;
        x = 0;
        while(x < 10)
        {
            turtle1.goForward(step);
            turtle2.goForward(step);
            x = x + 1;
        }
        //clear turtle evidence
        StdDraw.clear();
        /*Just to do something a little more interesting, create 
         * one turtle and have it move about randomly */

        Turtle rTurtle = new Turtle(0.5, 0.5, 0.0);
        for(int z = 0; z < 500; z++)
        {
        	/*Turtle can go any direction by going a
        	 * degree of left. Here, Math.random() will
        	 * be between 0 and 1.0, and the Turtle will 
        	 * turn between 0 and 360 degrees. The turn
        	 * will be different each time through the
        	 * loop, the step size will be constant.
        	 */
        	rTurtle.turnLeft(360.0*Math.random()); 
        	rTurtle.goForward(0.01);
        }
        //clear the screen
        StdDraw.clear();

        /* We've seen with other variable types, such as ints
         * and doubles that you can create an array of the type
         * using syntax such as:
         * 
         * int [] myInt = new int[5];
         * 
         * to create an array of 5 integers. The array syntax is
         * generic and can be used for any type. This is noteworthy
         * because it means that we can create an array of objects,
         * such as Turtles. Then, accessing each Turtle in the array
         * is the same as accessing an int in an array, we use the 
         * index of the object.

         * There are interesting things we can do with the 
         * Turtle graphics to illustrate how each turtle is an instance
         * and therefore treated independently of all other instances. 
         * Let's create an array of Turtles and set them all
         * in motion, moving randomly around the screen. Your book 
         * calls this Drunken Turtles, we'll stick with 
         * disoriented.
         */
        /* Next, we're going to create a herd of turtles, 
         * each with a randomly selected initial position and 0 angle 
         */
        
        //declare a variable that will be used to create 5 turtles
        int numTurtles = 5;
        
        /*I could create each turtle individually, requiring 5 lines 
         * of code, or I could just put Turtle creation in a for loop 
         * and make use of Math.random() to set each turtles position. 
         */

        /*this creates the variable, but doesn't instantiate the 
         * object, we didn't call the constructor for each Turtle.
         * This is equivalent to creating the int array, but not
         * giving the array elements any values.
         */
        Turtle [] turtles = new Turtle[numTurtles];

        for(int i = 0; i < numTurtles; i++)
        {
            /*Now, call the Turtle constructor and give each one a random starting location on the screen*/
            turtles[i] = new Turtle(Math.random(), Math.random(), 0.0);
        }
        /*we could modify Turtle to add a getX and getY method
         * to see where each Turtle was placed. We don't currently
         * know since it's random.
         */
        
        /*Let the turtles loose on the screen. Each one will take a 
         * step in a random direction. This is to illustrate that even
         * though they are all the same class, and they have simple 
         * rules for their behavior, each one will behave in a completely 
         * different way over time due to the randomness. This is one of 
         * the tenets of complexity and complex systems, that simple rules
         * and actions by the individual can generate complex patterns 
         * of behavior for the individual and for the population overall.
         */
        /*The programming related takeaway from this code is that each 
         * turtles[i] is unique. There is no interaction between 
         * turtles[1] and turtles[2] for example, and each instance 
         * maintains its own current information about position, etc. 
         * 
         * The other important programming takeaway is that the array
         * syntax for an object that we've created is the same as the 
         * array syntax for other data types, such as ints. The array
         * is generic, we can give it any type we want.
         */
        int N = 10; 

        for(int z = 0; z < N; z++)
        {
            for(int i = 0; i < numTurtles; i++)
            {
               turtles[i].turnLeft(360.0*Math.random()); //take a left turn of varied degree, different each time in loop
               turtles[i].goForward(0.012);
                
            }
        }

        StdDraw.clear();
         
        /*Exercise: how would we draw a square? Adding a method
         * to Turtle to draw a square would increase the current
         * functionality. If you wanted to use your Turtles for 
         * drawing shapes and cool designs, having the option of
         * drawing a square without having to use all the individual
         * steps each time would make your code easier to read
         * and more efficient to program. Any time you wanted to draw
         * a square, you would just call drawSquare, instead of having
         * to call goForward and turnLeft for each step of the square
         * drawing.
         * 
         */

        //Cool YouTube video of Turtle graphics.
        
 
    }
}

