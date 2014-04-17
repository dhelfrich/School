import java.text.DecimalFormat;

/*
 * There are many ways to round numbers in Java, and
 * some of them have consequences beyond just numbers not
 * looking good on screen. Today we're going to look at
 * a few of the options, and the positives and negatives
 * of these options.
 * 
 * When you round numbers, there's a difference between
 * rounding the actual value and rounding how a number
 * is displayed. Generally speaking, it's safer to round
 * the display and leave the actual value unchanged.
 */
public class Lecture37Rounding {

	/**
	 * @param args
	 */
	static float roundOff(float x, int position)
    {
        float a = x;
        double temp = Math.pow(10.0, position);
        a *= temp;
        a = Math.round(a);
        return (a / (float)temp);
    }

	public static void main(String[] args) {
		/*
		 * Options for changing the display.
		 * One of the simplest ways to change
		 * the display is to use the format 
		 * specifiers that go with the printf
		 * method. This will format the output
		 * to stdout. For example,
		 */
		double d = 4.567435234;
		//round display value to 2 decimal places
		System.out.printf("d=%.2f\n",d);
		//round display value to 3 decimal places
		System.out.printf("d=%.3f\n",d);
		/* In this example, the .2 is the number of
		 * decimal places, the f is the format 
		 * specifier for floating point numbers, and
		 * the % is also part of the format specification,
		 * it aligns the variable with the position in the
		 * string.
		 */
		
		/*Another formatting option is String.format. The %
		 * and the .X have the same meaning as with the printf
		 * method. The %n is a newline.
		 * Unlike printf, which always writes to
		 * stdout, String.format will generate a formatted
		 * string, and you can do with it what you want
		 * 
		 */
		double d2 = 0.912385;
		String test = String.format("%.5f%n", d2);
		//write to stdout to show that it worked.
		System.out.println(test);
		System.out.println(String.format("%.3f%n", d2));

		/*There is also a DecimalFormat class that
		 * can be used to generate an object that can
		 * format a number. Be careful with this one,
		 * the default behavior is to round .5 to the
		 * closest even number. This can result in numbers
		 * being rounded up or down. For example, 
		 * 0.912375 and 0.912385 will both round to
		 * 0.91238. 
		 * 
		 * Using DecimalFormat may give you more control
		 * over exactly how your numbers are displayed. But,
		 * it also has to instantiate an object. This will be
		 * most likely slower than String.format, which could
		 * be a problem if you have lots of displays to do.
		 */
		DecimalFormat df = new DecimalFormat("#.#####");
		System.out.println(df.format(0.912375));
		/*
		 * Moving on to rounding where we actually
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
        
	}

}
