/* In Python, we saw how variables could have different types. There 
 * were integers, which are whole numbers. There were floats, which are
 * decimal numbers. There were strings, which contained letters.
 * 
 * In Java, variables also have types, and those types are very similar
 * to what we saw in Python. However, the syntax for declaring a variable
 * is different in Java. 
 * 
 * Java requires you to be more explicit when you declare your variable.
 * You need to give the variable a type.
 * 
 * */
public class Lecture23JavaVariables
{

//we still have our main function that doesn't return a variable, it's a void type
//The String[] args is the command line parameters for the class.
	public static void main(String[] args)
	{
		
		/* Integers are declared using the int keyword, followed by the
		 * name of the variable, and then an initial value (this initial
		 * value is optional)
		 * For example, here we created two integers, called myInt1 and 
		 * myInt2 with values of 5 and 6, respectively
		 */
		 
		int myInt1 = 5;
		int myInt2 = 6;
		//add two integers together and store them in integer myInt3
		int myInt3 = myInt1 + myInt2;
		//the mod operator to find the remainder
		int myMod = myInt3 % myInt1;
		System.out.println("mod result:"+myMod);
		
		//variables with decimal values are called double
		double myDouble1 = 5.0;
		double myDouble2 = 10.0;
		//division operation, works great if everything is a double
		double divVals = myDouble1 / myDouble2;
		//addition operation
		double sumVals = myDouble1 + myDouble2;
		//multiplication
		double multVals = myDouble1 * myInt3;
		
		//There is also a char type, which is an individual letter
		char myChar = 'a';
		System.out.println(myChar);
		/* The String type. 
		 * Notice that the String keyword looks different than the double
		 * or int keywords. It's capitalized and it doesn't light up a 
		 * different color. Ints and doubles and chars are what's called
		 * primitive types in Java. They are pre-defined by the language.
		 * Whereas, the String, being a collection of chars, is 
		 * treated differently, it's handled differently in Java, and so
		 * the syntax is different.
		 */
		 
		String myStr = "This is a string";
		
		System.out.println("Hello, world");

		/* Building the print string. You can generate a string to print
		 * by adding things together. This is different than what you
		 * saw in Python, where using + on numbers and strings would
		 * generate an error.
		 */
		  
		System.out.println("divVals = " + divVals + " \n");
		 
		System.out.println("myInt3 = " + myInt3 + "\n");
		System.out.println("sumVals = " + sumVals + "\n"); 
		
		System.out.println(myStr + "\n");
		
		//Start discussion of objects here
		//Command line arguments and the Double and Integer object
		//args is an array of Strings, this is similar to a list in Python
		//if there is one argument, then args looks like ["argument1"]
		//if there are two arguments, then args looks like ["argument1", "argument2"]
		
		//index into args to get the value, args[0] gets the first argument 
		String myName = args[0];
		System.out.print(myName);
		System.out.println();
		
		//this gets the second argument from the command line
		String anotherArg = args[1];
		System.out.print(anotherArg);
		System.out.println();

		//if command line arguments are not intended to be used as strings, we need to cast them
		//since everything in Java is a class, our casting is also class-based
		//this takes a string and casts it as a double
		double argDouble = Double.parseDouble(args[2]);
		System.out.print(argDouble);
		System.out.println();
		
		int argInt = Integer.parseInt(args[3]);
		System.out.print(argInt);
		System.out.println();

		//Exercises:
		/* Calculate the Bill at the restaurant. The amount is a 
		 * command line argument +15% tip. Calculate what each
		 * person owes if it's split 4 ways.
		*/
		//Redo the lbs CO2 exercise from Lecture4, should be w/o if 
		
		//redo C to F question from the midterm1
		
		
		
		
		
		
		
		
	}
}
