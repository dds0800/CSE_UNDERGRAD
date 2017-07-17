/* This program uses code from "Algorithms in C, Third Edition,"
 *               by Robert Sedgewick, Addison-Wesley, 1998.
 */

#ifndef TWOD_ARRAYS_H
#define TWOD_ARRAYS_H

int ** malloc2d(int rows, int columns);

void free2d(int ** array, int rows, int columns);

void printMatrix(int ** array, int rows, int columns);

int ** randomMatrix(int rows, int columns, int limit);

int ** addMatrices(int ** A, int ** B, int rows, int columns);

#endif // TWOD_ARRAYS_H
