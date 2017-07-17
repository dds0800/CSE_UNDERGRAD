/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: Objects from this class will represent a safety violation.
 * An object from this class tells the scope, type, descirption of the violation.
 */

package tournamenttest;

public class SafetyViolation 
{
    private TournamentEnumeration.violationScopes scope;
    private TournamentEnumeration.violationTypes type;
    private String description;
    
    // This constructor will create a default violation.
    public SafetyViolation()
    {
        this(TournamentEnumeration.violationScopes.OTHER,TournamentEnumeration.violationTypes.ACCIDENT,"");
    }

    // This constructor will create a specific violation whenever it occurs.
    public SafetyViolation(TournamentEnumeration.violationScopes scope, TournamentEnumeration.violationTypes type, String description) {
        this.scope = scope;
        this.type = type;
        this.description = description;
    }
    
    

    // This method returns the scope of the violation.
    public TournamentEnumeration.violationScopes getScope() 
    {
        return scope;
    }

    // This method sets the scope of a violation.
    public void setScope(TournamentEnumeration.violationScopes scope)
    {
        this.scope = scope;
    }

    // This method returns the type of violation.
    public TournamentEnumeration.violationTypes getType()
    {
        return type;
    }

    // This method sets the type of vilation.
    public void setType(TournamentEnumeration.violationTypes type) 
    {
        this.type = type;
    }

    // This method returns the desciption of the violation.
    public String getDescription()
    {
        return description;
    }

    // This method sets the description for the violation.
    public void setDescription(String description) 
    {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n\nViolation Scope: "+scope+"\nViolation Type: "+type+"\nDesciption of Violation: "+description;
    }
}