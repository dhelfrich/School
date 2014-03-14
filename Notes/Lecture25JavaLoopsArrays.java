/*CSCI 1300, Spring 2014, Lecture 25
 * Copyright 2014 Rhonda Hoenigman
 * University of Colorado, Boulder, Colorado
*/

/* Loops, again.
 * For loops and arrays
 * The for loop in Java is a bit
 * different than what we saw in Python. In Java, it's a counter instead
 * of an iterator. In Python, the for was used to iterate through a 
 * collection, and we also saw how it could be used to index into a 
 * collection. In Java, we'll focus on the indexing of arrays, and talk
 * more about what an array is.
 *  
 */

public class Lecture25JavaLoopsArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		  
        /*Moving on to for loops. These loops look quite different in
         * Java than they do in Python, and they serve a slightly
         * different purpose.
         * 
         * The java for loop still has a looping variable just as it 
         * did in Python The syntax here is (initial state of looping 
         * variable; loop continuation condition, increment on looping 
         * variable)
         * In Python, the syntax was for x in range(0,10):
         * where x is the looping variable, the loop continuation 
         * condition is that x < 10, and the increment is 1 since this
         * is the default for range.
         * 
         * In Java, the same for loop looks like:
         */
        System.out.print("For loop example\n");
        for (int x = 0; x < 10; x++) {
            System.out.print(x + "th Hello\n");
        }
         /*The int x = 0 defines the looping variable called x and 
          * initializes it to 0. The x < 10 says stay in the loop as 
          * long as x < 10, just like in a while loop. The x++ is the 
          * shorthand way of writing x = x + 1. This is the increment
          * on x each time in the loop. Add 1 to x.
          */
           
        //class exercise: declare a variable x2 that is an integer, 
        //and write a loop that doubles x2 10 times, print result 
        //outside the loop. Initial value of x2 > 0
        int x2 = 1;
        for(int x = 0; x < 10; x++)
        {
        	x2 = x2 * 2;
        }
        System.out.println(x2);

        /*In Python, we saw how a variable could hold a collection on data,
         * such as a list of items, or a dictionary of key/value pairs.
         * Java also has this capability, and one of the simplest data
         * types that can hold multiple values is called an array. An array
         * is similar to a list in Python, but all items in the array need
         * to be the same type, and you need to give the array a size when
         * you declare it. 
         * 
         * An array is a container object that holds a number of items. 
         * The declaration looks different than it does for other variables
         * we've seen so far in Java.
         * For example, an array of 10 integers would look 
         * like:
         */
        int[] intArray = new int[10];
        /*intArray is the name of the array object, and we're saying 
         * create a new object that is of type int and make it big
         * enough to hold 10 integers. The new keyword is part of the 
         * Java syntax and we'll see this again when we talk more about
         * objects.
         */
        /*Once the array is created, we can access it the same way we
         * accessed items in the python lists, using the index of the
         * item. For example, we can set values in the array like so:
         */
        intArray[0] = 10;
        intArray[1] = 20;
        intArray[9] = 90;
        for(int x = 0; x < 10; x++)
        	System.out.println(intArray[x]);

        /*An array of 5 doubles looks like */
        double [] dblArray = new double[5];
        dblArray[4] = 99.99; //set one value
        
        /* Exercise:
         * Back to the area, circumference examples from the first two
		 * weeks of class. We calculated area and circumference for
		 * a circle with a given radius, and we got that radius value
		 * from the user. But, what if we wanted to calculate area for
		 * circles with a radius between 1 and 10 in increments of 1. 
		 */ 

        //moving on to nested for loops. 
        /* When you have an array such as the ones we defined above,
         * there is one dimension in the data. You can think of this
         * as being one row or one column or one set of features. But,
         * often, data has way more than one dimension. For example,
         * when we read .csv files in Python, each row was one 
         * dimension, and then within each row was another dimension.
         * In the QB data, each row was for a particular quarterback,
         * and each column defined the parameters needed for the QB
         * rating. Those parameters made up the second dimension of data.
         * 
         * If you want a loop that goes over multiple dimensions, you
         * will need multiple loops, one for each dimension.
         */
        /*The idea here is we have one for loop inside of another for 
          * loop, such as:
          */
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                System.out.print("a = " + a + " and b = " + b + "\n");
            }
        }
		/*In nested for loops, the inner loop will execute completely
		 * one time for each time the outer loop executes. In the 
		 * previous example, this means that when a =0, be inner b
		 * loop will go from 0 to 4. Then the inner loop exits, a is 
		 * incremented to 1, and the b loops again from 0 to 4.
		 */
		  
        /*These loops are used when you need to look at combinations of
         *  data. We will be doing more with nested for loops when we
         * talk about image analysis in a couple of weeks. In that case,
         *  each loop will be for a dimension in the image, one for loop
         * will control which row we're evaluating and one for loop will
         *  control which column we're evaluating. We kind of did 
         * something like this when we were reading files and splitting 
         * the lines. We had one for loop for the file row and we used 
         * another for loop once we split the row to look at the 
         * individual items in the row.
         */
        /*If we can have loops that cover 2D, then we can also have
         * data types that are 2D. A 2D array is often referred to as
         * a matrix. To declare a 2D array of integers, you could do:
         */
        int [][]myArray = new int[10][5];
        /*myArray is a 2D array that is 10 rows and 5 columns.
         * You can access individual items in the array using the
         * index for both the row and column.
         */
        myArray[0][0] = 25;
        myArray[1][1] = 15;
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 5; b++) {
                System.out.print(myArray[a][b] + " ");
            }
            System.out.println();
        }
		
         /*Exercise:Calculate wind chill for range of temperatures and
          * wind speeds. 35.74 + 0.6215T - 35.75(V^0.16) + 0.4275T(V^0.16)
          * There is a nonlinear relationship between temperature, wind
          * speed, and the wind chill. We may want to evaluate how
          * wind chill changes for a range of temperatures and a range
          * of wind speeds. For example, what is the wind chill when 
          * the temperature is 35 and the wind is between 5 and 35 mph.
          */ 
          //temperatures between 0 and 40, in increments of 5
          //wind speeds between 5 and 35, in increments of 5
          //Answer is in Lecture25WindChill.java
          
    }
}
