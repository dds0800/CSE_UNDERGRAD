/*
 * File:   main.c
 * Author: alex
 *
 * Created on October 23, 2015, 3:33 PM
 */

#include <stdio.h>
#include <stdlib.h>

#include "perm.h"


void print_2D(matrix_ptr mat){
    int i, j;
    if (mat == NULL || mat->data_arr == NULL) {
        return;
    }

    printf("\nrows = %d, columns = %d\n", mat->rows, mat->cols);
    int ct = 0;
    for(i = 0; i < mat->rows; i++){
        for(j = 0; j < mat->cols; j++, ct++) {
            printf("%3d", mat->data_arr[i][j] );
        }
        printf("\n");
    }
}

void call_perm_rec_1(int N, int nr_vals){
    printf("\nCalled : perm_rec_1(%d, %d);\n", N, nr_vals);
    perm_rec_1(N, nr_vals); // you must implement this function.
}

/*
 * Test generating permutations recursively and iteratively and returning an
 * array with all the permutations.
 */
int main(int argc, char** argv) {

    //The following print statement is a test for task 1.
    //printf("%d %d %d %d %d %d %d\n\n",task_1(-5),task_1(0),task_1(1),task_1(3),task_1(4),task_1(7),task_1(10));
    call_perm_rec_1(3,2);  // you need to implement perm_rec_1
    call_perm_rec_1(5,2);
    call_perm_rec_1(4,3);

    call_perm_rec_1(2,4);
    call_perm_rec_1(4,2);

    int N = 4;
    int nr_vals = 2;

    printf("\nIn Main, ITERATIVE, called : perm_iter(%d, %d);\n", N, nr_vals);
    perm_iter(N, nr_vals); // you must implement this function.

    printf("\nIn Main, called : perm_rec_2(%d, %d);\n", N, nr_vals);
    matrix_ptr res = perm_rec_2(N, nr_vals);  // you must implement this function.
    printf("\nIn Main, printing the res->data_arr table: \n");
    print_2D(res);

    free_matrix_ptr(res); // you must implement this function.


    printf("\nIn Main, called : task_1(%d);\n", N);
    int F = task_1(N);  // you must implement this function.
    printf("\nresult: %d\n", F);



    return (EXIT_SUCCESS);
}
