/*
 * Author: Daniel Singh
 * UTA ID: 1000930800
 * CSE 1325 Dr. Tiernan
 * Description:
 */

package tournamenttest;

import java.util.Scanner;
import java.util.GregorianCalendar;

/**
 * This class represents a date.
 * @author Daniel
 */
public class PDate
{
    private int month = 1;
    private TournamentEnumeration.months wordMonth;
    private int day = 1;
    private int year = 2015;
    private TournamentEnumeration.days wordDay;
    private int standardHour;
    private int minute;
    private TournamentEnumeration.timeOfDay timeOfDay;
    private int militaryHour;
    
    Scanner input = new Scanner(System.in);
    
    /**
     * This constructor creates a PDate object.
     * @param month An integer that represents a month.
     * @param day An integer that represents a day.
     * @param year An integer that represents a year.
     */
    public PDate(int month, int day, int year)
    {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    /**
     * This method will return the month value/
     * @return A integer that represents a month.
     */
    public int getMonth() 
    {
        return month;
    }

    /**
     * This method sets and error checks the month.
     * @param month An integer that represents a month.
     */
    public void setMonth(int month) //This method will mutate and error check the month member. 
    {
        while (month>12 || month<1) // This loop will execute as long as the method parameter is an invalid month.
        {
            System.out.println("\nInvalid month, please input a number between 1 and 12."); //This print statement will prompt the user to input a proper month value.
            month = input.nextInt();
        }
        
        this.month=month;
    }

    public TournamentEnumeration.months getWordMonth() // This method will allow access to the string month member.
    {
        return wordMonth;
    }

    public void setStr_month(TournamentEnumeration.months wordMonth) // This method will mutate and error check the string month member. 
    {
        this.wordMonth = wordMonth;
    }

    public int getDay() // This method will allow access to the Day member.
    {
        return day;
    }

    public void setDay(int day) //This method will error check the number of the days of the month. For now this program will assume that there are 30 days in every month.
    {
        while (day>30 || day<1) // This loop will execute as long as the method parameter is an invalid day.
        {
            System.out.println("\nInvalid day, please input a number between 1 and 30."); //This print statement will prompt the user to input a proper day value.
            day = input.nextInt();
        }
        
        this.day=day;
    }

    public int getYear() // THis method will allow access to the year member.
    {
        return year;
    }

    public void setYear(int year) 
    {
        while (year>9999 || year<2015) // This loop will execute as long as the method parameter is an invalid day.
        {
            System.out.println("\nInvalid year, please input a year before 2014."); //This print statement will prompt the user to input a proper day value.
            year = input.nextInt();
        }
        
        this.year=year;
    }

    public TournamentEnumeration.days wordDay() // This method will allow access to the string day mamber.
    {
        return wordDay;
    }

    public void setStr_day(TournamentEnumeration.days wordDay) // This method will mutate data for the string day member. 
    {
        this.wordDay = wordDay;
    }

    public int getStandardHour()  // This method will allow access to the standard hour member. 
    {
        return standardHour;
    }

    public void setStandardHour(int standardHour) // This method will mutate and error check the standard hour member.
    {
        while(standardHour<1 || standardHour>12) // This loop will execute if the user input is invalid.
        {
            System.out.println("\nInvalid hour. Please enter a number between 1 and 12.");
            standardHour = input.nextInt();
        }
        this.standardHour = standardHour;
    }

    public int getMinute() // This method will allow access to the Minute member.
    {
        return minute;
    }

    public void setMinute(int minute) // This method will mutate and error check the minute member.
    {
        while(minute<0 || minute>59) // This loop will execute if the user input is invalid.
        {
            System.out.println("\nInvalid minute. Please enter a number between 0 and 59.");
            minute = input.nextInt();
        }
            
        this.minute = minute;
    }

    public TournamentEnumeration.timeOfDay getTimeOfDay() // This method will allow access to the time of day member. AM/PM
    {
        return timeOfDay;
    }

    public void setTimeOfDay(TournamentEnumeration.timeOfDay timeOfDay) // This method will mutate and error check the time of day member.
    {
        this.timeOfDay = timeOfDay;
    }

    public int getMilitaryHour() // This method will allow access to the military hour member.
    {
        return militaryHour;
    }

    public void setMilitaryHour(int militaryHour) // This method will mutate and error check the military hour member.
    {
        while(militaryHour<0 || militaryHour>23) // This loop will execute if the user input is invalid.
        {
            System.out.println("\nInvalid hour. Please enter a number between 0 and 23.");
            militaryHour = input.nextInt();
        }
        this.militaryHour = militaryHour;
    }
    
    @Override
    public String toString() {
        return String.format("The date is: "+month+"/"+day+"/"+year);
    }
}