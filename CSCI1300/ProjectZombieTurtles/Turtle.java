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
	    private int dayOfLastChange;
	    private int recoveryTime;
	    private int immunityTime;
	    
	    public Turtle(String state, Universe uni)
	    {
	        this.zombieState = state;
	        this.uni = uni;
	        this.dayOfLastChange = this.uni.getDay();
	    }
	    
	    public void setLocation(int xIn, int yIn)
	    {
	        //erase old zombie location
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.filledCircle((double)this.x, (double)this.y, 6);

	        if (this.zombieState == "S") 
	            StdDraw.setPenColor(StdDraw.BLUE);
	        else if(this.zombieState == "I")
	            StdDraw.setPenColor(StdDraw.RED);
	        else if(this.zombieState == "R")
	        	StdDraw.setPenColor(StdDraw.GREEN);
	        
	        this.x = xIn;
	        this.y = yIn;
	        StdDraw.filledCircle((double)this.x, (double)this.y, 5);
	        //StdDraw.show(1);
	    }
	    
	    public void setRecImmTimes(int rec, int imm)
	    {
	    	this.recoveryTime = rec;
	    	this.immunityTime = imm;
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
	    		this.dayOfLastChange = uni.getDay();
	    	}
	    }
	    
	    public void infectedToRecovered()
	    {
	    	if (this.zombieState == "I" && uni.getDay()-this.dayOfLastChange >= this.recoveryTime)
	    	{
	    		this.zombieState = "R";
	    		this.dayOfLastChange = uni.getDay();
	    	}
	    }
	    
	    public void recoveredToSusceptible()
	    {
	    	if (this.zombieState == "R" && uni.getDay()-this.dayOfLastChange >= this.immunityTime)
	    	{
	    		this.zombieState = "S";
	    		this.dayOfLastChange = uni.getDay();
	    	}
	    }
	    
	    public void updateState()
	    {
	    	this.infectedToRecovered();
	    	this.recoveredToSusceptible();
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
