/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang
 * CSE 1320
 * Homework 8 Task 3
 * This task is similar to homework 7. Instead of using an array to store books
 * the books will be stored using linked lists.
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MENMAX 4

enum OPTIONS // This enumeration will be used in conjunction with user input
{
    ADD=1,
    REMOVE,
    DISPA,
    EXIT,
};

enum MONTHS // This enumeration relates the integers 1-12 with the months of the year.
{
    JAN=1,
    FEB,
    MAR,
    APR,
    MAY,
    JUN,
    JUL,
    AUG,
    SEP,
    OCT,
    NOV,
    DEC,
};

struct date // This structure will be used with the Book structure
{
    int year;
    int month;
    int day;
};

typedef struct
{
    int ISBN;
    char title[100];
    char type[50];
    char publisher[100];
    int pages;
    float price;
    int published;
    int status;
    char name[100];
    struct date date;
}Books;

struct Node
{
    Books book;
    struct Node *next;
};

typedef struct Node Node;

Node *header=NULL;

int display_menu() // This function will display the menu to the user or show menu options in array if set to debug
{
    char *menu[MENMAX]; // The character pointer array contains the menu options as its elements.
    int i,input;
    menu[0]="Add a new book";
    menu[1]="Remove a book";
    menu[2]="Display all book details";
    menu[3]="Exit";


        printf("Please enter an option\n\n");

        for (i=0;i<MENMAX;i+=1)
        {
            printf("%d: %s\n",i+1,menu[i]); // Print the menu options to user
        }

        fflush(stdin);
        scanf("%d",&input);
        printf("\n");

        while ((input>MENMAX) || (input<1)) // This loop will check to see if user input is valid
        {
            printf("Invalid input, please input a number from 1 to %d.\n",MENMAX);
            fflush(stdin);
            scanf("%d",&input);
            printf("\n");
        }

    return input; // Return the input to call a function within a switch statement in the main function
}

void add_book() // This function will create a node and add information to ins structure
{
    int ISBN,page_num,pub_year,check_out,book_time=0,i,not_leap=1;
    char book_name[100],is_out;
    float book_price;
    Node *current;

    current=(Node*)malloc(sizeof(Node)); // Creation of node
    current->next=header;
    header=current;

    printf("Please input a ISBN number.\n"); // Prompt the user to input an ISBN number
    fflush(stdin);
    scanf("%d",&ISBN);
    printf("\n");

    while ((ISBN>9999999999) || (ISBN<1000000000)) // This loop will see if the input has enough digits
    {
        printf("Invalid ISBN, please input a 10 digit ISBN\n");
        fflush(stdin);
        scanf("%d",&ISBN);
        printf("\n");
    }

    current=current->next;

    while(current) // This loop will check to see if the ISBN already exists within the database
    {
        if ((current->book.ISBN)==ISBN) // If an ISBN already exists, ask the user to input a new ISBN
        {
            printf("The book is currently in the library, please enter a different ISBN\n");
            fflush(stdin);
            scanf("%d",&ISBN);
            printf("\n");
            current=header->next;
        }

        current=current->next;
    }

    current=header;

    current->book.ISBN=ISBN; // Once the ISBN has been checked for duplication and validity, add the title to the node

    printf("Please enter a book title\n"); // Ask the user to input a book title
    fflush(stdin);
    fgets(book_name,100,stdin);
    strcpy(current->book.title,book_name); // Copy the title to the node

    printf("\n");

    printf("What is the category for the book?\n"); // Ask the user to input a book category
    fflush(stdin);
    fgets(&book_name[0],50,stdin);
    strcpy(current->book.type,book_name); // Copy the category to the node

    printf("\n");

    printf("Who is the publisher?\n"); // Ask the user to input the book's publisher
    fflush(stdin);
    fgets(&book_name[0],100,stdin);
    strcpy(current->book.publisher,book_name); // Copy the publisher name to the Book structure

    printf("\n");

    printf("How many pages are in the book?\n"); // Ask the user to input the number of pages within a book
    fflush(stdin);
    scanf("%d",&page_num);
    printf("\n");

    while (page_num<=0)
    {
        printf("Invalid number of pages, please input a number greater than zero\n");
        fflush(stdin);
        scanf("%d",&page_num);
        printf("\n");
    }

    current->book.pages=page_num; // Copy the number of pages to the node once number is valid.

    printf("Please enter the price of the book\n"); // Ask the user to input the book's price
    fflush(stdin);
    scanf("%f",&book_price);
    printf("\n");

    while (book_price<=0)
    {
        printf("Invalid book price, please enter a dollar amount larger than zero.\n");
        fflush(stdin);
        scanf("%f",&book_price);
        printf("\n");
    }

    current->book.price=book_price; // Copy the price to the Book structure once number is valid

    printf("Please enter the year the book was published\n"); // Ask the user to input a book title
    fflush(stdin);
    scanf("%d",&pub_year);
    printf("\n");

    while (pub_year<1500 || pub_year>2014)
    {
        printf("Invalid year, please enter a year before the 16th century and after 2014.\n"); // I'm not really sure how old the oldest book is. So I decided to put the 16th century.
        fflush(stdin);
        scanf("%d",&pub_year);
        printf("\n");
    }

    current->book.published=pub_year; // Copy the publisher year to the Book structure once number is valid

    printf("Is the book already checked out? Please type in y or n then press enter.\n"); // Ask the user to input a book title
    fflush(stdin);
    scanf("%c",&is_out);
    fflush(stdin);
    printf("\n");

    while (1) // This loop will check to see if user input for the status of the book is valid
    {

        if ((is_out=='Y') || (is_out=='y')) // If the user says yes, the book is checked out.
        {
            check_out=1; // This variable indicates the book is checked out,
            break;
        }
        else if ((is_out=='N') || (is_out=='n')) // If the user says no, then the book is not checked out.
        {
            check_out=0;
            break;
        }
        else // If the input is invalid, ask the user to try again and the input will be checked again during the next iteration.
        {
            printf("Invalid input, please input y or n then press enter.\n");
            fflush(stdin);
            scanf("%c",&is_out);
            fflush(stdin);
            printf("\n");
        }

    }

    current->book.status=check_out; // Copy the availability of the book to the Book structure

    if (check_out==1) // If the book is check out, ask the user for the name of the person and the books due date.
    {
        printf("What is the name of the person that checked out the book?\n");
        fflush(stdin);
        fgets(book_name,100,stdin);
        strcpy(current->book.name,book_name);
        printf("\n");
        printf("What is the due date for the check out book?\n");
        printf("Please enter month.\n");
        fflush(stdin);
        scanf("%d",&book_time);
        printf("\n");
        while (book_time<1 || book_time>12) // This loop will check to see if the user inputs a valid month
        {
            printf("Invalid Month, please enter a number between 1 and 12.\n");
            fflush(stdin);
            scanf("%d",&book_time);
            printf("\n");
        }

        current->book.date.month=book_time; //Assign the month the the structure

        printf("What year what the book checked out?\n"); // Ask the user for the year
        printf("Please enter a year.\n");
        fflush(stdin);
        scanf("%d",&book_time);
        printf("\n");

        while ((book_time<1500) || (book_time>2014)) // Books must be from before the 16th century and during this year.
        {
            printf("Invalid year, please enter a year before the 16th century and after 2014.\n"); // I'm not really sure how old the oldest book is. So I decided to put the 16th century.
            fflush(stdin);
            scanf("%d",&book_time);
            printf("\n");
        }

        current->book.date.year=book_time; // Assign the year to the structure

        printf("What day was the book checked out?\n"); // Ask the user for the day
        printf("Please enter a day.\n");
        fflush(stdin);
        scanf("%d",&book_time);
        printf("\n");

        if (current->book.date.month==FEB) // If the month is February...
        {
            if (current->book.date.year%4==0) // These if statements check to see if the year of the current book is a leap year..
            {
                if(current->book.date.year%100==0)
                {
                    if (current->book.date.year%400==0)
                    {
                        not_leap=0;
                        while ((book_time<1) || (book_time>29)) //... If a leap year, check to see if the user input is valid
                        {
                            printf("Invalid day, please enter a number between 1 and 29\n");
                            printf("%d is a leap year.\n",current->book.date.year);
                            fflush(stdin);
                            scanf("%d",&book_time);
                            printf("\n");
                        }
                    }
                }

                else
                {
                    not_leap=0;
                    while ((book_time<1) || (book_time>29)) //... If a leap year, check to see if the user input is valid
                    {
                        printf("Invalid day, please enter a number between 1 and 29\n");
                        printf("%d is a leap year.\n",current->book.date.year);
                        fflush(stdin);
                        scanf("%d",&book_time);
                        printf("\n");
                    }
                }
            }

            if (not_leap) // If not a leap year, February only has 28 days
            {
                while ((book_time<1) || (book_time>28))
                {
                    printf("Invalid day, please enter a number between 1 and 28\n");
                    fflush(stdin);
                    scanf("%d",&book_time);
                    printf("\n");
                }
            }
        }

        if((current->book.date.month==APR || current->book.date.month==JUN) || ((current->book.date.month==SEP)||(current->book.date.month==NOV)) ) // This statement is for months that have 30 days
        {
            while ((book_time<1) || (book_time>30))
            {
                printf("Invalid day, please enter a number between 1 and 30\n");
                fflush(stdin);
                scanf("%d",&book_time);
                printf("\n");
            }
        }

        else // If the current book's month is not any of the months with 30 days...
        {
            if (current->book.date.month!=FEB)//... and not February..
            {
                while ((book_time<1) || (book_time>31))
                {
                    printf("Invalid day, please enter a number between 1 and 31\n");
                    fflush(stdin);
                    scanf("%d",&book_time);
                    printf("\n");
                }
            }
        }

        current->book.date.day=book_time;
    }

    else // If the book is not checked out, then assign the following values to the structure
    {
        strcpy(current->book.name,"Not checked out yet.\n");
        current->book.date.day=0;
        current->book.date.month=0;
        current->book.date.year=0;
    }
}

void remove_book() // This function will remove a linked list
{
    int ISBN,found=0;
    Node *current=header,*Dummy;

    printf("Please enter the ISBN if the book you want to remove.\n"); // Prompt user for ISBN
    fflush(stdin);
    scanf("%d",&ISBN);
    printf("\n");

    while ((ISBN>9999999999) || (ISBN<1000000000)) // This loop will see if the input has enough digits
    {
        printf("Invalid ISBN, please input a 10 digit ISBN\n");
        fflush(stdin);
        scanf("%d",&ISBN);
        printf("\n");
    }

    while (current)
    {
        if (current->book.ISBN==ISBN)
        {
            found=1;
            break;
        }
        current=current->next;
    }

    if (!found)
    {
        printf("Book not found, now returning to main menu.\n\n");
        return;
    }

    else
    {
        if(current==header)
        {
            header=current->next;
            free(current);
            return;
        }

        else if(current->next==NULL)
        {
            Dummy=current;
            current=header;

            while (current)
            {
                if(current->next==Dummy)
                {
                    current->next=NULL;
                    free(Dummy);
                    break;
                }
                current=current->next;
            }
        }

        else
        {
            Dummy=current;
            current=header;

            while (current)
            {
                if(current->next==Dummy)
                {
                    current->next=Dummy->next;
                    free(Dummy);
                    break;
                }
                current=current->next;
            }
        }
    }
}

void display_in() // This function will display all linked lists
{
    Node *current=header;

    printf("\n\n");

    while (current)
    {
        printf("Title: %s\n",current->book.title);
        printf("ISBN: %d\n",current->book.ISBN);
        printf("Category: %s",current->book.type);
        printf("Publisher: %s",current->book.publisher);
        printf("Total number of pages: %d\n",current->book.pages);
        printf("Price: $%5.2f\n",current->book.price);
        printf("Year Published: %d\n",current->book.published);
        if (current->book.status==1)
            printf("Status: Checked out\n");
        else if (current->book.status==0)
            printf("Status: In Library\n");
        if (current->book.status==1)
            printf("Due Date: %d/%d/%d\n",current->book.date.month,current->book.date.day,current->book.date.year);
        printf("\n");
        current=current->next;
    }
}

void free_space() // This function deallocates the allocated memory.
{
    Node *current=header,*next_current;

    while (current)
    {
        next_current=current->next;
        free(current);
        current=next_current;
    }
}

int main(void)
{
    int choice,quit=1;

    printf("Welcome to the Singh Library Manager!\n");
    printf("Please follow the on-screen instructions to manage your library's books.\n\n");

    choice=display_menu(); // This function will display a menu to the user

    while (quit)
    {
        switch (choice)
        {
            case ADD:
                add_book();
                choice=display_menu();
                break;
            case REMOVE:
                remove_book();
                choice=display_menu();
                break;
            case DISPA:
                display_in();
                choice=display_menu();
                break;
            case EXIT:
                free_space();
                printf("Thank you for using Singh Library Manager\n");
                printf("Have a great day!\n");
                quit=0;
                break;
        }
    }
    return 0;
}
