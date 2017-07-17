/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: Objects from this class will represent a Judge in the
 * tournament. This class inherits data from the TourneyStaff class.
 */

package tournamenttest;

import java.util.ArrayList;

/**
 * This class represents a judge at a tournament.
 * @author Daniel
 */
public class Judge extends TourneyStaff
{
    private ArrayList<String> judgingQualifications= new ArrayList();
    private boolean completedTraining;

    /**
     * This constructor will create a Judge object.
     * @param completedTraining A boolean value that indicates if this
     * person has completed training or not.
     * @param first The person's first name.
     * @param last The person's last name,
     * @param eMail The person's eMail address.
     */
    public Judge(boolean completedTraining, String first, String last, String eMail) 
    {
        super(first, last, eMail);
        this.completedTraining = completedTraining;
    }

    /**
     * This constructor will create a Judge object.
     * @param completedTraining A boolean value that indicates if this
     * person has completed training or not.
     * @param tournamentName The name of the tournament this person belongs to.
     * @param finishTraining A boolean value that indicates if this
     * person has finished training or not.
     * @param compensationType An enumerated value that indicates how this
     * person is bing compensated.
     * @param first The person's first name.
     * @param last The person's last name.
     * @param mail  The person's eMail address.
     */
    public Judge(boolean completedTraining, String tournamentName, boolean finishTraining, TournamentEnumeration.compensation compensationType, String first, String last, String mail) 
    {
        super(tournamentName, finishTraining, compensationType, first, last, mail);
        this.completedTraining = completedTraining;
    }

    // This method will allow access to the list of qualifications.
    /**
     * This method will return a list of qualifications.
     * @return A list of qualifications that a judge has achieved.
     */
    public ArrayList<String> getJudgingQualifications() 
    {
        return judgingQualifications;
    }

    // This method will mutate the list of qualifications.
    /**
     * This method will set the list of qualifications.
     * @param judgingQualifications A list of qualifications that a judge has earned.
     */
    public void setJudgingQualifications(ArrayList<String> judgingQualifications) 
    {
        this.judgingQualifications = judgingQualifications;
    }

    // This method will return the value of the completeion of training.
    /**
     * This method will return a boolean value that indicates if 
     * the judge has completed training.
     * @return A boolean value that indicates the completion of training.
     */
    public boolean isCompletedTraining() 
    {
        return completedTraining;
    }

    // This method will mutate the value for training.
    /**
     * This method will set the boolean value for the 
     * completedTraining member,
     * @param completedTraining A boolean value that indicates the completion
     * of training.
     */
    public void setCompletedTraining(boolean completedTraining)
    {
        this.completedTraining = completedTraining;
    }

    @Override
    /**
     * This method will return a string that contains
     * information for a judge object.
     */
    public String toString() {
        return super.toString()+ " Completed Training?: " + completedTraining;
    }  
}