/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang CSE 1320
 * Homework 4 Task 1
 * Description: Plays the game of Muk Jji Ppa
 */

 #include <stdio.h>


 //Choices that the computer and user make

 #define ROCK 'r'
 #define PAPER 'p'
 #define SCISSORS 's'
 #define QUIT 'q'
 #define BELL 7

 int i=1; // Loop counter for game

 void welcome_message() // Welcomes user to game and explains rules of game
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

     return;
 }

 int generate_number() // Generate a random number that will represent the computer's choice
 {
    int nRand; // Declaration of random number variable
    time_t t;
    srand((unsigned) time(&t));
    nRand = rand()%3; // Generation of random number
    return nRand; // Return the random number

 }

 char computer_choice(int rand_num) // Takes random number from the generate_number function and turns it into rock paper or scissors.
 {
     char comp_choice;

     switch(rand_num)
     {
        case 0:
            comp_choice='r';
            break;
        case 1:
            comp_choice='p';
            break;
        case 2:
            comp_choice='s';
            break;
     }
     return comp_choice;
 }

 void display_rps()
 {
    printf("%cRock!\t",BELL); //Rock, Paper, Scissors!
    fflush(stdout);
    _sleep(1000);
    printf("%cPaper!\t",BELL);
    fflush(stdout);
    _sleep(1000);
    printf("%cScissors!\n",BELL);
    fflush(stdout);
    _sleep(1000);
    fflush(stdin);
     return;
 }

 char user_input() // Ask the user for their input
 {
     char user_inp;

     printf("What will you choose?\n");
     fflush(stdin);
     scanf("%c",&user_inp);
     return user_inp;
 }

 void user_attack(char user_guess, char comp_guess) // This function will be called when its the user's turn to attack.
 {
    char user_continue;

    int comp_num;

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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                user_attack(user_guess,comp_guess);
            }

        else if (comp_guess==ROCK)
                {
                fflush(stdin);
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("You win!!!\n");
                printf("%c",BELL);
                printf("%c",BELL);
                printf("%c",BELL);
                printf("%c",BELL);
                printf("\n");
                printf("Do you want to play again? Press any key or press q to quit\n");
                user_continue=user_input();
                switch (user_continue)
                {
                case QUIT:
                printf("\n");
                printf("Thanks for playing!\n");
                i=0;
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                computer_attack(user_guess,comp_guess);
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                user_attack(user_guess,comp_guess);
            }

        else if (comp_guess==PAPER)
            {
                fflush(stdin);
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("You win!!!\n");
                printf("%c",BELL);
                printf("%c",BELL);
                printf("%c",BELL);
                printf("%c",BELL);
                printf("\n");
                printf("Do you want to play again? Press any key or press q to quit\n");
                user_continue=user_input();
                switch (user_continue)
                {
                case QUIT:
                    printf("\n");
                    printf("Thanks for playing!\n");
                    i=0;
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                computer_attack(user_guess,comp_guess);
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                user_attack(user_guess,comp_guess);
            }

        else if (comp_guess==SCISSORS)
            {
                fflush(stdin);
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("You win!!!\n");
                printf("%c",BELL);
                printf("%c",BELL);
                printf("%c",BELL);
                printf("%c",BELL);
                printf("\n");
                printf("Do you want to play again? Press any key or press q to quit\n");
                user_continue=user_input();
                switch (user_continue)
                {
                case QUIT:
                printf("\n");
                printf("Thanks for playing!\n");
                i=0;
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                computer_attack(user_guess,comp_guess);
            }
        printf("\n");
        break;

    default:
    fflush(stdin);
    printf("I don't know what that is... let's try again...\n");
    user_guess=user_input();
    comp_num=generate_number();
    comp_guess=computer_choice(comp_num);
    user_attack(user_guess,comp_guess);
    }

    return;
 }

 void computer_attack(char user_guess,char comp_guess)
 {
    int comp_num;

    char user_continue;

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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                user_attack(user_guess,comp_guess);
            }

        else if (comp_guess==ROCK)
                {
                fflush(stdin);
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("You lose...\n");
                printf("%c",BELL);
                printf("\n");
                printf("Do you want to play again? Press any key or press q to quit\n");
                user_continue=user_input();
                switch (user_continue)
                {
                case QUIT:
                printf("\n");
                printf("Thanks for playing!\n");
                i=0;
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                computer_attack(user_guess,comp_guess);
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                user_attack(user_guess,comp_guess);
            }

        else if (comp_guess==PAPER)
            {
                fflush(stdin);
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("You lose...\n");
                printf("%c",BELL);
                printf("\n");
                printf("Do you want to play again? Press any key or press q to quit\n");
                user_continue=user_input();
                switch (user_continue)
                {
                case QUIT:
                    printf("\n");
                    printf("Thanks for playing!\n");
                    i=0;
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                computer_attack(user_guess,comp_guess);
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                user_attack(user_guess,comp_guess);
            }

        else if (comp_guess==SCISSORS)
            {
                fflush(stdin);
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("You lose...\n");
                printf("%c",BELL);
                printf("\n");
                printf("Do you want to play again? Press any key or press q to quit\n");
                user_continue=user_input();
                switch (user_continue)
                {
                case QUIT:
                printf("\n");
                printf("Thanks for playing!\n");
                i=0;
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
                display_rps();
                user_guess=user_input();
                comp_guess=generate_number();
                comp_guess=computer_choice(comp_num);
                computer_attack(user_guess,comp_guess);
            }
        printf("\n");
        break;

    default:
    fflush(stdin);
    printf("I don't know what that is... let's try again...\n");
    user_guess=user_input();
    comp_num=generate_number();
    comp_guess=computer_choice(comp_num);
    computer_attack(user_guess,comp_guess);
    }
     return;
 }

 void game_start()
 {
     char user_guess,comp_guess;

     int comp_num;

     display_rps();
     comp_num=generate_number();
     comp_guess=computer_choice(comp_num);
     user_guess=user_input();
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                user_attack(user_guess,comp_guess);
            }

        else if (comp_guess==ROCK)
            {
                fflush(stdin);
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("Draw...\n");
                game_start();
                }

        else
            {
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("The computer is going to attack!\n");
                printf("You are on defense.\n");
                _sleep(1000);
                _sleep(1000);
                _sleep(1000);
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                computer_attack(user_guess,comp_guess);
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                user_attack(user_guess,comp_guess);
            }

        else if (comp_guess==PAPER)
            {
                fflush(stdin);
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("Draw...\n");
                game_start();

            }

        else
            {
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("The computer is going to attack!\n");
                printf("You are on defense.\n");
                _sleep(1000);
                _sleep(1000);
                _sleep(1000);
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                computer_attack(user_guess,comp_guess);
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
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                user_attack(user_guess,comp_guess);
            }

        else if (comp_guess==SCISSORS)
            {
                fflush(stdin);
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("You lose...\n");
                printf("Draw...\n");
                game_start();
            }

        else
            {
                printf("You: %c Computer: %c\n",user_guess,comp_guess);
                printf("The computer is going to attack!\n");
                printf("You are on defense.\n");
                _sleep(1000);
                _sleep(1000);
                _sleep(1000);
                display_rps();
                user_guess=user_input();
                comp_num=generate_number();
                comp_guess=computer_choice(comp_num);
                computer_attack(user_guess,comp_guess);
            }
        printf("\n");
        break;

    default:
    fflush(stdin);
    printf("I don't know what that is... let's try again...\n");
    user_guess=user_input();
    comp_num=generate_number();
    comp_guess=computer_choice(comp_num);
    computer_attack(user_guess,comp_guess);
    }

     return;
 }

 int main(void) // The combinations of functions that make the game
 {

     welcome_message();

     while(i)
     {
         game_start();
     }

     return 0;
 }
