/*
* Daniel Singh
* UTA ID: 1000930800
* Prof. Kang CSE 1320
* Homework 2 Task 2
* This program is a number guessing game where
* the user must guess a random number between
* one and one hundred. The user has only six tries
* to guess the number, otherwise game over.
*/

#include <stdio.h> // Include standard library for printf and scanf functions

#define BELL_SOUND 7 // This sound will play win the user guesses correctly

int main(void)
{
    printf("Welcome to the Number Guessing game!\n"); // Explanation of rules to user
    printf("\n");
    printf("1. You have six tries to guess a number between 1 and 100.\n");
    printf("2. If you use all six tries and cannot guess the number... you lose.\n");
    printf("3. Whenever you guess a wrong number, I'll let you know if you guessed to high\n");
    printf("or too low.\n");
    printf("\n");
    printf("If you win... then you're just really good at guessing numbers...\n"); // This is a joke
    printf("\n");
    printf("Good Luck!\n");
    printf("\n");

    time_t t; // Generation of random number
    int nRand;
    srand((unsigned) time(&t));
    nRand = rand();

    if (nRand > 100) //Checking to see if random number is between 1 and 100.
    {
        while (nRand > 100) //Generate numbers until a number between 1 and 100 is found.
        {
            nRand=rand();
        }
    }


    printf("Okay I got the number!\n");  // Good number is found
    printf("\n");

    int i=6; // Loop counter and user input declaration
    int user_guess; // User input

    while (i>0) // Game Start
    {
        printf("What is your guess?\n"); // Prompts user to enter number
        scanf("%d",&user_guess);
        printf("\n");

        if ((user_guess)!=(nRand)) // If the user did not find the number
        {
            i-=1;
            if (((user_guess)>(nRand))&&(user_guess<=100)) // If guess is to high
            {
                printf("Too high, try again\n");
            }

            else if ((user_guess>100)||(user_guess<1)) // If the user inputs that is not between 1 and 100
            {
                printf("Invalid Guess, try again\n");
            }

            else
            {
                printf("Too Low, try again\n"); // If guess is to low
            }
            printf("\n");
            printf("Guesses Left: %d\n",i);
            printf("\n");
        }

        else
        {
            printf("You got it!!!\n"); // if the user guesses correctly
            for(i=0;i<5;i+=1)
                printf("%c",BELL_SOUND); // Victory Sound
            break;
        }
    }
    if (user_guess!=nRand) // Displays if user uses up all guesses
    {
        printf("Sorry... you lose.\n");
        printf("\n");
        printf("The number was %d.\n",nRand); // Shows the user the number they did not guess
    }

    return 0;
}
