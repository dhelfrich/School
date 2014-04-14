import java.awt.Color;
public class WednesdayLecture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Picture dolphin = new Picture("dolphin_swimming.jpg");
		//dolphin.show();
		
		Color cDolphin = dolphin.get(100,100);
		System.out.println(cDolphin);
		int b = cDolphin.getBlue();
		int r = cDolphin.getRed();
		int g = cDolphin.getGreen();
		System.out.println("r="+r+"g="+g+"b="+b);
		
		//how would we add a black horizontal stripe to the dolphin image
		//black pixel is 0,0,0
		
		int h = dolphin.height();
		int w = dolphin.width();
		//put a black stripe between 100-200 all the way across
		for(int x = 0;x<w;x++){
			for(int y = 100; y <= 200; y++){
				//need to set color
				dolphin.setColor(x, y, 0, 0, 0);
			}
		}
		//dolphin.show();
		Color cDolphin2 = dolphin.get(100,200);
		System.out.println(cDolphin2);
		
		//try to set a color outside the range --error
		//dolphin.setColor(2000, 2000, 0, 0, 0);
		
		//put multiple images together
		Picture redBug = new Picture("red_bug.png");
		Picture blueBug = new Picture("blue_bug.png");
		int wRed = redBug.width();
		int hRed = redBug.height();
		int wBlue = blueBug.width();
		int hBlue = blueBug.height();
		int wFinal = wRed + wBlue;
		
		/* But, the blank Picture is more useful as a 
		 * container for creating new images by reading
		 * images and putting them together, or adding
		 * elements of color.
		 * 
		 * Exercise: How would you create a Picture that
		 * contains both bugs side by side?
		 * 
		 * Create a Picture that is big enough to hold
		 * both images side by side. The images are
		 * the same height, so I will use the hRed. You
		 * could also use hBlue and that would be fine.
		 */ 
		Picture bothBugs = new Picture(wFinal,hRed);
		/*put red in first, starting at left edge
		 * Do this by setting the pixel values of 
		 * bothBugs to the redBug values.
		 */ 
		for(int x = 0; x < wRed; x++){
			for(int y = 0; y < hRed; y++){
				bothBugs.set(x, y, redBug.get(x, y));
			}
		}
		bothBugs.show();
		
		for(int x=wRed; x<wRed+wBlue; x++){
			for(int y = 0; y < hRed; y++){
				//find correct color
				Color c = blueBug.get(x-wRed,y);
				bothBugs.set(x, y, c);
			}
		}
		bothBugs.show();

	}

}
