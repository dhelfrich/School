
public class L27 {

	public static void printMessage(String msg){
		System.out.println(msg);
	}
	
	
	public static void main(String[] args) {
		int [][]int2DArray = {{1,2,3,4},{5,6,7,8}};
		//need a loop for each dimension
		for(int x = 0; x < int2DArray.length; x++){
			for(int y = 0; y < int2DArray[x].length; y++){
				System.out.println(int2DArray[x][y]);
			}
		}
				
				
		String[] strArray = {"good job", "hang in there", "spring break soon"};
		for(int z = 0; z < strArray.length; z++){
			printMessage(strArray[z]);
		}
		
		double area = calcArea(4);
		System.out.println("The area is " + area);
		
		//call calcArea using a radius between 1 and 10, in increments of 1
		
		for(int i = 1; i <= 10; i++){
			area = calcArea(i);
			System.out.println("The area is " + area);			
		}
		
		//Hamming Distance
		int[]a = {5,6,7,8};
		int[]b = {6,7,8,9};
		int[]c = {52,66,71,86};
		
		
		
	}
	
	//write a method that takes one argument, the radius and returns a double
	
	public static double calcArea(double radius) {
		double area = Math.PI*Math.pow(radius, 2);
		return area;				
	}
	
//	public static in compareArrays(int[]a,int[]b){
//		int diff = 0;
//		for(int i = 0; i< a.length; i++){
//			
//		}
//	}

}
