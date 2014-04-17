import java.awt.Color;

//Notes
//Charge objects - properties
	//color
	//location
	//size
	//velocity
	//behavior
//limitations
	//No interaction between particles
	//Particles have constant velocity, same velocity

/*Pseudo-code
 * Initialize system, set up the display, give the objects
 * an initial position.
 * Then, in a loop:
 * 	Calculate a potential for all points in the display
 * 	Calculate the color
 * 	Update the display
 * 	Move the particles
 */



public class ChargeSimulator {

	public static void main(String[] args) {
		
		//Initialization, create instances of the charge
		Charge[] c = new Charge[2];
		c[0] = new Charge(.51,.63,-10);
		c[1] = new Charge(.7,.3,10);
		
		//initialization, draw screen, blank window
		
		//draw screen
		int size = 512;
		Picture pic = new Picture(size,size);
		
		//How long to run the simulation
		int iterations = 5000;
		int x2 = 0;
		while(x2 < iterations){//for each iterations
			for(int i = 0; i<size;i++){//for each pixel
				for(int j = 0; j <size;j++){
					//scale to make x,y between 0 and 1
					double x = (double)i/size;
					double y = (double)j/size;
					
					double V = 0.0; //calculate the potential for that location
					for(int k = 0; k<2;k++){//for each particle add their potentials together
						V= V+c[k].potentialAt(x, y);
					}
					//convert V to color
					int g = 128 +(int) V;
					//error check
					if(g < 0){
						g = 0;
					}
					if(g > 255){
						g = 255;
					}
					
					Color color = new Color(g,g,g);
					pic.set(i,j, color);
							
				}
			}
			//grey is r=b=g
			pic.show();
			x2++;
			for(int k = 0; k < 2; k++)
				c[k].move();
		}
	}

}
