
public class L28 {

//Objects are things like doubles, integers and strings
//They have properties and actions
	public static void main(String[] args) {
		MyAuto subaru = new MyAuto("Subaru" , "Outback" , 2010);
		//Create a 2005 toyota prius
		MyAuto prius = new MyAuto("Toyota", "Prius",2005);
		
		//Set the speed
		subaru.setSpeed(50);
		
		//Get the speed of the subaru
		int speed = subaru.getSpeed();
		System.out.println("Speed = " + speed);
		
		
		
		
	}

}
