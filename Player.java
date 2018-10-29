import java.util.Scanner;
/**
 * This class specifies the behaviours and attributes of a player.
 * 
 * @author (Han Jacobs) 
 * @version (Semester 1 2018)
 */

public class Player
{
    // the Player class fields.
    private String name;
    private int goals;
    /**
     * Default Constructor for objects of class Player.
     */
    public Player()
    {
        // initialise instance variables
        name = "Player 1";
    }

    /**
     * Constructor which allows user to choose their name.
     */
    public Player(String playerName)
    {
        // initialise instance variables
        if (playerName.length() <= 8)
        {
            name = playerName;
        }
        else
        {
            name = "Player 1";    
        }
    }

    public int assignGoals(int playergoals)
    {
        goals += playergoals;  
        System.out.println(name + "  " + playergoals);
        return goals;    
    }

      public int getGoals()
    {
        return goals;    
    }
        
    public void displayPlayerScore()
    {
        System.out.println(name + " " + goals);
    }
        
    public String getName()
    {
        return name;    
    }

    public void printPlayerName()
    {
        System.out.println(name);
    }

    public void setName()
    {
        Scanner console = new Scanner(System.in);
        int counter  = 0;
        name = console.nextLine().trim();
        while(counter < 3)
        {
            if (counter == 2)
            {                 
                System.out.println("As you have had two unsuccessful attempts you will now be assigned a default name");
                name = ("Player" + "Team");
                counter = 3;
            }

            if(name.length() > 10 || name.length() < 2)
            {
                System.out.println("The name you have entered is invalid, please enter a name with a maximum of 10 characters and a minimum of two");
                counter = counter + 1;
                name = console.nextLine().trim();
            }
            else
            {
            name = name;
            counter = 3;
            }
        }   
    }
}
