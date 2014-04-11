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
		
		double [] distList = new double[3];
		distList[0] = euclidianDistance(food0, compareTo);
		distList[1] = euclidianDistance(food1, compareTo);
		distList[2] = euclidianDistance(food2, compareTo);
		
		//initialize smallest index
		int smallestIndex = 0;
		
		//find change the index to the smallest one
		for(int i=1;i<=2;i++){
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
		
		Picture pic = new Picture("greenBean.png");
		
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
			}
		}
		
		//Calculate and print percentages
		double totalPixels = pic.width()*pic.height();
		
		double percentGreenBeans = 100*greenBeansCount/totalPixels;
		double percentSweetPotatoes = 100*sweetPotatoesCount/totalPixels;
		double percentPasta = 100*pastaCount/totalPixels;
		
		System.out.println("Green Beans: " + String.format("%.2f", percentGreenBeans)+"%");
		System.out.println("Sweet Potatoes: " + String.format("%.2f", percentSweetPotatoes)+"%");
		System.out.println("Pasta: " + String.format("%.2f", percentPasta)+"%");
	}

}
