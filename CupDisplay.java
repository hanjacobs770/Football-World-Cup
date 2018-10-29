
/**
 * This CupDisplay class stores the relevant variable displayed at the end of the game. 
 * The reason for a seperate class is because the GameCode class is overloaded and we need to decentralise control.
 * 
 * @author (Han J) 
 * @version (Semester 1)
 */
public class CupDisplay
{
    // instance variables - replace the example below with your own
    private String cupWinner;
    private String goldenBoot;
    private String goldenBoot1;
    private String goldenBoot2;
    private String goldenBoot3;
    private String fairPlayAward;
    private String fairPlayAward1;
    private String fairPlayAward2;
    private String fairPlayAward3;

    /**
     * Constructor for objects of class CupDisplay
     */
    public CupDisplay()
    {
        // initialise instance variables
        cupWinner = "";
        goldenBoot = "";
        goldenBoot1 = "";
        goldenBoot2 = "";
        goldenBoot3 = "";
        fairPlayAward = "";
        fairPlayAward1 = "";
        fairPlayAward2 = "";
        fairPlayAward3 = "";
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void updateCupWinner(String newWinner)
    {
        // put your code here
        cupWinner = newWinner;
    }

    public void updateFairPlayAward(String newFairPlay, String fP1, String fP2, String fP3)
    {
        // put your code here
        fairPlayAward = newFairPlay;
        fairPlayAward1 = fP1;
        fairPlayAward2 = fP2;
        fairPlayAward3 = fP3;
    }

    public void updateGoldenBoot(String newGoldenBoot, String gB1, String gB2, String gB3)
    {
        // put your code here
        goldenBoot = newGoldenBoot;
        goldenBoot1 = gB1;
        goldenBoot2 = gB2;
        goldenBoot3 = gB3;
    }

    public void displayCupResults()
    {
        // put your code here
        String tie = "is a tie between: ";
        System.out.println("Well the Game is over and here are the results!");
        System.out.println("The Cup Winner is: " + cupWinner);
        if(fairPlayAward1.length() >= 2)
        {
            System.out.println("The result of the Fair Play competition " + tie + fairPlayAward + fairPlayAward1 + fairPlayAward2 + fairPlayAward3);
        }
        else
        {
            System.out.println("The result of the Fair Play competition is a win for: " + fairPlayAward);

        }

        if(goldenBoot1.length() >= 2)
        {
            System.out.println("The result of the Golden Boot competition " + tie + goldenBoot + goldenBoot1 + goldenBoot2 + goldenBoot3);
        }
        else
        {
            System.out.println("The result of the Golden Boot competition is a win for: " + goldenBoot);
        }
    }
}
