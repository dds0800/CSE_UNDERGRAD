#ifndef CSE2320_HW_7_H
#define CSE2320_HW_7_H

#include "graph.h"

int countConnected_UF(graph g);

void depth_first(graph g, int* labels, int curr_label);

int*  labelConnected_Search(graph g, int* comp_count);

int sameNeighbors(graph g, int v1, int v2);

void maxEdges(int ** adj, int V, int *mx_count, int *v_index);

int countConnectors(int ** adj, int A, int B, int V);

#endif // CSE2320_HW_7_H
