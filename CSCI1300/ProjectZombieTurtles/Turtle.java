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
	    private double percentComplete;
	    private Color pencolor;
	    private int red;
	    private int green;
	    private int blue;
	    
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
	        {
	        	StdDraw.setPenColor(StdDraw.BLUE);
	        }
	        else if(this.zombieState == "I")//If infected, set pen color to between red and green to show immunity
	        {
	        	percentComplete = (uni.getDay()-this.dayOfLastChange)/(this.recoveryTime+.00001); //want to avoid divide by zero
	        	red = (int) ((1-percentComplete)*255);
	        	green = (int) (percentComplete*255);
	        	blue = 0;
	        	pencolor = new Color(red,green,blue);
	            StdDraw.setPenColor(pencolor);
			}
	        else if(this.zombieState == "R") //If recovered, set pen color to somewhere between green and blue in order to show when they get susceptible
	        {
	        	percentComplete = (uni.getDay()-this.dayOfLastChange)/(this.immunityTime+.00001); //want to avoid divide by zero
	        	
	        	red = 0;
	        	green = (int) ((1-percentComplete)*255);
	        	blue = (int) (percentComplete*255);
	        	pencolor = new Color(red,green,blue);
	            StdDraw.setPenColor(pencolor);
	        }
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
