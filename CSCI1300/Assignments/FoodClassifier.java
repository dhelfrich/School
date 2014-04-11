import java.awt.Color;


public class FoodClassifier {

	/**
	 * @param args
	 */
	
	//For convenience, here is a method that gives the Euclidian Distance between two colors
	public static double euclidianDistance(Color c1, Color c2){
		double redDifSquared = Math.pow(c1.getRed() - c2.getRed(),2);
		double greenDifSquared = Math.pow(c1.getGreen() - c2.getGreen(),2);
		double blueDifSquared = Math.pow(c1.getBlue() - c2.getBlue(),2);
		
		double distance = Math.sqrt(redDifSquared + greenDifSquared + blueDifSquared);
		return distance;
	}
	
	//This method takes 4 colors as inputs and compares the last one to the first three
	//It returns the integer corresponding to which color it's closest to
	public static int classifyPixel(Color food0, Color food1, Color food2, Color compareTo){
		
		//create an array of distances 
		
		double [] distList = new double[4];
		distList[0] = euclidianDistance(food0, compareTo);
		distList[1] = euclidianDistance(food1, compareTo);
		distList[2] = euclidianDistance(food2, compareTo);
		distList[3] = 50;
		
		//initialize smallest index
		int smallestIndex = 0;
		
		//find change the index to the smallest one or don't classify if above 500
		for(int i=1;i<=3;i++){
			if(distList[i]<distList[smallestIndex]){
				smallestIndex = i;
			}
		}
		return smallestIndex;
		
	}
	

	
	public static void main(String[] args) {
		
		//Initialize variable -- Colors, Counters, and the picture
		Color greenBeans = new Color(53,67,38);
		Color sweetPotatoes = new Color(133,106,30);
		Color pasta = new Color(155,151,121);
		
		int greenBeansCount = 0;
		int sweetPotatoesCount = 0;
		int pastaCount = 0;
		int noneCount = 0;
		
		//Colors to change them to
		
		Color setGreenBeans = new Color(69, 185, 65);
		Color setSweetPotatoes = new Color(255, 196, 0);
		Color setPasta = new Color(222, 218, 204);
		Color setBlack = new Color(0,0,0);
		
		
		Picture pic = new Picture("greenBean.png");
		Picture pic2 = new Picture("greenBean.png");
		
		//Create a for loop to iterate through all pixels, classify them and increase their counters accordingly
		for(int x = 0; x < pic.width();x++){
			for(int y = 0;y < pic.height(); y++){
				Color c = pic.get(x, y);
				int closest = classifyPixel(greenBeans,sweetPotatoes,pasta,c);
				if(closest == 0){
					greenBeansCount++;
				}
				if(closest == 1){
					sweetPotatoesCount++;
				}
				if(closest == 2){
					pastaCount++;
				}
				if(closest == 3){
					noneCount++;
				}
			}
		}
		
		//Calculate and print percentages
		double totalPixels = pic.width()*pic.height();
		
		double percentGreenBeans = 100*greenBeansCount/totalPixels;
		double percentSweetPotatoes = 100*sweetPotatoesCount/totalPixels;
		double percentPasta = 100*pastaCount/totalPixels;
		double percentNone = 100*noneCount/totalPixels;

		
		System.out.println("Green Beans: " + String.format("%.2f", percentGreenBeans)+"%");
		System.out.println("Sweet Potatoes: " + String.format("%.2f", percentSweetPotatoes)+"%");
		System.out.println("Pasta: " + String.format("%.2f", percentPasta)+"%");
		System.out.println("None: " + String.format("%.2f", percentNone)+"%");

		
		/* From this point forward, the rest of this assignment is for fun
		 * 
		 */
		
		//create a for loop that sets the colors in pic
		for(int x = 0; x < pic2.width();x++){
			for(int y = 0;y < pic2.height(); y++){
				Color c = pic2.get(x, y);
				int closest = classifyPixel(greenBeans,sweetPotatoes,pasta,c);
				if(closest == 0){
					pic2.set(x, y, setGreenBeans);
				}
				if(closest == 1){
					pic2.set(x, y, setSweetPotatoes);
				}
				if(closest == 2){
					pic2.set(x, y, setPasta);
				}
				if(closest == 3){
					pic2.set(x, y, setBlack);
				}
			}
		}
		pic.show();
		pic2.show();
	
	}

}
