#include <stdio.h>
#include <stdlib.h>


#include "graph.h"
#include "hw7.h"


/*
g++ -o i1 instr_1.cpp hw7.cpp graph_matrix.cpp twoD_arrays.cpp list.cpp

run:
./i1 < g2.txt

*/



/*
Reads data from the user (stdin)
If you want to read from a file, use:
./i2 < g2.txt
*/
graph build_graph()
{
	printf("Calling the build_graph function...");
	int i,j, n;

	printf("\nEnter the number of vertices: ");

	scanf("%d", &n);

	graph g = newGraph(n);

	printf("\nEnter the edges (by pairs, e.g.: 3 1): ");
	while (scanf("%d %d", &i, &j) == 2)
	{
		addEdge(g,i,j);
	}
	return g;
}


/*
If using this function to build the graph, to read from file, use:
./i2
(the filename will be specified in the caller function.)
*/
graph build_graph_2(char * filename)
{
	printf("Calling the build_graph_2 function...");

	FILE *fp = fopen(filename,"r");
	char line[100];
	int i,j, n;

	printf("\nEnter the number of vertices: ");

	fscanf(fp, "%d", &n);
	printf("%d\n", n);

	graph g = newGraph(n);

	printf("\nEnter the edges (by pairs, e.g.: 3 1): ");
	while (feof(fp) == 0)
	{
		fgets(line, 100, fp);
		sscanf(line, "%d %d", &i, &j);
		addEdge(g,i,j);
	}
	return g;
}



int main()
{
	//test_build();

	graph g = build_graph();
	printf("\n\nTHE GRAPH IS: ");
	printGraph(g);


	int same_n = sameNeighbors(g, 0, 3);
	printf("\nDo vertices 0 and 3 have the same neighbors?  %d\n", same_n);


	same_n = sameNeighbors(g, 0, 1);
	printf("\nDo vertices 0 and 1 have the same neighbors?  %d\n", same_n);


	printf("\n Running connected components with Union Find:\n");
	int res = countConnected_UF(g);
	printf("Number of connected components: %d\n", res);

        printf("\n Running label connected components:\n");
        int comp_count = 0;
        int * labels = labelConnected_Search(g, &comp_count);
        printf("\nNumber of connected components: %d\n", comp_count);
        int i;
        printf("\n%5s:%5s\n", "v", "label");  // display labels
        for(i = 0; i< numVertices(g); i++){
            printf("%5d:%5d\n", i, labels[i]);
        }
        free(labels);

	int ** adj = getAdjacencyMatrix(g);
	if (adj == NULL)
	{
		printf("No adjacency matrix. Exit.");
		return 0;
	}

	int mx_count= -1;
	int v_index = -1;
	int V = numVertices(g);
	maxEdges(adj, V, &mx_count, &v_index);
	printf("\n\nVertex with most edges: %d (%d)\n", v_index, mx_count);

	int A = 0;
	int B = 1;
	res = countConnectors(adj, A, B, V);
	printf("\nThe number of vertices that serve as direct connectors to %d and %d is: %d\n", A, B, res);


	addEdge(g,1,4);
	printf("\n--------------- After adding edge: 1-4\n");

	maxEdges(adj, V, &mx_count, &v_index);
	printf("\nVertex with most edges: %d (%d)\n", v_index, mx_count);

	return 0;
}
