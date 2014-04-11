
public class Automobile {
	//properties
	private String make;
	private String model;
	private int year;
	private int speed;
	
	//constructor
	public Automobile(String ma, String mo, int y, int s){
		this.make = ma;
		this.model = mo;
		this.year = y;
		this.speed = s;
	}
	//set mothod
	public void setSpeed(int s){
		this.speed = s;
	}
	
	public int getSpeed(){
		return this.speed;
	}
}
