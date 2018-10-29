
/**
 * Write a description of class Menu here.
 * 
 * @author (Han J) 
 * @version (Semester 1 2018 Assignment 2)
 */
public class Menu
{
    // instance variables - replace the example below with your own
    private char input;

    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        input = 'Z';
    }

    /**
     * display menu 
     */
    public void displayMenu()
    {
        System.out.println("Please now select on option below by typing in the relevant character to continue!");   
        System.out.println("\nA. Play Preliminary Stage");
        System.out.println("B. Play Final");
        System.out.println("C. Display Teams");
        System.out.println("D. Display Players");
        System.out.println("E. Display Cup Result");
        System.out.println("X. Close");
    }

    public void test()
    {
  String b = "dsfdfdfdfdfdf";
  b = b.toUpperCase();
  System.out.println(b);
      
    }
}
