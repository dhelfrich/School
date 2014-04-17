import java.text.DecimalFormat;


public class RoundingNotes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//rounding the display
		double g = .345626;
		System.out.printf("g=%.3f\n", g);
		//format a string
		String test = String.format("%.3f", g);
		System.out.println(test);
		DecimalFormat df = new DecimalFormat("##.######");
		System.out.println(df.format(.3483139));
		System.out.println(df.format(.3483145));


	}

}
