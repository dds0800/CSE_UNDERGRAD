/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: Objects from this class will represent an Inspector in the
 * tournament. This class inherits data from the TourneyStaff class.
 */

package tournamenttest;

/**
 * This class represents an inspector at a hardware, software,
 * or field testing station.
 * @author Daniel
 */
public class Inspector extends TourneyStaff
{
    private TournamentEnumeration.inspections kindOfInspector;
    private int stationNumber;

    /**
     * This constructor creates an inspector object. 
     * @param kindOfInspector An enumerated value that indicates the kind of
     * inspector this person is.
     * @param stationNumber An integer that represents a station number.
     * @param first The person's first name.
     * @param last The person's last name,
     * @param eMail The person's eMail address
     */
    public Inspector(TournamentEnumeration.inspections kindOfInspector, int stationNumber, String first, String last, String eMail) 
    {
        super(first, last, eMail);
        this.kindOfInspector = kindOfInspector;
        this.stationNumber = stationNumber;
    }

    /**
     * This constructor creates an inspector object.
     * @param kindOfInspector An enumerated value that indicates the kind of
     * inspector this person is.
     * @param stationNumber An integer that represents a station number.
     * @param tournamentName The name of the tournament this person belongs to.
     * @param finishTraining A boolean value that indicates if the person has
     * completed training or not.
     * @param compensationType An enumerated value that indicates how this
     * person is being compensated.
     * @param first The person's first name.
     * @param last The person's last name.
     * @param mail THe person's eMail address.
     */
    public Inspector(TournamentEnumeration.inspections kindOfInspector, int stationNumber, String tournamentName, boolean finishTraining, TournamentEnumeration.compensation compensationType, String first, String last, String mail) 
    {
        super(tournamentName, finishTraining, compensationType, first, last, mail);
        this.kindOfInspector = kindOfInspector;
        this.stationNumber = stationNumber;
    }

    // This method allow access to the inspection value.
    
    /**
     * This method returns the type of inspector.
     * @return An enumerated value that indicates the roles this
     * person is able to accomplish.
     */
    public TournamentEnumeration.inspections getKindOfInspector() 
    {
        return kindOfInspector;
    }

    // This method will mutate the inspection value.
    /**
     * This method will set the type of inspector.
     * @param kindOfInspector An enumerated value that indicates the roles this
     * person is able to accomplish.
     */
    public void setKindOfInspector(TournamentEnumeration.inspections kindOfInspector)
    {
        this.kindOfInspector = kindOfInspector;
    }

    // This method will allow access to the station number.
    /**
     * This method will return the station number.
     * @return An integer that represents the station
     * number this person belongs to.
     */
    public int getStationNumber() 
    {
        return stationNumber;
    }

    // This method will muatate the station member.
    /**
     * This method will set the station number.
     * @param stationNumber An integer that represents the station
     * this person belongs to.
     */
    public void setStationNumber(int stationNumber) 
    {
        this.stationNumber = stationNumber;
    }

    @Override
    /**
     * This method will return a string that includes information about
     * an inspector.
     */
    public String toString()
    {
        return super.toString()+ " Type of Inspector: " + kindOfInspector + " Station Number: " + stationNumber;
    }
}