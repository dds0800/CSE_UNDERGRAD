/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class contains general information about a team's mentor. 
 * This class inherits methods and the data fields from the Person and Team Person classes. 
 */

package tournamenttest;

/**
 * This class represents a mentor for a team.
 * @author Daniel
 */
public class Mentor extends TeamPerson
{
       private int firstYear;
       private int[] teams;
       private String employer;
       
       /**
        * This constructor will create a Mentor object.
        * @param first The first name of the mentor.
        * @param last The last name of the mentor.
        * @param mail The eMail address of the mentor.
        * @param teamNum The team number that the mentor belongs to.
        * @param currentAdd The current address of the mentor.
        * @param year The year this person was first a mentor.
        * @param listOfTeams A list of teams that the mentor belongs to.
        * @param worksFor The organization the mentor works for,
        */
    public Mentor(String first, String last, String mail, int teamNum, Address currentAdd, int year,int[] listOfTeams , String worksFor)
    {
        super(first,last,mail,teamNum,currentAdd);
        
         while(year>2015)
        {
            System.out.println("\nInvalid year, please enter a less that or equal to 2015.");
            year = input.nextInt();
        }
        
        this.teams = listOfTeams;
      
        this.employer = worksFor;
    }
    
    /**
     * This method will create a Mentor object.
     * @param first The first name of the mentor.
     * @param last The last name of the mentor.
     * @param mail The eMail address of the mentor.
     * @param teamNum The team number the mentor belongs to.
     */
    public Mentor(String first, String last, String mail, int teamNum)
    {
        super(first,last,mail,teamNum);
        System.out.println("\nPlease enter the first year this person was a Mentor");
        setFirstYear(input.nextInt());
        System.out.println("\nWho is this person's employer? Please do NOT include spaces.");
        setEmployer(input.next());
    }

    /**
     * This method will return the first year this person was a mentor.
     * @return An integer that represents the year this person was a mentor.
     */
    public int getFirstYear() // This method will allow access to the First Year member.
    {
        return firstYear;
    }

    /**
     * This method will set and error check the first year this person
     * was a mentor.
     * @param firstYear An integer that represents the first year
     * this person was a mentor.
     */
    public void setFirstYear(int firstYear) // This method will mutate and error check the First Year member. We'll assume that all coaches started before 2000.
    {
         while(firstYear<2000 || firstYear > 2015)
        {
            System.out.println("\nInvalid year, please enter year before 2016 and after 1999");
            firstYear = input.nextInt();
        }
        this.firstYear = firstYear;
    }

    /**
     * This method will return a list of teams.
     * @return An array of team objects that a mentor belongs to.
     */
    public int[] getTeams() // This method will allow access to the Teams member.
    {
        return teams;
    }

    /**
     * This method will set the list of teams.
     * @param teams An array of team objects that a mentor belongs to.
     */
    public void setTeams(int[] teams) // This method will mutate the Teams member.
    {
        this.teams = teams;
    }

    /**
     * This method will return the name of the employer for the mentor.
     * @return A string that represents a mentor's employer.
     */
    public String getEmployer() // This method will allow access to the Employer member.
    {
        return employer;
    }

    /**
     * This method will set the employer for a mentor.
     * @param employer A string that represents a mentor's employer.
     */
    public void setEmployer(String employer) // This method will mutate the Employer member.
    {
        this.employer = employer;
    } 

    @Override
    /**
     * This method returns a string that contains information
     * about a Mentor object.
     */
    public String toString() {
        return super.toString()+"\nFirst year as Mentor: " + firstYear + "\nEmployer: " + employer;
    }   
}
