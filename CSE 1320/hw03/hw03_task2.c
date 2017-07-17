/*
* Daniel Singh
* UTA ID: 1000930800
* Prof. Kang CSE 1320
* Homework 3 Task 2
* This program will print the pattern represented in task two.
*/

#include <stdio.h>

#define STAR '*'

void main()
{
    int i,j,k; //Declaration of Loop Counters

    for (i=1;i<=7;i+=1) // This loop prints a new line after one line as been printed.
    {
        for (j=1;j<=i;j+=1) //This loop prints the numbers first.
        {
            printf("%d",j);
        }

        for (k=(7-i);k>0;k-=1) //This loop prints the asterisks after the numbers are printed.
        {
            printf("%c",STAR);
        }
        printf("\n"); // After the numbers and asterisks are printed, a new line will begin.
    }
}

