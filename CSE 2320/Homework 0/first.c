/* Daniel Singh
 * UTA ID: 1000930800
 * CSE 2320 Dr. Stefan
 * Description: This program will ask the user
 * for two integers and print all the integers
 * in between from least to greatest.
 */

 #include <stdio.h> // Include library of standard input and output functions.

 int main(void) // Main Start
 {
     int input_1,input_2,i,larger_int;

     printf("Please input the first integer:\n"); // Prompt the user for the first integer.
     scanf("%d",&input_1); // Store input into variable.
     printf("\nPlease input the second integer:\n"); // Prompt user to enter second integer.
     scanf("%d",&input_2);

     if(input_1<input_2) // Perform a check to see which integer is smaller. The smaller integer will be the loop counter.
     {
        i=input_1;
        larger_int=input_2;
     }
     else
     {
        i=input_2;
        larger_int=input_1;
     }

     printf("\nThe integers between %d and %d are:\n\n",i,larger_int);

     while(i<=larger_int) // This loop will print all the integers that the user input.
     {
         printf("%d\n",i);
         i+=1;
     }

     return 0;
 }
