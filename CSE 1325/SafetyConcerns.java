/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This interface contains methods the pertain to saftey violations.
 * This interface will be implemented in the Tournament, Robot, and TeamPerson classes.
 */

package tournamenttest;

public interface SafetyConcerns
{
    public boolean countSafetyIssues();
    public String displaySafetyIssueSource();
}
