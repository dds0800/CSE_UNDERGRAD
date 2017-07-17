/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class contains the main routine that will simulate the 
 * Robot Tournament. 
 */

package tournamenttest;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class TournamentTest // Main Class Start
{
    public static void main(String[] args) // Main Routine Start
    {
        Scanner input = new Scanner(System.in); //Create scanner object to get user input.
       /* System.out.println("Hello, this program simulates robot tournaments.\n");
        System.out.println("\nTo see the output data found in the test data file please type in 1.");
        System.out.println("The tournament program will execute normally after option 1.");
        System.out.println("To skip the output data and execute the program normally, please type in 2\n");
        System.out.println("Please enter your choice now.");
        int userInp = input.nextInt();
        boolean outputData = true;
        
       while(outputData)
        {
            switch(userInp) // Switch statement will let the grader decide if they want to see the test data or not.
            {
                case 1:
                    System.out.println("\nThe following is a test of how setting a PDate object is handled.\n");
                    System.out.println("\nCurrent Date 13/1/2015");
                    PDate testDate = new PDate(13,1,2015);
                    System.out.println("\n"+testDate+"\n");
                    System.out.println("\nThe following is a test of how the dimensions of a robot is handled..\n");
                    System.out.println("Current Dimenstions -1X-5X-100");
                    Robot testRobot = new Robot(-1,-5,-100);
                    System.out.println("\nThe following is a test of how the qualifying and ranking points are handled.\n");
                    Tournament testTournament1 = new Tournament(6,-1,-2,-4,100,20,2000,3,4567,-12,123,-1000,2);
                    //Tournament testTournament2 = new Tournament(6);
                    System.out.println("\n*** The Normal Simulation will now begin ***\n");
                    outputData = false;
                    break;
                case 2:
                   outputData = false;
                    break;
                default:
                    System.out.println("\nInvalid input, please enter 1 or 2.");
                    userInp = input.nextInt();
                    break;
            }
        } */
        System.out.println("\nWelcome to the tournament simulation!\n"); //Welcome the user to the program.
        System.out.println("All test data will be displayed when you end the simulation.\n");
        Tournament robotTournament = new Tournament(); // Create a tournament object and prompt the user for general information for the tournament.
        robotTournament.setTournamentStatus(TournamentEnumeration.tournamentStatus.INSPECTIONS);
        boolean tournamentStart = true;
     
        while(tournamentStart) // This loop contains a menu in which the user will progress through the tournament.
        {
            System.out.println("\nPlese input one of the following menu options."); // Show the user the menu options and prompt the user to select a choice.
            System.out.println("\n1. Team Sign In"); 
            System.out.println("2. Edit Team Information");
            System.out.println("3. Edit Team Member Information");
            System.out.println("4. Turn Robot on to prepare for inpections.");
            System.out.println("5. Hardware Inspection"); 
            System.out.println("6. Software Inspection"); 
            System.out.println("7. Field Test"); 
            System.out.println("8. Go to a judging station.");
            System.out.println("9. Judge interviews"); 
            System.out.println("10. Generate Matches");
            System.out.println("11. Play Matches"); 
            System.out.println("12. Display Awards");
            System.out.println("13. Display information about a person."); 
            System.out.println("14. Display information about a team"); 
            System.out.println("15. Display information about a team's robot."); 
            System.out.println("16. Display infromation about the tournament."); 
            System.out.println("17. End Simulation\n");
            
            int userInp = input.nextInt();
            int maxTeamNum = robotTournament.getMaxTeamNum();

            switch(userInp) // This switch statement will contain the menu choices. 
            {
                case 1:
                    int teamNumber;
                    Team team = new Team();
                    System.out.println("\nWhat team would you like to add in? Please enter a positve integer that is less than or equal to "+maxTeamNum);
                    teamNumber = input.nextInt();
                    
                    while(teamNumber<=0 || teamNumber>maxTeamNum) //This while loop will check to see if the number of teams in a valid integer.
                    {
                        System.out.println("\nInvalid team number, please enter a postive integer that is less than or equal to "+maxTeamNum);//Inform the user that the team number is invalid and prompt the user to input another team number.
                        teamNumber = input.nextInt();
                    }
                    
                    for(Team listTeam: robotTournament.getTeams()) //This loop will interate through the list of team objects and find the corressponding object.
                    {
                        if(listTeam.getTeamNumber()==teamNumber)
                            team = listTeam;
                    }
                    
                    robotTournament.addTeam(team);
                    break;
                    
                case 2:
                   System.out.println("\nWhat team would you like to edit?");
                   System.out.println("Please enter the team's number.");
                   int teamNum;
                   boolean teamFound = false;
                   while(!teamFound)
                   {
                        teamNum=input.nextInt();
                        for(Team teams: robotTournament.getTeams())
                        {
                            if(teams.getTeamNumber()==teamNum)
                            {
                                teams.openEditGUI();
                                teamFound=true;
                            }
                        }
                        if(!teamFound)
                        {
                            System.out.println("\nInvalid team number. Please enter a team number that exists.");
                        }
                   }
                   break;
                     
                case 3:
                   robotTournament.teamMemberModGUI();
                   break;
                    
                case 4:
                    team = new Team();
                    System.out.println("\nWhat team's robot would you like to turn on? Please enter a postive integer that is less than or equal to "+maxTeamNum);
                    teamNumber = input.nextInt();
                    
                    while(teamNumber<=0 || teamNumber>maxTeamNum) //This while loop will check to see if the number of teams in a valid integer.
                    {
                        System.out.println("\nInvalid team number, please enter a postive integer that is less than or equal to "+maxTeamNum);//Inform the user that the team number is invalid and prompt the user to input another team number.
                        teamNumber = input.nextInt();
                    }
                    
                    for(Team checkedInTeam : robotTournament.getTeams())
                    {
                        if(checkedInTeam.getTeamNumber()==teamNumber)
                            team = checkedInTeam;
                    }
                    
                    team.getRobotDescription().robotPower(team.getRobotDescription(), team);
                    break;
                    
                case 5:
                    team = new Team();
                    System.out.println("\nWhat team's robot would you like to take for a hardware inspection? Please enter a postive integer that is less than or equal to "+maxTeamNum);
                    teamNumber = input.nextInt();
                    
                    while(teamNumber<=0 || teamNumber>maxTeamNum) //This while loop will check to see if the number of teams in a valid integer.
                    {
                        System.out.println("\nInvalid team number, please enter a postive integer that is less than or equal to "+maxTeamNum);//Inform the user that the team number is invalid and prompt the user to input another team number.
                        teamNumber = input.nextInt();
                    }
                    
                    for(Team checkedInTeam : robotTournament.getTeams())
                    {
                        if(checkedInTeam.getTeamNumber()==teamNumber)
                            team = checkedInTeam;
                    }
                    
                    team.getRobotDescription().hardwareInspection(team.getRobotDescription(),robotTournament.getHardwareStations());
                    break;
                    
                case 6:
                    team = new Team();
                    System.out.println("\nWhat team's robot would you like to take for a software inspection? Please enter a postive integer that is less than or equal to "+maxTeamNum);
                    teamNumber = input.nextInt();
                    
                    while(teamNumber<=0 || teamNumber>maxTeamNum) //This while loop will check to see if the number of teams in a valid integer.
                    {
                        System.out.println("\nInvalid team number, please enter a postive integer that is less than or equal to "+maxTeamNum);//Inform the user that the team number is invalid and prompt the user to input another team number.
                        teamNumber = input.nextInt();
                    }
                    
                    for(Team checkedInTeam : robotTournament.getTeams())
                    {
                        if(checkedInTeam.getTeamNumber()==teamNumber)
                            team = checkedInTeam;
                    }
                    
                    team.getRobotDescription().softwareInspection(team.getRobotDescription(),robotTournament.getSoftwareStations());
                    break;
                    
                case 7:
                    team = new Team();
                    System.out.println("\nWhat team's robot would you like to take for a field test? Please enter a postive integer that is less than or equal to "+maxTeamNum);
                    teamNumber = input.nextInt();
                    
                    while(teamNumber<=0 || teamNumber>maxTeamNum) //This while loop will check to see if the number of teams in a valid integer.
                    {
                        System.out.println("\nInvalid team number, please enter a postive integer that is less than or equal to "+maxTeamNum);//Inform the user that the team number is invalid and prompt the user to input another team number.
                        teamNumber = input.nextInt();
                    }
                    
                    for(Team checkedInTeam : robotTournament.getTeams())
                    {
                        if(checkedInTeam.getTeamNumber()==teamNumber)
                            team = checkedInTeam;
                    }
                    
                    team.getRobotDescription().fieldTest(team.getRobotDescription(),robotTournament.getFieldTestingStations());
                    
                    if(team.getRobotDescription().getRobotStatus()==TournamentEnumeration.robotStatus.FIELD_TEST_PASSED)
                        team.setTeamStatus(TournamentEnumeration.teamGameStatus.PASSED_INSPECTION);
                    break;
                    
                case 8:
                    team = new Team();
                    System.out.println("\nWhat team will go to a judging station? Please enter a postive integer that is less than or equal to "+maxTeamNum);
                    teamNumber = input.nextInt();
                    
                    while(teamNumber<=0 || teamNumber>maxTeamNum) //This while loop will check to see if the number of teams in a valid integer.
                    {
                        System.out.println("\nInvalid team number, please enter a postive integer that is less than or equal to "+maxTeamNum);//Inform the user that the team number is invalid and prompt the user to input another team number.
                        teamNumber = input.nextInt();
                    }
                    
                    for(Team checkedInTeam : robotTournament.getTeams())
                    {
                        if(checkedInTeam.getTeamNumber()==teamNumber)
                            team = checkedInTeam;
                    }                    
                    team.goToJudging(robotTournament, team);
                    break;
                
                case 9:
                    team = new Team();
                    System.out.println("\nWhat team will go to the judging interview? Please enter a postive integer that is less than or equal to "+maxTeamNum);
                    teamNumber = input.nextInt();
                    
                    while(teamNumber<=0 || teamNumber>maxTeamNum) //This while loop will check to see if the number of teams in a valid integer.
                    {
                        System.out.println("\nInvalid team number, please enter a postive integer that is less than or equal to "+maxTeamNum);//Inform the user that the team number is invalid and prompt the user to input another team number.
                        teamNumber = input.nextInt();
                    }
                    
                    for(Team checkedInTeam : robotTournament.getTeams())
                    {
                        if(checkedInTeam.getTeamNumber()==teamNumber)
                            team = checkedInTeam;
                    }
                    
                    team.judgeInterview(team);
                    break;
                    
                case 10:
                    
                    /* This variable is used to determine if the tournament is ready
                    to generate matches. This will only be used within the else statement. */
                    
                   System.out.println("Unable to generate matches at this time.");
                   boolean matchGen = true; 
                    
                    // If there are no checked in teams, then matches cannont be generated.
                    if (robotTournament.getCheckedInTeams().isEmpty())
                    {
                        System.out.println("\nNo teams have checked in. Please check in teams to generate matches.");
                    }
                    
                    else
                    {
                        // This for loop will check to see if all the checked in teams have completed judging.
                        for(Team teams : robotTournament.getCheckedInTeams())
                        {
                            if(robotTournament.getTournamentStatus()!=TournamentEnumeration.tournamentStatus.INSPECTIONS || teams.getJudgingStatus()!=TournamentEnumeration.teamJudgingStatus.COMPLETED)
                                matchGen = false;
                        }
                        
                        // This statement will check to see if matches are ready to be generated
                        if(matchGen)
                        {
                            System.out.println("\n\nUnable to generate matches at this time.\n\n");
                            /*robotTournament.setTournamentStatus(TournamentEnumeration.tournamentStatus.MATCH_GENERATION);
                            System.out.println("\n The tournament status has been set to Match Generation. Now determining team eligibility and generating matches.");
                            System.out.println();
                            // This loop will determine if a team is eligible to play or not.
                            for(Team teams : robotTournament.getTeams())
                            {
                                if(teams.getTeamStatus()==TournamentEnumeration.teamGameStatus.PASSED_INSPECTION && teams.getJudgingStatus()==TournamentEnumeration.teamJudgingStatus.COMPLETED)
                                {   // This block of code will inform the user which teams are able to play.
                                    teams.setTeamStatus(TournamentEnumeration.teamGameStatus.ELIGIBLE);
                                    System.out.println("Team: "+teams.getTeamNumber()+" is now eligible to play.");
                                    robotTournament.getEligibleTeams().add(teams);
                                }
                                
                                else
                                { // This block of code will inform the user which teams are unable to play.
                                    teams.setTeamStatus(TournamentEnumeration.teamGameStatus.INELIGIBLE);
                                    System.out.println("Team: "+teams.getTeamNumber()+" is not able to play.");
                                }
                            }
                            
                            System.out.println("\n\nNow generating matches.");
                            
                            // This variable represents the number of matches that each team needs to play.
                            int numberOfMatchesPerTeam;
                            
                            if(robotTournament.getEligibleTeams().size()<25)
                                numberOfMatchesPerTeam=4;
                            
                            else
                                numberOfMatchesPerTeam=3;
                            
                            robotTournament.generateMatches(numberOfMatchesPerTeam);*/
                            
                           // System.out.println("\nThe matches have been generated. Please proceed to playing the matches.");
                        }
                        
                        else if(robotTournament.getTournamentStatus()==TournamentEnumeration.tournamentStatus.MATCH_GENERATION)
                            System.out.println("\nMatches have already been generated, please proceed to playing the mathces.");
                        
                        else if(robotTournament.getTournamentStatus()==TournamentEnumeration.tournamentStatus.MATCHES)
                            System.out.println("\nMatches have already been played through.");
                        
                        else
                        {
                            System.out.println("\nUnable to generate matches. Please make sure that all checked in teams have completed judging and the Tournament is currently doing inspections.");
                        }
                    }
                    break;
                    
                 case 11:
                     System.out.println("\n\nUnable to play matches at this time.\n\n");
                     /* This array will be used to store assigned point values.
                     If a point value is in this array, then it cannot be assigned to a team.
                     
                    int sizeOfEligibleTeams = robotTournament.getEligibleTeams().size();
                    int[] judgingRank = new int[sizeOfEligibleTeams];
                    /* If the matches have been generated, then the matches will begin.
                     For Lab #2, all scoring is randomly generated.
                    if(robotTournament.getTournamentStatus()==TournamentEnumeration.tournamentStatus.MATCH_GENERATION)
                    {
                        robotTournament.setTournamentStatus(TournamentEnumeration.tournamentStatus.MATCHES);
                        //System.out.println("\nThe matches have now started.");
                        
                        for(GameMatch match : robotTournament.getMatchesToBePlayed())
                        {
                           match.generationOfMatchResults();
                        }
                        
                        int i=0;
                         
                        // This loop will assign juding points to the team.
                        for(Team teams : robotTournament.getEligibleTeams())
                        {
                             // On the first interation, a valid number will always be assigned.
                            if(i==0)
                            {
                                teams.setJudgingPoints(-1,sizeOfEligibleTeams);
                                judgingRank[0]=teams.getJudgingPoints();
                                i+=1;
                            }
                            
                            /*On any other itereation, the values of the judgingRank array
                            must be checked in order for all teams to have unique values. 
                            else
                            {
                                int j=0;
                                teams.setJudgingPoints(-1,sizeOfEligibleTeams);
                                while(j<judgingRank.length)
                                {
                                    if(teams.getJudgingPoints()==judgingRank[i])
                                        {
                                            teams.setJudgingPoints(-1,sizeOfEligibleTeams);
                                            j=-1;
                                        }
                                      j+=1;
                                 }
                             }
                        }
                     System.out.println("\nMatches are now over. Tournament status has been set to awards.");
                     robotTournament.setTournamentStatus(TournamentEnumeration.tournamentStatus.AWARDS);
                     System.out.println("Go to display awards to see the final results.");
                    }
                    else if(robotTournament.getTournamentStatus()==TournamentEnumeration.tournamentStatus.MATCHES)
                    {
                        System.out.println("\nUnable to play matches. Matches have already been played.");
                    }
                    else
                    {
                        System.out.println("\nUnable to play matches. Please generate matches first.");
                    }*/
                    break;
                    
                     
                 case 12:
                     System.out.println("\n\n Unable to display awards at this time.\n\n");
                    //robotTournament.displayAwards();
                    break;
                     
                 case 13:
                    
                     boolean findPerson=true;
                    
                    /* This loop will display a menu in which the user can
                    determine the kind of person they want to find.*/
                    
                    while(findPerson)
                    {
                        System.out.println("\nPlease select one of the following options.\n");
                        System.out.println("1. Display information about a team's coach.");
                        System.out.println("2. Display information about a team's mentor.");
                        System.out.println("3. Display information about a team member.");
                        System.out.println("4. Display information about a tournament staff member.");
                        System.out.println("5. Display information about a vistor at the tournament.");
                        System.out.println("6. Go back to main menu.");
                        userInp=input.nextInt();
                        
                        switch(userInp)
                        {
                            case 1:
                                System.out.println("\nPlease enter the coach's email address. Please do NOT include any spaces.");
                                String email=input.next();
                                for(Team teams : robotTournament.getTeams())
                                {
                                    if(email.equalsIgnoreCase(teams.getCoach().geteMail()))
                                    {
                                        JOptionPane.showMessageDialog(null,teams.getCoach().toString(),"Coach",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }
                                findPerson=false;
                                break;
                                
                            case 2:
                                 System.out.println("\nPlease enter the mentor's email address. Please do NOT include any spaces.");
                                email=input.next();
                                for(Team teams : robotTournament.getTeams())
                                {
                                    if(email.equalsIgnoreCase(teams.getMentor().geteMail()))
                                    {
                                        JOptionPane.showMessageDialog(null,teams.getMentor().toString(),"Mentor",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }
                                findPerson=false;
                                break;
                                
                            case 3:
                                System.out.println("\nPlease enter the team member's email address. Please do NOT include any spaces.");
                                email=input.next();
                                
                                for(Team people : robotTournament.getTeams())
                                {
                                    for(Person persons : people.getTeamMembers())
                                    {
                                        if(email.equalsIgnoreCase(persons.geteMail()))
                                        {
                                            JOptionPane.showMessageDialog(null,persons.toString(),"Team Member",JOptionPane.PLAIN_MESSAGE);
                                        }
                                    }
                                }
                                findPerson=false;
                                break;
                                
                            case 4:
                                System.out.println("\nPlease enter the tournament staff member's email address. Please do NOT include any spaces.");
                                email=input.next();
                                for(Person persons : robotTournament.getTournamentStaff())
                                {
                                    if(email.equalsIgnoreCase(persons.geteMail()))
                                    {
                                        JOptionPane.showMessageDialog(null,persons.toString(),"Tournament Staff",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }
                                findPerson=false;
                                break;
                                
                            case 5:
                                System.out.println("\nPlease enter the visitor's email address. Please do NOT include any spaces.");
                                email=input.next();
                                for(Person persons : robotTournament.getVisitors())
                                {
                                    if(email.equalsIgnoreCase(persons.geteMail()))
                                    {
                                        JOptionPane.showMessageDialog(null,persons.toString(),"Visitor",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }
                                findPerson=false;
                                break;
                                
                            case 6:
                                System.out.println("\nNow going back to main menu.");
                                findPerson=false;
                                break;
                                
                            default:
                                System.out.println("\nInvalid input. Please try again.");
                                break;
                        }
                    }
                     
                    break;
                    
                case 14:
                    team = new Team();
                    System.out.println("\nWhat team's status would you like to see? Please enter a postive integer that is less than or equal to "+maxTeamNum);
                    teamNumber = input.nextInt();
                    
                    while(teamNumber<=0 || teamNumber>maxTeamNum) //This while loop will check to see if the number of teams in a valid integer.
                    {
                        System.out.println("\nInvalid team number, please enter a postive integer that is less than or equal to "+maxTeamNum);//Inform the user that the team number is invalid and prompt the user to input another team number.
                        teamNumber = input.nextInt();
                    }
                    
                    for(Team checkedInTeam : robotTournament.getTeams())
                    {
                        if(checkedInTeam.getTeamNumber()==teamNumber)
                            team = checkedInTeam;
                    }
                    
                    System.out.println("\n"+team);
                    break;
                    
                case 15:
                    
                    team = new Team();
                    
                    System.out.println("\nWhat is the robot's team number?");
                    teamNumber = input.nextInt();
                    
                    while(teamNumber<=0 || teamNumber>robotTournament.getMaxTeamNum()) //This while loop will check to see if the number of teams in a valid integer.
                    {
                        System.out.println("\nInvalid team number, please enter a postive integer and a valid team number.");//Inform the user that the team number is invalid and prompt the user to input another team number.
                        teamNumber = input.nextInt();
                    }
                    
                    for(Team listTeam: robotTournament.getTeams())
                    {
                        if(listTeam.getTeamNumber()==teamNumber)
                            team = listTeam;
                    }
                    
                    JOptionPane.showMessageDialog(null,team.getRobotDescription(),"Team "+team.getTeamNumber()+"'s Robot Desciption",JOptionPane.PLAIN_MESSAGE);
                    break;
                     
                case 16:
                    System.out.println("\n"+robotTournament);
                    break;
                    
                case 17: // If the user decides to quit, thank the user and end simulation.
                    System.out.println("\nThank you for using the Singh robot tournament simulation!");
                    System.out.println("\nNow displaying test data.\n\n");
                    tournamentStart = false;
                    break;
                    
                default: //This statement will execute if the user inputs an invalid menu choice.
                    System.out.println("Invalid input, please input one of the follwing menu options.");
                    break;    
            }
        }
        //Test Data starts here
       /* Team testRed1= new Team();
        Team testRed2= new Team();
        Team testBlue1= new Team();
        Team testBlue2= new Team();
        Team[] testAllianceRed = new Team[2];
        Team[] testAllianceBlue = new Team[2];
        testAllianceRed[0]=testRed1;
        testAllianceRed[1]=testRed2;
        testAllianceBlue[0]=testBlue1;
        testAllianceBlue[1]=testBlue2;
        GameMatch testMatch = new GameMatch(0,testAllianceRed,testAllianceBlue);
        testMatch.generationOfMatchResults();
        System.out.println(testMatch);
        for(Team team : testAllianceRed)
        {
            System.out.println("Qualifying and Ranking Points for red alliance: "+team.getQualifyingPoints()+" "+team.getRankingPoints());
        }
        for(Team team : testAllianceBlue)
        {
            System.out.println("Qualifying and Ranking Points for blue alliance: "+team.getQualifyingPoints()+" "+team.getRankingPoints());
        }
        System.out.println();
        testMatch.generationOfMatchResults();
        System.out.println(testMatch);
        for(Team team : testAllianceRed)
        {
            System.out.println("Qualifying and Ranking Points for red alliance: "+team.getQualifyingPoints()+" "+team.getRankingPoints());
        }
        for(Team team : testAllianceBlue)
        {
            System.out.println("Qualifying and Ranking Points for blue alliance: "+team.getQualifyingPoints()+" "+team.getRankingPoints());
        }
        System.out.println();
        
        Tournament testTournament1 = new Tournament(8);
        testTournament1.setTournamentStatus(TournamentEnumeration.tournamentStatus.AWARDS);
        testTournament1.assignJudgingPoints();
        testTournament1.displayAwards();
        Tournament testTournament2 = new Tournament(15);
        testTournament2.requiredNumberOfMatches(testTournament2.getEligibleTeams().size());*/
        
        //Test data for lab 4
        
        Tournament testTournament1 = new Tournament(8);
        testTournament1.setTournamentStatus(TournamentEnumeration.tournamentStatus.AWARDS);
        for(Team team : testTournament1.getEligibleTeams())
        {
            team.setRankingPoints();
            team.setQualifyingPoints();
        }
        testTournament1.assignJudgingPoints();
        testTournament1.displayAwards();
        Robot testRobot1 = new Robot();
        boolean[] testValues = {true,true,false,false,true,false,true,true};
        testRobot1.setRobotActions(testValues);
        System.out.println(testRobot1.displayActions());
        
        
        //CREATE NEW OBJECTS HERE
    } // Main Routine End
} // Main Class End
