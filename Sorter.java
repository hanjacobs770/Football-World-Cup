import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Menu here.
 * 
 * @author (Han J) 
 * @version (Semester 1 2018 Assignment 2)
 */
public class Sorter
{
    // instance variables - replace the example below with your own
    private ArrayList<Team> teamSort;
    private int indexOfTeam1;
    private int indexOfTeam2;

    /**
     * Constructor for objects of class Menu
     */
    public Sorter()
    {      
        teamSort = new ArrayList<>(); 
        indexOfTeam1 = 0;
        indexOfTeam2 = 0;

    }
    
    /**
     * This passes the teams array list from GameCode to Sorter for sorting
     */
    public void updateArray(ArrayList<Team> teamNew)
    {
     teamSort = teamNew;
    }
    
        public void selectFinalTeams1()
    {
        //this method will detemine the final teams
        System.out.println(teamSort.size());        
        int a =0;
        int b =0 ;
        int size = teamSort.size();
        int points;
        int points1;
        int goals;
        int goals1;
        while( a < size)
        {
            b = a + 1;
            points = teamSort.get(a).getPoints();
            points1 = teamSort.get(b).getPoints();            
            if (points > points1)
            {
                indexOfTeam1 = a;    
            }

            if (points == points1)
            {
                goals = teamSort.get(a).getGoals();
                goals1 = teamSort.get(b).getGoals();  
                if(goals > goals1)
                {
                    indexOfTeam1 = a;       
                }
                else if (goals == goals1)
                {
                    int randomFinal = teamSort.get(a).randomFinal();
                    if( randomFinal == 1)
                    {
                        indexOfTeam1 = a;        
                    }
                    else
                    {
                        indexOfTeam1 = b;          

                    }

                }
            }
            a ++;
        }

        while( a == size)
        {
            b = a - 1;
            points = teamSort.get(a).getPoints();
            points1 = teamSort.get(b).getPoints();            
            if (points > points1)
            {
                indexOfTeam1 = a;    
            }

            if (points == points1)
            {
                goals = teamSort.get(a).getGoals();
                goals1 = teamSort.get(b).getGoals();  
                if(goals > goals1)
                {
                    indexOfTeam1 = a;       
                }
                else if (goals == goals1)
                {
                    int randomFinal = teamSort.get(a).randomFinal();
                    if( randomFinal == 1)
                    {
                        indexOfTeam1 = a;        
                    }
                    else
                    {
                        indexOfTeam1 = b;          

                    }

                }
            }
            a ++;
        }
        selectFinalTeams2();
    }

    public void selectFinalTeams2()
    {
        //this method will detemine the final teams
        System.out.println(teamSort.size());
        int a =0;
        int b =0 ;
        int size = teamSort.size();
        int points;
        int points1;
        int goals;
        int goals1;
        while( a < size)
        {
            b = a + 1;
            if (b == indexOfTeam1)
            {
             b = a + 2;   
            }
            points = teamSort.get(a).getPoints();
            points1 = teamSort.get(b).getPoints();            
            if (points > points1)
            {
                indexOfTeam2 = a;    
            }

            if (points == points1)
            {
                goals = teamSort.get(a).getGoals();
                goals1 = teamSort.get(b).getGoals();  
                if(goals > goals1)
                {
                    indexOfTeam2 = a;       
                }
                else if (goals == goals1)
                {
                    int randomFinal = teamSort.get(a).randomFinal();
                    if( randomFinal == 1)
                    {
                        indexOfTeam2 = a;        
                    }
                    else
                    {
                        indexOfTeam2 = b;          

                    }

                }
            }
            a ++;
             if (a == indexOfTeam1)
            {
             a = a + 1;   
            }
        }

        while( a == size)
        {
            b = a - 1;
            if (b == indexOfTeam1)
            {
             b = a - 2;   
            }
            points = teamSort.get(a).getPoints();
            points1 = teamSort.get(b).getPoints();            
            if (points > points1)
            {
                indexOfTeam2 = a;    
            }

            if (points == points1)
            {
                goals = teamSort.get(a).getGoals();
                goals1 = teamSort.get(b).getGoals();  
                if(goals > goals1)
                {
                    indexOfTeam2 = a;       
                }
                else if (goals == goals1)
                {
                    int randomFinal = teamSort.get(a).randomFinal();
                    if( randomFinal == 1)
                    {
                        indexOfTeam2 = a;        
                    }
                    else
                    {
                        indexOfTeam2 = b;          

                    }

                }
            }
            a ++;
        }
    }
    
    public int getIndexOfTeam1()
    {
    return indexOfTeam1;   
    }
    
    public int getIndexOfTeam2()
    {
    return indexOfTeam2;   
    }
}
