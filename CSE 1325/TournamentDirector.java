/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: Objects from this class will represent a Tournament Director in the
 * tournament. This class inherits data from the TourneyStaff class.
 */

package tournamenttest;

import java.util.Scanner;

public class TournamentDirector extends TourneyStaff 
{
    private String organizationTitle;
    private int firstYearAsDirector;
    
    Scanner input = new Scanner(System.in);

    public TournamentDirector(String organizationTitle, int firstYearAsDirector,String first, String last, String eMail) 
    {
        super(first,last,eMail);
        this.organizationTitle = organizationTitle;
        this.firstYearAsDirector = firstYearAsDirector;
    }
    
    
    public TournamentDirector(String first, String last, String eMail)
    {
        super(first,last,eMail);
        System.out.println("\nWhat is the name of the organization that this tournament director if from");
        System.out.println("Please do NOT include any spaces.");
        setOrganizationTitle(input.next());
        System.out.println("\nWhat was the first year this person has served as a tournament director?");
        System.out.println("Please enter in a year before 2016 and after 1999.");
        setFirstYearAsDirector(input.nextInt());
        System.out.println("\nHow many years of experience does this person has in robot tournaments?");
        System.out.println("Please enter in an integer that is greater than zero.");
        setExperience(input.nextInt());
    }

    public TournamentDirector(String tournamentName, boolean finishTraining, TournamentEnumeration.compensation compensationType, String first, String last, String mail) {
        super(tournamentName, finishTraining, compensationType, first, last, mail);
    }

    // This method will retrieve the organizational title. 
    public String getOrganizationTitle()
    {
        return organizationTitle;
    }

    // This method will mutate the organizational title.
    public void setOrganizationTitle(String organizationTitle) 
    {
        this.organizationTitle = organizationTitle;
    }

    // This method will retrieve the first year as director.
    public int getFirstYearAsDirector() 
    {
        return firstYearAsDirector;
    }

    // This method will mutate and error check the first year as director.
    public void setFirstYearAsDirector(int firstYearAsDirector)
    {
        while(firstYearAsDirector>2015 || firstYearAsDirector<2000)
        {
            System.out.println("Invalid year. Please enter a year before 2016 and after 1999");
            firstYearAsDirector = input.nextInt();
        }
        this.firstYearAsDirector = firstYearAsDirector;
    }

    @Override
    public String toString() 
    {
        return super.toString()+" Organization Name: "+organizationTitle+" First Year as Director: "+firstYearAsDirector;
    }
}