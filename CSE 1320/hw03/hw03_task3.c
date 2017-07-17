/*
* Daniel Singh
* UTA ID: 1000930800
* Prof. Kang CSE 1320
* Homework 3 Task 3
* This program is the game of Muk-Jji-Ppa.
*/

#include <stdio.h>

#define ROCK 'r'
#define PAPER 'p'
#define SCISSORS 's'
#define QUIT 'q'
#define BELL_SOUND 7

int main(void)
{
    printf("Let's play Muk, Jji, Ppa\n"); // Explanation of game to user
    printf("\n");
    printf("This game is very similar to rock, paper scissors.\n");
    printf("1. We'll both choose either rock, paper, or scissors at random.\n");
    printf("2. 'r' is for Rock, 'p' is for Paper and 's' is for Scissors.\n");
    printf("3. The first round determines who attacks.\n");
    printf("4. The winner becomes the attack and the other person becomes the defender.\n");
    printf("5. The attacker's goal is for the defender to get the same hand as the attacker\n");
    printf("6. The defender's goal is to beat the attacker's hand so they can be on offense\n");
    printf("7. If the defender gets the same hand as the attacker, the attacker wins.\n");
    printf("\n");
    printf("Press enter to start"); // Gives user time to read the game's rules
    getchar();
    fflush(stdin);
    printf("\n");
    printf("Okay! Let's Play!\n");
    printf("\n");

    int nRand; // Random number to be used as the computers guess

    char comp_guess, user_guess; // Computer and user choices

    int i; // Loop counter for game

    for(i=1;i;) //Game Start
    {
        int battle_start=0;
        int user_attack=0;

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

        printf("%cRock!\t",BELL_SOUND); //Rock, Paper, Scissors!
        fflush(stdout);
        _sleep(1000);
        printf("%cPaper!\t",BELL_SOUND);
        fflush(stdout);
        _sleep(1000);
        printf("%cScissors!\n",BELL_SOUND);
        fflush(stdout);
        _sleep(1000);
        fflush(stdin);

        printf("\n");
        printf("What is your choice?\n"); // User inputs their choice
        scanf("%c",&user_guess);
        printf("\n");

        switch(user_guess)
        {
            case ROCK:
                if (comp_guess==SCISSORS)
                {
                    battle_start=1;
                    user_attack=1;
                    printf("You: %c Computer: %c\n",user_guess,comp_guess);
                    printf("You are going to attack!\n");
                    printf("The Computer is on defense.\n");
                    _sleep(1000);
                    _sleep(1000);
                    _sleep(1000);

                }

                else if (comp_guess==ROCK)
                {
                    printf("You: %c Computer: %c\n",user_guess,comp_guess);
                    printf("Draw... Let's try again\n");
                }

                else
                {
                    battle_start=1;
                    printf("You: %c Computer: %c\n",user_guess,comp_guess);
                    printf("The computer is going to attack!\n");
                    printf("You are on defense.\n");
                    _sleep(1000);
                    _sleep(1000);
                    _sleep(1000);
                }
                printf("\n");
                break;

            case PAPER:
                if (comp_guess==ROCK)
                {
                    battle_start=1;
                    user_attack=1;
                    printf("You: %c Computer: %c\n",user_guess,comp_guess);
                    printf("You are going to attack!\n");
                    printf("The Computer is on defense.\n");
                    _sleep(1000);
                    _sleep(1000);
                    _sleep(1000);

                }

                else if (comp_guess==PAPER)
                {
                    printf("You: %c Computer: %c\n",user_guess,comp_guess);
                    printf("Draw... Let's try again\n");
                }

                else
                {
                    battle_start=1;
                    printf("You: %c Computer: %c\n",user_guess,comp_guess);
                    printf("The computer is going to attack!\n");
                    printf("You are on defense.\n");
                    _sleep(1000);
                    _sleep(1000);
                    _sleep(1000);
                }
                printf("\n");
                break;

                case SCISSORS:
                if (comp_guess==PAPER)
                {
                    battle_start=1;
                    user_attack=1;
                    printf("You: %c Computer: %c\n",user_guess,comp_guess);
                    printf("You are going to attack!\n");
                    printf("The Computer is on defense.\n");
                    _sleep(1000);
                    _sleep(1000);
                    _sleep(1000);

                }

                else if (comp_guess==SCISSORS)
                {
                    printf("You: %c Computer: %c\n",user_guess,comp_guess);
                    printf("Draw... Let's try again\n");
                }

                else
                {
                    battle_start=1;
                    printf("You: %c Computer: %c\n",user_guess,comp_guess);
                    printf("The computer is going to attack!\n");
                    printf("You are on defense.\n");
                    _sleep(1000);
                    _sleep(1000);
                    _sleep(1000);
                }
                printf("\n");
                break;

                default:
                    printf("I don't know what that is... let's try again...\n");
        }

            while (battle_start)
            {
                char user_continue;

                 printf("\n");
                printf("The Battle will now start!!!\n");
                _sleep(1000);
                _sleep(1000);
                _sleep(1000);

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

                printf("%cRock!\t",BELL_SOUND); //Rock, Paper, Scissors!
                fflush(stdout);
                _sleep(1000);
                printf("%cPaper!\t",BELL_SOUND);
                fflush(stdout);
                _sleep(1000);
                printf("%cScissors!\n",BELL_SOUND);
                fflush(stdout);
                _sleep(1000);
                fflush(stdin);

                printf("\n");
                printf("What is your choice?\n"); // User inputs their choice
                scanf("%c",&user_guess);
                printf("\n");

                if (user_attack)
                {
                    switch(user_guess)
                    {
                        case ROCK:
                            if (comp_guess==SCISSORS)
                            {
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You are going to attack!\n");
                                printf("The Computer is on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);

                            }

                            else if (comp_guess==ROCK)
                            {
                                fflush(stdin);
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You win!!!\n");
                                printf("%c",BELL_SOUND);
                                printf("%c",BELL_SOUND);
                                printf("%c",BELL_SOUND);
                                printf("%c",BELL_SOUND);
                                printf("\n");
                                printf("Do you want to play again? Press any key or press q to quit\n");
                                scanf("%c",&user_continue);
                                switch (user_continue)
                                {
                                case QUIT:
                                    battle_start=0;
                                    i=0;
                                    printf("\n");
                                    printf("Thanks for playing!\n");
                                    break;
                                default:
                                    printf("\n");
                                    printf("Let's go again!\n");

                                }
                            }

                            else
                            {
                                user_attack=0;
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("The computer is going to attack!\n");
                                printf("You are on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);
                            }
                            printf("\n");
                            break;

                        case PAPER:
                            if (comp_guess==ROCK)
                            {
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You are going to attack!\n");
                                printf("The Computer is on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);

                            }

                            else if (comp_guess==PAPER)
                            {
                                fflush(stdin);
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You win!!!\n");
                                printf("%c",BELL_SOUND);
                                printf("%c",BELL_SOUND);
                                printf("%c",BELL_SOUND);
                                printf("%c",BELL_SOUND);
                                printf("\n");
                                printf("Do you want to play again? Press any key or press q to quit\n");
                                scanf("%c",&user_continue);
                                switch (user_continue)
                                {
                                case QUIT:
                                    i=0;
                                    battle_start=0;
                                    printf("\n");
                                    printf("Thanks for playing!\n");
                                    break;
                                default:
                                    printf("\n");
                                    printf("Let's go again!\n");

                                }

                            }

                            else
                            {
                                user_attack=0;
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("The computer is going to attack!\n");
                                printf("You are on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);
                            }
                            printf("\n");
                            break;

                            case SCISSORS:
                            if (comp_guess==PAPER)
                            {
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You are going to attack!\n");
                                printf("The Computer is on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);

                            }

                            else if (comp_guess==SCISSORS)
                            {
                                fflush(stdin);
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You win!!!\n");
                                printf("%c",BELL_SOUND);
                                printf("%c",BELL_SOUND);
                                printf("%c",BELL_SOUND);
                                printf("%c",BELL_SOUND);
                                printf("\n");
                                printf("Do you want to play again? Press any key or press q to quit\n");
                                scanf("%c",&user_continue);
                                switch (user_continue)
                                {
                                case QUIT:
                                    i=0;
                                    battle_start=0;
                                    printf("\n");
                                    printf("Thanks for playing!\n");
                                    break;
                                default:
                                    printf("\n");
                                    printf("Let's go again!\n");

                                }
                            }

                            else
                            {
                                user_attack=0;
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("The computer is going to attack!\n");
                                printf("You are on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);
                            }
                            printf("\n");
                            break;

                            default:
                            fflush(stdin);
                            printf("I don't know what that is... let's try again...\n");
                    }

                }

                else
                {
                    switch(user_guess)
                    {
                        case ROCK:
                            if (comp_guess==SCISSORS)
                            {
                                user_attack=1;
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You are going to attack!\n");
                                printf("The Computer is on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);

                            }

                            else if (comp_guess==ROCK)
                            {
                                fflush(stdin);
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You lose...\n");
                                printf("%c",BELL_SOUND);
                                printf("\n");
                                printf("Do you want to play again? Press any key or press q to quit\n");
                                scanf("%c",&user_continue);
                                switch (user_continue)
                                {
                                case QUIT:
                                    i=0;
                                    battle_start=0;
                                    printf("\n");
                                    printf("Thanks for playing!\n");
                                    break;
                                default:
                                    printf("\n");
                                    printf("Let's go again!\n");

                                }
                            }

                            else
                            {
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("The computer is going to attack!\n");
                                printf("You are on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);
                            }
                            printf("\n");
                            break;

                        case PAPER:
                            if (comp_guess==ROCK)
                            {
                                user_attack=1;
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You are going to attack!\n");
                                printf("The Computer is on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);

                            }

                            else if (comp_guess==PAPER)
                            {
                                fflush(stdin);
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You lose...\n");
                                printf("%c",BELL_SOUND);
                                printf("\n");
                                printf("Do you want to play again? Press any key or press q to quit\n");
                                scanf("%c",&user_continue);
                                switch (user_continue)
                                {
                                case QUIT:
                                    i=0;
                                    battle_start=0;
                                    printf("\n");
                                    printf("Thanks for playing!\n");
                                    break;
                                default:
                                    printf("\n");
                                    printf("Let's go again!\n");

                                }

                            }

                            else
                            {
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("The computer is going to attack!\n");
                                printf("You are on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);
                            }
                            printf("\n");
                            break;

                            case SCISSORS:
                            if (comp_guess==PAPER)
                            {
                                user_attack=1;
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You are going to attack!\n");
                                printf("The Computer is on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);

                            }

                            else if (comp_guess==SCISSORS)
                            {
                                fflush(stdin);
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("You lose...\n");
                                printf("%c",BELL_SOUND);
                                printf("\n");
                                printf("Do you want to play again? Press any key or press q to quit\n");
                                scanf("%c",&user_continue);
                                switch (user_continue)
                                {
                                case QUIT:
                                    i=0;
                                    battle_start=0;
                                    printf("\n");
                                    printf("Thanks for playing!\n");
                                    break;
                                default:
                                    printf("\n");
                                    printf("Let's go again!\n");

                                }
                            }

                            else
                            {
                                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                                printf("The computer is going to attack!\n");
                                printf("You are on defense.\n");
                                _sleep(1000);
                                _sleep(1000);
                                _sleep(1000);
                            }
                            printf("\n");
                            break;

                            default:
                            printf("I don't know what that is... let's try again...\n");
                    }

                }

            }
    }

    return 0;
}



