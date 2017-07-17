/* This program uses code from "Algorithms in C, Third Edition,"
 *               by Robert Sedgewick, Addison-Wesley, 1998.
 */

#include <stdlib.h>
#include <stdio.h>

#include "list.h"
#include "twoD_arrays.h"
#include "graph.h"

// a graph where edges are recorded as a matrix
struct struct_graph
{
   int number_of_vertices;
   int ** adjacencies;
};


// creates a graph with the specified number of vertices
graph newGraph(int number)
{
   graph result = (graph)malloc(sizeof(*result));
   result->number_of_vertices = number;
   result->adjacencies = malloc2d(number, number);

   // initialize adjacencies to signify that at present the
   // graph contains no edges.
   int i, j;
   for (i = 0; i < number; i++)
   {
      for (j = 0; j < number; j++)
      {
         result->adjacencies[i][j] = 0; // no edge from i to j
      }
   }

   return result;
}

// deallocates the memory allocated to graph g.
void destroyGraph(graph g)
{
   if (g == NULL) return;
   free2d(g->adjacencies, g->number_of_vertices, g->number_of_vertices);
   free(g);
}

// returns the number of vertices in g.
int numVertices(graph g)
{
   if (g == NULL) return 0;
   return g->number_of_vertices;
}

// Returns 1 if v is a valid number for a vertex of graph g.
// This function does not have a declaration in graphs.h because I am using it internally.
int isVertexValid(graph g, int v){
   if ((v < 0) || (v >= g->number_of_vertices))
   {
      return 0;   // invalid number for a vertex.
   }

   return 1;
}

// returns the list of neighbors of vertex v in graph g.
list vertexNeighbors(graph g, int v)
{
   if (g == NULL) return NULL;
   if (isVertexValid(g, v) == 0)
   {
	   return NULL;
   }
   list result = newList();
   int n;
   for (n = 0; n < g->number_of_vertices; n++)
   {
      if (g->adjacencies[v][n] == 1)
      {
         insertAtBeginning(result, newLink(n));
      }
   }

   return result;
}


// returns 1 if the specified edge exists, 0 otherwise.
int edgeExists(graph g, int v1, int v2)
{
   if (g == NULL) return 0;
   if (isVertexValid(g, v1) == 0)
   {
      return 0;
   }
   if (isVertexValid(g, v2) == 0)
   {
      return 0;
   }

   return g->adjacencies[v1][v2];
}

// connects vertices v1 and v2 in the graph.
// returns 1 if successful, 0 if errors occurred.
int addEdge(graph g, int v1, int v2)
{
   if (g == NULL) return 0;
   if ( (isVertexValid(g, v1) == 0) || (isVertexValid(g, v2) == 0) )
   {
	  printf("Invalid vertex. No edge added.");
      return 0;
   }

   g->adjacencies[v1][v2] = 1;   // add edge from v1 to v2
   g->adjacencies[v2][v1] = 1;   // add edge from v2 to v1

   return 1;
}

// disconnects vertices v1 and v2 in the graph.
// returns 1 if successful, 0 if errors occurred.
int removeEdge(graph g, int v1, int v2)
{
   if (g == NULL) return 0;
   if (isVertexValid(g, v1) == 0)
   {
      return 0;
   }
   if (isVertexValid(g, v2) == 0)
   {
      return 0;
   }

   g->adjacencies[v1][v2] = 0;
   g->adjacencies[v2][v1] = 0;

   return 1;
}


// Prints the graph, namely the vertices, and the neighbors of each vertex.
void printGraph(graph g)
{
   if (g == NULL)
   {
      printf("\nNULL graph\n\n");
      return;
   }
   printf("\n");
   int v, n;
   for (v = 0; v < g->number_of_vertices; v++)
   {
      printNeighbors(g, v);
   }
   printf("\n");
}


// Prints the neighbors of vertex v.
void printNeighbors(graph g, int v)
{
   if (g == NULL)
   {
      printf("\nNULL graph\n\n");
      return;
   }
   if (isVertexValid(g, v) == 0)
   {
      printf("%d is not a vertex of the graph\n", v);
      return;
   }

   list neighbors = vertexNeighbors(g, v);
   printf("Vertex %d. Neighbors: ", v);

   link n;
   for (n = getFirst(neighbors); n != NULL; n = getLinkNext(n))
   {
      printf("%d ", getLinkItem(n));
   }
   printf("\n");
   destroyList(neighbors);
}

int** getAdjacencyMatrix(graph g)
{
	return g->adjacencies;
}
