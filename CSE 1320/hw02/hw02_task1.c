/*
* Daniel Singh
* UTA ID: 1000930800
* Prof. Kang CSE 1320
* Homework 2 Task 1
* This program outputs the first 128 ASCII
* characters and their numbers in decimal
* hexadecimal and octal representations.
*/

#include <stdio.h> //Include standard input and output library for printf function.

int i; // Declaration of counter variable for loop

int main(void)

{
    printf("Decimal\t Octal\t Hexadecimal\t ASCII Symbol\n"); //Header for table

    for(i=1;i<=128;i+=1) // For Loop to print the first 128 characters
    {
        printf("%d\t %o\t %x\t\t %c\n",i,i,i,i); //Printing the ASCII characters with their corresponding number representations
    }
    return 0;
}
