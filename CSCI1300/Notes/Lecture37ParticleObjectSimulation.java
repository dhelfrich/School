/*
 * In today's lecture, we'll continue discussing the
 * particle simulation we started on Monday. Before
 * continuing with the code, we're going to discuss
 * what we observe in the simulation, and then put
 * together some pseudo code. Then, we'll continue
 * with the coding.
 * 
 * The full code for the simulation is in 
 * Lecture36ParticleObjectInteraction.java,
 * Charge.java, and Picture.java.
 *
 */
public class Lecture37ParticleObjectSimulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		Properties and behavior of the objects:
		Objects floating in space
		Objects have a color – black or white
		Objects have a size
		Objects have a velocity (change in x and y directions)
		Objects change direction at the walls

		Properties and behavior of display:
		Things are moving – it’s an animation
		Every pixel is some shade of grey
		There is fuzziness on edges of floating objects
		The display has edges and objects bounce off

		What we’re watching:
		Simulation of movement of charged particles
		There is a charge of the particle, and the electric potential around that particle can be calculated with Coloumbs Law. Grey areas are no charge. Fuzzy areas are some charge, but the value is diminishing as distance from particle center increases.

		Limitations:
		Particles all have same velocity
		No collisions between particles
		No attractive or repulsive forces between particles
		It’s 2D

		PseudoCode:
		Initialize the system, setup the display and give the objects an initial position
		Put things in motion (Loop)
		•	Calculate the potential for all points in the display using all particles
		•	Calculate the color
		•	Update the display using those values
		•	Move particles
*/

		/*Class exercises:
		 * Once we have this working, how would we
		 * Add a constructor that allows us to set the particle velocity?
		 * Change the color?
		 * Instead of bouncing off wall, wrap around?
		 */
	}

}
