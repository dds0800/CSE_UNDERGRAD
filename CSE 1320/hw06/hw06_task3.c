/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang CSE 1320
 * Homework 6 Task 3 (Bonus)
 * This program is an improvement on task 2 in which the user can actually
 * interact with the records. The record is considered an integer number and the user
 * cannot change or delete records until the record database is full.
 */

#include <stdio.h>

#define ADD 1 // These constants correspond to user input
#define CHANGE 2
#define DELETE 3
#define QUIT 4

int pass=0; // This global variable helps with deleting a record, the adding a new one

int check_input(int input) // This function is a recursive function that checks the user's input
{
    if((input<=4) && (input>=1)) // If the input is within range, return the good value
        return input;
    else // If the input is not valid, ask the user for a valid input, then check the input again
    {
        printf("\n");
        printf("Invalid input, please try a different selection: ");
        fflush(stdin);
        scanf("%d",&input);
        fflush(stdin);
        printf("\n");
        return check_input(input);
    }
}

int check_record(int input) // This function is a recursive function that checks the user's input
{
    if((input<=5) && (input>=1)) // If the input is within range, return the good value
        return input;
    else // If the input is not valid, ask the user for valid input and check the input again
    {
        printf("\n");
        printf("Invalid record, please select a record: ");
        fflush(stdin);
        scanf("%d",&input);
        fflush(stdin);
        printf("\n");
        return check_input(input);
    }
}

void display_message(int count, int *pointer) // This function is the menu of the record system. In nature, this function is recursive until the user in finished
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
    fflush(stdin);
    user_input=check_input(user_input);

    switch(user_input) // This statement will determine want the user wants to do
    {
        case ADD: // If the user wishes to add a record...

            if(count==5) // If the database is full, the user needs to delete or change a record
            {
                printf("Records are full, please change or delete a record.\n");
                printf("\n");
                display_message(count,pointer);
            }

            else // If the database is not full, input a record into the array
            {
                fflush(stdin);
                printf("Please add a record...");
                scanf("%d",(pointer+count));
                fflush(stdin);
                printf("\n");
                printf("Press enter to continue.\n");
                getchar();
                printf("\n");
                count+=1;
                if (pass) // If the user deleted a record, the database is now considered full
                    display_message(5,pointer);
                else // If the user haven't deleted the record the data base is not full
                    display_message(count,pointer);
                // Because I use the count variable for a counter and index, I had to create the pass variable
            }
            break;
        case CHANGE: // If the user wished to change a record...
            if(count<5) // The database must be filled first
            {
                printf("You cannot change any records until the database if full.\n");
                printf("Please try again.\n");
                printf("\n");
                display_message(count,pointer);
            }

            else // If the database is full
            {
                fflush(stdin);
                for(i=0;i<5;i+=1) // Show the user the records and their values
                {
                    printf("Record %d: %d ",i+1,*(pointer+i));
                }
                printf("\n");
                printf("Which record do you wish to change? "); // Prompt the user for a record
                fflush(stdin);
                scanf("%d",&user_input);
                fflush(stdin);
                printf("\n");
                user_input=(check_record(user_input))-1; // Check if input is valid then subtract one to get a number that is a valid index
                printf("Please input a new record: "); // Prompt the user to put in a new record
                fflush(stdin);
                scanf("%d",pointer+user_input);
                fflush(stdin);
                printf("\n");
                printf("Press enter to continue.\n");
                getchar();
                printf("\n");
                display_message(count,pointer);
            }
            break;
        case DELETE: // If the user wishes to delete a record...
             if(count<5) // The user cannot delete a record until the database is empty
             {
                printf("You cannot delete any records until the database if full.\n");
                printf("Please try again.\n");
                printf("\n");
                display_message(count,pointer);
             }
             else // If the database is full, then the user can delete a record
             {
                pass=1; // The variable helps when adding a new record later
                fflush(stdin);
                for(i=0;i<5;i+=1) // Show the user the records and their values
                {
                    printf("Record %d: %d ",i+1,*(pointer+i));
                }
                printf("\n");
                printf("Which record do you wish to delete? "); // Prompt the user for a record to delete
                fflush(stdin);
                scanf("%d",&user_input);
                fflush(stdin);
                printf("\n");
                user_input=(check_record(user_input))-1; // Check to see if input is valid, the subtract one to get a valid index for the array
                count=user_input;
                (*(pointer+user_input))=NULL; // The record the user chose is now empty
                printf("Record is now deleted.\n");
                printf("Press enter to continue.\n");
                getchar();
                printf("\n");
                display_message(count,pointer);
             }
             break;
        case QUIT: // If the user wishes to quit...
            printf("\n");
            printf("Thanks for using the Singh Record System!\n"); // Thanks for using my program!
            printf("\n");
            user_input=5;
            break;
    }
}

int main(void) // Main Function
{
    int count=0, rgn_records[5];
    int *rgn_address=&rgn_records;

    printf("Welcome to the Singh Record System!\n"); // Welcome the user to the system and give them directions
    printf("Please follow the prompts to edit the records in the database.\n");
    printf("You cannot change or delete a record until the entire database is full.\n");
    printf("Press enter to continue.\n");
    fflush(stdin);
    getchar();
    fflush(stdin);
    printf("\n");

    display_message(count,rgn_address); // Function call to record system

    return 0;
}
