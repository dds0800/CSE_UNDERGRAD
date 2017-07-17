/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class contains the address of a person.
 */

package tournamenttest;

import java.util.Scanner;


/**
 * This class represents an address for a person.
 * @author Daniel
 */
public class Address
{
    private String streetName;
    private String city;
    private String state;
    private int zipCode;
    
    Scanner input = new Scanner(System.in);
    
    /**
     * This constructor initializes an Address object.
     * @param street The name of the street.
     * @param cityLoc The name of the city.
     * @param stateLoc  The name of the state.
     */
    public Address(String street, String cityLoc, String stateLoc)
    {
        this.streetName = street;
        this.city = cityLoc;
        this.state = stateLoc;
    }

    /**
     * This method will return the name of the street.
     * @return A string which is the street name.
     */
    public String getStreetName() // This method will allow access to the street name member.
    {
        return streetName;
    }

    /**
     * This method will set the street name.
     * @param streetName The name of the street.
     */
    public void setStreetName(String streetName) // This method will muatate data for the street name member. 
    {
        this.streetName = streetName;
    }

    /**
     * This method will return the name of the city.
     * @return A string which is the name of the city.
     */
    public String getCity() // This method will allow access to the city member.
    {
        return city;
    }

    /**
     * This method will set the name of the city.
     * @param city The name of the city.
     */
    public void setCity(String city)  // This method will muatate data for the city member.
    {
        this.city = city;
    }

    /**
     * This method will return the name of the state.
     * @return A string which is the name of the street.
     */
    public String getState() // This method will allow access to the state member.
    {
        return state;
    }

    /**
     * This method will set the name of the state,
     * @param state The name of the state.
     */
    public void setState(String state)  // This method will muatate data for the state member.
    {
        this.state = state;
    }

    /**
     * This method will return a 5 digit zip code.
     * @return A 5 digit zip code.
     */
    public int getZipCode() // This method will allow access to the zip code member.
    {
        return zipCode;
    }

    /**
     * This method will set and error checked a passed zip code.
     * @param zipCode A 5 integers that represent a zip code.
     */
    public void setZipCode(int zipCode)  // This method will muatate and error check the zip code member.
    {
        while(zipCode<10000 || zipCode>99999) // This loop will execute if the user input is invalid.
        {
            System.out.println("\nInvaid zip code. Please try again.");
            zipCode = input.nextInt();
        }
        this.zipCode = zipCode;
    }

    @Override
    /**
     * This method will return information about an address object.
     */
    public String toString()
    {
        return "Street: " + streetName + "\nCity and State: " + city + ", "+state +"\n Zip Code: "+zipCode;
    }
}