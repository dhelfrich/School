
public class Tree {

	public Tree()
	{
		
	}
	
    public void tree(int n, double x, double y, double a, double branchRadius) {
    	double bendAngle = Math.toRadians(15);
    	double branchAngle = Math.toRadians(37);
        double branchRatio = .65;
        
        double cx = x + Math.cos(a) * branchRadius;
        double cy = y + Math.sin(a) * branchRadius;

        StdDraw.setPenRadius(.002 * Math.pow(n, 1.2));
        
        StdDraw.line(x, y, cx, cy);
        StdDraw.show(10);
        if (n == 0) return;
        /*
         * Three recursive calls to the tree method,
         * passing in n-1 each time, and the appropriate
         * drawing parameters.
         */
        tree(n-1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio);
        tree(n-1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio);
        tree(n-1, cx, cy, a + bendAngle,               branchRadius * (1 - branchRatio));
  }

}
