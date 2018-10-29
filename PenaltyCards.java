/**
 * This class manages the generation of penalty cards.
 * 
 * @author (Han J) 
 * @version (Semester 1 2018 Assignment 2)
 */
public class PenaltyCards
{
    // these are the two types of penalty cards
    private int yellowCards;
    private int redCards;

    /**
     * Constructor for objects of class penaltyCards
     */
    public PenaltyCards()
    {
        // initially there are no penalties.
        yellowCards = 0;
        redCards = 0;
    }

    public int getRedCards()
    {
        return redCards;    
    }

    public int getYellowCards()
    {
        return yellowCards;    
    }   

    public void redCards()
    {
        int test = (int)(Math.random()*((40 - 0) + 1  ));
        if (test == 10)
        {
            redCards += 1;   
        }
    }

    /**
     * This method randomly genrates penalties each game 
     */
    public void yellowCards()
    {
        int test = (int)(Math.random()*((10 - 0) + 1  ));
        if (test == 10)
        {
            yellowCards += 1;   
        }
    }

    public void setToZero()
    {
        yellowCards = 0;
        redCards = 0;   
    }

}
