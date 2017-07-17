/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class will contain details about a specific match.
 */

package tournamenttest;

import java.util.Scanner;
import java.util.Random;
import java.util.GregorianCalendar;

/**
 * This class represents a match in which four teams will compete.
 * @author Daniel
 */
public class GameMatch 
{
    private int matchNumber;
    private int gameFieldNumber;
    private Team[] redAlliance = new Team[2];
    private Team[] blueAlliance = new Team[2];
    private int redFinal;
    private int blueFinal;
    private int[][] actionsPerformed = new int[4][8];
    
    Scanner input = new Scanner(System.in);
    GregorianCalendar random = new GregorianCalendar();
    Random randSeed = new Random(random.getTimeInMillis());

    // This method will generate the match results and add to the teams current scores.
    
    /**
     * This constructor takes in a red and blue team with a match number.
     * @param matchNumber An integer that indicates what number match it is.
     * @param redTeam An array of team objects that represent the red team.
     * @param blueTeam An array of team objects that represent the blue team.
     */
    public GameMatch(int matchNumber,Team[] redTeam, Team[] blueTeam)
    {
        this.matchNumber=matchNumber;
        redAlliance=redTeam;
        blueAlliance=blueTeam;
        for(Team team : redAlliance)
        {
            team.getGamesToBePlayed().add(matchNumber);
        }
        for(Team team : blueAlliance)
        {
            team.getGamesToBePlayed().add(matchNumber);
        }
    }
    
    // This method generates the match results for a match.
    
    /**
     * This method will randomly generate scores to assign ranking and qualifying
     * points to the alliances in the match.
     */
    public void generationOfMatchResults()
    {
        setRedFinal();
        setBlueFinal();
        
        if(redFinal>blueFinal)
        {
            for(Team team : redAlliance)
            {
                team.setQualifyingPoints(2);
                team.setRankingPoints(blueFinal);
            }
            
            for(Team team : blueAlliance)
            {
                team.setRankingPoints(blueFinal);
            }
        }
        
        else if(redFinal<blueFinal)
        {
            for(Team team : blueAlliance)
            {
                team.setQualifyingPoints(2);
                team.setRankingPoints(redFinal);
            }
            
            for(Team team : redAlliance)
            {
                team.setRankingPoints(redFinal);
            }
        }
        
        else
        {
            for(Team team : blueAlliance)
            {
                team.setQualifyingPoints(1);
                team.setRankingPoints(redFinal);
            }
             
            for(Team team : redAlliance)
            {
                team.setQualifyingPoints(1);
                team.setRankingPoints(redFinal);
            }
        }
    }
    
    /**
     * This method returns the match number.
     * @return An integer that represents the match number.
     */
    public int getMatchNumber() // This method will allow access to the Match Number member.
    {
        return matchNumber;
    }

    // This method will set and error check the match number.
    
    /**
     * This method sets the match number for a gamematch object.
     * @param lastMatch An integer that represents the last match that was played.
     * @param matchNumber An integer that is a possible match number
     */
    public void setMatchNumber(int lastMatch, int matchNumber) // This method will mutate and error check the Match Number member.
    {
        while(matchNumber<lastMatch || matchNumber>lastMatch+2) // This loop will execute if user input is invalid.
        {
            System.out.println("\nInvalid match number. Please input a number greater than "+lastMatch+" and less than "+lastMatch+2+ ".");
            matchNumber = input.nextInt();
        }
        this.matchNumber = matchNumber;
    }

    // This method will return the game field number.
    
    /**
     * This method will return the game field number of where the match occurred.
     * @return An integer that represents the field at which a match was held.
     */
    public int getGameFieldNumber() // This method will allow access to the Game Field Number member.
    {
        return gameFieldNumber;
    }

    // This method will set and error check the game match field number.
    
    /**
     * This method will set the game field number for a game match object.
     * @param maxFieldNum An integer that represents the maximum amount of game fields.
     * @param gameFieldNumber  An integer the represents a possible game field.
     */
    public void setGameFieldNumber(int maxFieldNum, int gameFieldNumber) // This method will mutate and error check the Field Game Number member.
    {
        while(gameFieldNumber<1 || gameFieldNumber>maxFieldNum) // This loop will execute if the user input is invalid.
        {
            System.out.println("\nInvalid field number. Please enter a number between 0 and"+maxFieldNum+".");
            gameFieldNumber = input.nextInt();
        }
        this.gameFieldNumber = gameFieldNumber;
    }

    /**
     * This method will the get red alliance.
     * @return An array that holds team objects that represent the red alliance.
     */
    public Team[] getRedAlliance() // This method will allow access to the Red Team member.
    {
        return redAlliance;
    }

    /**
     * This method will set the red alliance member.
     * @param redAlliance An array made of two team objects that represent the red alliance.
     */
    public void setRedAlliance(Team[] redAlliance) // This method will mutate the Red Team member.
    {
        this.redAlliance = redAlliance;
    }

    /**
     * This method will the get blue alliance.
     * @return An array that holds team objects that represent the blue alliance.
     */
    public Team[] getBlueAlliance() // This method will allow access to the Blue Team member.
    {
        return blueAlliance;
    }

    /**
     *  This method will set the blue alliance member.
     * @param blueAlliance An array made of two team objects that represent the blue alliance.
     */
    public void setBlueAlliance(Team[] blueAlliance) // This method will mutate the Blue Team member.
    {
        this.blueAlliance = blueAlliance;
    }

    /**
     * This method will return the red alliance's final score.
     * @return An integer that represents the red alliance's final score.
     */
    public int getRedFinal() // This method will allow access to the Red Final score.
    {
        return redFinal;
    }

    /**
     * This method will set the red alliance's final score.
     * @param redFinal An integer that represents the red alliance's final score.
     */
    public void setRedFinal(int redFinal) // This method will mutate and error check the Red Final member.
    {
        this.redFinal = redFinal;
    }
    
    /**
     * This method will randomly generate a final score for a red alliance
     * between the range of 0 and 540.
     */
     public void setRedFinal()
     {
         this.redFinal=randSeed.nextInt(541);
     }

     /**
     * This method will return the blue alliance's final score.
     * @return An integer that represents the blue alliance's final score.
     */
    public int getBlueFinal() // This method will allow access to the Blue Final score.
    {
        return blueFinal;
    }

    /**
     * This method will set the blue alliance's final score.
     * @param blueFinal An integer that represents the blue alliance's final score.
     */
    public void setBlueFinal(int blueFinal) // This method will mutate and error check the Blue Final member.
    {
        this.blueFinal = blueFinal;
    }
    
    /**
     * This method will randomly generate a final score for a blue alliance
     * between the range of 0 and 540.
     */
    public void setBlueFinal()
     {
         this.blueFinal=randSeed.nextInt(541);
     }

    /**
     * This method will return the array of actions performed in a match.
     * @return A 2 dimensional array that indicated which team's robot
     * performed what movies.
     */
    public int[][] getActionsPerformed() 
    {
        return actionsPerformed;
    }

    /**
     * This method will set the array of actions performed.
     * @param actionsPerformed A 2 dimensional array that indicated which team's robot
     * performed what movies.
     */
    public void setActionsPerformed(int[][] actionsPerformed) 
    {
        this.actionsPerformed = actionsPerformed;
    }

    @Override
    /**
     * This method will return a string that includes information about 
     * a game match object.
     */
    public String toString() 
    {
        return "The results for match "+" are Red Final: "+redFinal+" Blue Final: "+blueFinal;
    } 
}