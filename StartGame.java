/**
 * This Class is the start button for the game.
 * 
 * @author (Hannock Jacoms) 
 * @version (Semester 1 2018)
 * This class is like the start button it just starts the game and that's it, it just provides for a cleaner interface.
 */
public class StartGame
{

    private GameCode footBallWorldCup;

    /**
     * Constructor for objects of class GamePlay
     */
    public StartGame()
    {
        // initialise instance variables
        footBallWorldCup = new GameCode();
    }

    /**
     * This Starts the Game!
     */
    public void startGame()
    {
        footBallWorldCup.playGame();
    }
}