import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class manages the different teams.
 * 
 * @author (Han J) 
 * @version (Semester 1 2018 Assignment 2)
 */
public class Team
{
    // instance variables - replace the example below with your own

    private ArrayList<Player> players;
    private int currentScore;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int gamesDrawn;
    private int points;
    private PenaltyCards penaltyCards;
    private PenaltyShootOut penaltyShootOut;
    private RandomGoalsGenerator randomGoals;
    private int ranking;
    private String name;

    /**
     * Constructor for objects of class Team
     */
    public Team()
    {
        // initialise instance variables
        gamesDrawn = 0;
        gamesWon = 0;
        gamesLost = 0;
        gamesPlayed = 0; 
        name = "Team1";
        players = new ArrayList<>();
        points = 0;
        randomGoals = new RandomGoalsGenerator();
        penaltyShootOut = new PenaltyShootOut();
        penaltyCards = new PenaltyCards();
        addPlayers();

    } 

    public void addPlayers()
    {
        int noOfPlayers = 2;
        int count = 0;
        while( count < noOfPlayers)
        {
            Player player = new Player();
            players.add(player);
            count = count + 1;
        }
    }

    /**
     * This sets the player goals
     */
    public int assignPlayerGoals(int goals)
    {
        //             for( Player player : players)
        //         {
        //              player.assignGoals((goals/goals/players.size()));
        //              players.get(0).assignGoals((goals - ((goals/players.size())*goals/players.size())));
        //         }        
        int goals1 = (goals/2);
        int goals2 = goals - goals1;
        players.get(0).assignGoals(goals1);
        players.get(1).assignGoals(goals2);
        return goals1;
    }

    public int currentScore()
    {
        return currentScore;
    }

    public void displayPlayerScore()
    {
        System.out.println("Here are the goals by player for team: " + name);
        for( Player player : players)
        {
            player.displayPlayerScore();   
        }
    }

    public void firstRoundShooutout()
    {
        int penaltyGoals = 0;
        penaltyShootOut.firstRoundShooutout();  
        penaltyGoals = penaltyShootOut.getpenalyGoals();
        System.out.println();
        System.out.println(name + " has scored " + penaltyGoals + " Goals!!");
    }

    public int generateGoals()
    {
        int rankingDifference = 0;
        int teamGoals = randomGoals.generateGoals(rankingDifference);
        System.out.println(name + " has scored " + teamGoals + " Goals!!");
        assignPlayerGoals(teamGoals);
        currentScore = teamGoals;
        return teamGoals;
    }

    public void generatePenalties()
    {
        penaltyCards.yellowCards();
        penaltyCards.redCards(); 
    }

    public int getGamesDrawn()
    {
        return gamesDrawn;
    }

    public int getGamesPlayed()
    {
        return gamesPlayed;
    }

    public int getGamesLost()
    {
        return gamesLost;
    }

    public int getGamesWon()
    {
        return gamesWon;
    }

    public int getGoals()
    {
        int totalGoals = 0;
        for( Player player : players)
        {
            totalGoals += player.getGoals();   
        }
        return totalGoals;
    }

    public String getName()
    {
        return name;
    }

    public int getPoints()
    {
        return points;
    }

    public int getPenaltyGoals()
    {
        int penaltyGoals = penaltyShootOut.getpenalyGoals();
        return penaltyGoals;
    }

    public int getPenaltyScore()
    {
        //Mark Matrix
        int red = 2;
        int yellow = 1;
        int totalMarks = 0;
        totalMarks = ((penaltyCards.getYellowCards() *yellow) + (penaltyCards.getRedCards() *red));
        return totalMarks;
    }

    public void incrementGamesDrawn()
    {
        gamesDrawn ++;
    }

    public void incrementGamesLost()
    {
        gamesLost ++;
    }

    public void incrementGamesPlayed()
    {
        gamesPlayed += 1 ;
    }

    public void incrementGamesWon()
    {
        gamesWon ++;
    }

    public int incrementTeamPoints( int pointsScored)
    {    
        points += pointsScored ;
        return points;
    }

    public void incrementTeamWins()
    {
        gamesWon ++;
    }

    public void lastRoundShooutout()
    {
        int subtract = penaltyShootOut.getpenalyGoals();
        System.out.println("As first round penalties were tied we now move into sudden death, first goal wins the game");        
        penaltyShootOut.lastRoundShooutout(); 
        System.out.println();
        int newPenaltyGoals = penaltyShootOut.getpenalyGoals() - subtract;        
        if ( newPenaltyGoals >= 1)
        {
            System.out.println(name + " has scored the winning Goal!!");
        }
             
    }

    public int randomFinal()
    {
        int randomFinal = ((int)(Math.random()*((((1 - 0) + 1 )))));
        return randomFinal;        
    }

    public void setParameterstoZero()
    {
        gamesDrawn = 0;
        gamesWon = 0;
        gamesLost = 0;
        gamesPlayed = 0;  
        penaltyCards.setToZero();
        penaltyShootOut.setToZero();
    }

    public void setPlayerName()
    /**
     * This sets the player name
     */
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Please now enter the name for both Players for team: " + name);
        System.out.println("First Player 1");        
        players.get(0).setName();
        System.out.println("And now for Player 2");
        players.get(1).setName();
    }

    public void setName()
    {                
        System.out.println("Please now enter the name for the next Team");                 
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
