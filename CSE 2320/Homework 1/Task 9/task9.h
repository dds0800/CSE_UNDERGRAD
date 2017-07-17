/* This program uses code from "Algorithms in C, Third Edition,"
 *               by Robert Sedgewick, Addison-Wesley, 1998.
 */

#include <stdio.h>

/* returns the set id of the object. */
int find(int object, int id[]);

/* Unites the two sets specified by set_id1 and set_id2.
   Please note the new arguments: int p, and int q passed to this function
*/
void set_union(int set_id1, int set_id2, int id[], int size, int size_arr[], int p, int q);

/*  Print index and content of given array. */
void print_array_int(int arr[], int size);
