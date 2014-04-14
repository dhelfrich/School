/* Lecture36ParticleObjectInteractions.java
 * Covered on pages 316-323, 371-377
 * 
 * Today, we're going to look at another example of 
 * simulation. We're simulating charged particles
 * moving in space. The particles can have positive
 * or negative charge. The nice thing about this
 * simulation is that it includes a visualization,
 * allowing us to see how the charge from each
 * particle generates a charge over the entire space,
 * and we can visualize that charge at any location.
 * 
 * There are two classes included in this simulation,
 * they are Charge and Picture. We've worked with 
 * Picture previously, this is what we'll use for
 * visualization. The Charge.java class is the charged
 * particle and we'll use it to create those objects.
 * 
 */

import java.awt.Color;
public class Lecture36ParticleObjectInteraction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* In this simulation, there are two components:
		 * there are the calculations of the electric 
		 * charge, and there is the visualization of that
		 * charge.
		 * 
		 */
        
        /*
         * Here, we create an instance of Picture, this
         * is needed for the visualization section of
         * the simulation. We're using the Picture
         * constructor that creates a blank image
         * of a fixed size.
         */
        int size = 512;
        Picture pic = new Picture(size, size);
		/*
		 * To calculate the charge, we need to create
		 * instances of our charged particles. Each of
		 * these will have an initial position in space
		 * and a charge. We see these parameters in the
		 * constructor. Here, we create 9 charged 
		 * particles. In the Charge constructor, you'll
		 * notice that the velocities are the same for
		 * all charges. We could change that if we wanted
		 * by adding another parameter to the constructor.
		 */
		int N = 9;

        Charge[] c = new Charge[N];
        c[0] = new Charge(0.51, 0.63, -100);
        c[1] = new Charge(0.50, 0.50, 40);
        c[2] = new Charge(0.50, 0.72, 10);
        c[3] = new Charge(0.33, 0.33, 5);
        c[4] = new Charge(0.20, 0.20, -10);
        c[5] = new Charge(0.70, 0.70, 10);
        c[6] = new Charge(0.82, 0.72, 20);
        c[7] = new Charge(0.85, 0.23, 30);
        c[8] = new Charge(0.90, 0.12, -50);

        /*
         * The positions and charge potentials are scaled
         * for the size of the display.
         */
        /*
         * The iterations is used to control how long
         * the simulation will run. Each time through 
         * the loop, the potential of the charges at
         * each location in the picture is calculated,
         * and a pixel color to represent that level of
         * charge is selected and the image is updated.
         * 
         * There are three loops needed. One for the 
         * number of iterations, and one loop for each
         * dimension in the image. We're setting each
         * pixel, and to get to each pixel we need two
         * loops.
         *
         */
        int x2 = 0;
        int iterations = 5000;
        while(x2 < iterations)
        {
            for(int i = 0; i < size; i++)
            {
                for(int j = 0; j < size; j++)
                {
                    /*
                     * The potential calculation expects
                     * numbers between 0 and 1.0. Need to
                     * scale the 0-512 size to be between
                     * 0 and 1.0.
                     */
                	double x = (double)i/size;
                    double y = (double)j/size;

                	double V = 0.0;
                    /*
                     * At each position, the electric potential
                     * is the sum of the potential at that
                     * position for all charges. We're at the
                     * pixel level here, at the i,j position.
                     * Next, we need another loop to sum the
                     * potential at this location. We can do 
                     * this by looping over the charges and 
                     * calling the potentialAt method for each
                     * charge, giving it the current i,j position.
                     * potentialAt uses Columbs Law. 
                     */
                    for(int k = 0; k < N; k++)
                      V+= c[k].potentialAt(x,y);
                    /* V is now the potential at the i,j
                     * position, and this number can be very
                     * positive or very negative, depending
                     * on what's in the system. But, when we
                     * want to incorporate visualization, we
                     * have limitations on the numbers we can
                     * use. Each color weight, r,g,b only holds
                     * a value between 0-255. We're going to be
                     * displaying the potential in shades of grey,
                     * and grey is shown as equal values for r,g,b.
                     * For example, r=100, g=100, b=100 is a shade
                     * of grey.
                     * 
                     */
                    //need a mean value, then add or subtract
                    int g = 128+(int)V;
                    /*
                     * The values for g need to be between 0-255
                     * for the visualization to work, this is the
                     * range on the color values. Check for 
                     * outliers, and scale to the minimum or maximum
                     * for g.
                     */
                    if (g < 0){
                    	g = 0;
                    }
                    if (g > 255){
                        g = 255;
                    }
 
                    Color color = new Color(g,g,g);
                    pic.set(i,j,color);
                }
            }
            pic.show();
            for(int k = 0; k < N; k++)
                c[k].move();
            x2++;
        }

	}

}
