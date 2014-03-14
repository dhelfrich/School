 /*CSCI 1300, Spring 2014
 * Copyright 2014 Rhonda Hoenigman
 * University of Colorado, Boulder, Colorado
*/

/*Conditionals and loops, pages 46-55 in your Java book. 
 * In Python, we used if/elif/else blocks and while loops to
 * control the flow through a program. This enabled us to do
 * one thing if the value of a variable met a condition, and do
 * another thing if it didn't. 
 * 
 * Java has the same constructs, also called if/elif/else, to establish
 * branching in the code, and while loops to set up repetition in
 * the code.
 */ 


/* Loops, again.
 * Just like in Python, Java has commands for implementing tasks that
 * you want to repeat for either a defined number of times or until a
 * pre-defined condition has been met. These loops are called while and
 * for, just like in Python. For the while loop, the syntax is a 
 * little different, but the concept is the same, repeat the code in
 * the loop while the condition is true. The for loop in Java is a bit
 * different than what we saw in Python. In Java, it's a counter instead
 * of an iterator. In Python, the for was used to iterate through a 
 * collection, and we also saw how it could be used to index into a 
 * collection. In Java, we'll focus on the indexing.
 *  
 * */

public class Lecture24JavaConditionalsLoops
{		
	public static void main(String[] args)
	{

		
		//declare some variables as integers
		int a = 5;
		int b = 6;
		//add two integers together and store them in integer c
		int c = a + b;
		
		
		/* You want to know if the variable c that we 
		 * just declared is greater than 5
		* You would write:
		* */
		if (c > 5)
		{
			System.out.print("c is > 5\n");
		}	
		/* There are a few things to notice in this example. The word 
		 * "if" is the same as you used in Python and it serves the
		 * same purpose. The () here are required, they weren't in 
		 * Python. The purpose of the statement is to check the truth
		 * value of the expression in the (), so is it true that c > 5.
		 * 
		 * Next, notice the {. This is the start of the block of code
		 * that executes if the if statement is true. In Python, this
		 * was accomplished with indentation. Here, indentation doesn't 
		 * matter. Then, the block is closed with the }. That's the end
		 * of the if block of code. 
		 * 
		 * Note: if you only have one line of code in your if block, then
		 * you don't need the {}, so we could have skipped them in this
		 * example. But, for now it's good to get in the habit of using
		 * them.
		 */ 
		
		/*And, just like in Python, where's there's an if, there's an
		 * if/else.
		 * */
		if (c > 5)
		{
			System.out.print("c > 5\n");
		}
		else
		{
			System.out.print("c <= 5\n");
		}
		
		/*There's also an else if, but it looks a bit different than
		 * Python. Java uses else if instead of elif. But the logic
		 * is the same */
		if (c > 5)
		{
			System.out.print("c > 5\n");
		}
		else if (c < 5)
		{
			System.out.print("c < 5\n");
		}
		else
		{
			System.out.print("c = 5\n");
		}

		/* The operators in conditionals are the same as we saw in Python.
		 * There's <, >, <=, >=, ==, != for less than, greater than,
		 * less than or equal to, greater than or equal to, equal, not
		 * equal.
		 */ 
		 
		 /*Redo the Python Subaru if exercise using command line args.
		  */

        //Create a variable called i that is an integer and set it to 0
        int i = 0;
 
        /*My first Java while loop.
         * Use i to control how many times we go through the loop
         * In this example, i goes from 0 to 10, inside the while loop, 
         * we print ith Hello, using the current value of i
         * */
        System.out.print("While loop example\n");
        while (i <= 10) {
            System.out.print(i + "th Hello\n");
            //increment i so that we don't loop forever
            i = i + 1;
        }
		/*Notice some of the syntax on the while loop. You start with the
		 * keyword while, then () contains the condition that your're 
		 * checking. As long as that condition is true, we will repeat
		 * the code in the while loop block. The block of code that runs
		 * is enclosed in the {}.
		 */
		 /*The relational operators for a while loop are the same as they
		  * are for the if statements, <=, >=, <, >, ==, !=
		  
		  Notice how this example prints one less time than the previous
		  * example
		  */
		  i = 0;
        while (i < 10) {
            System.out.print(i + "th Hello\n");
            //increment i so that we don't loop forever
            i = i + 1;
        }		   

		/*In these previous while examples, we were checking for truth,
		 * but we had a good idea of how many times the while loop code
		 * would run because we were counting. We could do another 
		 * example using some random variable and some operation where
		 * we didn't know how many times we needed to run the loop.
		 */
		  //Exercise: sum random numbers until sum > 500
		   
	}

}
