import java.awt.Color;

public class Turtle {

	/**
	 *
	 * @author user
	 */
	    private int x;
	    private int y;
	    private String zombieState; //(S,I,R)
	    private Universe uni;
	    private int timeOfLastChange;
	    
	    public Turtle(String state, Universe uni)
	    {
	        this.zombieState = state;
	        this.uni = uni;
	        this.timeOfLastChange = this.uni.getDay();
	    }
	    
	    public void setLocation(int xIn, int yIn)
	    {
	        //erase old zombie location
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.filledCircle((double)this.x, (double)this.y, 6);

	        if (this.zombieState == "S") 
	            StdDraw.setPenColor(StdDraw.RED);
	        else if(this.zombieState == "I")
	            StdDraw.setPenColor(StdDraw.BLUE);
	        else if(this.zombieState == "R")
	        	StdDraw.setPenColor(StdDraw.GREEN);
	        
	        this.x = xIn;
	        this.y = yIn;
	        StdDraw.filledCircle((double)this.x, (double)this.y, 5);
	        //StdDraw.show(1);
	    }
	    
	    public String getZombieState()
	    {
	        return this.zombieState;
	    }
	    
	    public void makeZombie()
	    {
	    	if(zombieState == "S")
	    	{
	    		this.zombieState = "I";
	    		this.timeOfLastChange = uni.getDay();
	    	}
	    }
	    
	    public int getXLocation()
	    {
	        return this.x;
	    }
	    
	    public int getYLocation()
	    {
	        return this.y;
	    }

}
