/*
 * Daniel Singh
 * UTA ID:1000930800
 * Prof. Kang CSE 1320
 * Homework 4 Task 2
 * Description: The user is asked to input distinct positive integers until array is full.
 * Once full the program will output the highest and lowest number.
 */

 #include <stdio.h>

 int rgn_user[5]; //Array for user input

 int i=0,j=0; //Loop Counter declaration

 int rep_check; //Declaration of number repetition check variable

 int user_inp; // This variable will be assign to user input, then the array.

 int rgn_max,rgn_min;


 void array_check(int array_num)
 {
    if ((array_num)<=0) // If the user enters a negative number or zero, ask the user for a positive integer
         {
             printf("Please enter a non-negative/non-zero integer.\n");
             fflush(stdin);
             scanf("%d",&user_inp);
             rgn_user[i]=user_inp;
             array_check(rgn_user[i]);
         }

    else // If the input is valid, check to see if a number is repeated.
         {
             j=0;
             while (j<i)
             {
                 if (j==i) // If the index of the array is equal to the index from which it came from, skip it
                 {
                     j+=1;
                     continue;
                 }

                 else if ((rgn_user[j])==(array_num)) // If another index is equal to user input, ask the user again for valid input
                 {
                    printf("You already entered this integer, please enter a different integer.\n");
                    fflush(stdin);
                    scanf("%d",&user_inp);
                    rgn_user[i]=user_inp;
                    array_check(rgn_user[i]); // Check again to see if user input is valid
                 }

                 j+=1;
             }
         }
 }

 int main(void)
 {

     while (i<5)
     {
         printf("Please enter a distinct positive integer.\n");
         fflush(stdin);
         scanf("%d",&user_inp);
         rgn_user[i]=user_inp;
         array_check(rgn_user[i]);
         i+=1;


    }

    rgn_max=rgn_user[0];

    rgn_min=rgn_user[0];

    for(i=1;i<5;i+=1) // Check for maximum number
    {
        if (rgn_user[i]>rgn_max)
        {
            rgn_max=rgn_user[i];
        }
    }

    for(i=1;i<5;i+=1) // Check for minimum number
    {
        if (rgn_user[i]<rgn_min)
        {
            rgn_min=rgn_user[i];
        }
    }

    printf("\n");
    printf("From all the integers you entered, %d is the maximum and %d is the minimum.\n",rgn_max,rgn_min);

    return 0;
 }
