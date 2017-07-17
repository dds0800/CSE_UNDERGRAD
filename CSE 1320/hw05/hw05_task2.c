/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang CSE 1320
 * Homework 5 Task 2
 * This program estimates e^x using the Taylor Series
 * x is equal to the user input.
 */

 #include <stdio.h>
 #include <math.h> // This library was included to use the exp() function

 #define N 10

float display(float x, int n) // This function returns the value of the Taylor Series at a specific iteration of n
 {
     float sum,numerator,denominator;
     int i,j,base,n2;

     sum=0;
     n2=n;

     for(i=n;i>=2;i-=1) // This loop calculates iterations of the Taylor Series n=2 to current n value
     {

         numerator=x;
         base=x;
         for(j=1;j<n2;j+=1) // This loop calculate x^n
         {
             numerator*=base;
         }

         denominator=n2;
         for(j=n2;j>1;j-=1) // This loop calculates n!
         {
             denominator=denominator*(j-1);
         }

         n2-=1;

         sum+=(numerator/denominator); // At all iterations of n
     }

     sum=sum+(1+x); // Add n=0 and n=1 to the total sum

     return sum;
 }


 float Taylor(float x, int n) // This function is the Taylor Series. The approximation is calculated by recursion
 {
     float sum,numerator,denominator;
     int i,base;


     if (n==0) // When n=0 the sum of the Taylor Series is 1
     {
        printf("When n is 0, the Taylor Series approximates to %f\n",x/x);
        return 1+Taylor(x,n+1);
     }
     else if (n==1) // When n=0 the sum of the Taylor Series is x
     {
        printf("When n is 1, the Taylor Series approximates to %f\n",x);
        return x+Taylor(x,n+1);
     }
     else if (n==N) // This statement ends the recursive function
        return 0;
     else // When n is not equal 0, 1, or 10
     {

         numerator=x;
         base=x;

         for(i=1;i<n;i+=1) // This loop calculates x^n
         {
             numerator*=base;
         }

         denominator=n;

         for(i=n;i>1;i-=1) // This loops calculates n!
         {
             denominator=denominator*(i-1);
         }

         printf("When n is %d, the Taylor Series approximates to %f\n",n,display(x,n)); // Display to user the current iteration of n

         return (numerator/denominator)+Taylor(x,n+1);
     }
 }



 int main(void) // Main function
 {
     float x; // User input for exponential function
     int n=0; // n is

     printf("y=e^x\n");
     printf("What does x equal? "); // Ask the user for x
     fflush(stdin); // Flush input buffer from any previous keyboard input
     scanf("%f",&x);
     printf("\n");
     printf("When x is equal to %f, y is equal to %f\n",x,exp(x)); // Show the user what e^x evaluates to
     printf("\n");
     printf("Let's take x and put it into the Taylor Series to get a similar approximation.\n"); // Take x and approximate using the Taylor Series
     printf("\n");
     Taylor(x,n); // Function call to recursive function.

     return 0;
 }
