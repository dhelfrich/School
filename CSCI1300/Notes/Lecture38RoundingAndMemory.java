
public class Lecture38RoundingAndMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Continuing where we left off last time
		 * with rounding, we're going to cover
		 * rounding where we actually
		 * change values.
		 * 
		 * Simplest way to round numbers is to use
		 * Math.round. This will round a floating
		 * point number to the closest integer value.
		 * Math.round returns a long, which is a really
		 * big integer.
		 */
		double a1 = 4.43994523;
		long b = Math.round(a1);
		System.out.println(b);

		/* Another rounding option, if you
		 * want your numbers to still be decimals
		 * is to multiply by a factor of 10, and then
		 * divide by the same factor.
		 * 
		 * This is not advised as a rounding option due
		 * to strange things that can happen with 
		 * floating point arithmetic. For our purposes
		 * in this class, rounding to 2 decimal places should
		 * be ok. However, if you round during your calculations
		 * instead of just at the end, you can see the cumulative
		 * effects of rounding and get results that you don't 
		 * expect. Also, most floating point numbers can't be
		 * represented exactly in a computer. For example, a
		 * number may require an infinitely repeating pattern
		 * of binary 1's and 0's, but you only have 32 bits for 
		 * floats and 64 bits for doubles. This finite precision
		 * means that there is truncation in the value, which
		 * can be further compounded with rounding.
		 * 
		 * If you do want to round by multiply and divide
		 * method, you would do:
		 */
		a1 = Math.round(a1*100.0)/100.0;
		System.out.println(a1);
		
		/*
		 * But, here is an example showing how things
		 * can be not quite what you expect. We do
		 * rounding on .000943 to get .001. However,
		 * when we subtract the rounded value from
		 * a float .001, we get a number that is not 
		 * quite 0, due to some loss of precision.
		 * 
		 * Repeating this action using doubles for both
		 * numbers will yield a different result.
		 */
        double a = Math.round(0.000943*1000.0)/1000.0;
        float a2 = (float)0.001;
        double a3 = a2-a;
        System.out.println(a3);

		/*
		 * The next topic we're going to discuss gets
		 * into concepts of computer memory and what 
		 * happens when you create an object, and then
		 * make a copy of that object.
		 * 
		 * For this exercise, we're going to create a
		 * class called Cat, and then create instances
		 * of Cat. Here, we create an array of Cat
		 * called cat.
		 */
		//an array of Cats
		Cat[] cat = new Cat[2];
		cat[0] = new Cat("Fluffy", 1);
		cat[1] = new Cat("Scruffy",2);

		/*
		 * Create space in memory for another
		 * Cat array, called catCopy. But, don't create
		 * instances of Cat.
		 */
		Cat[] catCopy = new Cat[2];
		/* For catCopy, create a reference to cat
		 * where each item in the catCopy array
		 * is a reference to the corresponding
		 * item in cat. 
		 * 
		 * This is called a shallow copy. This makes
		 * a copy of the reference to the object,
		 * not creating a new instance.
		 */
        for( int i=0; i<cat.length; i++){
          catCopy[i] = cat[i];
          //verify values are equal
          System.out.println(cat[i].getName() + " " + cat[i].getAge());
          System.out.println(catCopy[i].getName() + " " + catCopy[i].getAge());
          
        }
        /* What makes shallow copy interesting is that, since
         * we've copied a reference, changing a value for one
         * of the objects should also change the value for the
         * other object.
         * 
         * Call the setAge method on cat[0], changing the age
         * to 13. This only calls the method on cat, not on 
         * catCopy. However, if we print the values for age
         * for both cat and catCopy, they've both changed.
         */
        cat[0].setAge(13);
        System.out.println(cat[0].getAge() + " " + catCopy[0].getAge());
        /*The opposite is also true, if we change something
         * on catCopy, that will also change cat.
         */
        catCopy[1].setAge(5);
        System.out.println(cat[1].getAge() + " " + catCopy[1].getAge());

        /*
         * The other copy option, which will create
         * unique instances of the objects instead
         * of references to objects, is called deep copy.
         * Deep copy, creates a new instance of the
         * object, using the values from the object
         * being copied. We shouldn't see values for
         * copy change when original changed.
         */
        Cat[] catCopy2 = new Cat[2];
	    for( int i=0; i<cat.length; i++){
	    	/*
	    	 * Get the values from cat, and then use
	    	 * them in catCopy2.
	    	 */
	    	String name = cat[i].getName();
	        int age = cat[i].getAge();
	    	catCopy2[i] = new Cat(name, age);
	        System.out.println(cat[i].getName() + " " + cat[i].getAge());
	        System.out.println(catCopy2[i].getName() + " " + catCopy2[i].getAge());

	    }
	    /*
	     * Now, if we change cat, or catCopy2, we should
	     * just see that instance change, not both.
	     */
	    cat[0].setAge(100); //worlds oldest cat
	    //catCopy2 hasn't changed
        System.out.println(cat[0].getAge() + " " + catCopy2[0].getAge());
        /*
         * Another place where references are meaningful is
         * in arguments to methods. Passing a reference, as we
         * saw in Assignment 9, means that an object can be
         * modified in the method and the changes will be
         * visible in the calling method. For example, if
         * cat were modified in a method called modifyCat,
         * whatever changes we make are present in main.
         * 
         * Call modifyCat here, pass it an item in catCopy2
         */
        modifyCat(catCopy2[1],200);
        System.out.println(catCopy2[1].getAge());
        /*
         * Then, if you pass a reference to modifyCat,
         * that is a copy of another reference, both values
         * should change.
         */
        System.out.println(catCopy[1].getAge());
        modifyCat(catCopy[1], 220);
        System.out.println(catCopy[1].getAge() + " " + cat[1].getAge());
        
	}

	public static void modifyCat(Cat cat, int age){
		//make a change to cat
		cat.setAge(age);
		//no return value
	}
}
