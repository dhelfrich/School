/* We're continuing on with a discussion of objects
 * and methods using both the Picture class that
 * was introduced on Monday and expanding the 
 * capabilities of the Automobile class. For the
 * Picture class, we're going to look at indexing
 * into the image to modify individual pixels to 
 * demonstrate 2D arrays and nested for loops.
 * 
 * Picture uses the Color object, we need to 
 * import it first.
 */
import java.awt.Color;

public class Lecture31ObjectExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* This class is included in a project with
		 * Picture, so we can create an instance of
		 * it here.
		 * 
		 */
		Picture dolphin = new Picture("dolphin_swimming.jpg");
		/* dolphin now contains the color values for all
		 * pixels in the dolphin_swimming.jpg image. The
		 * color of the pixel is made up of red, green, and
		 * blue values between 0-255. We can retrieve those
		 * values and we can also modify those values to 
		 * change the dolphin variable.
		 */
		//Display the image to see where we start
		dolphin.show();
		/* We can retrieve individual pixel values using
		 * the get method included with Picture. For
		 * example, get the r,g,b values of the pixel
		 * at 100,100:
		 */
		Color cDolphin = dolphin.get(100, 100);
		//this area should be kind of blue
		System.out.println(cDolphin);

		/* When you print cDolphin, you see that it's
		 * recognized as a java.awt.Color object, which
		 * we expect. We also see that there are three
		 * numbers printed, one for each red, green, and
		 * blue. This tells use that those values are
		 * properties of Color, and we should be able to
		 * retrieve them using methods in Color.
		 * 
		 * We use the getRed, getGreen, and getBlue
		 * methods.
		 */
		int r = cDolphin.getRed();
		int g = cDolphin.getGreen();
		int b = cDolphin.getBlue();
		/* When we print, we should see the same numbers
		 * we saw when we printed the Color object, but
		 * now they're contained in nice integers that
		 * we can work with easily.
		 */
		System.out.println("r=" + r + " g=" + g + " b=" + b);
		
		/* We can retrieve pixel r,g,b values and also
		 * set those values to create new images. For 
		 * example, let's draw a black stripe through our
		 * dolphin image. We need to use the set method
		 * that is included with Picture. We want the 
		 * stripe to go horizontally through the middle
		 * of the image, all of the way across the image.
		 * This is easiest with the for loop, where each
		 * time through the loop, we use the index of the
		 * loop as the index into the image. 
		 * 
		 */
		//we need the size of the image
		int w = dolphin.width();
		int h = dolphin.height();
		
		/* Here is the exception to the row,column
		 * rule I mentioned before. With images, 
		 * x is the width and y is the height. This
		 * effectively makes x the column and y
		 * the row.
		 */
		for(int x = 0; x < w; x++){
			for(int y = 100; y < 200; y++){
				/* setColor expects 5 arguments, the
				 * x,y values and the three r,g,b
				 * values. This will change the 
				 * r,g,b, weights for the x,y 
				 * pixel.
				 */
				dolphin.setColor(x, y, 0, 0, 0);
				
			}
		}
		//Show the new image.
		dolphin.show();
		//put multiple images together
		Picture redBug = new Picture("red_bug.png");
		Picture blueBug = new Picture("blue_bug.png");
		int wRed = redBug.width();
		int hRed = redBug.height();
		int wBlue = blueBug.width();
		int hBlue = blueBug.height();
		int wFinal = wRed + wBlue;
		/*Here, we just verify that the images can 
		 * be written into another Picture object
		 * We create a blank Picture and the copy the
		 * values of the bug photos into the Picture
		 * object.
		 */
		Picture red = new Picture(wRed,hRed);
		for(int x = 0; x < wRed; x++){
			for(int y = 0; y < hRed; y++){
				red.set(x, y, redBug.get(x, y));
			}
		}
		red.show();
		
		Picture blue = new Picture(wBlue,hBlue);
		for(int x = 0; x < wBlue; x++){
			for(int y = 0; y < hBlue; y++){
				blue.set(x, y, blueBug.get(x, y));
			}
		}
		blue.show();

		/* But, the blank Picture is more useful as a 
		 * container for creating new images by reading
		 * images and putting them together, or adding
		 * elements of color.
		 * 
		 * Exercise: How would you create a Picture that
		 * contains both bugs side by side?
		 * 
		 * Create a Picture that is big enough to hold
		 * both images side by side. The images are
		 * the same height, so I will use the hRed. You
		 * could also use hBlue and that would be fine.
		 */ 
		Picture bothBugs = new Picture(wFinal,hRed);
		/*put red in first, starting at left edge
		 * Do this by setting the pixel values of 
		 * bothBugs to the redBug values.
		 */ 
		for(int x = 0; x < wRed; x++){
			for(int y = 0; y < hRed; y++){
				bothBugs.set(x, y, redBug.get(x, y));
			}
		}
		/*Next, we need to add the blue bug on the
		 * right side of the red bug. We do this by
		 * starting the indexing at the edge of the
		 * red bug and going all the way to the left
		 * edge of bothBugs.
		 */ 
		for(int x = wRed; x < wFinal; x++){
			for(int y = 0; y < hRed; y++){
				/*The index of blueBug needs to remove
				 * the offset from the for loop. blueBug.get
				 * should only go from 0 to 128, but x is 
				 * starting at 128 so that we can print the
				 * blue bug next to the red bug. We need to 
				 * subtract wRed from the blueBug x index
				 * in order to get the correct number.
				 */
				bothBugs.set(x, y, blueBug.get(x-wRed, y));
			}
		}
		bothBugs.show();

		/*We can also write one image over the top of
		 * the other, such as draw a bug in our dolphin
		 * image by changing the color values for the 
		 * dolphin at a specified location that is the
		 * size of the bug. For example, if we want to
		 * put the upper-left-hand corner of the bug
		 * image at 700,600 of the dolphin image, we 
		 * could do:
		 * 
		 */
		for(int x = 0; x < wRed; x++){
			for(int y = 0; y < hRed; y++){
				dolphin.set(x+700, y+600, redBug.get(x, y));
			}
		}

		dolphin.show();
	}

}
