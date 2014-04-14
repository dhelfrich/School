/*Java is an object-oriented programming language, 
 * which means that everything in the language is
 * treated as an object, and these objects are created
 * from classes. 
 *
 * We use objects because they provide much more 
 * complex functionality that is encapsulated in 
 * reasonable way than if we just used primitive
 * types, such as int,float,string,boolean. Objects
 * provide a way of representing things in the world.
 * For example, if you wanted a bicycle type, that 
 * would be difficult to capture all of the features
 * of the bicycle, both its properties and its actions,
 * using only simple types. However, with objects, you
 * can build a computational bicycle and assign it the
 * properties and methods that it needs to be 
 * representative of a bicycle. 
 * 
 * Today, we're going to build an automobile object. 
 * Automobiles have properties, such as color, type, 
 * year, make, model, current speed, etc. Automobiles
 * also have actions such as acceleration, turn, brake.
 * 
 */

public class Lecture28ObjectExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Create a new instance of the Automobile object
		 * This calls the constructor in the Automobile
		 * class, giving it the values for make, model, and year
		 */
		Automobile subaru = new Automobile("Subaru", "Outback", 2010,60);
		//create another Automobile, called prius
		//Calls the constructor with different values
		Automobile prius = new Automobile("Toyota", "Prius", 2005,1);
		/*exercise: how would we change Automobile to include
		 * other properties?
		 */
		/*
		 * To access properties in the Automobile instance, we need
		 * what is called a getter, it is a method of the Automobile
		 * that can access a specific property for that instance
		 * only. For example,
		 */
		int speed = subaru.getSpeed();
		System.out.println(speed);
		/*The getSpeed method is defined in the Automobile
		 * class. We will also want to set the speed, using
		 * the setSpeed method defined in the class.
		 */
		subaru.setSpeed(65);
		//now get the speed again
		speed = subaru.getSpeed();
		System.out.println(speed);
		/*but, setting the subaru speed doesn't change the
		 * prius speed.
		 */
		speed = prius.getSpeed();
		System.out.println(speed);
		
		/*
		 * What are some of the things that an automobile can do?
		 */

	}

}
