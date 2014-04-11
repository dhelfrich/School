
public class Lecture27MethodExamples {

	/**
	 * @param args
	 */
	/*define the printMessage method. Takes one argument
	 * that is a String and doesn't return anything, it
	 * just prints the msg. Notice that the method is
	 * defined inside the class.
	 */
	public static void printMessage(String msg){
		System.out.println(msg);
	}
	
	public static int addTwoNums(int x, int y){
		int z = x + y;
		return z;
	}
	
	public static void main(String[] args) {
		/*Before going to objects, we're going to do
		 * a little more with methods and arrays that
		 * we started on in the last lecture.
		 */
		//a 1D array of integers looks like
		int []intArray = {1,2,3,4};
		//and you can access the items with a for loop
		for(int i = 0; i < intArray.length; i++){
			System.out.println(intArray[i]);
		}	
		//you can also declare the array with all values 0
		int []myArray = new int[4];
		
		//a 2D array of integers looks like
		int [][]int2DArray = {{1,2,3,4},{5,6,7,8}};
		//need a loop for each dimension
		for(int x = 0; x < int2DArray.length; x++){
			for(int y = 0; y < int2DArray.length; y++){
				System.out.println(int2DArray[x][y]);
			}
		}

		//you can also have an array of strings
		String[] strArray = {"good job", "hang in there", "spring break soon"};
		for(int z = 0; z < strArray.length; z++){
			System.out.println(strArray[z]);
		}
		/* We also started methods in Java and saw that they
		 * can have different types and those types need to
		 * be defined.
		 * 
		 * Here is an example of calling a method called 
		 * printMessage that takes one argument and doesn't
		 * return a value.
		 */
		printMessage("this is a message");

		//method that takes two numbers and returns their sum
		int s = addTwoNums(10,20);
		System.out.println("the sum is " + s);
		
        /* Exercise:
         * Back to the area, circumference examples from the first two
		 * weeks of class. We calculated area and circumference for
		 * a circle with a given radius, and we got that radius value
		 * from the user. But, what if we wanted to calculate area for
		 * circles with a radius between 1 and 10 in increments of 1. 
		 *
		 *Write a method called calcArea that takes one argument, 
		 *a double that is the radius, and returns the area.
		 *Call the function in a loop to pass in radius values between
		 *1 and 10. Area = PI*r^2.
		 */ 

		/*Another exercise: In Python we calculated the Hamming
		 * distance between two strings by looking for places
		 * where the letters were different in each string. there
		 * are other similarity measures involving numbers, 
		 * generally arrays of numbers, where you sum the difference
		 * between two arrays.
		 * 
		 * Given the following three arrays, write a method that 
		 * takes two arguments that are both integer arrays, and
		 * returns the absolute value between the two arrays.
		 */
        int []a = {5, 6, 7, 8};
        int []b = {6, 7, 8, 9};
        int []c = {52, 66, 71, 86};

        /*next, determine which of the two arrays are closer to
         * each other. The answer is in the 
         * Lecture26StaticMethods.java file.
         */
        
	}

}
