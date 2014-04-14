/* Today, we're going to review the material we started
 * before the break about objects, including constructors,
 * instance variables, and instance methods. Then, we're
 * going to move on and talk about third-party code, which
 * is code that comes from some source other than yourself
 * or Java. In this case, we'll be using a file called
 * Picture.java, which provides some graphics capabilities
 * that make image access and manipulation easier than
 * it would be without that Picture class. The Picture
 * class is effectively a wrapper that makes image
 * processing easier. 
 */
import java.awt.Color;

public class Lecture30ObjectExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* In the last lecture, we created an Automobile 
		 * class, with instance variables for year,make
		 * model, speed. We can create an instance of
		 * that Automobile class using the constructor
		 * 
		 */
		Automobile subaru = new Automobile("Subaru","Outback",2005, 10);
		/*The class also has a method to set the speed and
		 * get the speed of the subaru.
		 * 
		 */
		subaru.setSpeed(65);
		System.out.println(subaru.getSpeed());
		/* The getSpeed and setSpeed are examples
		 * of getters and setters because they are
		 * used to get and set private variables.
		 * 
		 * But why? Why use private variables?
		 * Notice first that you can't access any of 
		 * the instance variables directly. If you
		 * type subaru. you won't see any of the variables
		 * as options for things you can select. However
		 * if you make one of the variables public, and
		 * then type subaru. you will see that name of the
		 * variable and you can set it directly. This
		 * is the difference between public and private.
		 * 
		 * When you build a class, such as Automobile,you
		 * care the designer of that class and as such,
		 * you want to be able to control how it is used. If
		 * variables are public, they can be changed at will,
		 * and the change may be unnecessary or generate an
		 * error. For example, if make is public, the user
		 * could try to change it to a number, which would
		 * generate an error. However, if make is private,
		 * then the setter method could include error 
		 * handling that will help the program fail gracefully.
		 * In this example, it may not even make sense to 
		 * have a method for setting the make. Once a
		 * real automobile is built, its make doesn't change.
		 * We can create the same behavior for our Automobile
		 * class by having a method for getting the make but
		 * nothing for setting the make. This effectively 
		 * makes the variable read-only.
		 * 
		 * The Automobile class encapsulates all of the 
		 * functionality that you as the designer want to
		 * include in that Automobile variable.
		 * 
		 * Next, we're moving on to look at an example of
		 * a class created by a third-party. The Picture.java
		 * file was included on the website for the course
		 * textbook and includes a nice, simple way of using
		 * some of Java's built-in image processing without
		 * having to deal with the Java-ness of it. It's 
		 * called third-party because it's not included in
		 * Java, and it wasn't developed by any of us. It
		 * was developed by some other third-party. 
		 * 
		 * Using the functionality of Picture should look 
		 * familiar. Calling the constructor to create a 
		 * new instance of Picture:
		 */
		Picture pict = new Picture("dolphin_swimming.jpg");
		//Use the show method to display the image
		pict.show();
		/*Use the height and width methods
		 * to return the height and width of the image
		 */
		int height = pict.height();
		int width = pict.width();
		/*We can look at the Picture class and see the 
		 * constructor and the height and width methods.
		 * 
		 * One of the things you'll notice when you look
		 * at Picture.java is that there are multiple
		 * constructors, and they all look slightly 
		 * different. There are multiple ways to create
		 * an instance of Picture. We are using the 
		 * constructor that creates an image from a file,
		 * the argument to the constructor is the name of 
		 * the file to open, in this case, dolphin_swimming.jpg.
		 * The constructor encapsulates all of the code to
		 * open the file and display it and handle any
		 * error checking needed to make sure that you as
		 * the user entered a valid filename. You don't 
		 * have to worry about any of that stuff, you just
		 * use the Picture class and have one line of 
		 * code in your program to create a Picture object
		 * 
		 * Since we have multiple constructors, let's look
		 * at creating another instance of Picture using
		 * a different constructor. We'll use the constructor
		 * that creates a blank image for a given height and 
		 * width.
		 */
		Picture newPict = new Picture(width, height);
		//should be same size as dolphin photo
		newPict.show();
		/*The Picture objects contain a 2D array of the color
		 * values for each pixel in the image. The pixel is
		 * the smallest visual unit on your computer screen,
		 * and the color value of that unit is made up of a 
		 * combination of three weights: red, green, and blue.
		 * There is a value for red between 0-255, a value
		 * for green between 0-255, and a value for blue
		 * between 0-255. For example, in our black image,
		 * we could get the Color of any pixel and see
		 * 0,0,0, these are the red, green, and blue weights
		 * for the color black. First, import Color. Color
		 * is a class that is built-in to Java and contains
		 * the red, green, and blue properties of a pixel.
		 * The get method in the Picture class returns
		 * an object that is of type Color.
		 * 
		 */
		Color c = newPict.get(100, 100);
		System.out.println(c);
		/*Getting the color of one of the dolphin pixels
		 * most likely won't be 0,0,0.
		 */
		Color cDolphin = pict.get(100, 100);
		//this area should be kind of blue
		System.out.println(cDolphin);
		
		//Exercise: is it possible to set the color on these images?
	}

}
