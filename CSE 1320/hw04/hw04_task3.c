/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang CSE 1320
 * Homework 4 Task 3
 * Description: Prints an array that contains random numbers between 0 and 500.
 */


//****NOTE TO GRADER**** I could not figure out why the random number would not generate correctly.

 #include <stdio.h>

 #define RGNMAX 10

 int rgn_random[10][10]; // Creation of array in memory

 int random_number() // Generation of random number
 {
    int nRand;
    nRand = rand()%501;
    return nRand;
 }

 void rgn_assignment() // Assign random numbers to indices in array.
 {
     int i,j;

     for(i=0;i<RGNMAX;i+=1)
     {
         for(j=0;j<RGNMAX;j+=1)
         {
             rgn_random[i][j]=random_number();
         }
     }
     return;
 }

 void rgn_check() // Check for repetition in a line of the array
 {
     int i,j,k;
     int check;

     for(i=0;i<RGNMAX;i+=1)
     {
         for(j=0;j<RGNMAX;j+=1)
         {
             check=rgn_random[i][j];

             for(k=0;k<RGNMAX;k+=1)
             {

                 if(k==j)
                 {
                     continue;
                 }

                 else
                 {
                     if((rgn_random[j][k])==check) // If the same number is found in a different index, replace it with a new one.
                     {
                         rgn_random[j][k]=random_number();
                     }
                 }
             }
         }

     }
     return;
 }


 void print_array() // Print the indicies of the array.
 {
     int i,j;

     for(i=0;i<RGNMAX;i+=1)
     {
         for(j=0;j<RGNMAX;j+=1)
         {
            if(j==9)
            {
                printf("%d\t",rgn_random[i][j]);
            }
            else
            {
                printf("%d,\t",rgn_random[i][j]);
            }
        }
        printf("\n");
     }
     return;
 }

 int main(void) // This function assigns numbers to the array, checks for repetition, and then prints the array.
{
    srand((unsigned) time(NULL));
    rgn_assignment();
    rgn_check();
    print_array();
    return 0;
}
