/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class will contain general information about a person.
 */

package tournamenttest;

public class Person
{
    private String firstName;
    private String lastName;
    private String eMail;
    
    public Person(String first,String last,String mail)
    {
        this.firstName = first;
        this.lastName = last;
        this.eMail = mail;
    }

    public String getFirstName() // This method will allow access to the First Name member.
    {
        return firstName;
    }

    public void setFirstName(String firstName) // This method will mutate data for the First Name member.
    {
        this.firstName = firstName;
    }

    public String getLastName() // This method will allow access to the Last Name member.
    {
        return lastName;
    }

    public void setLastName(String lastName) // This method will mutate data for the First Name member.
    {
        this.lastName = lastName;
    }

    public String geteMail() // This method will allow access to the email member.
    {
        return eMail;
    }

    public void seteMail(String eMail) // This method will mutate data for the First Name member.
    {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + ", Last Name: " + lastName + ", Email Address: " + eMail;
    }
    
    
}