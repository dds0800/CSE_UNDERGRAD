/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang CSE 1320
 * Homework 8 Task 2
 * This program is an implementation of the Selection sorting algorithm.
 * The program will sort 100 integers stored in an array using the Selection algorithm.
 */

#include <stdio.h>

#define MAX 100

void select(int random_array[MAX])
{
    int i,j,key,key2,max;

    max=MAX-1;

    for (i=0;i<max;i++)
    {
        key=random_array[i];
        key2=i;

        for (j=i+1;j<=max;j++)
        {
            if (random_array[j]<key)
            {
                key=random_array[j];
                key2=j;
            }
        }
        random_array[key2]=random_array[i];
        random_array[i]=key;
    }

    printf("After the Selection sorting algorithm is applied\nthese are the numbers of the sorted array.\n\n");

    for (i=0;i<MAX;i++)
    {
        if (i%5==0 && i!=0)
            printf("\n");

        printf("%d\t",random_array[i]);
    }

    printf("\n\n");

}

int main(void)
{
    int i,random[MAX];
    time_t t;
    srand((unsigned) time(&t));
    char user_inp='y';

    while(user_inp=='y' || user_inp=='Y')
    {
        for (i=0;i<MAX;i++)
        {
            random[i]=rand();
        }

        printf("These are the random numbers in the array.\n\n");

        for (i=0;i<MAX;i++)
        {
            if (i%5==0 && i!=0)
                printf("\n");

            printf("%d\t",random[i]);
        }

        printf("\n\n");

        select(random);

        printf("Would you like to try again? Please press y or n\n");
        fflush(stdin);
        scanf("%c",&user_inp);
        fflush(stdin);

        while((user_inp!='n' && user_inp!='N') && (user_inp!='y' && user_inp!='Y'))
        {
            printf("Invalid input, please try again.\n\n");
            fflush(stdin);
            scanf("%c",&user_inp);
            fflush(stdin);
        }

        if(user_inp=='n' || user_inp=='N')
            break;
    }

    return 0;
}
