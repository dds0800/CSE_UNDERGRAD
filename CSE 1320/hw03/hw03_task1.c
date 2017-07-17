/*
* Daniel Singh
* UTA ID: 1000930800
* Prof. Kang CSE 1320
* Homework 3 Task 1
* This program will print a multiplication table
*/

#include <stdio.h>

void main()
{
 int i,j; // Counter variable for the loops

 printf("X\t");

 for (i=1;i<=12;i+=1)
 {
    printf("%d\t",i); //This loop prints a horizontal line which contain the reference numbers
 }

 printf("\n");

 for (i=1;i<=12;i+=1) //Leave this twelve alone its the length of the column for the table
 {
     printf("%d\t",i); //This part of the loop will print the vertical reference numbers

     for (j=1;j<=12;j+=1) //This loop prints the current vertical reference number times all the horizontal reference number
     {
         printf("%d\t",i*j);
     }
     printf("\n");
 }

}
