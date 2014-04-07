/* This lecture is intended to provide examples
 * for calculating the Euclidean distance between
 * two pixels in an image. In Assignment 10, you
 * will be using the Euclidean distance to classify
 * pixels in a food image and determine the 
 * percentage of each food type in the image.
 */
import java.awt.Color;

public class Lecture32EuclideanDistanceExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* We'll use the dolphin photo again
		 * here and pick out a few pixels from
		 * the image and look at their r,g,b
		 * values.
		 * 
		 */
		Picture dolphin = new Picture("dolphin_swimming.jpg");
		dolphin.show();
		//draw a few black squares to see where we are
		/*These first two boxes are up in the sky of the
		 * image and should be a similar color.
		 * This is purely for informational purposes, it 
		 * isn't needed for classification. It gives us
		 * information about what we should expect to see
		 * if we read the r,g,b values of a nearby pixel.
		 */
		for(int x = 100; x < 105; x++){
			for(int y = 100; y < 105; y++){
				dolphin.setColor(x, y, 0, 0, 0);
			}
		}
		for(int x = 200; x < 205; x++){
			for(int y = 100; y < 105; y++){
				dolphin.setColor(x, y, 0, 0, 0);
			}
		}
		/*This box is down in the water*/
		for(int x = 600; x < 605; x++){
			for(int y = 600; y < 605; y++){
				dolphin.setColor(x, y, 0, 0, 0);
			}
		}
		
		dolphin.show();
		/*Choose points that are just outside the
		 * boxes we drew and get their color values
		 */
		Color c1 = dolphin.get(106, 100);
		Color c2 = dolphin.get(206, 100);
		Color c3 = dolphin.get(606, 600);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		/* The values for c1 and c2 are pretty
		 * similar, which we expect. But, the
		 * values for r,g,b are not exactly the
		 * same, showing that there is some 
		 * variation in the color between the 
		 * two pixels. The third pixel, from the
		 * water, has r,g,b, values that make it
		 * quite different from the other two
		 * pixels.
		 * 
		 * The similarity between the pixels can
		 * be captured by calculating the 
		 * Euclidean distance. This will produce
		 * one number that can then be used for
		 * classification. The Euclidean distance
		 * needs the values for r,g,b for both
		 * pixels, we can get those using methods
		 * in the Color object.
		 */
		//first pixel
		int r1 = c1.getRed();
		int g1 = c1.getGreen();
		int b1 = c1.getBlue();
		//second pixel
		int r2 = c2.getRed();
		int g2 = c2.getGreen();
		int b2 = c2.getBlue();
		//distance between first and second pixel
		double dist1 = Math.sqrt(Math.pow(r1-r2, 2) + Math.pow(g1-g2, 2) + Math.pow(b1-b2, 2));
		//third pixel
		int r3 = c3.getRed();
		int g3 = c3.getGreen();
		int b3 = c3.getBlue();
		//distance between first and third pixel
		double dist2 = Math.sqrt(Math.pow(r1-r3, 2) + Math.pow(g1-g3, 2) + Math.pow(b1-b3, 2));
		/* As expected, dist1 is less than dist2 */
		
		System.out.println("first distance = " + dist1);
		System.out.println("second distance = " + dist2);
		
	}

}
