/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang CSE 1320
 * Homework 6 Task 2
 * This program displays an interactive menu in which the user
 * must choose to add, delete, or edit a record. Once the user
 * is finished, the user has the option to quit.
 */

#include <stdio.h>

#define ADD 1 // These constants correspond to user input
#define CHANGE 2
#define DELETE 3
#define QUIT 4

int check_input(int input) // This function is a recursive function that checks the user's input
{
    if((input<=4) && (input>=1)) // If the input is within range, return the good value
        return input;
    else
    {
        printf("\n");
        printf("Invalid input, please try a different selection: ");
        fflush(stdin);
        scanf("%d",&input);
        printf("\n");
        return check_input(input);
    }
}

void display_message() // This function is the menu of the record system. In nature, this function is recursive until the user in finished
{
    char *psz_messages[4]={"1-Add a record","2-Change a record","3-Delete a record","4-Quit"}; // Array with messages for the user
    int i, user_input;

    for(i=0;i<4;i+=1) // This loop prints the options for the records to the user
    {
        printf("%s\n",psz_messages[i]);
    }

    printf("Please enter a selection: "); // Prompt the user for input
    fflush(stdin); // Clean input buffer for clean input
    scanf("%d",&user_input);
    user_input=check_input(user_input);

    switch(user_input) // This statement will determine want the user wants to do
    {
        case ADD: // If the user wishes to add a record...
            fflush(stdin);
            printf("Please add a record...\n");
            printf("Press enter to continue.\n");
            getchar();
            printf("\n");
            display_message();
            break;
        case CHANGE: // If the user wished to change a record...
            fflush(stdin);
            printf("Please change a record...\n");
            printf("Press enter to continue.\n");
            getchar();
            printf("\n");
            display_message();
            break;
        case DELETE: // If the user wishes to delete a record...
            fflush(stdin);
            printf("Please delete a record...\n");
            printf("Press enter to continue.\n");
            getchar();
            printf("\n");
            display_message();
            break;
        case QUIT: // If the user wishes to quit...
            printf("\n");
            printf("Thanks for using the Singh Record System!\n"); // Thanks for using my program!
    }
}

int main(void) // Main Function
{
    printf("Welcome to the Singh Record System!\n"); // Welcome the user to the system and give them directions
    printf("Please follow the prompts to edit the records in the database.\n");
    printf("Press enter to continue.\n");
    fflush(stdin);
    getchar();
    fflush(stdin);
    printf("\n");

    display_message(); // Function call to record system

    return 0;
}
