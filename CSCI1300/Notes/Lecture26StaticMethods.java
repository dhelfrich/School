 /*CSCI 1300, Spring 2014
 * Copyright 2014 Rhonda Hoenigman
 * University of Colorado, Boulder, Colorado
*/
/*In Python, we saw how code could be encapsulated in functions,
 * where a function was a block of code that did stuff. Instead
 * of typing all of that code every time we needed it, we could
 * just call the function using the function name, and that code
 * would then run at the spot where the function was called.
 * In Java, this same functionality exists, only, java functions are
 * called methods. The syntax is a bit different, but the concepts
 * are the same. 
 */
public class Lecture26StaticMethods {

	/**
	 * @param args
	 */
    /*This method is called addTwoNums. It takes two arguments, both
     * integers, and returns an integer. Notice that the arguments now
     * have the data type in front of them, in Python they didn't, and the
     * method name also has a data type in front of it. That's how we
     * know the type associated with that method. Since the method returns an
     * integer, somewhere in the method, there must be a variable that is 
     * declared as an int, and it is that variable that will be the return. In this
     * case, int sum is the return. The type of the variable sum is the same 
     * type as the method return.
     * 
     * The variables a and b are local
     * to this method only, meaning that those same variables not visible
     * outside of this method. The int sum variable is also local.
     */
    public static int addTwoNums(int a, int b)
    {
        int sum;
        sum = a + b;
        return sum;
    }
    
    /*In this example, the method takes two doubles, divides them, and
     * returns that value. The return type is a double also.
     */
    public static double divTwoNums(double b, double c)
    {
        double z = b / c;
        return z;
    }
    
    //this function has three inputs, which are two arrays of ints
    //the function returns the sum of the differences between the arrays
    public static int compareArrays(int []var1, int[] var2)
    {
        /* diff1 is a local variable. It can only be used within 
         * compareArrays and goes out of scope outside of this method
         */
        
        int diff1 = 0;
        for(int i = 0; i < var2.length; i++)
        {
            //Use the Math.abs method on var1[i] and var2[i]
        	diff1 = diff1 + Math.abs(var1[i]-var2[i]);
            
        }
        return diff1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //function examples
        //here is a function with two integer inputs that returns an integer
        int intFunc;
        intFunc = addTwoNums(5,6);
        System.out.println(intFunc);
        
        double dblFunc;
        dblFunc = divTwoNums(6,5);
        System.out.println(dblFunc);
        
        //create three integer arrays
        int []a = {5, 6, 7, 8};
        int []b = {6, 7, 8, 9};
        int []c = {52, 66, 71, 86};
        int diff1 = 0;
        int diff2 = 0;
    
        /*Back to similarity, we want to know if array b or array c
         * is more similar to array a. I created a function to calculate
         * the absolute difference between array a and b. This is like
         * to our Hamming distance exercise where you calculated string
         * similarity and the number of mis-matched letters between two
         * strings.
         * 
         * We've written a method called compareArrays. We can call it twice
         * to calculate the difference between a and b and a and c.
         */
        diff1 = compareArrays(a,b);
        diff2 = compareArrays(a,c);
        
        //next, compare the values of diff1 and diff2
        if (diff1 < diff2)
        {
            System.out.println("a more similar to b");
        }else if(diff1 > diff2)
        {
            System.out.println("a more similar to c");
        }else
        {
            System.out.println("a equally similar to b and c");
        }


	}

}
