/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class contains general information about a team member.
 * This class inherits methods and the data fields from Person and TeamPerson classes.
 */

package tournamenttest;

import java.util.Scanner;

public class TeamMember extends TeamPerson
{
    private PDate lastRobotWork;
    private TournamentEnumeration.teamExperience experience;
    private TournamentEnumeration.teamRole role;
    private int grade;
    private int age;
 
    Scanner input = new Scanner(System.in);
    
    public TeamMember(String first,String last,String mail,int teamNum,TournamentEnumeration.teamRole role)
    {
        super(first ,last , mail, teamNum);
        this.role=role;
        System.out.println("\n What is this member's grade. Please input an integer between 7 and 12.");
        setGrade(input.nextInt());
        System.out.println("\n What is this member's age. Please input an integer between 10 and 20.");
        setAge(input.nextInt());
    }
    public TeamMember(String first,String last,String mail,PDate date, int teamNum, Address currentAdd)
    {
        super(first,last,mail,teamNum,currentAdd);
        this.lastRobotWork = date;
    }

    public PDate getLastRobotWork() // This method will allow access to the PDate object.
    {
        return lastRobotWork;
    }

    public void setLastRobotWork(PDate lastRobotWork) // This method will mutate the PDate object. 
    {
        this.lastRobotWork = lastRobotWork;
    }

    public TournamentEnumeration.teamExperience getExperience() // This method will allow access to the team experience member.
    {
        return experience;
    }

    public void setExperience(TournamentEnumeration.teamExperience experience) // This method will mutate and error check the team experience member. 
    {
        boolean found = false;
        
        if(experience==TournamentEnumeration.teamExperience.EXPERIENCED)
            found = true;
            
        else if(experience==TournamentEnumeration.teamExperience.NOVICE)
            found = true;
                
        else if(experience==TournamentEnumeration.teamExperience.PEER_MENTOR)
            found = true;
        
        if (found) // If the parameter is found, then assign the status to the TeamMember object.
        {
            this.experience = experience;
        }
    }

    public TournamentEnumeration.teamRole getRole() // This method will allow access to the Team Role member.
    {
        return role;
    }

    public void setRole(TournamentEnumeration.teamRole role)  // This member will mutate and error check the Team Role member.
    {
        boolean found = false;
        
        if(role==TournamentEnumeration.teamRole.CAPTAIN)
            found = true;
            
        else if(role==TournamentEnumeration.teamRole.CODING)
            found = true;
                
        else if(role==TournamentEnumeration.teamRole.CONSTRUCTION)
            found = true;
        
        else if(role==TournamentEnumeration.teamRole.DESIGN)
            found = true;
        
        else if(role==TournamentEnumeration.teamRole.DRIVER)
            found = true;
        
        else if(role==TournamentEnumeration.teamRole.TESTER)
            found = true;
        
        if (found) // If the parameter is found, then assign the status to the TeamMember object.
        {
            this.role = role;
        }
    }

    public int getGrade() // This method will allow access to the Grade member.
    {
        return grade;
    }

    public void setGrade(int grade) // This method will mutate and error check data for the Grade member.  
    {
        while(grade<7 || grade>12) // This loop will execute if the user input is invalid.
        {
            System.out.println("\nInvalid grade level. Please enter a grade level between 7 and 12.");
            grade = input.nextInt();
        }
        
        this.grade = grade;
    }

    public int getAge()  // This method will allow access to the Team Member's age.
    {
        return age;
    }

    public void setAge(int age) // This method will mutate and error check data for the Team Member's age. 
    {
        while(age<10 || age>20) // This loop will execute if the user input is invalid. We'll assume that the members are between the ages of 10 and 20
        {
            System.out.println("\nInvalid age, please input an age between 10 and 20.");
            age = input.nextInt();
        }
        
        this.age = age;
    }

    @Override
    public String toString() 
    {
        return super.toString()+"\n"+"Position: Team Member " + ", Experience:" + experience + ", Team Role: " + role + ", Grade Level: " + grade + ", Age: " + age;
    }  
}