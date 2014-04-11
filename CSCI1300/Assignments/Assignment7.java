
//Daniel Helfrich
//Recitation: Aaron Davis, 113
//Assignment 7

public class Assignment7 {

	
	public static void main(String[] args) {

		//Problem 1
		
		//Get commmand line args
		double t = Double.parseDouble(args[0]);
		double v = Double.parseDouble(args[1]);
		
		//Check that the arguments are valid
		if (-50 <= t && t <= 50 && 3 <= v && v <=120)
		{
			//Calculate w
			double w = 35.74 + 0.6215*t + (0.4275*t - 35.75)*Math.pow(v, 0.16);
			
			//Print
			String windout = "The windchill is " + w + " degrees F";
			System.out.println(windout);

		}
		else
		{
			System.out.println("Results not valid");
		}
		
		//Problem 2
		
		//Get command line arg
		int folds = Integer.parseInt(args[2]);
		
		//set thickness
		double thickness = (double) 1/200;
		
		//calculate folded thickness
		double fthick = thickness*Math.pow(2,folds);
		
		//print
		String thickout = "The thickness after " + folds + " folds is " + fthick + " cm";
		System.out.println(thickout);
		
		//Problem 3
		
		//Define Parameters

		double g = 9.8;
		double k = .18;
		double Cr = .001;
		
		//Get inputs
		
		double M = Double.parseDouble(args[3]);
		double M_b = Double.parseDouble(args[4]);
		double v2 = Double.parseDouble(args[5]);
		double CF_draft = Double.parseDouble(args[6]);
		
		//Equations
		
		double P_air = k*CF_draft*Math.pow(v2,3);
		double P_roll = Cr*g*(M+M_b)*v2;
		double P_sec = P_air + P_roll;
		
		//Print
		String resistanceout = "The power is " + P_sec + " W/s";
		System.out.println(resistanceout);
	}

}
