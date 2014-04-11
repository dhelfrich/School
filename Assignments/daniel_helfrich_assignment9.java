import java.awt.Color;


public class daniel_helfrich_assignment9 {


	public static Color removeBlueColor(Color c){
		Color newc = new Color(c.getRed(), c.getGreen(),0);
		return newc;
	}
	
	public static Color removeBlueGreenColor(Color c){
		Color newc = new Color(c.getRed(),0,0);
		return newc;
	}
	
	public static void removeBlue(Picture pic){
		int h = pic.height();
		int w = pic.width();
		for(int x = 0; x<w;x++){
			for(int y = 0; y<h;y++){
				pic.set(x, y, removeBlueColor(pic.get(x,y)));
			}
		}
		System.out.println("height: " + h + " , width: "+ w);
	}
	
	public static void drawRedStripe(Picture pic){
		int h = pic.height();
		int w = pic.width();
		for(int x = w/2-101; x<w/2+99;x++){
			for(int y = 0; y<h;y++){
				pic.set(x, y, removeBlueGreenColor(pic.get(x,y)));
			}
		}
	}
	
	public static void main(String[] args) {
		Picture testPic = new Picture("dolphin_swimming.jpg");
		removeBlue(testPic);
		drawRedStripe(testPic);
		testPic.show();

	}

}
