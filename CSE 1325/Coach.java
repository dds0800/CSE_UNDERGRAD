/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class contains general information about a team's coach. 
 * This class inherits methods and the data fields from the Person and Team Person classes. 
 */

package tournamenttest;

/**
 * This class represents a coach for a team.
 * @author Daniel
 */
public class Coach extends TeamPerson
{
    private int firstYear;
    private int[] teams;
    private String employer;
    private boolean hasTeacher;

    /**
     * This constructor creates a coach object.
     * @param first First name of coach.
     * @param last Last name of coach.
     * @param mail Email address of coach.
     * @param teamNum The team number that the coach belongs to.
     * @param currentAdd The current address of the coach.
     * @param year The year this person was a coach for the first time.
     * @param listOfTeams A list of teams that the coach belongs to.
     * @param worksFor  The name of the person the coach works for.
     */
    public Coach(String first, String last, String mail, int teamNum, Address currentAdd, int year, int[] listOfTeams, String worksFor) // This constructor intitializes the inherited members and this object's members.
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
     * This constructor is used to create a coach object.
     * @param first The first name of the coach.
     * @param last The last name of the coach.
     * @param mail The email address of the coach.
     * @param teamNum The team number that the coach belongs too.
     */
    public Coach(String first, String last, String mail, int teamNum)
    {
        super(first,last,mail,teamNum);
        System.out.println("\nPlease enter the first year this person was a coach");
        setFirstYear(input.nextInt());
        System.out.println("\nWho is this person's employer? Please do NOT include spaces.");
        setEmployer(input.next());
    }
     
    /**
     * This method will return the first year this person was coach.
     * @return An integer that represents a year.
     */
    public int getFirstYear() // This method will allow access to the First Year member.
    {
        return firstYear;
    }

    /**
     * This method sets and error checks the passed year parameter,
     * @param firstYear An integer the represents the first year this person was coach.
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
     * This method returns an array of teams that this coach, coaches.
     * @return A list of integers that represents a team.
     */
    public int[] getTeams() // This method will allow access to the Teams member.
    {
        return teams;
    }

    /**
     * This method sets the array of teams that belongs to the coach.
     * @param teams A list of integers that represents a team's number.
     */
    public void setTeams(int[] teams) // This method will mutate the Team member.
    {
        this.teams = teams;
    }
    
    /**
     * This method returns the coach's employer.
     * @return A string that indicates the coach's employer.
     */
    public String getEmployer() // This method will allow access to the Employer member.
    {
        return employer;
    }

    /**
     * This method will set the string for the employer.
     * @param employer The name of the coach's employer.
     */
    public void setEmployer(String employer) // This method will mutate the Employer member.
    {
        this.employer = employer;
    } 

    /**
     * This method will return a boolean value indicating if the coach has a teacher.
     * @return True if the coach has a teacher. False is the coach does not have a teacher.
     */
    public boolean isHasTeacher() // This method will allow access to the Teacher member.
    {
        return hasTeacher;
    }

    /**
     * This method will change the status of the hasTeacher member.
     * @param hasTeacher A boolean value that indicates if the coach has a teacher or not.
     */
    public void setHasTeacher(boolean hasTeacher) // This member will mutate the Teacher member.
    {
        this.hasTeacher = hasTeacher;
    }

    @Override
    /**
     * This method will return a string that gives information about a coach object.
     */
    public String toString() {
        return super.toString()+"\nFirst year as coach: " + firstYear + "\nEmployer: " + employer;
    } 
}