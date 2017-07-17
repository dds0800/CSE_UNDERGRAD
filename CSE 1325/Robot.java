/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class contains general information of a team's robot.
 */

package tournamenttest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.GregorianCalendar;

public class Robot //implements SafetyConcerns
{
    private int teamNumber;
    private String robotName;
    private TournamentEnumeration.robotStatus robotStatus;
    private int[] vistedStations = new int[3];
    private int height;
    private int width;
    private int depth;
    private boolean[] robotActions = new boolean[8];
    private ArrayList<SafetyViolation> violations = new ArrayList();
    
    GregorianCalendar random = new GregorianCalendar();
    Random randSeed = new Random(random.getTimeInMillis());
    
    Scanner input = new Scanner(System.in);
    
    public Robot() //This method will create a dummy robot.
    {
        int teamNumber=0;
        for(int i=0;i<8;i+=1)
        {
            this.robotActions[i]=false;
        }
    }
    
    public Robot(int teamNumber) // This constructor will create a Robot object whenever a team has been created.
    {
        this.teamNumber = teamNumber;
        robotStatus = TournamentEnumeration.robotStatus.OFF;
        System.out.println("\nPlease enter the Robot's name for Team "+this.teamNumber+". Please do NOT include spaces.");
        robotName = input.next();
        System.out.println("\nWhat is the Robot's height in inches? Please enter a postive integer.");
        height = input.nextInt();
        setHeight(height);
        System.out.println("\nWhat is the Robot's width in inches? Please enter a postive integer.");
        width = input.nextInt();
        setWidth(width);
        System.out.println("\nWhat is the Robot's depth in inches? Please enter a postive integer.");
        depth = input.nextInt();
        setDepth(depth);
        for(int i=0;i<8;i+=1)
        {
            this.robotActions[i]=false;
        }
    }
    
    public Robot(int aHeight,int aWidth,int aDepth) // This constructor is used to test input data in the main method.
    {
        setHeight(aHeight);
        setWidth(aWidth);
        setDepth(aDepth);
        System.out.println("\nThe height width and depth respectively in inches is: "+this.height+" "+this.width+" "+this.depth+"\n");
    }
    
    public String displayActions()
    {
        String actions= new String("Actions Include: ");
        
        if(this.robotActions[0]==true)
            actions+="Autonomous Forward Motion ";
        
        if(this.robotActions[1]==true)
            actions+="Autonomous Object Pickup  ";
        
        if(this.robotActions[2]==true)
            actions+="Autonomous Scoring ";
        
        if(this.robotActions[3]==true)
            actions+="Tele-op object scoop/pick up ";
        
        if(this.robotActions[4]==true)
            actions+="Tele-op object hold ";
        
        if(this.robotActions[5]==true)
            actions+="tele-op object drop/release ";
        
        if(this.robotActions[6]==true)
            actions+="Tele-op robot scoring movement ";
        
        if(this.robotActions[7]==true)
            actions+="Tele-op game unit scoring ";
        
        
        return actions;
    }
    
    public void hardwareInspection(Robot readyBot, int maxHardwareStations) // This method will simulate the robot recieving a hardware inspection.
    {
        int inspectionRating;
        
        if(readyBot.robotStatus==TournamentEnumeration.robotStatus.READY) // If the robot is ready for hardware inspection, then commence the inspection.
        {
            readyBot.vistedStations[0]=(randSeed.nextInt(maxHardwareStations))+1; // Store the station at which the robot was at.
            inspectionRating = (randSeed.nextInt(9))+1;
            
            if(inspectionRating>=0 && inspectionRating<4) // If the robot failed inpsection, inform the user that the robot has failed and try agian.
            {
                System.out.println("\nThe robot has failed the hardware inspection. Please fix your robot and try the hardware inpsection again.");
            }
            
            else // If the robot passed change status to inspection pass,
            {
                System.out.println("\nThe robot has passed the hardware inpection. Please continue to the software inspection.");
                readyBot.robotStatus = TournamentEnumeration.robotStatus.HW_ISP_PASSED;
            }
            
            System.out.println("\nThe robot was inpected at station "+readyBot.vistedStations[0]); // Inform the user what station the robot was at.
        }
        
        else if(readyBot.robotStatus==TournamentEnumeration.robotStatus.OFF) //This means that the robot has already passed inspection.
        {
            System.out.println("\nPlease turn this robot on for the hardware inspection.");
        }
        
        else
            System.out.println("\nThis robot has already passed hardware inpection.");   
    }
    
    public void softwareInspection(Robot readyBot, int maxSoftwareStations) // This method will simulate a software insepction.
    {
        int inspectionRating;
        
        if(readyBot.robotStatus==TournamentEnumeration.robotStatus.HW_ISP_PASSED) // If the robot is ready for software inspection, then commence the inspection.
        {
            readyBot.vistedStations[1]=randSeed.nextInt(maxSoftwareStations)+1; // Store the station at which the robot was at.
            inspectionRating = randSeed.nextInt(9)+1;
            
            if(inspectionRating>0 && inspectionRating<6) // If the robot failed inpsection, inform the user that the robot has failed and try agian.
            {
                System.out.println("\nThe robot has failed the software inspection. Please fix your robot's code and try the software inpsection again.");
            }
            
            else // If the robot passed change status to inspection pass,
            {
                System.out.println("\nThe robot has passed the software inpection. Please continue to Field Testing.");
                readyBot.robotStatus = TournamentEnumeration.robotStatus.SW_ISP_PASSED;
            }
            
            System.out.println("\nThe robot was inpected at station "+readyBot.vistedStations[1]); // Inform the user what station the robot was at.
        }
        
        else if(readyBot.robotStatus==TournamentEnumeration.robotStatus.OFF) 
            System.out.println("\nPlease turn this robot on and go to hardware inspection.");
        
        else if(readyBot.robotStatus==TournamentEnumeration.robotStatus.READY) 
            System.out.println("\nPlease take this robot to hardware inspection.");

        else
            System.out.println("\nThis robot has already passed software inpection.");//This means that the robot has already passed inspection.   
    }
    
    public void fieldTest(Robot readyBot, int maxFieldLocs) // This method will simulate a Field Test
    {
        int inspectionRating;
        
        if(readyBot.robotStatus==TournamentEnumeration.robotStatus.SW_ISP_PASSED) // If the robot is ready for software inspection, then commence the inspection.
        {
            readyBot.vistedStations[2]=randSeed.nextInt(maxFieldLocs)+1; // Store the station at which the robot was at.
            inspectionRating = randSeed.nextInt(9)+1;
            
            if(inspectionRating>0 && inspectionRating<5) // If the robot failed inpsection, inform the user that the robot has failed and try agian.
            {
                System.out.println("\nThe robot has failed the Field Test. Please fix your robot's code and try the software inpsection again.");
            }
            
            else // If the robot passed change status to inspection pass,
            {
                System.out.println("\nThe robot has passed the Field Test.");
                readyBot.robotStatus = TournamentEnumeration.robotStatus.FIELD_TEST_PASSED;
                System.out.println("\nYThis team's robot has now passed all required inspections. Please proceed to judging.");
            }
            
            System.out.println("\nThe robot was inpected at station "+readyBot.vistedStations[2]); // Inform the user what station the robot was at.
        }
        
        else if(readyBot.robotStatus==TournamentEnumeration.robotStatus.OFF) 
            System.out.println("\nPlease turn this robot on and go to hardware inspection.");
        
        else if(readyBot.robotStatus==TournamentEnumeration.robotStatus.READY) 
            System.out.println("\nPlease take this robot to hardware inspection.");
        
        else if(readyBot.robotStatus==TournamentEnumeration.robotStatus.HW_ISP_PASSED)
        {
            System.out.println("This robot has already passed hardware inspection, but has not passed software inspection");
            System.out.println("Please take this robot to software inspection.");
        }
        
        else
            System.out.println("\nThis robot has already passed the field test. Please proceed to judging.");//This means that the robot has already passed inspection.
    }
    
    public void robotPower(Robot powerBot, Team team)
    {
        if(powerBot.getRobotStatus()==TournamentEnumeration.robotStatus.OFF && team.getTeamStatus()==TournamentEnumeration.teamGameStatus.PREPARING)
        {
            powerBot.setRobotStatus(TournamentEnumeration.robotStatus.READY);
            System.out.println("\nTeam "+powerBot.getTeamNumber()+"'s robot is now on and ready for inpsections.");
        }
        
        else if(team.getTeamStatus()!=TournamentEnumeration.teamGameStatus.PREPARING || powerBot.getRobotStatus()!=TournamentEnumeration.robotStatus.OFF)
            System.out.println("\nUnable to complete this action. Please make sure this team has signed in and the robot is turned off.");
    }

    public int getTeamNumber() // This method allows access to the Team Number member.
    {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber, int maxTeamNum) // This method mutate and error check the Team Number member. 
    {
        while(teamNumber<1 || teamNumber> maxTeamNum) // This loop will execute if the user input is invalid
        {
            System.out.println("\nInvalid team number. Please input a number greater than 1 or less than"+maxTeamNum+".");
            teamNumber = input.nextInt();
        }
        this.teamNumber = teamNumber;
    }

    public String getRobotName() // This method will allow access to the Robot Name.
    {
        return robotName;
    }

    public void setRobotName(String robotName) // This method will mutate the Robot Name member. 
    {
        this.robotName = robotName;
    }

    public TournamentEnumeration.robotStatus getRobotStatus() // This method will allow access to the Robot Status member, 
    {
        return robotStatus;
    }

    public void setRobotStatus(TournamentEnumeration.robotStatus robotStatus) // This method will mutate and error check the Robot Status member.
    {
        boolean found = false;
        
        if(robotStatus==TournamentEnumeration.robotStatus.FIELD_TEST_PASSED)
            found = true;
            
        else if(robotStatus==TournamentEnumeration.robotStatus.HW_ISP_PASSED)
            found = true;
                
        else if(robotStatus==TournamentEnumeration.robotStatus.OFF)
            found = true;
            
        else if(robotStatus==TournamentEnumeration.robotStatus.READY)
            found = true;
        
        else if(robotStatus==TournamentEnumeration.robotStatus.SW_ISP_PASSED)
            found = true;
        
        if (found) // If the parameter is found, then assign the status to the robot object.
        {
            this.robotStatus = robotStatus;
        }
    }

    public int[] getVistedStations() // This method will allow access to the Visited Stations member.
    {
        return vistedStations;
    }

    public void setVistedStations(int[] vistedStations) // This method will mutate data for the Visited Stations member.
    {
        this.vistedStations = vistedStations;
    }

    public int getHeight() // This method will allow access to the height member. 
    {
        return height;
    }

    public void setHeight(int height) // This method will mutate and error check the Height member.
    {
        while(height<1) // This loop will execute if the user input is invalid.
        {
            System.out.println("\nInvalid height, please input a number greater than 1.");
            height = input.nextInt();
        }
        
        this.height = height;
    }

    public int getWidth() // This method will allow access to the width member.
    {
        return width;
    }

    public void setWidth(int width) // This method will mutate and error check the width member. 
    {
        while(width<1) // This loop will execute if the user input is invalid.
        {
            System.out.println("\nInvalid width, please input a number greater than 1.");
            width = input.nextInt();
        }
         
        this.width = width;
    }

    public int getDepth() // This method will allow access to the depth member.
    {
        return depth;
    }

    public void setDepth(int depth) // This method mutate and error check the depth member.
    {
        while(depth<1) // This loop will execute if the user input is invalid.
        {
            System.out.println("\nInvalid depth, please input a number greater than 1.");
            depth = input.nextInt();
        }
         
        this.depth = depth;
    }

    public boolean[] getRobotActions()  // This method will allow access to the Robot Actions array.
    {
        return robotActions;
    }

    public void setRobotActions(boolean[] robotActions) // This method will mutate the Robot Actions member.
    {
        this.robotActions = robotActions;
    }

    // This method will return the list of violations.
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
    public String toString() {
        return "\nRobot Name: "+robotName+"\nTeam Number:" +teamNumber+"\nHeight: "+height+" in.\nWidth: "+width+" in.\nDepth: "+depth+" in.\nRobot Status: "+robotStatus+"\n"+displayActions();
    }   
}