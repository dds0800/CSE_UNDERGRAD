/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang CSE 1320
 * Homework 5 Task 1
 * This program asks the user to input a string and prints the string without
 * any repeated characters.
 */

 #include <stdio.h>
 #include <string.h> // This library was included to use its string length function

 void no_repetitions() // This function takes user input and checks it for any character repetitions
 {
     char userinput[100], output[100],check;
     int i,j,k,length,index,good;

     fflush(stdin); // Clear input buffer before the user puts anything in
     fgets(userinput,100,stdin); // Obtain user input from keyboard
     printf("\n");

     length=strlen(userinput); // The length variable allows the iteration through the string without accessing an element that does not exist.
     index=0; // This variable is the index of the output array. A non repeated character will be an element of the ouput array.

     for(i=0;i<length;i+=1) // Iterate through the string
     {
         good=1;
         for(j=0;j<=i;j+=1) // This loop will check a single character against every element in the user input array
         {
             if(i==j) // If the elements are the same, repetition will not count
                continue;
             else if(userinput[i]==userinput[j]) // If a repeated character is found...
             {
                for(k=0;k<=index;k+=1) //... check in the output array to see if the character is already accounted for.
                    if(output[k]==userinput[i]) // If repetition is found do not add to output array
                        good=0;
             }
         }
         if(good) // If the character is not repeated add to output array
         {
             output[index]=userinput[i];
             index+=1; // Increase the amount of indicies within the output array
         }
     }
     length=index;
     printf("The string without repetitions is: ");

     for(i=0;i<length;i+=1) // I could of used the index variable for the testing condition of the loop, but I used length for the sake of intuition
        printf("%c",output[i]); // Print non-repeated characters
 }

int main(void) // Main function
{
    printf("Please input a string: "); // Ask user to input a string
    no_repetitions(); //Function call to ask user for string and print string with no repetitions

    return 0;
}
