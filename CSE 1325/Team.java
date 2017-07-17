/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class contains general information about a team.
 */

package tournamenttest;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JFrame;

public class Team 
{
    private int teamNumber;
    private String teamName;
    private Robot robotDescription;
    private int numberOfMembers;
    private Coach coach;
    private Mentor mentor;
    private ArrayList<TeamMember> teamMembers = new ArrayList();
    private String group;
    private String sponsor;
    private PDate judgingTime;
    private int judgingLocation;
    private TournamentEnumeration.teamGameStatus teamStatus;
    private TournamentEnumeration.teamJudgingStatus judgingStatus;
    private int rankingPoints = 0;
    private int qualifyingPoints = 0;
    private int judgingPoints;
    private ArrayList<Integer> gamesToBePlayed = new ArrayList();
    private TournamentEnumeration.teamColor color;
    
    Scanner input = new Scanner(System.in);
    GregorianCalendar random = new GregorianCalendar();
    Random randSeed = new Random(random.getTimeInMillis());
    
    public Team() // This constructor will create a dummy team that does not exist.
    {
        teamNumber = 0;
        robotDescription = new Robot();
    }
    
    public Team(int teamNum)
    {
        this.teamNumber=teamNum;
    }
    
    // This constructor will create a real team and initialize people and data members.
    public Team(int teamNumber,int maxTeamNum) 
    {
        setTeamNumber(teamNumber,maxTeamNum);
        System.out.println("\nPlease enter the team "+teamNumber+"'s name. Please do NOT include spaces.");
        teamName = input.next();
        teamStatus = TournamentEnumeration.teamGameStatus.NOT_SIGNED_IN;
        judgingStatus = TournamentEnumeration.teamJudgingStatus.NOT_SIGNED_IN;
        System.out.println("\nPlease enter information for the team's Captain: ");
        System.out.println("\nWhat is the first name of this team member? Please do NOT include spaces.");
        String firstName = new String(input.next());
        System.out.println("\nWhat is the last name of this team member? Please do NOT include spaces.");
        String lastName = new String(input.next());
        System.out.println("\nWhat is the email address of this team member? Please do NOT include spaces.");
        String eMail = new String(input.next());
        teamMembers.add(new TeamMember(firstName, lastName, eMail,teamNumber,TournamentEnumeration.teamRole.CAPTAIN));
        System.out.println("\nPlease enter information for the team's code writer: ");
        System.out.println("\nWhat is the first name of this team member? Please do NOT include spaces.");
        firstName = new String(input.next());
        System.out.println("\nWhat is the last name of this team member? Please do NOT include spaces.");
        lastName = new String(input.next());
        System.out.println("\nWhat is the email address of this team member? Please do NOT include spaces.");
        eMail = new String(input.next());
        teamMembers.add(new TeamMember(firstName, lastName, eMail,teamNumber,TournamentEnumeration.teamRole.CODING));
        System.out.println("\nPlease enter information for the team's robot constructor: ");
        System.out.println("\nWhat is the first name of this team member? Please do NOT include spaces.");
        firstName = new String(input.next());
        System.out.println("\nWhat is the last name of this team member? Please do NOT include spaces.");
        lastName = new String(input.next());
        System.out.println("\nWhat is the email address of this team member? Please do NOT include spaces.");
        eMail = new String(input.next());
        teamMembers.add(new TeamMember(firstName, lastName, eMail,teamNumber,TournamentEnumeration.teamRole.CONSTRUCTION));
        System.out.println("\nPlease enter information for the team's robot designer: ");
        System.out.println("\nWhat is the first name of this team member? Please do NOT include spaces.");
        firstName = new String(input.next());
        System.out.println("\nWhat is the last name of this team member? Please do NOT include spaces.");
        lastName = new String(input.next());
        System.out.println("\nWhat is the email address of this team member? Please do NOT include spaces.");
        eMail = new String(input.next());
        teamMembers.add(new TeamMember(firstName, lastName, eMail,teamNumber,TournamentEnumeration.teamRole.DESIGN));
        System.out.println("\nPlease enter information for the team's robot driver: ");
        System.out.println("\nWhat is the first name of this team member? Please do NOT include spaces.");
        firstName = new String(input.next());
        System.out.println("\nWhat is the last name of this team member? Please do NOT include spaces.");
        lastName = new String(input.next());
        System.out.println("\nWhat is the email address of this team member? Please do NOT include spaces.");
        eMail = new String(input.next());
        teamMembers.add(new TeamMember(firstName, lastName, eMail,teamNumber,TournamentEnumeration.teamRole.DRIVER));
        System.out.println("\nPlease enter information for the team's robot tester: ");
        System.out.println("\nWhat is the first name of this team member? Please do NOT include spaces.");
        firstName = new String(input.next());
        System.out.println("\nWhat is the last name of this team member? Please do NOT include spaces.");
        lastName = new String(input.next());
        System.out.println("\nWhat is the email address of this team member? Please do NOT include spaces.");
        eMail = new String(input.next());
        teamMembers.add(new TeamMember(firstName, lastName, eMail,teamNumber,TournamentEnumeration.teamRole.TESTER));
        System.out.println("\nPlease enter information for the team's coach: ");
        System.out.println("\nWhat is the first name of this person? Please do NOT include spaces.");
        firstName = new String(input.next());
        System.out.println("\nWhat is the last name of this person? Please do NOT include spaces.");
        lastName = new String(input.next());
        System.out.println("\nWhat is the email address of this person? Please do NOT include spaces.");
        eMail = new String(input.next());
        this.coach = new Coach(firstName,lastName,eMail,teamNumber);
         System.out.println("\nPlease enter information for the team's mentor: ");
        System.out.println("\nWhat is the first name of this person? Please do NOT include spaces.");
        firstName = new String(input.next());
        System.out.println("\nWhat is the last name of this person? Please do NOT include spaces.");
        lastName = new String(input.next());
        System.out.println("\nWhat is the email address of this person? Please do NOT include spaces.");
        eMail = new String(input.next());
        this.mentor = new Mentor(firstName,lastName,eMail,teamNumber);
        robotDescription = new Robot(teamNumber);
    }
    
    public Team(int teamNum, int qualPoint, int rankPoint)
    {
        setTeamNumber(teamNum,6);
        setQualifyingPoints(qualPoint);
        setRankingPoints(rankPoint);
    }
    
    public void goToJudging(Tournament currentTournament, Team team) // This method will assign a random judging location to a team object/
    {
        if(team.judgingStatus==TournamentEnumeration.teamJudgingStatus.BEFORE && team.robotDescription.getRobotStatus()==TournamentEnumeration.robotStatus.FIELD_TEST_PASSED)
        {
        int location = randSeed.nextInt(currentTournament.getJudgingLocations())+1;
        judgingLocation = location;
        judgingStatus = TournamentEnumeration.teamJudgingStatus.IN;
        System.out.println("\nTeam "+team.teamNumber+" has been assigned judging location "+location);
        System.out.println("\nPlease go to your assigned station and begin your interview.");
        }
        else if(team.judgingStatus==TournamentEnumeration.teamJudgingStatus.NOT_SIGNED_IN)
            System.out.println("\nUnable to go to judging. This team must be signed in first.");
        else if(team.judgingStatus==TournamentEnumeration.teamJudgingStatus.IN)
            System.out.println("\nThis team is currently in judging.");
        else if(team.robotDescription.getRobotStatus()!=TournamentEnumeration.robotStatus.FIELD_TEST_PASSED)
            System.out.println("\nThis team's robot must pass all required inspections before this team can go to judging.");
        else
            System.out.println("\nThis team has already completed judging.");
    }
    
    public void judgeInterview(Team team) // This method will simulate a judge interview.
    {
        if(team.judgingStatus==TournamentEnumeration.teamJudgingStatus.IN)
        {
            judgingStatus = TournamentEnumeration.teamJudgingStatus.COMPLETED;
            System.out.println("\nThis team has completed judging.");
        }
        
        else if(team.judgingStatus==TournamentEnumeration.teamJudgingStatus.BEFORE)
            System.out.println("\nPlease go to a judging station to obtain a judging location number");
        
        else if(team.judgingStatus==TournamentEnumeration.teamJudgingStatus.NOT_SIGNED_IN)
            System.out.println("\nUnable to go to judging. This team must be signed in first.");
        
        else
            System.out.println("\nThis team has already completed judging.");
    }
    
    public void openEditGUI()
    {
        TeamModifyFrame frame = new TeamModifyFrame(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,300);
        frame.setVisible(true);
        this.teamName=frame.getTeam().getTeamName();
        this.group=frame.getTeam().getGroup();
        this.sponsor=frame.getTeam().getSponsor();
    }

    public int getTeamNumber() // This method will allow access to the Team Number member. 
    {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber, int maxTeamNum) // This method will mutate and check data for the Team Number member. 
    {
        while(teamNumber < 0) // This loop will exectute if user input is invalid.
        {
            System.out.println("\nInvalid team number. Please enter a number greater than 1 and less than"+maxTeamNum+".");
            input.nextInt();
        }
        
        this.teamNumber = teamNumber;
    }

    public String getTeamName() // This method will allow access to the Team Name member.
    {
        return teamName;
    }

    public void setTeamName(String teamName) // This method will mutate data for the Team Name member. 
    {
        this.teamName = teamName;
    }

    public Robot getRobotDescription() // This method will allow access to the Robot object. 
    {
        return robotDescription;
    }

    public void setRobotDescription(Robot robotDescription) // This method will mutate this object's robot object.
    {
        this.robotDescription = robotDescription;
    }

    public int getNumberOfMembers() // This method will allow access to the Number of members member.
    {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) // This method will muatate and error check data for the Number of members member. 
    {
        while (numberOfMembers<6) // This loop will exectute if the user input is invalid.
        {
            System.out.println("\nInvalid number of team members, there must be at least 6 members in a team.");
            input.nextInt();
        }
        
        this.numberOfMembers = numberOfMembers;
    }

    public Coach getCoach() // This method will allow access to the coach object. 
    {
        return coach;
    }

    public void setCoach(Coach coach) // This method will mutate the Coach object.
    {
        this.coach = coach;
    }

    public Mentor getMentor() // This method will allow access to the Mentor object. 
    {
        return mentor;
    }

    public void setMentor(Mentor mentor)  // This method will mutate the Mentor object.
    {
        this.mentor = mentor;
    }

    public  ArrayList<TeamMember> getTeamMembers() // This method will allow access to the team member names.
    {
        return teamMembers;
    }

    public void setTeamMembers(ArrayList<TeamMember> teamMembers) // This method will mutate the list of Team member names.
    {
        this.teamMembers = teamMembers;
    }

    public String getGroup() // This method will allow access to the Group member. 
    {
        return group;
    }

    public void setGroup(String group) // This method will mutate data for the group name. 
    {
        this.group = group;
    }

    public String getSponsor() // This method will allow access to the Sponsor member.
    {
        return sponsor;
    }

    public void setSponsor(String sponsor) // This method will mutate data for the Sponsor name.
    {
        this.sponsor = sponsor;
    }

    public PDate getJudgingTime() // This method will allow access to the PDate member. 
    {
        return judgingTime;
    }

    public void setJudgingTime(PDate judgingTime) // This method will mutate the PDate object. 
    {
        this.judgingTime = judgingTime;
    }

    public int getJudgingLocation() // This method will allow access to the team's judging location. 
    {
        return judgingLocation;
    }

    public void setJudgingLocation(int judgingLocation, int maxNumLocations) // This method will mutate and error check data for the team's judging location. 
    {
        while(judgingLocation<1 || judgingLocation>maxNumLocations) // This loop will execute if the user input is invalid.
        {
            System.out.println("Invalid Judging location. Please enter a number greater than 1 and less than"+maxNumLocations+".");
        }
        
        this.judgingLocation = judgingLocation;
    }

    public TournamentEnumeration.teamGameStatus getTeamStatus() // This method will allow access to the Team Status member. 
    {
        return teamStatus;
    }

    public void setTeamStatus(TournamentEnumeration.teamGameStatus teamStatus) // This method will mutate and error check the Team Status member.
    {
        boolean found = false;
        
        if(teamStatus==TournamentEnumeration.teamGameStatus.INELIGIBLE)
            found = true;
            
        else if(teamStatus==TournamentEnumeration.teamGameStatus.PASSED_INSPECTION)
            found = true;
                
        else if(teamStatus==TournamentEnumeration.teamGameStatus.PLAYED5_MATCHES)
            found = true;
            
        else if(teamStatus==TournamentEnumeration.teamGameStatus.PREPARING)
            found = true;
        
        else if(teamStatus==TournamentEnumeration.teamGameStatus.NOT_SIGNED_IN)
            found = true;
        
        if (found) // If the parameter is found, then assign the status to the tournament object.
        {
            this.teamStatus = teamStatus;
        }
    }

    public TournamentEnumeration.teamJudgingStatus getJudgingStatus() // This method will allow access to the Judging Status member.
    {
        return judgingStatus;
    }

    public void setJudgingStatus(TournamentEnumeration.teamJudgingStatus judgingStatus) // This method will mutate and error check the Judging Status member.
    {
        boolean found = false;
        
        if(judgingStatus==TournamentEnumeration.teamJudgingStatus.BEFORE)
            found = true;
            
        else if(judgingStatus==TournamentEnumeration.teamJudgingStatus.COMPLETED)
            found = true;
                
        else if(judgingStatus==TournamentEnumeration.teamJudgingStatus.IN)
            found = true;
        
        if (found) // If the parameter is found, then assign the status to the tournament object.
        {
            this.judgingStatus = judgingStatus;
        }
    }

    public int getRankingPoints() // This method will allow access to the Ranking Points member.
    {
        return rankingPoints;
    }

    public void setRankingPoints() // This method will mutate and error check the Ranking Points member.
    { 
        this.rankingPoints = randSeed.nextInt(1576);
    }
    
     public void setRankingPoints(int rankingPoints) // This method will mutate and error check the Ranking Points member.
    {
        this.rankingPoints = this.rankingPoints + rankingPoints;
    }

    public int getQualifyingPoints() // This member will allow access the Qualifying points member. 
    {
        return qualifyingPoints;
    }

    public void setQualifyingPoints() // This member will mutate and error check the Qualifying points member. 
    { 
        this.qualifyingPoints = randSeed.nextInt(11);
    }
    
    public void setQualifyingPoints(int qualifyingPoints) // This member will mutate and error check the Qualifying points member. 
    {
      this.qualifyingPoints = this.qualifyingPoints + qualifyingPoints;
    }

    public int getJudgingPoints() // This member will allow access to the Judging points member.
    {
        return judgingPoints;
    }

    public void setJudgingPoints(int judgingPoints, int totalNumTeam) // This member will mutate and error check data for the Judging Points member. 
    {
        while(judgingPoints<1 || judgingPoints>totalNumTeam)
        {
            judgingPoints = randSeed.nextInt(totalNumTeam)+1;
        }
        this.judgingPoints = judgingPoints;
    }

    // This method will allow access to the match list.
    public ArrayList<Integer> getGamesToBePlayed() 
    {
        return gamesToBePlayed;
    }

    // This method will mutate the match list.
    public void setGamesToBePlayed(ArrayList<Integer> gamesToBePlayed) 
    {
        this.gamesToBePlayed = gamesToBePlayed;
    }

    // This method will allow access to a team's color.
    public TournamentEnumeration.teamColor getColor() 
    {
        return color;
    }

    // This method will change a team's color.
    public void setColor(TournamentEnumeration.teamColor color) 
    {
        this.color = color;
    }
    
    

    @Override
    public String toString() {
        return "Team Number: "+teamNumber+"\nTeam Name: "+teamName+"\nStatus In Tournament: "+teamStatus+"\nJudging Status: "+judgingStatus;
    }
}