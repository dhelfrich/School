
public class L27 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [][]int2DArray = {{1,2,3,4},{5,6,7,8}};
		//need a loop for each dimension
		for(int x = 0; x < int2DArray.length; x++){
			for(int y = 0; y < int2DArray.length; y++){
				System.out.println(int2DArray[x][y]);
			}
		}
	}

}
