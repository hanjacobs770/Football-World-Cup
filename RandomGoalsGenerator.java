
/**
 * This class generates the goals in each game.
 * 
 * @author (Han Jacobs) 
 * @version (Semester 1 2018)
 */
public class RandomGoalsGenerator
{
    // instance variables - replace the example below with your own
    private int goals;

    /**
     * Constructor for objects of class RandomGoalsGenerator
     * I found the Math.Random method through Google.
     */

    public RandomGoalsGenerator()
    {
    goals = 0;    
    }

    public int generateGoals(int rankingdifference)
    {
        goals = (int)(Math.random()*((((5 - rankingdifference) + 1 +((int)(Math.random()*((2-1)+1) + 1 ))))));
        return goals;
    }
}
