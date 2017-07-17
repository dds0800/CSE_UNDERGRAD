/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: Objects from this class will represent a General Staff member 
 * in the tournament. This class inherits data from the TourneyStaff class.
 */

package tournamenttest;

/**
 * This class represents a general staff member at a robot tournament.
 * @author Daniel
 */
public class GeneralEventStaff extends TourneyStaff
{
    private TournamentEnumeration.generalRoles role;

    /**
     * This constructor will create a General Event Staff object.
     * @param role An enumerated value that indicated what role this 
     * person is capable of doing.
     * @param first The person's first name.
     * @param last The person's last name.
     * @param eMail The person's eMail address
     */
    public GeneralEventStaff(TournamentEnumeration.generalRoles role, String first, String last, String eMail)
    {
        super(first, last, eMail);
        this.role = role;
    }

    /**
     * This constructor will create a General Event Staff object.
     * @param role An enumerated value that indicateds what role this person
     * is capable of doing.
     * @param tournamentName The name of the tournament this person belongs to
     * @param finishTraining A boolean value that indicates if this person
     * has completed training or not.
     * @param compensationType An enumerated values that shows how this
     * person is being compensated
     * @param first The person's first name.
     * @param last The person's last name.
     * @param mail  The person's eMail address.
     */
    public GeneralEventStaff(TournamentEnumeration.generalRoles role, String tournamentName, boolean finishTraining, TournamentEnumeration.compensation compensationType, String first, String last, String mail) 
    {
        super(tournamentName, finishTraining, compensationType, first, last, mail);
        this.role = role;
    }

    // This method will return the role values.
    /**
     * This method will return the staff member's role.
     * @return An enumerated value that indicated what
     * role this person is capable of doing.
     */
    public TournamentEnumeration.generalRoles getRole() 
    {
        return role;
    }

    // This method will mutate the role values.
    /**
     * This method will set the role for the staff member.
     * @param role An enumerated value that indicates what role this
     * person is capable of doing.
     */
    public void setRole(TournamentEnumeration.generalRoles role)
    {
        this.role = role;
    }

    @Override
    /**
     * This method will return a string that includes
     * information about a General Event Staff person.
     */
    public String toString() 
    {
        return super.toString() + " General Role : " + role;
    }
}