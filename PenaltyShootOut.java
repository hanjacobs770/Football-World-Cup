
/**
 * This class generates the goals in each game.
 * 
 * @author (Han Jacobs) 
 * @version (Semester 1 2018)
 */
public class PenaltyShootOut
{
    // instance variables - replace the example below with your own
    private int penaltyGoals;

    /**
     * Constructor for objects of class RandomGoalsGenerator
     * I found the Math.Random method through Google.
     */

    public PenaltyShootOut()
    {
    }

    public void firstRoundShooutout()
    {
        int counter = 0;
        while (counter < 5)
        {
            penaltyGoals += ((int)(Math.random()*((((1 - 0) + 1 )))));
            counter ++;
        }
    }

     public void lastRoundShooutout()
    {      
            penaltyGoals += ((int)(Math.random()*((((1 - 0) + 1 )))));
    }
          
    public int getpenalyGoals()
    {
        return penaltyGoals;    
    }
    
    public void setToZero()
    {
    penaltyGoals = 0;    
    }
   
}

