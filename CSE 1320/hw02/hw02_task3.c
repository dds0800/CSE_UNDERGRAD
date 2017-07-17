/*
* Daniel Singh
* UTA ID: 1000930800
* Prof. Kang CSE 1320
* Homework 2 Task 3
* This program is a rock paper scissors game. The game
* keeps track of the score between the user and computer
* and if the user loses, the user has the option to
* play another game (best two out of three) with out
* taking an immediate loss. The user can only use this once.
*/

#include <stdio.h>

#define ROCK 'r'
#define PAPER 'p'
#define SCISSORS 's'
#define QUIT 'q'
#define BELL_SOUND 7

int main(void)
{
    printf("Let's play some rock, paper, scissors!\n"); // Explanation of game to user
    printf("\n");
    printf("1. We'll both choose either rock, paper, or scissors at random.\n");
    printf("2. 'r' is for Rock, 'p' is for Paper and 's' is for Scissors.\n");
    printf("3. Press 'q' anytime to quit.\n");
    printf("4. If you lose the first time, you can choose to play best two\n");
    printf("out of three. (WHETHER YOU CHOOSE TO USE IT OR NOT YOU CANNOT USE IT AGAIN)\n");
    printf("\n");
    printf("Press enter to start"); // Gives user time to read the game's rules
    getchar();
    fflush(stdin);
    printf("\n");
    printf("Okay! Let's Play!\n");

    int nRand; // Random number to be used as the computers guess

    char comp_guess, user_guess; // Computer and user choices

    int user_score=0,comp_score=0; // Score between user and computer

    char user_continue; // For the best two out of three option

    int i; // Loop counter for game

    int best_23=1; // If the user wishes to try again

    for(i=1;i;) //Game Start
    {
        time_t t;
        srand((unsigned) time(&t));
        nRand = rand(); // Generation of random number

        while ((nRand<1) || (nRand>3) ) // Checks if number is between 1 and 3
        {
            nRand=rand(); // Generates number until  a number between 1 and 3 is found
        }

        switch(nRand) // Conversion of number to rock, paper, or scissors
        {
        case 1:
            comp_guess=ROCK;
            break;
        case 2:
            comp_guess=PAPER;
            break;
        case 3:
            comp_guess=SCISSORS;
            break;
        }

        printf("\n");
        printf("%c",BELL_SOUND);
        printf("The score is: You: %d  Computer: %d\n",user_score,comp_score); // Displays score to user
        printf("\n");
        _sleep(1000); // Gives user time to read the score
        _sleep(1000);
        _sleep(1000);

        printf("%cRock!\t",BELL_SOUND); //Rock, Paper, Scissors!
        fflush(stdout);
        _sleep(1000);
        printf("%cPaper!\t",BELL_SOUND);
        fflush(stdout);
        _sleep(1000);
        printf("%cScissors!\n",BELL_SOUND);
        fflush(stdout);
        _sleep(1000);

        printf("\n");
        printf("What is your choice?\n"); // User inputs their choice
        scanf("%c",&user_guess);
        printf("\n");


        switch(user_guess) //What the user chooses
        {
        case 'r': // If the user chooses rock
            {
                getchar();
                if ((user_guess)==(comp_guess)) // If choices are the same
                {
                    printf("You:%c Computer:%c Draw\n",user_guess,comp_guess);
                }
                else if (comp_guess=='p') // If computer beats user
                {
                    printf("You:%c Computer:%c You lose...\n",user_guess,comp_guess);
                    printf("\n");
                    comp_score+=1;

                    while (best_23)
                    {

                        printf("Do you want to do best two out of three? Type 'y' or 'n'\n");
                        scanf("%c",&user_continue);
                        printf("\n");
                        if (user_continue=='y') // If the user does not want to lose yet.
                        {
                            getchar();
                            printf("Let's go again\n");//Restart game again
                            comp_score-=1;
                            best_23=0;
                        }

                        else if (user_continue=='n') // User gives up
                        {
                            getchar();
                            best_23=0;
                            break;

                        }
                        else // If the user enters any other key
                        {
                            fflush(stdin);
                            printf("Invalid Choice\n");
                            printf("\n");
                            best_23=0;
                        }
                    }
                }
                else // If user beats computer
                {
                    user_score+=1;
                    printf("You:%c Computer:%c You Win!\n",user_guess,comp_guess);
                    printf("\n");
                }

                break;
            }
        case 'p':
            {
                getchar();
                if ((user_guess)==(comp_guess)) // If choices are the same
                {
                    printf("You:%c Computer:%c Draw\n",user_guess,comp_guess);
                }
                else if (comp_guess=='s') // If computer beats user
                {
                    printf("You:%c Computer:%c You lose...\n",user_guess,comp_guess);
                    printf("\n");
                    comp_score+=1;

                    while (best_23)
                    {
                        printf("Do you want to do best two out of three? Type 'y' or 'n'\n");
                        scanf("%c",&user_continue);
                        printf("\n");
                        if (user_continue=='y') // If the user does not want to lose yet.
                        {
                            getchar();
                            printf("Let's go again\n");//Restart game again
                            comp_score-=1;
                            best_23=0;
                        }

                        else if (user_continue=='n') // User gives up
                        {
                            getchar();
                            best_23=0;
                        }
                        else // If the user enters any other key
                        {
                            fflush(stdin);
                            printf("Invalid Choice\n");
                            printf("\n");
                            best_23=0;
                        }
                    }
                }
                else // If user beats computer
                {
                    user_score+=1;
                    printf("You:%c Computer:%c You Win!\n",user_guess,comp_guess);
                    printf("\n");
                }


                break;
            }
        case 's':
            {
                getchar();
                if ((user_guess)==(comp_guess)) // If choices are the same
                {
                    printf("You:%c Computer:%c Draw\n",user_guess,comp_guess);
                }
                else if (comp_guess=='r') // If computer beats user
                {
                    printf("You:%c Computer:%c You lose...\n",user_guess,comp_guess);
                    printf("\n");
                    comp_score+=1;

                    while (best_23)
                    {
                        printf("Do you want to do best two out of three? Type 'y' or 'n'\n");
                        scanf("%c",&user_continue);
                        printf("\n");
                        if (user_continue=='y') // If the user does not want to lose yet.
                        {
                            getchar();
                            printf("Let's go again\n");//Restart game again
                            comp_score-=1;
                            best_23=0;
                        }

                        else if (user_continue=='n') // User gives up
                        {
                            getchar();
                            best_23=0;
                        }
                        else // If the user enters any other key
                        {
                            fflush(stdin);
                            printf("Invalid Choice\n");
                            printf("\n");
                            best_23=0;
                        }
                    }
                }
                else // If user beats computer
                {
                    user_score+=1;
                    printf("You:%c Computer:%c You Win!\n",user_guess,comp_guess);
                    printf("\n");
                }


                break;
            }
        case 'q':
            {
                getchar();
                printf("Thanks for playing!\n");
                i=0;
                break;
            }
        default:
            {
                fflush(stdin);
                printf("I don't know what that is... let's try again...");
                printf("\n");
                break;
            }
        }
    }

    return 0;
}
