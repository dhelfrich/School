import java.awt.Color;

public class ObjectExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Automobile subaru = new Automobile("subaru","outback",2010,10);
		System.out.println("current speed: " + subaru.getSpeed());
		subaru.setSpeed(65);
		System.out.println("current speed: " + subaru.getSpeed());
		
		Automobile prius = new Automobile("toyota","prius",2005,1);
		System.out.println("current speed prius: " + prius.getSpeed());
		
		Picture dolphin = new Picture("dolphin_swimming.jpg");
		dolphin.show();
		
		int h = dolphin.height();
		int w = dolphin.width();
		Color c = dolphin.get(100, 100);
				
		System.out.println("height: "+h+" width: "+w);
		System.out.println(c);
			
		Picture blank = new Picture(5000,600);
		//blank.show();

	}

}
