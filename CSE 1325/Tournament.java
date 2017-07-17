/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: Objects from this class represent a tournament that is being played through. 
 */


package tournamenttest;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.util.Formatter;
import java.util.GregorianCalendar;
import javax.swing.JFrame;

public class Tournament //implements SafetyConcerns
{
    /**
     * This member gives the tournament name.
     */
    private String tournamentName;
    private PDate date;
    private String location;
    private int maxTeamNum;
    private ArrayList<Team> checkedInTeams = new ArrayList();
    private int hardwareStations;
    private int softwareStations;
    private int fieldTestingStations;
    private String[] gameFields; 
    private int judgingLocations;
    private TournamentEnumeration.tournamentStatus tournamentStatus;
    private String[] teamRankings;
    private ArrayList<Team> teams = new ArrayList();
    private ArrayList<Team> preRegisteredTeams = new ArrayList();
    private ArrayList<GameMatch> matchesToBePlayed = new ArrayList();
    private ArrayList<Integer> scores = new ArrayList();
    private int currentMatch;
    private ArrayList<Person> tournamentStaff = new ArrayList();
    private int numberOfVisitors;
    private ArrayList<Visitor> visitors = new ArrayList();
    private ArrayList<Team> eligibleTeams = new ArrayList();
    private ArrayList<SafetyViolation> violations = new ArrayList();
    private Formatter file;
    
    Scanner input = new Scanner(System.in);
    GregorianCalendar random=new GregorianCalendar();
    Random randSeed = new Random(random.getTimeInMillis());
    
    
  /* public Tournament(String tournamentName, int[] date, String location, int maxTeamNum, int[]checkedInTeams) //This constructor
    {
        this.tournamentName=tournamentName;
        
        this.date=date;
        
        this.location=location;
        
        if (maxTeamNum<=0) //This if statement will check to see if the maximum number of teams is a valid integer.
        {
            System.out.println("Invalid number of teams. Please enter a number greater than zero"); //Inform the user that the input is invalid.
            //Prompt user here
        }
        
        else
            this.maxTeamNum=maxTeamNum; //If the integer is valid, then assign to the object.
    } */
    
    
    public Tournament() //This constructor will run as soon as the program excutes. The purpose of this constructor is to initialize the data field for the tournament object.
    {
        System.out.println("Please enter the tournament's name. Please do NOT include spaces.");
        tournamentName = input.next();
        System.out.println("\nWhat is the first name of the tournament director? Please do NOT include spaces.");
        String firstName = new String(input.next());
        System.out.println("\nWhat is the last name of the tournament director? Please do NOT include spaces.");
        String lastName = new String(input.next());
        System.out.println("\nWhat is the email address of the tournament director? Please do NOT include spaces.");
        String eMail = new String(input.next());
        tournamentStaff.add(new TournamentDirector(firstName,lastName,eMail));
        System.out.println("\nWhat is the first name of the referee? Please do NOT include spaces.");
        firstName = new String(input.next());
        System.out.println("\nWhat is the last name of the referee? Please do NOT include spaces.");
        lastName = new String(input.next());
        System.out.println("\nWhat is the email address of the referee Please do NOT include spaces.");
        eMail = new String(input.next());
        tournamentStaff.add(new Referee(firstName,lastName,eMail));
        System.out.println("\nWhat month is the tournament in? Please enter an integer between 1 and 12.");
        int tempMonth = input.nextInt();
        System.out.println("\nWhat day is the tournament in? Please enter an integer between 1 and 30.");
        int tempDay = input.nextInt();
        System.out.println("\nWhat year is the tournament? Please enter a year after 2014");
        int tempYear = input.nextInt();
        date = new PDate(tempMonth,tempDay,tempYear);
        System.out.println("\nPlease enter what city the tournament is located in. Please do NOT include spaces."); //Prompt ths user for the location of the tournament.
        location = input.next();
        System.out.println("\nWhat was the maximum number of teams? NOTE: There is a minimum of 12 teams and a maximum of 36 teams."); //Prompt the user for the maximum number of teams.
        System.out.println("Please enter an integer between the minimum and maximum numbers.");
        setMaxTeamNum(input.nextInt());
        for(int i = 1; i<=maxTeamNum; i+=1)
        {
            teams.add(new Team(i,getMaxTeamNum()));
        }
        System.out.println("\nHow many hardware inspection stations are available? Please enter a positive integer."); //Prompt the user for the number of available hardware inspection stations.
        setHardwareStations(input.nextInt());
        for(int i=0;i<hardwareStations;i+=1)
        {
            System.out.println("\nWhat is the first name of the hardware inpector for station "+(i+1)+"? Please do NOT include spaces.");
            firstName = new String(input.next());
            System.out.println("\nWhat is the last name of the hardware inpector for station "+(i+1)+"? Please do NOT include spaces.");
            lastName = new String(input.next());
            System.out.println("\nWhat is the email address of the hardware inpector for station "+(i+1)+"? Please do NOT include spaces.");
            eMail = new String(input.next());
            tournamentStaff.add(new Inspector(TournamentEnumeration.inspections.HARDWARE,i+1,firstName,lastName,eMail));
        }
        System.out.println("\nHow many software inspection stations are available? Please enter a postive integer."); //Prompt the user for the number of available software inspection stations.
        setSoftwareStations(input.nextInt());
        for(int i=0;i<softwareStations;i+=1)
        {
            System.out.println("\nWhat is the first name of the software inpector for station "+(i+1)+"? Please do NOT include spaces.");
             firstName = new String(input.next());
            System.out.println("\nWhat is the last name of the software inpector for station "+(i+1)+"? Please do NOT include spaces.");
            lastName = new String(input.next());
            System.out.println("\nWhat is the email address of the software inpector for station "+(i+1)+"? Please do NOT include spaces.");
             eMail = new String(input.next());
            tournamentStaff.add(new Inspector(TournamentEnumeration.inspections.SOFTWARE,i+1,firstName,lastName,eMail));
        }
        System.out.println("\nHow many field testing locations are available? Please enter a positive integer."); //Prompt the user for the number of available field testing locations.
        setFieldTestingStations(input.nextInt());
        for(int i=0;i<fieldTestingStations;i+=1)
        {
            System.out.println("\nWhat is the first name of the field test inpector for station "+(i+1)+"? Please do NOT include spaces.");
            firstName = new String(input.next());
            System.out.println("\nWhat is the last name of the field test inpector for station "+(i+1)+"? Please do NOT include spaces.");
            lastName = new String(input.next());
            System.out.println("\nWhat is the email address of the field test inpector for station "+(i+1)+"? Please do NOT include spaces.");
            eMail = new String(input.next());
            tournamentStaff.add(new Inspector(TournamentEnumeration.inspections.FIELD_TEST,i+1,firstName,lastName,eMail));
        }
        System.out.println("\nHow many judging locations are available? Please enter a positive integer."); //Prompt the user for the number of available field testing locations.
        setJudgingLocations(input.nextInt());
        for(int i=0;i<judgingLocations;i+=1)
        {
            System.out.println("\nWhat is the first name of the judge for station "+(i+1)+"? Please do NOT include spaces.");
            firstName = new String(input.next());
            System.out.println("\nWhat is the last name of the judge for station "+(i+1)+"? Please do NOT include spaces.");
            lastName = new String(input.next());
            System.out.println("\nWhat is the email address of the judge for station "+(i+1)+"? Please do NOT include spaces.");
            eMail = new String(input.next());
            tournamentStaff.add(new Judge(true,firstName,lastName,eMail));
        }
        System.out.println("\nHow many visitors are expected to be at the tournament? Please enter a positive integer.");
        setNumberOfVisitors(input.nextInt());
        for(int i=0;i<numberOfVisitors;i+=1)
        {
            System.out.println("\nWhat is the first name of visitor "+(i+1)+"? Please do NOT include spaces.");
            firstName = new String(input.next());
            System.out.println("\nWhat is the last name of visitor "+(i+1)+"? Please do NOT include spaces.");
            lastName = new String(input.next());
            System.out.println("\nWhat is the email address of visitor "+(i+1)+"? Please do NOT include spaces.");
            eMail = new String(input.next());
            visitors.add(new Visitor(firstName,lastName,eMail));
            System.out.println("\nIs this visitor related to a team member? Please type in yes or no and press enter. Please do NOT include spaces.");
            visitors.get(i).setRelationToTeamMember(input.next());
            System.out.println("\nIs it this visitor's first time to a robot tournmanet? Please type in yes or no and press enter. Please do NOT include spaces.");
            visitors.get(i).setFirstTimeToTournament(input.next());
            System.out.println("\nIs this visitor a potential donor? Please type in yes or no and press enter. Please do NOT include spaces.");
            visitors.get(i).setPotentialDonor(input.next());
            System.out.println("\nIs this visitor a pontential vounteer? Please type in yes or no and press enter. Please do NOT include spaces.");
            visitors.get(i).setPotentialVolunteer(input.next());
        }
    }
    
    public Tournament(String name, PDate date, String location, int maxTeamNum, ArrayList<Team> checkIn, int hwLocs, int swLocs, int ftLocs, int judgeLocs, ArrayList<Person> staff)
    {
        setTournamentName(name);
        setDate(date);
        setLocation(location);
        setMaxTeamNum(maxTeamNum);
        setCheckedInTeams(checkIn);
        setHardwareStations(hwLocs);
        setSoftwareStations(swLocs);
        setFieldTestingStations(ftLocs);
        setJudgingLocations(judgeLocs);
        setTournamentStaff(staff);
        
    }
    
    public Tournament(int teamNum, int qualPoint1, int qualPoint2, int qualPoint3,int  qualPoint4,int  qualPoint5,int qualPoint6, int rankPoint1, int rankPoint2, int rankPoint3,int rankPoint4, int rankPoint5, int rankPoint6) // This constructor is used to demenostrate how a tournament handles incorrect qualifying points and ranking points with 6 teams.
    {
        System.out.println("\nTeam 1 Qualifying Points: "+qualPoint1+" Ranking Points: "+rankPoint1);
        System.out.println("\nTeam 2 Qualifying Points: "+qualPoint2+" Ranking Points: "+rankPoint2);
        System.out.println("\nTeam 3 Qualifying Points: "+qualPoint3+" Ranking Points: "+rankPoint3);
        System.out.println("\nTeam 4 Qualifying Points: "+qualPoint4+" Ranking Points: "+rankPoint4);
        System.out.println("\nTeam 5 Qualifying Points: "+qualPoint5+" Ranking Points: "+rankPoint5);
        System.out.println("\nTeam 6 Qualifying Points: "+qualPoint6+" Ranking Points: "+rankPoint6);
        int[] qualPoints = {qualPoint1,qualPoint2,qualPoint3,qualPoint4,qualPoint5,qualPoint6};
        int[] rankPoints = {rankPoint1,rankPoint2,rankPoint3,rankPoint4,rankPoint5,rankPoint6};
        System.out.println("\nThe new points are\n");
        for(int i=1;i<7;i+=1)
        {
            Team team = new Team(i,qualPoints[i-1],rankPoints[i-1]);
            System.out.println("\nTeam "+team.getTeamNumber()+" Qualifying Points: "+team.getQualifyingPoints()+" Ranking Points: "+team.getRankingPoints());
        }
        
    }
    
     public Tournament(int teamNum)// This construtor will demonstrate how the program handles teams signing in.
    {
   
        for(int i=1;i<=teamNum;i+=1)
        {
            eligibleTeams.add(new Team());
        }
        
        for(Team team: eligibleTeams)
        {
            team.setTeamNumber(randSeed.nextInt(101), teamNum);
        }
    } 
    
     public void assignJudgingPoints()
     {
         ArrayList<Integer> judgingRank = new ArrayList();
         int i=0;
         // This loop will assign juding points to the team.
            for (Team team : eligibleTeams) 
            {
                // On the first interation, a valid number will always be assigned.
                if (i == 0) 
                {
                    team.setJudgingPoints(-1, eligibleTeams.size());
                    judgingRank.add(team.getJudgingPoints());
                    i += 1;
                } /*On any other itereation, the values of the judgingRank array
                 must be checked in order for all teams to have unique values. */ 
                else 
                {
                    int j=0;
                    team.setJudgingPoints(-1, eligibleTeams.size());
                    while (j < judgingRank.size()) 
                    {
                        if (team.getJudgingPoints() == judgingRank.get(j)) 
                        {
                            team.setJudgingPoints(-1, eligibleTeams.size());
                            j = -1;
                        }
                        j += 1;
                    }
                    judgingRank.add(team.getJudgingPoints());
                }
            }
     }
    public void addTeam (Team aTeam) //This method will add a team number to the array of teams. 
    {
        boolean teamFound=false;
        
        for(Team team : checkedInTeams) // This while loop will check to see if the team has already checked in.
                {
                   if(aTeam.getTeamNumber()==team.getTeamNumber() && aTeam.getTeamNumber() != 0) //This if statement tests to see if the team has already checked in. 
                   {
                       teamFound=true;
                       System.out.println("Team "+team.getTeamNumber()+" has already checked in.");//Inform the user the team has already checked in.
                   }
                }
        if(!(teamFound))
        {
           checkedInTeams.add(aTeam);
           aTeam.setTeamStatus(TournamentEnumeration.teamGameStatus.PREPARING);
           aTeam.setJudgingStatus(TournamentEnumeration.teamJudgingStatus.BEFORE);
           System.out.println("\nTeam "+aTeam.getTeamNumber()+" has been signed in.");
        }
    }

    public void eligibility(Team team) // This method will notify the user if a team is ready to play.
    {
        if (team.getTeamStatus()!=TournamentEnumeration.teamGameStatus.PASSED_INSPECTION) // If a team has not passed inspection, notify the user that the team in not ready to play.
           System.out.println("Team number "+team.getTeamNumber()+ "is not ready to play.");
    }
    
    public void displayAwards()
    {
        if(this.tournamentStatus==TournamentEnumeration.tournamentStatus.AWARDS)
        {
            int i=1;

            System.out.println("\nMatches are now over. Awards are now being assigned.");
            System.out.println("\nTournament Status set to Awards.");
            //System.out.println("Please end simulation");

            System.out.println("\nTop 8 teams ranked by Judging Points\n");

            while(i<=8)
            {
                int j=0;
                while(j<eligibleTeams.size())
                {
                    if(eligibleTeams.get(j).getJudgingPoints()==i)
                        System.out.println(i+". Team "+eligibleTeams.get(j).getTeamNumber()+"\tJudging Points: "+eligibleTeams.get(j).getJudgingPoints());
                    j+=1;
                }
                i+=1;
            }
            
            System.out.println("\n\nRanked by Qualifying and Ranking Points\n");
            
            // First teams will be sorted according to qualifying points.
            
            // This array is easier for me to do sorting versus an ArrayList
            Team[] orderedTeams= new Team[eligibleTeams.size()];
            
            i=0;
            
            for(Team teams : eligibleTeams)
            {
                orderedTeams[i]=teams;
                i+=1;
            }
            
            i=1;
            
            /* This loop will sort the array to having the team
            with the largest qualifying points as its first index.
            while(i<orderedTeams.length)*/
            {
                if(orderedTeams[i].getQualifyingPoints()>orderedTeams[i-1].getQualifyingPoints())
                {
                    Team temp = orderedTeams[i-1];
                    orderedTeams[i-1]=orderedTeams[i];
                    orderedTeams[i]=temp;
                    i=0;
                }
                i+=1;
            }
           
            /* Now this loop will arrange the teams according to ranking points
            with the priority of the qualifying points in mind.*/
            
            i=1;
            while(i<orderedTeams.length)
            {
                 if(orderedTeams[i].getQualifyingPoints()==orderedTeams[i-1].getQualifyingPoints())
                 {
                     if(orderedTeams[i].getRankingPoints()>orderedTeams[i-1].getRankingPoints())
                     {
                        Team temp = orderedTeams[i-1];
                        orderedTeams[i-1]=orderedTeams[i];
                        orderedTeams[i]=temp;
                        i=0;
                     }
                 }
                 i+=1;
            }
            
            // Now that the array is properly organized, print the ordering to the user.
            
           i=0;
           
           while(i<orderedTeams.length)
           {
               System.out.println((i+1)+". Team "+orderedTeams[i].getTeamNumber()+" Qualifying Points: "+orderedTeams[i].getRankingPoints()+" Ranking Points: "+orderedTeams[i].getRankingPoints());
               i+=1;
           }
           
           //Now the team standings will be written to a file.
           if(writeStandings())
           {
               i=0;
               while(i<orderedTeams.length)
               {
                   file.format("Team: %d Qualifying Points: %d Ranking Points: %d",orderedTeams[i].getTeamNumber(),orderedTeams[i].getQualifyingPoints(),orderedTeams[i].getRankingPoints());
                   file.format("\n");
                   i+=1;
               }
               System.out.println("\nTeam standings have successfully been written to a file.\n");
               file.close();
           }
        }
        else
        {
            System.out.println("Unable to display awards. Please make sure that all matches have been played through.");
        } 
    }
    
    public boolean writeStandings()
    {
        try
        {
            file = new Formatter("standings.txt");
        }
        catch(Exception e)
        {
            System.out.println("\nCannot write team standings, file was not found.");
            return false;
        }
        
        return true;
    }
    
    // This method will generate matches based on eligible teams.
    public void generateMatches(int maxNumberOfMatches)
    {
        System.out.println("\n\nUnable to generate matches, please select a different option.\n\n");
      /*  for(int i=1;matchRequirement(maxNumberOfMatches,eligibleTeams);)
        {
            /* On the first iteration, all teams will be assigned a color 
            and the first match object will be intialized
            
            if(i==1)
            {
                int sizeOfList=eligibleTeams.size();
                int j=1;
                
                //If the teams are even set half red and half blue.
                if(sizeOfList%2==0)
                {
                    for(Team team : eligibleTeams)
                    {
                        if(j<=(sizeOfList/2))
                        {
                            team.setColor(TournamentEnumeration.teamColor.RED);
                            j+=1;
                        }
                        
                        else
                        {
                            team.setColor(TournamentEnumeration.teamColor.BLUE);
                        }
                    }
                }
                
                else
                {
                    for(Team team : eligibleTeams)
                    {
                        if(j<=(sizeOfList/2)+1)
                        {
                            team.setColor(TournamentEnumeration.teamColor.RED);
                            j+=1;
                        }
                        
                        else
                        {
                            team.setColor(TournamentEnumeration.teamColor.BLUE);
                        }
                    }
                }
                
               Team[] redTeam = new Team[2];
               Team[] blueTeam = new Team[2];
               boolean teamFound = true;
               
               while(teamFound)
               {
                   System.out.println("Loop1");
                   Team possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                   
                   if(possibleTeam.getColor()==TournamentEnumeration.teamColor.RED)
                   {
                       redTeam[0]=possibleTeam;
                       teamFound=false;
                   }
               }
               
               teamFound=true;
               
               while(teamFound)
               {
                   System.out.println("Loop2");
                   Team possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                   
                   if(possibleTeam.getColor()==TournamentEnumeration.teamColor.RED && possibleTeam!=redTeam[0])
                   {
                       redTeam[1]=possibleTeam;
                       teamFound=false;
                   }
               }
               
               teamFound=true;
               
               while(teamFound)
               {
                   System.out.println("Loop3");
                   Team possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                   
                   if(possibleTeam.getColor()==TournamentEnumeration.teamColor.BLUE)
                   {
                       blueTeam[0]=possibleTeam;
                       teamFound=false;
                   }
               }
               
               teamFound=true;
               
               while(teamFound)
               {
                   System.out.println("Loop4");
                   Team possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                   
                   if(possibleTeam.getColor()==TournamentEnumeration.teamColor.BLUE && possibleTeam!=blueTeam[0])
                   {
                       blueTeam[1]=possibleTeam;
                       teamFound=false;
                   }
               }
               
               matchesToBePlayed.add(new GameMatch(i,redTeam,blueTeam));
               i+=1;
            } 
           
            //The following logic will be used for any other match that is not the first match.
            else
            {
               Team[] redTeam = new Team[2];
               Team[] blueTeam = new Team[2];
               boolean teamFound = true;
               int sizeOfList=eligibleTeams.size();
               
               Team possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));;
               
               while(teamFound)
               {
                   possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                   
                   System.out.println("Loop5");
                   if(/*possibleTeam.getColor()==TournamentEnumeration.teamColor.BLUE && possibleTeam.getGamesToBePlayed().size()!=3)
                   {
                       possibleTeam.setColor(TournamentEnumeration.teamColor.RED);

                       // This loop will check to see if the team has not played in a previous match.
                       boolean goodTeamFound=true;
                       for(Team team: matchesToBePlayed.get(i-2).getRedAlliance())
                       {
                           System.out.println("Loop6");
                           if (possibleTeam==team)
                           {
                               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                               goodTeamFound=false;
                           }
                       }
                       
                       for(Team team: matchesToBePlayed.get(i-2).getBlueAlliance())
                       {
                           System.out.println("Loop7");
                           if (possibleTeam==team)
                           {
                               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                               goodTeamFound=false;
                           }
                       }
                       
                       if(goodTeamFound)
                           teamFound=false;
                   }
               }
               
               redTeam[0]=possibleTeam;
               
               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
               teamFound=true;
               
               while(teamFound)
               {
                   possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                   System.out.println("Loop8");
                   if(/*possibleTeam.getColor()==TournamentEnumeration.teamColor.BLUE && possibleTeam.getGamesToBePlayed().size()!=3)
                   {
                       possibleTeam.setColor(TournamentEnumeration.teamColor.RED);

                       // This loop will check to see if the team has not played in a previous match.
                       boolean check1=true;
                       for(Team team: matchesToBePlayed.get(i-2).getRedAlliance())
                       {
                           System.out.println("Loop9");
                           if (possibleTeam==team)
                           {
                               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                               check1=false;
                           }
                       }
                       
                       for(Team team: matchesToBePlayed.get(i-2).getBlueAlliance())
                       {
                           System.out.println("Loop10");
                           if (possibleTeam==team)
                           {
                               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                               check1=false;
                           }
                       }
                       
                       boolean check2=true;
                       if(check1)
                       {
                           teamFound=false;
                           /*for(GameMatch game : matchesToBePlayed)
                           {
                               System.out.println("Loop11");
                               for(Team team : game.getRedAlliance())
                               {
                                   System.out.println("Loop12");
                                   if(redTeam[0]==team)
                                   {
                                        possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));  
                                        check2=false;
                                   }
                               }
                           }
                       }
                       
                       /*if(check2)
                           teamFound=false;
                           
                   }
               }
               
               redTeam[1]=possibleTeam;
               
               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
               teamFound=true;
               
               while(teamFound)
               {
                   possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                   System.out.println("Loop13");
                   if(/*possibleTeam.getColor()==TournamentEnumeration.teamColor.RED && possibleTeam.getGamesToBePlayed().size()!=3)
                   {
                       possibleTeam.setColor(TournamentEnumeration.teamColor.BLUE);

                       // This loop will check to see if the team has not played in a previous match.
                       boolean goodTeamFound=true;
                       for(Team team: matchesToBePlayed.get(i-2).getRedAlliance())
                       {
                           System.out.println("Loop14");
                           if (possibleTeam==team)
                           {
                               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                               goodTeamFound=false;
                           }
                       }
                       
                       for(Team team: matchesToBePlayed.get(i-2).getBlueAlliance())
                       {
                           System.out.println("Loop15");
                           if (possibleTeam==team)
                           {
                               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                               goodTeamFound=false;
                           }
                       }
                       
                       if(goodTeamFound)
                           teamFound=false;
                   }
               }
               
               blueTeam[0]=possibleTeam;
               
               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
               teamFound=true;
               
               while(teamFound)
               {
                   possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                   System.out.println("Loop16");
                   if(/*possibleTeam.getColor()==TournamentEnumeration.teamColor.RED && possibleTeam.getGamesToBePlayed().size()!=3)
                   {
                       possibleTeam.setColor(TournamentEnumeration.teamColor.BLUE);

                       // This loop will check to see if the team has not played in a previous match.
                       boolean check1=true;
                       for(Team team: matchesToBePlayed.get(i-2).getRedAlliance())
                       {
                           System.out.println("Loop17");
                           if (possibleTeam==team)
                           {
                               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                               check1=false;
                           }
                       }
                       
                       for(Team team: matchesToBePlayed.get(i-2).getBlueAlliance())
                       {
                           System.out.println("Loop18");
                           if (possibleTeam==team)
                           {
                               possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));
                               check1=false;
                           }
                       }
                       
                      // boolean check2=true;
                       if(check1)
                       {
                           teamFound=false;
                       
                           /*for(GameMatch game : matchesToBePlayed)
                           {
                               System.out.println("Loop19");
                               for(Team team : game.getBlueAlliance())
                               {
                                   System.out.println("Loop20");
                                   if(blueTeam[0]==team)
                                   {
                                        possibleTeam=eligibleTeams.get((randSeed.nextInt(sizeOfList)));  
                                        check2=false;
                                   }
                               }
                           }
                       }
                       
                       /*if(check2)
                           teamFound=false;
                           
                   }
               }
               
               blueTeam[1]=possibleTeam;
               
               matchesToBePlayed.add(new GameMatch(i,redTeam,blueTeam));
               i+=1;
               System.out.println(i);
            }
        }*/
    }
    
    // This method will determine if all the teams have at least been assigned to the correct number of matches.
    public boolean matchRequirement(int maxNumberOfMatches, ArrayList<Team> teams)
    {
        for(Team team : teams)
        {
            if(team.getGamesToBePlayed().size()!=maxNumberOfMatches)
                return true;
        }
        
        return false;
    }
    
    public int requiredNumberOfMatches(int numOfTeams)
    {
        if(numOfTeams>=12 && numOfTeams<=24)
        {
            System.out.println("\nEach team must play 4 matches.\n\n");
            return 4;
        }
        
        else if(numOfTeams>24)
        {
            System.out.println("\nEach team must play 3 matches.\n\n");
            return 3;
        }
        
        else
        {
           System.out.println("\nEach team must play 5 matches.\n\n");
           return 5;
        }
            
    }
    
    public void teamMemberModGUI()
    {
        TeamMemberModifyFrame frame = new TeamMemberModifyFrame(teams);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,300);
        frame.setVisible(true);
        /*for(Team team: teams)
        {
            if(team.getTeamNumber()==frame.getTeam().getTeamNumber())
            {
                for(TeamMember member:team.getTeamMembers())
                    if(member.getTeamNumber()==frame.getTeamMember().getTeamNumber())
                    {
                        member.setExperience(frame.getTeamMember().getExperience());
                        System.out.println(member.getExperience());
                    }
            }
        }*/
    }

    public String getTournamentName() //This method will allow access to Tournament name member. 
    {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) //This method will mutate the Tournament name member, 
    {
        this.tournamentName = tournamentName;
    }

    public String getLocation() // This method will allow access to the Location member.
    {
        return location;
    }

    public void setLocation(String location) // This method will mutate data for the Location member.
    {
        this.location = location;
    }

    public int getMaxTeamNum() // This method will allow access to the Maximum Team Number member.
    {
        return maxTeamNum;
    }

    public void setMaxTeamNum(int maxTeamNum) //This method will mutate and error check the Maximum Team Number mmeber. 
    {
        while(maxTeamNum<12 || maxTeamNum>36) //This loop will execute as long as the input is invalid.
        {
            System.out.println("\nInvalid number of teams, please input an integer between 12 and 36.");
            maxTeamNum = input.nextInt();
        }
        this.maxTeamNum = maxTeamNum;
    }

    public ArrayList<Team> getCheckedInTeams() // This method will allow access to the Checked in Teams member. 
    {
        return checkedInTeams;
    }

    public void setCheckedInTeams(ArrayList<Team> checkedInTeams) // This method will mutate and error check the Checked in Teams member. 
    {
        
        this.checkedInTeams = checkedInTeams;
    }

    public int getHardwareStations() {
        return hardwareStations;
    }

    public void setHardwareStations(int hardwareStations) //This method will mutate and error check the number of hardware stations.
    {
        while(hardwareStations<1) //This loop will exectute if the user input is invalid.
        {
            System.out.println("Invalid number of hardware stations, please input an integer greater than one.");
            hardwareStations = input.nextInt();
        }
        this.hardwareStations = hardwareStations;
    }

    public int getSoftwareStations() // This method will allow access to the Software Stations member.
    {
        return softwareStations;
    }

    public void setSoftwareStations(int softwareStations) //This method will mutate and error check the number of software stations.
    {
        while(softwareStations<1) //This loop will exectute if the user input is invalid.
        {
            System.out.println("Invalid number of software stations, please input an integer greater than one.");
           softwareStations = input.nextInt();
        }
        this.softwareStations = softwareStations;
    }

    public int getFieldTestingStations() //This method will mutate and error check the number of field testing stations.
    {
        return fieldTestingStations;
    }

    public void setFieldTestingStations(int fieldTestingStations) 
    {
        while(fieldTestingStations<1) //This loop will exectute if the user input is invalid.
        {
            System.out.println("Invalid number of field testing stations, please input an integer greater than one.");
            fieldTestingStations = input.nextInt();
        }
        this.fieldTestingStations = fieldTestingStations;
    }

    public String[] getGameFields() // This method will allow access to the Gamefields member. 
    {
        return gameFields;
    }

    public void setGameFields(String[] gameFields) // This method will mutate data for the Gamefields member. 
    {
        this.gameFields = gameFields;
    }

    public int getJudgingLocations() // This method will allow access to the Judging locations member.
    {
        return judgingLocations;
    }

    public void setJudgingLocations(int judgingLocations) // This method will mutate and error check for the Judging locations member.
    {
          while(judgingLocations<1) //This loop will exectute if the user input is invalid.
        {
            System.out.println("Invalid number of judging locations, please input an integer greater than one.");
            judgingLocations = input.nextInt();
        }
          
        this.judgingLocations = judgingLocations;
    }

    public TournamentEnumeration.tournamentStatus getTournamentStatus() // This method will allow access to the tournament status member. 
    {
        return tournamentStatus;
    }

    public void setTournamentStatus(TournamentEnumeration.tournamentStatus tournamentStatus) // This method will mutate and error check the tournament status member. 
    {
        boolean found = false;
        
        if(tournamentStatus==TournamentEnumeration.tournamentStatus.AWARDS)
            found = true;
            
        else if(tournamentStatus==TournamentEnumeration.tournamentStatus.INSPECTIONS)
            found = true;
                
        else if(tournamentStatus==TournamentEnumeration.tournamentStatus.MATCHES)
            found = true;
            
        else if(tournamentStatus==TournamentEnumeration.tournamentStatus.MATCH_GENERATION)
            found = true;
        
        if (found) // If the parameter is found, then assign the status to the tournament object.
        {
            this.tournamentStatus = tournamentStatus;
        }
    }

    public String[] getTeamRankings() // This method will allow access to the Team Rankings member.
    {
        return teamRankings;
    }

    public void setTeamRankings(String[] teamRankings) // This method will muate data for the Team Rankings member. 
    {
        this.teamRankings = teamRankings;
    }

    public PDate getDate() // This method will allow access to the date member.
    {
        return date;
    }

    public void setDate(PDate date) //This method will mutate and error check the date member.
    {
        this.date = date;
    }

    public ArrayList<Team> getTeams() // This method will allow access to the Teams member.
    {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) // This method will mutate the Teams member.
    {
        this.teams = teams;
    }

    // This method will allow access to the preregisted teams list.
    public ArrayList<Team> getPreRegisteredTeams() 
    {
        return preRegisteredTeams;
    }

    // This method will simply assign a list of preregisted teams to a tournament object.
    public void setPreRegisteredTeams(ArrayList<Team> preRegisteredTeams) 
    {
        this.preRegisteredTeams = preRegisteredTeams;
    }
    
    // This method will do attempt to read in preregistered teams from a file.
    public void setPreRegisteredTeams()
    {
        // You need to write this code!!!
    }
    
    // This method will allow access to the list of matches.
    public ArrayList<GameMatch> getMatchesToBePlayed() 
    {
        return matchesToBePlayed;
    }

    // This method will mutate the list of game mathces.
    public void setMatchesToBePlayed(ArrayList<GameMatch> matchesToBePlayed) 
    {
        this.matchesToBePlayed = matchesToBePlayed;
    }

    // This method will allow access to the list of scores.
    public  ArrayList<Integer> getScores() 
    {
        return scores;
    }

    // This method will mutate the list of scores.
    public void setScores(ArrayList<Integer> scores) 
    {
        this.scores = scores;
    }

    // This method will allow access to the current match number.
    public int getCurrentMatch() 
    {
        return currentMatch;
    }

    /* This method will mutate the current match number. No error checking
    will be needed because the match number will be properly set by a loop
    counter variable. */
    public void setCurrentMatch(int currentMatch) 
    {
        this.currentMatch = currentMatch;
    }

    // This method will allow access to the list of staff members.
    public ArrayList<Person> getTournamentStaff() 
    {
        return tournamentStaff;
    }

    // This method will set the list of staff members.
    public void setTournamentStaff(ArrayList<Person> tournamentStaff) 
    {
        this.tournamentStaff = tournamentStaff;
    }
    
    // Standard get method.
    public int getNumberOfVistors() 
    {
        return numberOfVisitors;
    }

    // This method will mutate and error check the number of visitors.
    public void setNumberOfVisitors(int numberOfVisitors) 
    {
        while(numberOfVisitors<1)
        {
            System.out.println("\nInvalid number of visitors. Please enter an integer greater than 0.");
            this.numberOfVisitors=input.nextInt();
        }
        this.numberOfVisitors = numberOfVisitors;
    }

    // Standard get method.
    public ArrayList<Visitor> getVisitors()
    {
        return visitors;
    }

    // Standard set method.
    public void setVisitors(ArrayList<Visitor> visitors)
    {
        this.visitors = visitors;
    }

    // Standard get method.
    public ArrayList<Team> getEligibleTeams() 
    {
        return eligibleTeams;
    }

    // Standard set method.
    public void setEligibleTeams(ArrayList<Team> eligibleTeams) 
    {
        this.eligibleTeams = eligibleTeams;
    }

    // Standard get method.
    public  ArrayList<SafetyViolation> getViolation() 
    {
        return this.violations;
    }

    // Standard set method.
    public void setViolations(ArrayList<SafetyViolation> violations) 
    {
        this.violations = violations;
    }
    
    @Override
    public String toString() 
    {
        return "\nTournament name: " + tournamentName +"\nDate: " +date+ "\nLocation: " + location + "\nThe number of signed in teams are: " + checkedInTeams.size() + "\nStatus of Tournament: " + tournamentStatus;
    }
   }