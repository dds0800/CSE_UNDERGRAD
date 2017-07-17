/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang CSE 1320
 * Homework 6 Task 1
 * This program will ask to user to enter 10 integers into an array then ask
 * the user for indices to swap within the array.
 */

#include <stdio.h>

void swap(int *pnArray, int nIndex1, int nIndex2) // This function swaps the indicies of the array through pointers
{
    int ntemp=*(pnArray+nIndex2); // This variable holds a value temporarily

    (*(pnArray+nIndex2))=(*(pnArray+nIndex1)); // Move the value to the next index where the temporary value was
    (*(pnArray+nIndex1))=ntemp; // Put the temporary value where the copied value was
}

int check_input(int input) // This function is a recursive function that checks the user's input
{
    if((input<=9) && (input>=0)) // If the value is in the range, return the good value
        return input;
    else // If the value is not in the range...
    {
        printf("\n");
        printf("Invalid index, please input an integer between 0 and 9: "); // ...Prompt the user to enter a new value...
        fflush(stdin);
        scanf("%d",&input);
        printf("\n");
        return check_input(input); // ... and check it again
    }
}

int main(void) // Main Function
{
    int rgn_user[10],*prgn_user,i,index_1,index_2;

    prgn_user=&rgn_user; // Memory address of the array that will be passed to the swap function

    for(i=0;i<10;i+=1) // This loop prompts the user to enter 10 integers
    {
        printf("Please enter an integer: ");
        scanf("%d",&rgn_user[i]); // Stores the integer in the current index of the array
        printf("\n");
    }

    printf("The values of the array are...\n"); // Now show the user the values they inputted

    for(i=0;i<10;i+=1) // This loop prints the values within the array
    {
       printf("%d ",rgn_user[i]);
    }

    printf("\n");
    printf("\n");

    printf("Please enter an index between 0 and 9: "); // Ask the user for the first index they wish to swap
    fflush(stdin); // Clear input buffer to get clean user input
    scanf("%d",&index_1);
    index_1=check_input(index_1); // Check to see if the index is within range
    printf("\n");

    printf("Please enter another index between 0 and 9: "); // Ask the user for the second index they wish to swap
    fflush(stdin);
    scanf("%d", &index_2);
    index_2=check_input(index_2); // Check index again
    printf("\n");

    swap(prgn_user,index_1,index_2); // This function call will swap the elements in the indicies

    printf("The new values of the array are...\n "); // Now show the user the new array with swapped values

     for(i=0;i<10;i+=1) // This loop prints the new elements in the array
    {
       printf("%d ",rgn_user[i]);
    }

    printf("\n");

    return 0;
}
