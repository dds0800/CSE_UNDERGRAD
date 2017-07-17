#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#include "perm.h"





// Implement the functions below. You can add any helper function you need.

int task_1_helper(int N,int* values)
{
    //printf("%d\n\n",values[N]);

    if(values[N] != -1)
    {
        //printf("\nComputed result was used\n");
        return values[N];
    }
    int calc_val;

    if(N==0 || N==1)
        calc_val=1;

    else if(N%2!=0)
        calc_val = task_1_helper(N+1,values)-2;

    else
        calc_val =  task_1_helper(N/2,values) + task_1_helper(N-2,values);

    //printf("You made it here\n\n");

    values[N] = calc_val;

    return calc_val;
}

int task_1(int N)
{
    if(N<0)
    {
        printf("\nInvalid value for N. N must be >= 0.\n");
        return 0;
    }

    else
    {

        int* solutions = malloc(sizeof(int)*(N+2));

        int i;

        for(i=0;i<=(N+1);i++)
            solutions[i] = -1;

        int result = task_1_helper(N,solutions);

        free(solutions);

        return result;
    }
}

/*int task_1(int N)
{
    if(N<0)
    {
        printf("\nInvalid value for N. N must be >= 0.\n");
        return 0;
    }

    if(N%2==0)
        int* solutions = malloc(sizeof(int)*(N+1));

    else
        int* solutions = malloc(sizeof(int)*(N+2));

    int i;

    solutions[0]=1;
    solutions[1]=1;

    for(i=0;i<)

    for(i=2;i<=N;i++)
    {
        if(i%2==0)
        {
            if()
        }
        else
        {
            if(s)
        }
    }

    return solutions[N];
}*/

void free_matrix_ptr(matrix_ptr my_matrix)
{
    /*int i;

    for(i=0;i<my_matrix->rows;i++)
        free(my_matrix->data_arr[i]);

    free(my_matrix->data_arr);*/
    free(my_matrix);
    return;
}

void rec_1_helper(int N, int values, int* perm_arr, int place)
{
    if(perm_arr[N-1]==(values-1))
        return;

    int i;

    for(i=(N-1);i>=0;i++)
        printf("%d ",perm_arr[i]);

    printf("\n");



    if(perm_arr[place]==(values-1))
    {
        for(i=0;i<=place;i++)
            perm_arr[i] = 0;

        rec_1_helper(N,values,perm_arr,place+1);
    }
}

void perm_rec_1(int N, int nr_vals)
{
    if(nr_vals==0)
    {
        printf("\nThere are zero things to choose from.\n");
        return;
    }

    else if(N==0)
    {
        printf("\nZero elements was chosen.\n");
        return;
    }
    int* permutation = malloc(sizeof(int)*N);

    int i;

    for(i=0;i<N;i++)
        permutation[i] = 0;

    //rec_1_helper(N,nr_vals,permutation,0);

    free(permutation);

    printf("\n\n");

    return;
}

matrix_ptr perm_rec_2(int N, int nr_vals)
 {
     if(nr_vals==0)
    {
        printf("\nThere are zero things to choose from.\n");
        return NULL;
    }

    else if(N==0)
    {
        printf("\nZero elements was chosen.\n");
        return NULL;
    }

    printf("\nfailure\n");
    matrix_ptr permutations;
    printf("\nfailure1\n");

    int i,j,x=1,y=N;

    for(i=0;i<N;i++)
        x *= nr_vals;

    //int data[x][y];

    permutations = malloc(sizeof(int)*8);

    permutations->rows = x;
    permutations->rows = y;
    //permutations->data_arr=data;

    /*for(i=0;i<x;i++)
    {
        for(j=0;j<y;j++)
            permutations->data_arr[i][j]=0;
    }*/

    printf("Seg here\n\n");

    int** temp = malloc(sizeof(int*)*x);

    printf("\nhello\n");
    for(i=0;i<x;i++)
    {
        temp[i] = malloc(sizeof(int)*y);
    }

    permutations->data_arr=temp;

    printf("Loop seg\n\n");

    printf("%d\n\n",x);

    for(i=0;i<x;i++)
    {
        for(j=0;j<y;j++)
        {
            printf("Illegal Access\n\n");
            printf("%d %d\n\n",i,j);
            permutations->data_arr[i][j]=0;
        }
    }

    printf("HERE!!\n\n");

    return permutations;
}


void perm_iter(int N, int nr_vals)
{
    if(nr_vals==0)
    {
        printf("\nThere are zero things to choose from.\n");
        return;
    }

    else if(N==0)
    {
        printf("\nZero elements was chosen.\n");
        return;
    }

    /*int i = N, j = nr_vals,k,l;

    int* permutations = malloc(sizeof(int)*N);

    for(k=0;k<N;k++)
        permutations[k]=0;*/



}
