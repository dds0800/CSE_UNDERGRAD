/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: Objects from this class will represent a visitor of the 
 * tournament. This class inherits data from the Person class.
 */

package tournamenttest;

import java.util.Scanner;

public class Visitor extends Person
{
    private boolean relationToTeamMember;
    private boolean firstTimeToTournament;
    private boolean potentialDonor;
    private boolean potentialVolunteer;
    
    Scanner input = new Scanner(System.in);

    public Visitor(boolean relationToTeamMember, boolean firstTimeToTournament, boolean potentialDonor, boolean potentialVolunteer, String first, String last, String mail) 
    {
        super(first, last, mail);
        this.relationToTeamMember = relationToTeamMember;
        this.firstTimeToTournament = firstTimeToTournament;
        this.potentialDonor = potentialDonor;
        this.potentialVolunteer = potentialVolunteer;
    }

    public Visitor(String first, String last, String mail)
    {
        super(first, last, mail);
    }

    // This method will return the value of relation to member.
    public boolean isRelationToTeamMember() 
    {
        return relationToTeamMember;
    }

    // This method will mutate the value of relation to member.
    public void setRelationToTeamMember(boolean relationToTeamMember) 
    {
        this.relationToTeamMember = relationToTeamMember;
    }
    
    public void setRelationToTeamMember(String answer)
    {
        boolean validInput=true;
        
        while(validInput)
        {
            if(answer.equalsIgnoreCase("Yes"))
            {
                this.relationToTeamMember = true;
                validInput=false;
            }
            else if(answer.equalsIgnoreCase("No"))
            {
                this.relationToTeamMember = false;
                validInput=false;
            }
            else
            {
                System.out.println("\nInvalid input. Please type in yes or no without any spaces.");
                answer=input.next();
            }
        }
    }

    // This method will return the value of first time to tournament.
    public boolean isFirstTimeToTournament() 
    {
        return firstTimeToTournament;
    }

    // This method will mutate the value of first time to tournament
    public void setFirstTimeToTournament(boolean firstTimeToTournament)
    {
        this.firstTimeToTournament = firstTimeToTournament;
    }
    
    public void setFirstTimeToTournament(String answer)
    {
        boolean validInput=true;
        
        while(validInput)
        {
            if(answer.equalsIgnoreCase("Yes"))
            {
                this.firstTimeToTournament = true;
                validInput=false;
            }
            else if(answer.equalsIgnoreCase("No"))
            {
                this.firstTimeToTournament = false;
                validInput=false;
            }
            else
            {
                System.out.println("\nInvalid input. Please type in yes or no without any spaces.");
                answer=input.next();
            }
        }
    }

    // This method will return the value of potential donor.
    public boolean isPotentialDonor() 
    {
        return potentialDonor;
    }

 
    // This method will mutate the value of potential donor
    public void setPotentialDonor(boolean potentialDonor) 
    {
        this.potentialDonor = potentialDonor;
    }
    
    public void setPotentialDonor(String answer)
    {
        boolean validInput=true;
        
        while(validInput)
        {
            if(answer.equalsIgnoreCase("Yes"))
            {
                this.potentialDonor = true;
                validInput=false;
            }
            else if(answer.equalsIgnoreCase("No"))
            {
                this.potentialDonor = false;
                validInput=false;
            }
            else
            {
                System.out.println("\nInvalid input. Please type in yes or no without any spaces.");
                answer=input.next();
            }
        }
    }
    
    // This method will return the value of potential volunteer.
    public boolean isPotentialVolunteer() 
    {
        return potentialVolunteer;
    }

    // This method will mutate the value of potential volunteer
    public void setPotentialVolunteer(boolean potentialVolunteer)
    {
        this.potentialVolunteer = potentialVolunteer;
    }
    
    public void setPotentialVolunteer(String answer)
    {
        boolean validInput=true;
        
        while(validInput)
        {
            if(answer.equalsIgnoreCase("Yes"))
            {
                this.potentialVolunteer = true;
                validInput=false;
            }
            else if(answer.equalsIgnoreCase("No"))
            {
                this.potentialVolunteer = false;
                validInput=false;
            }
            else
            {
                System.out.println("\nInvalid input. Please type in yes or no without any spaces.");
                answer=input.next();
            }
        }
    }

    @Override
    public String toString() 
    {
        return super.toString() + " Related to a Team Member?: " + relationToTeamMember + " First Time to Tournament?: " + firstTimeToTournament + " Potential Donor?: " + potentialDonor + " Potential Volunteer?: " + potentialVolunteer;
    }
}