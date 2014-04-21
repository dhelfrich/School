/*Lecture39RecursionAndFractals.java
 * Author: Rhonda Hoenigman
 * University of Colorado, Boulder
 */
/*
 * We've been using methods for most of the 
 * semester, in both Python and Java, and
 * we've seen many, many examples of methods
 * calling each other. 
 * 
 * Today we're going to talk about a method
 * calling itself. This is called recursion. 
 * 
 * Recursion is not just a method calling itself,
 * it's an interesting way of defining problems.
 * Some problems have a recursive structure, where
 * each step in the solution is the same operation
 * and is based on all previous steps.
 */
public class Lecture39RecursionAndFractals {
	/*
	 * The Hello World of recursion is
	 * calculating the factorial recursively.
	 * The factorial calculation is 
	 * 1*2*3*4*5*...*n
	 * Another way to think of it is
	 * 1* factorial(2)
	 * factorial(2)*3
	 * factorial(3)*4
	 * ...
	 * factorial(n-1)*n
	 * 
	 * The repeated calling of a factorial
	 * method can be implemented by factorial
	 * calling itself for a larger number each
	 * time
	 */
	public static int factorial(int n){
		/*
		 * Every recursive function needs a 
		 * base case, the value that will return
		 * a value and not make any additional
		 * recursive calls. Here, it's when
		 * n=1.
		 */
		if(n == 1)
			return 1;
		/*
		 * When n > 1, there will be another
		 * recursive call to factorial, using
		 * n-1. Eventually, reducing n by 1 each
		 * time will result in n=1, and the code
		 * will return.
		 */
		return n * factorial(n-1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int f = factorial(5);
		System.out.println(f);
		
		/*
		 * There are many natural patterns that
		 * exhibit a recursive structure. These
		 * are referred to as fractal, which is
		 * a repeating, self-similar pattern.
		 * 
		 * One example of a fractal pattern is a 
		 * tree. The smaller branches of the tree
		 * are a self-similar pattern of the larger
		 * branches of the tree. In nature, the 
		 * pattern is less exact, due to biological
		 * variability. However, if we were to draw
		 * a tree, we could draw a nice neat fractal
		 * tree using a set of rules to define the
		 * size, shape, and branching angle of all
		 * branches, based on these same properties
		 * for the previously drawn (larger) branches
		 * 
		 * Here, we use a class called Tree.java, and
		 * create an instance of tree. You will also
		 * need the StdDraw in your project.
		 */
    	int branch = 2; 
        StdDraw.setCanvasSize(800, 800);
        Tree t = new Tree();
        t.tree(branch, .5, 0, Math.PI/2, .3);

		
	}

}
