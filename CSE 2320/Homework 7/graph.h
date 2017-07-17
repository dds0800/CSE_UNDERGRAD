/* This program uses code from "Algorithms in C, Third Edition,"
 *               by Robert Sedgewick, Addison-Wesley, 1998.
 */

#ifndef CSE2320_GRAPHS_H
#define CSE2320_GRAPHS_H

#include "list.h"

typedef struct struct_graph * graph;

// creates a graph with the specified number of vertices
graph newGraph(int number);

// deallocates the memory allocated to graph g.
void destroyGraph(graph g);

// returns the number of vertices in g.
int numVertices(graph g);

// returns the list of neighbors of vertex v in graph g.
list vertexNeighbors(graph g, int v);

// connects vertices v1 and v2 in the graph.
// returns 1 if successful, 0 if errors occurred.
int addEdge(graph g, int v1, int v2);

// disconnects vertices v1 and v2 in the graph.
// returns 1 if successful, 0 if errors occurred.
int removeEdge(graph g, int v1, int v2);

// returns 1 if the specified edge exists, 0 otherwise.
int edgeExists(graph g, int v1, int v2);

// Prints the graph, namely the vertices, and the neighbors of each vertex.
void printGraph(graph g);

// Prints the neighbors of vertex v.
void printNeighbors(graph g, int v);


/************   ADDED FOR HW 4  *************************/
// returns the pointer to the adjacency matrix of g.
int** getAdjacencyMatrix(graph g);




#endif // CSE2320_GRAPHS_H
