/*The Automobile class is what defines instances of the 
 * Automobile object. The class file here defines what
 * the properties are of the object and what the methods
 * are for the object.
 */
public class Automobile {
	/* Define the properties of the Automobile. These are
	 * called instance variables, each instance of automobile
	 * that we create will have values for these variables.
	 * 
	 * What are all the properties of an automobile?
	 */
	//start with four properties for now.
	private String make;
	private String model;
	private int year;
	private int currentSpeed;
	/*These variables are declared as private, which means
	 * that only methods inside this class can access them. 
	 */

	/*We need a way to create a new instance of an object.
	 * The new keyword is used for that, but there is code
	 * that runs when we use new. That code is called the
	 * constructor, and the constructor is part of the class
	 * for that object.
	 * 
	 */
	Automobile(String ma, String mo, int y){
		this.make = ma;
		this.model = mo;
		this.year = y;
	}
	/*The syntax is a little different than what we've seen
	 * so far, there's no public, static, void, or any
	 * other type, it's just the name of the class, and the 
	 * arguments for that class.
	 */
	
	/*The instance variables above are all private, meaning
	 * that if we want to change them outside of the class, 
	 * we can't. For example, the constructor was called in
	 * Lecture28ObjectExamples, but we couldn't print the 
	 * value of make, model, year, or currentSpeed without
	 * the help of some public method that will allow access
	 * to those values. 
	 * 
	 */
	/*
	 * This is an instance method, it will run on the specific
	 * instance of the object upon which it has been called.
	 * This particular method is an example of a getter, it
	 * gets a value from the object.
	 */
	public int getSpeed(){
		return this.currentSpeed;
	}
	/*
	 * If we can get the speed, we may also want to set the speed.
	 * This is called a setter. Notice that the setter doesn't
	 * return a value, but it does have an argument. Whatever
	 * value is passed in to the method is used to set the value
	 * of an instance variable.
	 */
	public void setSpeed(int speed){
		this.currentSpeed = speed;
	}

}
