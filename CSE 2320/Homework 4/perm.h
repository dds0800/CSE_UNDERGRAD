/*
 * File:   perm.h
 * Author: alex
 *
 * Created on October 23, 2015, 3:33 PM
 */

#ifndef PERM_H
#define	PERM_H

struct matrix_2D_struct {
    int** data_arr;
    int rows;
    int cols;
};
typedef struct matrix_2D_struct * matrix_ptr;

/* Implement the functions below. You can write additional helper functions.
 * Do not modify the matrix_2D_struct or the matrix_ptr definitions.
 */

/* Implements:
For all N < 0, F(N) should print an error message and return 0.
Base case: F(0) = 1.
Base case: F(1) = 1.
If N is an odd integer, N > 1, then: F(N) = F(N+1) - 2.
If N is an even integer, N > 1, then: F(N) = F(N/2) + F(N-2).
 */
int task_1(int N);

/*
 * This function will be used to calculate and store values in
 * a dynamically created array for the task_1 function.
 */

int task_1_helper(int N,int* values);

/*
 * Generates RECURSIVELY and prints all the permutations with repetitions
 * of N objects taken from a set of nr_vals different objects.
 */

void rec_1_helper(int N, int values, int* perm_arr, int place);

void perm_rec_1(int N, int nr_vals);

/*
 * Generates RECURSIVELY  and returns a matrix_ptr that holds all the permutations
 * with repetitions of N objects taken from a set of nr_vals different objects.
 */
matrix_ptr perm_rec_2(int N, int nr_vals);

/*
 * Generates ITERATIVELY and prints all the permutations with repetitions
 * of N objects taken from a set of nr_vals different objects.
 */
void perm_iter(int N, int nr_vals);

/* Frees the dynamic memory allocated for my_array.
 */
void free_matrix_ptr(matrix_ptr my_array);

#endif  /*PERM_H*/
