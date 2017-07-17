/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: Objects from this class will represent a Referee in the
 * tournament. This class inherits data from the TourneyStaff class.
 */

package tournamenttest;

public class Referee extends TourneyStaff
{
    private boolean completedOnlineTraining;
    private boolean completedTrainingInPerson;

    public Referee(boolean completedOnlineTraining, boolean completedTrainingInPerson, String first, String last, String eMail) 
    {
        super(first, last, eMail);
        this.completedOnlineTraining = completedOnlineTraining;
        this.completedTrainingInPerson = completedTrainingInPerson;
    }

    public Referee(boolean completedOnlineTraining, boolean completedTrainingInPerson, String tournamentName, boolean finishTraining, TournamentEnumeration.compensation compensationType, String first, String last, String mail) 
    {
        super(tournamentName, finishTraining, compensationType, first, last, mail);
        this.completedOnlineTraining = completedOnlineTraining;
        this.completedTrainingInPerson = completedTrainingInPerson;
    }
    
    public Referee(String first, String last, String eMail) 
    {
        super(first, last, eMail);
        System.out.println("\nHow many years of experience does this person has in robot tournaments?");
        System.out.println("Please enter in an integer that is greater than zero.");
        setExperience(input.nextInt());
    }

    // This method will return the value of the completion of training.
    public boolean isCompletedOnlineTraining() 
    {
        return completedOnlineTraining;
    }

    // The method will mutate the value of the completion of training.
    public void setCompletedOnlineTraining(boolean completedOnlineTraining) 
    {
        this.completedOnlineTraining = completedOnlineTraining;
    }

    // This method will return the value of the completion of training.
    public boolean isCompletedTrainingInPerson() 
    {
        return completedTrainingInPerson;
    }

     // The method will mutate the value of the completion of training.
    public void setCompletedTrainingInPerson(boolean completedTrainingInPerson)
    {
        this.completedTrainingInPerson = completedTrainingInPerson;
    }

    @Override
    public String toString() 
    {
        return super.toString() + " Completed Online Training?: " + completedOnlineTraining + " Completed Training in Person?:" + completedTrainingInPerson;
    }
}