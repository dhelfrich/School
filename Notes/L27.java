
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
		
	}
	
	//write a method that takes one argument, the radius and returns a double
	
	public static double calcArea(double radius) {
		double area = Math.PI*Math.pow(radius, 2);
		return area;
				
	}

}
