/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class contain enumerations that will be used for showing the status of certain objects
 * throughout the tournament simulation. In order to progress to the next constant, the constants must
 * must follow the order that they are defined in this class.
 */

package tournamenttest;

public class TournamentEnumeration
{
    public enum tournamentStatus {INSPECTIONS,MATCH_GENERATION,MATCHES,AWARDS};
    public enum teamExperience {PEER_MENTOR,EXPERIENCED,NOVICE}
    public enum teamRole {CODING,DESIGN,CONSTRUCTION,TESTER,CAPTAIN,DRIVER}
    public enum robotStatus {OFF,READY,HW_ISP_PASSED,SW_ISP_PASSED,FIELD_TEST_PASSED}
    public enum teamGameStatus {NOT_SIGNED_IN,PREPARING,PASSED_INSPECTION,PLAYED5_MATCHES,ELIGIBLE,INELIGIBLE}
    public enum teamJudgingStatus {NOT_SIGNED_IN,BEFORE,IN,COMPLETED}
    public enum months {JANUARY,FEBUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER}
    public enum days {MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY}
    public enum timeOfDay {AM,PM}
    public enum compensation {PAID,VOLUNTEER}
    public enum inspections {HARDWARE,SOFTWARE,FIELD_TEST}
    public enum teamColor {RED,BLUE}
    public enum roles {TOURNAMENT_DIRECTOR,JUDGE,REFEREE,INSPECTOR,GENERAL_EVENT_STAFF}
    public enum violationScopes {PERSONAL,ROBOT,EVENT,OTHER}
    public enum violationTypes {PROTECTION,ACCIDENT,PREPARATION}
    public enum generalRoles{} // This will be defined when these roles become necessary.
}