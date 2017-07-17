/*
 * Daniel Singh
 * UTA ID: 1000930800
 * Prof. Kang CSE 1320
 * Homework 7
 * This program is a library manager
 */

#include <stdio.h>
#include <string.h>

enum OPTIONS // This enumeration will be used in conjunction with user input
{
    ADD=1,
    REMOVE,
    OUT,
    IN,
    DISPD,
    DISPA,
    DISPC,
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

int dont_add[100];

int index=0;

int current_book=0; // This variable will be constantly updated and will be used as the next available space within the Book Array Structure

Books Book[100]; // This will be used as a database for 100 books

int display_menu() // This function will display the menu to the user or show menu options in array if set to debug
{
    char *menu[8]; // The character pointer array contains the menu options as its elements.
    int i,input;
    menu[0]="Add a new book";
    menu[1]="Remove a book";
    menu[2]="Check out a book";
    menu[3]="Check in a book";
    menu[4]="Display all book details";
    menu[5]="Display all available book details";
    menu[6]="Display all checked-out books";
    menu[7]="Exit";


        printf("Please enter an option\n\n");

        for (i=0;i<8;i+=1)
        {
            printf("%d: %s\n",i+1,menu[i]); // Print the menu options to user
        }

        fflush(stdin);
        scanf("%d",&input);
        printf("\n");

        while ((input>8) || (input<1)) // This loop will check to see if user input is valid
        {
            printf("Invalid input, please input a number from 1 to 8.\n");
            fflush(stdin);
            scanf("%d",&input);
            printf("\n");
        }

    return input; // Return the input to call a function within a switch statement in the main function
}

void add_book() // This function will add a book to the Book structure
{
    int ISBN,page_num,pub_year,check_out,book_time=0,i,not_leap=1;
    char book_name[100],is_out;
    float book_price;

    if (current_book>100)
    {
        printf("The database is full, please close program and try again or remove a book.\n");
        printf("Now returning to main menu.\n\n");
        return;
    }

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

    for (i=0;i<100;i+=1) // This loop will check to see if the ISBN already exists within the database
    {
        if ((Book[i].ISBN)==ISBN) // If an ISBN already exists, ask the user to input a new ISBN
        {
            printf("The book is currently in the library, please enter a different ISBN\n");
            fflush(stdin);
            scanf("%d",&ISBN);
            printf("\n");
            i=0;
        }
    }

    Book[current_book].ISBN=ISBN; // Once the ISBN has been checked for duplication and validity, add the title to the structure

    printf("Please enter a book title\n"); // Ask the user to input a book title
    fflush(stdin);
    fgets(book_name,100,stdin);
    strcpy(Book[current_book].title,book_name); // Copy the title to the Book structure

    printf("\n");

    printf("What is the category for the book?\n"); // Ask the user to input a book category
    fflush(stdin);
    fgets(&book_name[0],50,stdin);
    strcpy(Book[current_book].type,book_name); // Copy the category to the Book structure

    printf("\n");

    printf("Who is the publisher?\n"); // Ask the user to input the book's publisher
    fflush(stdin);
    fgets(&book_name[0],100,stdin);
    strcpy(Book[current_book].publisher,book_name); // Copy the publisher name to the Book structure

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

    Book[current_book].pages=page_num; // Copy the number of pages to the Book structure once number is valid.

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

    Book[current_book].price=book_price; // Copy the price to the Book structure once number is valid

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

    Book[current_book].published=pub_year; // Copy the publisher year to the Book structure once number is valid

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

    Book[current_book].status=check_out; // Copy the availability of the book to the Book structure

    if (check_out==1) // If the book is check out, ask the user for the name of the person and the books due date.
    {
        printf("What is the name of the person that checked out the book?\n");
        fflush(stdin);
        fgets(book_name,100,stdin);
        strcpy(Book[current_book].name,book_name);
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

        Book[current_book].date.month=book_time; //Assign the month the the structure

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

        Book[current_book].date.year=book_time; // Assign the year to the structure

        printf("What day was the book checked out?\n"); // Ask the user for the day
        printf("Please enter a day.\n");
        fflush(stdin);
        scanf("%d",&book_time);
        printf("\n");

        if (Book[current_book].date.month==FEB) // If the month is February...
        {
            if (Book[current_book].date.year%4==0) // These if statements check to see if the year of the current book is a leap year..
            {
                if(Book[current_book].date.year%100==0)
                {
                    if (Book[current_book].date.year%400==0)
                    {
                        not_leap=0;
                        while ((book_time<1) || (book_time>29)) //... If a leap year, check to see if the user input is valid
                        {
                            printf("Invalid day, please enter a number between 1 and 29\n");
                            printf("%d is a leap year.\n",Book[current_book].date.year);
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
                        printf("%d is a leap year.\n",Book[current_book].date.year);
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

        if((Book[current_book].date.month==APR || Book[current_book].date.month==JUN) || ((Book[current_book].date.month==SEP)||(Book[current_book].date.month==NOV)) ) // This statement is for months that have 30 days
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
            if (Book[current_book].date.month!=FEB)//... and not February..
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

        Book[current_book].date.day=book_time;
    }

    else // If the book is not checked out, then assign the following values to the structure
    {
        strcpy(Book[current_book].name,"Not checked out yet.\n");
        Book[current_book].date.day=0;
        Book[current_book].date.month=0;
        Book[current_book].date.year=0;
    }
}

void remove_book() // This function will remove a book by assigning dummy/null values to the members in the book's structure
{
    int i,ISBN,found=1;

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

    for (i=0;i<current_book;i+=1) // Check all the books in the structure so far for a matching ISBN
    {
        if (Book[i].ISBN==ISBN) // If the book is found...
        {
            found=0;
            dont_add[index]=i; // When writing to the file, do not add the book
            index+=1; // Update the index value for the don't add array
            Book[i].ISBN==0; // Assign dummy/null values to the book structure
            *Book[i].name="No Name";
            Book[i].pages=0;
            Book[i].price=0;
            Book[i].published=0;
            *Book[i].publisher="No Publisher";
            Book[i].status=2;
            *Book[i].title="Not in database";
            *Book[i].type="Not in database";
            Book[i].date.day=0;
            Book[i].date.month=0;
            Book[i].date.year=0;
            printf("Book was removed.\n");
        }
    }

    if (found==1) // If the book has not been found, then exit the function and return to the menu
    {
        printf("Book not found, now returning to main menu.\n");
        printf("\n");
        return;
    }
    printf("\n");
}

void check_out()
{
    int ISBN,i,book_time,found=1;

    printf("Please enter the ISBN if the book you want to check out.\n"); // Prompt user for ISBN
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

    for (i=0;i<current_book;i+=1) // Check all the books in the structure so far for a matching ISBN
    {
        if (Book[i].ISBN==ISBN) // If the book is found...
        {
            found=0;
            Book[i].status=1;
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

            Book[i].date.month=book_time; //Assign the month the the structure

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

            Book[i].date.year=book_time; // Assign the year to the structure

            printf("What day was the book checked out?\n"); // Ask the user for the day
            printf("Please enter a day.\n");
            fflush(stdin);
            scanf("%d",&book_time);
            printf("\n");

            if (Book[current_book].date.month==FEB) // If the month is February...
            {
                if (Book[current_book].date.year%4==0) // These if statements check to see if the year of the current book is a leap year..
                {
                    if(Book[current_book].date.year%100!=0)
                                                                                                                                      {
                        if (Book[current_book].date.year%400==0)
                        {
                            while ((book_time<1) || (book_time>29)) //... If a leap year, check to see if the user input is valid
                            {
                                printf("Invalid day, please enter a number between 1 and 29\n");
                                printf("%d is a leap year.\n",Book[current_book].date.year);
                                fflush(stdin);
                                scanf("%d",&book_time);
                                printf("\n");
                            }
                        }
                    }
                }

                else // If not a leap year, February only has 28 days
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

            if((Book[current_book].date.month==APR || Book[current_book].date.month==JUN) || ((Book[current_book].date.month==SEP)||(Book[current_book].date.month==NOV)) ) // This statement is for months that have 30 days
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
                if (Book[current_book].date.month==FEB)//... and not February..
                    break;

                else // ...then it has 31 days.
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

            Book[current_book].date.day=book_time;
        }

    }

    if (found==1) // If the book has not been found, then exit the function and return to the menu
    {
        printf("Book not found, now returning to main menu.\n");
        printf("\n");
        return;
    }

    else
        printf("The book is now checked out.\n\n");
}

void check_in()
{
    int ISBN,i,found=1;

    printf("Please enter the ISBN if the book you want to check out.\n"); // Prompt user for ISBN
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

    for (i=0;i<current_book;i+=1) // Check all the books in the structure so far for a matching ISBN
    {
        if (Book[i].ISBN==ISBN)
        {
            found=0;
            Book[i].status=0;
            Book[i].date.day=0;
            Book[i].date.month=0;
            Book[i].date.year=0;
        }
    }

    if (found==1) // If no books are found return to the main menu
    {
        printf("Book not found, now returning to main menu.\n");
        printf("\n");
        return;
    }

    else
        printf("The book is now checked in.\n\n"); // If a book was found, inform the user that the action is complete

}

void display_all() // This function will display all books in the database
{
    int i,j,display;

    for (i=0;i<current_book;i+=1) // This loop will iterate through the structure array
    {
        for (j=0;j<index;j+=1)
        {
            display=1;

            if(dont_add[j]!=i) // If the book was not removed from the data base, continue to check for other books
                continue;
            else // If a removed book was found, do not display its information
            {
                display=0;
                break;
            }
        }

        if (display)
        {
            printf("Title: %s",Book[i].title);// Display all details if it's not in the do not add list
            printf("ISBN: %d\n",Book[i].ISBN);
            printf("Category: %s",Book[i].type);
            printf("Publisher: %s",Book[i].publisher);
            printf("Total number of pages: %d\n",Book[i].pages);
            printf("Price: $%5.2f\n",Book[i].price);
            printf("Year Published: %d\n",Book[i].published);
            if (Book[i].status==1)
                printf("Status: Checked out\n");
            else if (Book[i].status==0)
                printf("Status: In Library\n");
            if (Book[i].status==1)
                printf("Due Date: %d/%d/%d\n",Book[i].date.month,Book[i].date.day,Book[i].date.year);
            printf("\n");
        }
    }
}

void display_in() // This function will display all the books that are checked in
{
    int i;

     printf("These books are currently in the Library:\n\n");

    for (i=0;i<current_book;i+=1)
    {
        if (Book[i].status==0) // If the book is checked in
        {
            printf("Title: %s",Book[i].title);// Display all details if it's not in the do not add list
            printf("ISBN: %d\n",Book[i].ISBN);
            printf("Category: %s",Book[i].type);
            printf("Publisher: %s",Book[i].publisher);
            printf("Total number of pages: %d\n",Book[i].pages);
            printf("Price: $%5.2f\n",Book[i].price);
            printf("Year Published: %d\n",Book[i].published);
        }

        printf("\n");
    }

    printf("\n");
}

void display_out() // This function will display all the books that are checked out
{
    int i;

    printf("These book are currently checked out:\n\n");

    for (i=0;i<current_book;i+=1)
    {
        if (Book[i].status==1) // If the book is checked out...
        {
            printf("Title: %s",Book[i].title);// Display all details if it's not in the do not add list
            printf("ISBN: %d\n",Book[i].ISBN);
            printf("Category: %s",Book[i].type);
            printf("Publisher: %s",Book[i].publisher);
            printf("Total number of pages: %d\n",Book[i].pages);
            printf("Price: $%5.2f\n",Book[i].price);
            printf("Year Published: %d\n",Book[i].published);
            printf("Due Date: %d/%d/%d\n",Book[i].date.month,Book[i].date.day,Book[i].date.year);
        }

        printf("\n");
    }

    printf("\n");
}

void save_books() // This function will write all the books into the database into a file
{
    FILE *file;
    int i,j,display;

    file=fopen("books.txt","w"); // Create a new file or overwrite an existing one to populate the book structure the next time this program runs

    for (i=0;i<current_book;i+=1)
    {
        for (j=0;j<index;j+=1) // If the book was removed, do not write it to the file
        {
            display=1;

            if(dont_add[j]!=i)
                continue;
            else
            {
                display=0;
                break;
            }
        }

        if (display) // If the book was not removed, write its contents to a file
        {
            fprintf(file,"%s",Book[i].title);// Write all details if it's not in the do not add list
            fprintf(file,"%d\n",Book[i].ISBN);
            fprintf(file,"%s",Book[i].type);
            fprintf(file,"%s",Book[i].publisher);
            fprintf(file,"%d\n",Book[i].pages);
            fprintf(file,"%5.2f\n",Book[i].price);
            fprintf(file,"%d\n",Book[i].published);
            fprintf(file,"%s",Book[i].name);
            if (Book[i].status==1)
                fprintf(file,"1\n");
            else if (Book[i].status==0)
                fprintf(file,"0\n");
            if (Book[i].status==1)
                fprintf(file,"%d\n%d\n%d\n",Book[i].date.month,Book[i].date.day,Book[i].date.year);
            else
                fprintf(file,"%d\n%d\n%d\n",0,0,0);
            if (i==(current_book-1)) // if the book is the last one in the structure, write end to the file to signify that it is the end of the file
                fprintf(file,"end");
            else
                fprintf(file,"new book\n"); // If not the last book, write new book to the file to signify that the following lines will contain information on a new book
        }
    }

    fclose(file);
}

void read_books() // This function will write pre-existing books to the Book structure if found
{
    FILE *file;

    int i,book_info;
    char szinfo[100];
    float book_price;

    file=fopen("books.txt","r");

    if (file==NULL)
    {
        printf("Save file not found\n\n"); // Inform user that no previous file was found
    }

    else
    {
        printf("Save file found, now populating list.\n\n");
        for (i=0;;i+=1) // This loop will add new books to the Book structure
        {
            fgets(szinfo,100,file);
            if (szinfo[0]==EOF)
            {
                printf("Save file is empty.\n\n");
                return;
            }
            strcpy(Book[i].title,szinfo);
            fscanf(file,"%d",&Book[i].ISBN);
            fgets(szinfo,100,file);
            fgets(szinfo,100,file);
            strcpy(Book[i].type,szinfo);
            fgets(szinfo,100,file);
            strcpy(Book[i].publisher,szinfo);
            fscanf(file,"%d",&Book[i].pages);
            fgets(szinfo,100,file);
            fscanf(file,"%f",&Book[i].price);
            fgets(szinfo,100,file);
            fscanf(file,"%d",&Book[i].published);
            fgets(szinfo,100,file);
            fgets(szinfo,100,file);
            strcpy(Book[i].name,szinfo);
            fscanf(file,"%d",&Book[i].status);
            fgets(szinfo,100,file);
            fscanf(file,"%d",&Book[i].date.month);
            fgets(szinfo,100,file);
            fscanf(file,"%d",&Book[i].date.day);
            fgets(szinfo,100,file);
            fscanf(file,"%d",&Book[i].date.year);
            fgets(szinfo,100,file);
            fgets(szinfo,100,file);
            if (szinfo[0]=='e') // If no more books are left, stop populating the list
                break;
            else if (szinfo[0]=='n') // Prepare structure for new book if "new book is found in file"
                continue;
            else
                printf("ERROR HAS OCCURED\n\n\n\n"); // This should not display if population ran correctly
        }
        printf("Population completed\n\n"); // Inform user that book population is complete
        current_book=i+1;
    }

    fclose(file);
}

int main(void)
{
    int choice,quit;

    read_books();

    printf("Welcome to the Singh Library Manager!\n");
    printf("Please follow the on-screen instructions to manage your library's books.\n\n");

    choice=display_menu(); // This function will display a menu to the user

    while (quit)
    {
        switch (choice)
        {
            case ADD:
                add_book();
                current_book+=1;
                choice=display_menu();
                break;
            case REMOVE:
                remove_book();
                choice=display_menu();
                break;
            case OUT:
                check_out();
                choice=display_menu();
                break;
            case IN:
                check_in();
                choice=display_menu();
                break;
            case DISPD:
                display_all();
                choice=display_menu();
                break;
            case DISPA:
                display_in();
                choice=display_menu();
                break;
            case DISPC:
                display_out();
                choice=display_menu();
                break;
            case EXIT:
                save_books();
                printf("Thank you for using Singh Library Manager\n");
                printf("Have a great day!\n");
                quit=0;
                break;
        }
    }

    return 0;
}
