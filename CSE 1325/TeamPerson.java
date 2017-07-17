/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class contains general information about a team.
 * This class inherits the methods and data field from the Person class.
 */

package tournamenttest;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamPerson extends Person //implements SafetyConcerns
{
  private int teamNumber;
  private Address address;
  private int hoursInWeek;
  private int hoursInSeason;
  private ArrayList<SafetyViolation> violations = new ArrayList();
  
  Scanner input = new Scanner(System.in);
  
    public TeamPerson(String first,String last,String mail,int teamNum, Address currentAdd)
    {
        super(first,last,mail);
        
    }
    
    public TeamPerson(String first,String last,String mail,int teamNum)
    {
        super(first,last,mail);
        this.teamNumber=teamNum;
        
    }

    public int getTeamNumber() // This method will allow access to the Team Number member.
    {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber, int maxTeamNum) // This method will mutate and error check the Team Number member.
    {
        while(teamNumber<1 || teamNumber>maxTeamNum) // This loop will exectute if user input is invalid.
        {
            System.out.println("Invalid team number. Please input a number that is greater than 1 and less than"+maxTeamNum+".");
            teamNumber = input.nextInt();
        }
        this.teamNumber = teamNumber;
    }

    public Address getAddress() // The method will allow access to the address object.
    {
        return address;
    }

    public void setAddress(Address address) // This method will mutate data for the address member.
    {
        this.address = address;
    }

    public int getHoursInWeek() // This method will allow access to the number of hours completed in a week.
    {
        return hoursInWeek;
    }

    public void setHoursInWeek(int hoursInWeek) // The method will mutate and error check the Hours in week member.
    {
        while(hoursInWeek<1) // This loop will execute if the user input is invalid.
        {
            System.out.println("Invalid number of hours, please input a number greater than one.");
            hoursInWeek = input.nextInt();
        }
        
        this.hoursInWeek = hoursInWeek;
    }

    public int getHoursInSeason() // This method will allow access to the hours completed in a season.
    {
        return hoursInSeason;
    }

    public void setHoursInSeason(int hoursInSeason) // This method will allow access to the hours in season member.
    {
        while(hoursInSeason<1) // This loop will execute if the user input is invalid.
        {
            System.out.println("Invalid number of hours, please input a number greater than one.");
            hoursInSeason = input.nextInt();
        }
         
        this.hoursInSeason = hoursInSeason;
    }

    // This method will return the list of violations
    public ArrayList<SafetyViolation> getViolations() 
    {
        return violations;
    }

    // This method will set the list of violations.
    public void setViolations(ArrayList<SafetyViolation> violations) 
    {
        this.violations = violations;
    }

   
    
    @Override
    public String toString()
    {
        return super.toString()+"\n"+ "Team Number: " + teamNumber + ", Address: " + address + ", Hours Completed this week: " + hoursInWeek + ", Hours completed this season: " + hoursInSeason;
    }
}