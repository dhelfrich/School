
public class ZombieApocalypse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // set some number to be zombies
        int z = 20;
        //this is number of total ZombieTurtles, only z of which are initially zombies
        int zTurtles = 300;
        int N = 250;
        double probability = Double.parseDouble(args[0]);
        int recoveryTime = Integer.parseInt(args[1]);
        int immunityTime = Integer.parseInt(args[2]);
        int radius = Integer.parseInt(args[3]);
        /*need a Universe object that we can put turtles into. turtles will be circles and change colors when they 
         * come in contact with other turtles that are inflicted with zombie-ism
         * 
         */
        Universe un = new Universe(600, 600);
        un.setParameters(probability,recoveryTime,immunityTime,radius);
        un.addTurtles(zTurtles, z);
        /*our simulation will run for N iterations */
        for(int i = 0; i < N; i++)
        {
            un.updateZombies();

            un.zombieAttack();

            un.nextDay();
           
        }
            

	}

}
