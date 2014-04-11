
public class Assignment8 {
	
	public static double GreatCircle(double x1, double y1, double x2, double y2){
		double x1rads = Math.toRadians(x1);
		double y1rads = Math.toRadians(y1);
		double x2rads = Math.toRadians(x2);
		double y2rads = Math.toRadians(y2);
		
		double d;
		d = 6371*Math.acos(Math.sin(x1rads)*Math.sin(x2rads)+Math.cos(x1rads)*Math.cos(x2rads)*Math.cos(y1rads-y2rads));
		return d;
	}
	
	public static void PowersOfTwo(int N){
		double pow;
		for(int i=0;i<=N;i++){
			pow = Math.pow(2,i);
			System.out.println(pow);			
		}
	}
	
	public static void Simulator(int N){
		double x = 0.01;
		double r = 3.5;
		for(int i = 0; i<=N; i++){
			x = r*x*(1-x);
			System.out.println(x);
		}
	}
	
	public static double[][] multiply(double[][] mat1,double[][] mat2){
		

		
		//get the dimensions
		int m = mat1.length;
		int n = mat1[0].length;
		
		//initialize product
		double [][] product = new double [m][n];
		
		//print the array w/ nested for loop
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				product[i][j] = mat1[i][j]*mat2[i][j];
			}
			System.out.println();
		}
		
		return product;
		
	}
	
	public static void main(String[] args){
		double GreatOut = GreatCircle(Double.parseDouble(args[0]),Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]));
		System.out.println(GreatOut);
		
		PowersOfTwo(Integer.parseInt(args[4]));
		
		Simulator(Integer.parseInt(args[5]));
		
		double [][] m1 = {{1,2,3,4},{3,4,5,6}};
		double [][] m2 = {{4,3,2,1},{9,9,8,4}};
		
		//calculate the product
		
		double [][] product = multiply(m1, m2);
		
		//get the dimensions
		int m = product.length;
		int n = product[0].length;

		//print the array w/ nested for loop
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print(product[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
