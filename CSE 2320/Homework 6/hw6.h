#ifndef HW6_2320_H
#define	HW6_2320_H

typedef struct tree_node_struct * tree_link;

typedef int Item;

void print_array(int arr[], int N);

// Creates a new link, that contains the value specified in the argument,
// and that points to NULL. */
tree_link new_tree_link(Item value);
void free_tree(tree_link root);

void print_line(tree_link node, int depth);
void print_tree(tree_link root, int depth, int order);


int count_one_child(tree_link root);

tree_link tree_from_array_preorder(Item arr[], int N);

tree_link tree_from_array_preorder_aux(Item arr[], int *pos, int N);

tree_link tree_from_array_level(Item arr[], int N);

tree_link level_order_aux(Item arr[], int N, int pos);


char** read_from_file(char* fname, int * size);
void free_words(char** words, int num_words);
void len_sort(char** words, int num_words);
void swap(int* arr, int index_1, int index_2);

// You can modify this function if you want to.
void print_strings(char** words, int num_words);
#endif	/* HW6_2320_H */
