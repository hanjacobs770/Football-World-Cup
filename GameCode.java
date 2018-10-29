import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Menu here.
 * 
 * @author (Han J) 
 * @version (Semester 1 2018 Assignment 2)
 */
public class GameCode
{
    // instance variables - replace the example below with your own
    
    private ArrayList<Team> teams;
    private Menu menuDisplay;  
    private CupDisplay cupDisplay;
    private Sorter gameSort;
    private int playFinal;

    /**
     * Constructor for objects of class Menu
     */
    public GameCode()
    {
        cupDisplay = new CupDisplay();
        menuDisplay = new Menu();
        teams = new ArrayList<>();
        playFinal = 0;
        gameSort = new Sorter();
    }

    public void addTeams()
    {
        Team team = new Team();
        teams.add(team);
    }
    
    public void addTeams1()
    {
        int noOfTeams = 4;
        int count = 0;
        while( count < noOfTeams)
        {
            Team team = new Team();
            teams.add(team);
            count = count + 1;
        }
    }
    
    public void allocatePoints(int test, int test1)
    {
        //Scoring matrix
        int win = 3;
        int loss = 0;
        int draw = 1;        
        if( (teams.get(test).currentScore()) > (teams.get(test1).currentScore()))
        {
            teams.get(test).incrementGamesWon();
            teams.get(test).incrementTeamPoints(win);
            teams.get(test1).incrementGamesLost();
            teams.get(test1).incrementTeamPoints(loss);
            displayGameResult(1,test,test1);
        }
        else if (teams.get(test).currentScore() < teams.get(test1).currentScore())
        {
            teams.get(test1).incrementGamesWon();
            teams.get(test1).incrementTeamPoints(win);
            teams.get(test).incrementGamesLost();
            teams.get(test).incrementTeamPoints(loss); 
            displayGameResult(2,test,test1);
        }
        else if ( teams.get(test).currentScore() == teams.get(test + 1).currentScore())
        {
            teams.get(test1).incrementGamesDrawn();
            teams.get(test1).incrementTeamPoints(draw);
            teams.get(test).incrementGamesDrawn();
            teams.get(test).incrementTeamPoints(draw); 
            displayGameResult(3,test,test1);
        }
    }

    public void analyseInput()
    {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine().toUpperCase().trim();
        switch (input)
        {
            case "A":  playPreliminaryStage(); 
            break;
            case "B":  playFinal(); 
            break;
            case "C":  displayTeams(); 
            break;
            case "D":  displayPlayers(); 
            break;
            case "E":  displayCupResult(); 
            break;
            case "X":  System.out.println("The program will now end" );
            System.exit(0); 
            break;
            case "S": gameSort.selectFinalTeams1();
        }

    }

    public void displayCupResult()
    {
        if (playFinal >= 2)
        {
            System.out.println("Here are the cup results");
            cupDisplay.displayCupResults();
        }
        else
        {
            System.out.println("You cannot display the cup result until the final has been played\n" );
            menuDisplay.displayMenu();
            analyseInput();
        }
        System.out.println("\nNow, wasn't that fun?/nWould you like to play the game again from the beginning?");
        analyseInput();
    }

    public void displayGameResult(int number, int test, int test1)
    {
        switch (number)
        {
            case 1: System.out.println("The result of the game between " + teams.get(test).getName() + " and " + teams.get(test1).getName() + " Is a win for " + teams.get(test).getName());              
            break;
            case 2: System.out.println("The result of the game between " + teams.get(test).getName() + " and " + teams.get(test1).getName() + " Is a win for " + teams.get(test1).getName());  
            break;
            case 3: System.out.println("The result of the game between " + teams.get(test).getName() + " and " + teams.get(test1).getName() + " Is a draw");
            break;
        }
    }

    public void displayPlayers()
    {
        for( Team team : teams)
        {
            team.displayPlayerScore();   
        }
        System.out.println();
        menuDisplay.displayMenu();
        analyseInput();
    }

    /**
     * display menu 
     */
    public void displayTeams()
    {
        System.out.println("      Played Won Lost Drawn Goals Points FairPlayScore");
        for( Team team : teams)
        {
            System.out.println("         " + team.getGamesPlayed() + "    " + team.getGamesWon() + "   " + team.getGamesLost() + "     " + team.getGamesDrawn() + "      " + team.getGoals() + "       " + team.getPoints() + "        " + team.getPenaltyScore() + "           " + team.getName());
        }        
        System.out.println();
        menuDisplay.displayMenu();
        analyseInput();
    }

    public void finalRound(int test, int test1)
    {
        int win = 3;
        int loss = 0;
        if( (teams.get(test).currentScore()) > (teams.get(test1).currentScore()))
        {
            teams.get(test).incrementGamesWon();
            teams.get(test).incrementTeamPoints(win);
            teams.get(test1).incrementGamesLost();
            teams.get(test1).incrementTeamPoints(loss);                
            System.out.println("\nThe result of the final game between " + teams.get(test).getName() + " and " + teams.get(test1).getName() + " Is a win for " + teams.get(test).getName());
            cupDisplay.updateCupWinner(teams.get(test).getName());
            displayCupResult();
        }
        else if (teams.get(test).currentScore() < teams.get(test1).currentScore())
        {
            teams.get(test1).incrementGamesWon();
            teams.get(test1).incrementTeamPoints(win);
            teams.get(test).incrementGamesLost();
            teams.get(test).incrementTeamPoints(loss); 
            System.out.println("The result of the final game between " + teams.get(test).getName() + " and " + teams.get(test1).getName() + " Is a win for " + teams.get(test1).getName());
            cupDisplay.updateCupWinner(teams.get(test1).getName());
            displayCupResult();
        }
        else if ( teams.get(test).currentScore() == teams.get(test + 1).currentScore())
        {
            System.out.println("The result of the final game between " + teams.get(test).getName() + " and " + teams.get(test1).getName() + " Is a draw");
            System.out.println("We will therefore move to a penalty shootout");
            playPenaltyRound(test, test1);
        }
    }

    public void gamePlayFinal()
    {
        int team1 = gameSort.getIndexOfTeam1();
        int team2 = gameSort.getIndexOfTeam1();        
        System.out.println("\nFIT9131 FIFA World cup grand final");
        System.out.println("*************");
        System.out.println("\nThis final is between teams : " + teams.get(team1).getName() + " and " + teams.get(team2).getName() + "\nNow let's play!!!!");
        teams.get(team1).incrementGamesPlayed();
        teams.get(team1).generateGoals();
        teams.get(team1).generatePenalties();
        teams.get(team2).incrementGamesPlayed();
        teams.get(team2).generateGoals();               
        teams.get(team2).generatePenalties();
        finalRound(team1, team2);
    } 

    public void gamePlayPenalties()
    {
        int team1 = 0;
        int team2 = 1;        
        teams.get(team1).incrementGamesPlayed();
        teams.get(team1).generateGoals();
        teams.get(team1).generatePenalties();
        teams.get(team2).incrementGamesPlayed();
        teams.get(team2).generateGoals();               
        teams.get(team2).generatePenalties();
        finalRound(team1, team2);
    }

    public void gamePlayPrelim()
    {
        int count = 0;
        int countEnd = count + 1; 
        int game = 1;
        while(count <= (teams.size() - 2))
        {
            while( countEnd <= (teams.size() - 1))
            {
                System.out.println("\nGame " + game);
                System.out.println("*************");
                teams.get(count).incrementGamesPlayed();
                teams.get(count).generateGoals();
                teams.get(count).generatePenalties();
                teams.get(countEnd).incrementGamesPlayed();
                teams.get(countEnd).generateGoals();               
                teams.get(countEnd).generatePenalties();
                allocatePoints(count, countEnd);
                countEnd = countEnd + 1;
                game ++;
            }
            count = count + 1;
            countEnd = count + 1; 
        }
        System.out.println("\nThe Preliminary Stage is over with the following results:");
        displayTeams();
    }

      public void playFinal()
    {

        if (playFinal >= 1)
        {
            System.out.print('\u000C');
            System.out.println("Welcome to the final round of the FIT9131 FIFA world cup");
            playFinal = 2;
            gameSort.updateArray(teams);
            gameSort.selectFinalTeams1();
            gamePlayFinal();
        }
        else       
            System.out.println("Please play the preliminary round before you play the final\n");    
        analyseInput();
    }
    
    public void playGame()
    {
        addTeams1();
        System.out.println("Hi, and welcome the FIT9131 FIFA World Cup!\nBefore we start please enter the names for the players and teams");
        for( Team team : teams)
        {
            team.setName();    
        }               
        for( Team team : teams)
        {
            team.setPlayerName();    
        }
        menuDisplay.displayMenu();
        analyseInput();
    }

    public void playPenaltyRound(int team1, int team2)
    {
        //Scoring matrix
        int win = 3;
        int loss = 0;      
        int count = 0;
        teams.get(team1).firstRoundShooutout();
        teams.get(team2).firstRoundShooutout();
        while(count < 1)
        {
            if( (teams.get(team1).getPenaltyGoals()) > (teams.get(team2).getPenaltyGoals()))
            {
                teams.get(team1).incrementGamesWon();
                teams.get(team1).incrementTeamPoints(win);
                teams.get(team2).incrementGamesLost();
                teams.get(team2).incrementTeamPoints(loss);                
                System.out.println("\nThe result of the penalty shootout between " + teams.get(team1).getName() + " and " + teams.get(team2).getName() + " Is a win for " + teams.get(team1).getName());
                count =1;
                cupDisplay.updateCupWinner(teams.get(team1).getName());
                displayCupResult();
            }
            else if (teams.get(team1).getPenaltyGoals() < teams.get(team2).getPenaltyGoals())
            {
                teams.get(team2).incrementGamesWon();
                teams.get(team2).incrementTeamPoints(win);
                teams.get(team1).incrementGamesLost();
                teams.get(team1).incrementTeamPoints(loss); 
                System.out.println("\nThe result of the penalty shootout between " + teams.get(team1).getName() + " and " + teams.get(team2).getName() + " Is a win for " + teams.get(team2).getName());
                cupDisplay.updateCupWinner(teams.get(team2).getName());
                count = 1;
                displayCupResult();
            }
            else if (teams.get(team1).getPenaltyGoals() == teams.get(team2).getPenaltyGoals())
            {
                teams.get(team1).lastRoundShooutout();
                teams.get(team2).lastRoundShooutout();
            }
        }
    }

    public void playPreliminaryStage()
    {
        System.out.println("Welcome to the Preliminary Stage each team will now play each other exactly once,\nto determine which two teams continue on the finals");
        playFinal = 1;
        gamePlayPrelim();
    }
}
