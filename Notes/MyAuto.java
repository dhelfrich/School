
public class MyAuto {
	//what are the properties of an automobiile?
	//make, model, year, number of wheels, color, number of doors, condition, interior type
	//All of these are properties
	//instance variables are the properties
	private String make; //make is an instance variable
	private String model;
	private int year;
	private int speed;
	
	//we need a way to construct an automobile with a set of values for defined properties
	MyAuto(String ma, String mo, int y){
		this.make = ma;
		this.model = mo;
		this.year = y;
	}
	//Get the speed of the automobile
	public int getSpeed(){
		return this.speed;
	}
	//Set the speed of the automobile
	public void setSpeed(int newSpeed){
		this.speed = newSpeed;
	}

}
