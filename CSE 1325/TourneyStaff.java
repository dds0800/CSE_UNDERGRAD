/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: Objects from this class will represent a staff member in the
 * tournament. This class inherits data from the Person class.
 */
package tournamenttest;

import java.util.ArrayList;
import java.util.Scanner;

public class TourneyStaff extends Person
{
    private String tournamentName;
    private int experience = 0;
    private ArrayList<TournamentEnumeration.roles> ableRoles = new ArrayList();
    private boolean finishTraining;
    private TournamentEnumeration.compensation compensationType;
    
    Scanner input = new Scanner(System.in);
    
    
    
    public TourneyStaff(String first, String last, String eMail)
    {
        super(first,last,eMail);
    }

    public TourneyStaff(String tournamentName, boolean finishTraining, TournamentEnumeration.compensation compensationType, String first, String last, String mail) 
    {
        super(first, last, mail);
        this.tournamentName = tournamentName;
        this.finishTraining = finishTraining;
        this.compensationType = compensationType;
    }
    
    

    // This method will allow access to the tournament name.
    public String getTournamentName() 
    {
        return tournamentName;
    }
    
    // This method will mutate the tournament name.
    public void setTournamentName(String tournamentName)
    {
        this.tournamentName = tournamentName;
    }

    // This method will allow access to the years of experience.
    public int getExperience() 
    {
        return experience;
    }

    // This method will mutate the years of experience.
    public void setExperience(int experience) 
    {
        while(experience<1)
        {
            System.out.println("\nInvalid number of years. Please enter a positive integer");
            experience = input.nextInt();
        }
    
        this.experience = experience;
    }

    // This method will allow access to the list of roles.
    public ArrayList<TournamentEnumeration.roles> getAbleRoles()
    {
        return ableRoles;
    }

    // This method will mutate the list of roles.
    public void setAbleRoles(ArrayList<TournamentEnumeration.roles> ableRoles)
    {
        this.ableRoles = ableRoles;
    }

    // This method will return the value of the training value.
    public boolean isFinishTraining() {
        return finishTraining;
    }

    // This method will mutate the training value.
    public void setFinishTraining(boolean finishTraining) 
    {
        this.finishTraining = finishTraining;
    }

    // This method will allow access to the compensation type.
    public TournamentEnumeration.compensation getCompensationType() 
    {
        return compensationType;
    }

    // This method will mutate the compensation type.
    public void setCompensationType(TournamentEnumeration.compensation compensationType) 
    {
        this.compensationType = compensationType;
    }

    @Override
    public String toString() {
        return super.toString()+" Years of Experience: "+experience;
    }
}
