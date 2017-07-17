#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#include "hw6.h"

const int N_MAX = 100;

const Item STOP = 0;

struct tree_struct
{
	tree_link root;
};

struct tree_node_struct
{
   int item;
   tree_link left;
   tree_link right;
};


/* Creates a new link, that contains the value specified in the argument,
 * and that points to NULL for both children. */
tree_link new_tree_link(Item value)
{
   tree_link result = (tree_link)malloc(sizeof(struct tree_node_struct));
   result->item = value;
   result->left = NULL;
   result->right = NULL;
   return result;
}



void print_line(tree_link node, int depth)
{
	int i;
	for (i = 0; i<depth; i++) printf("  ");

	if (node == NULL)
		printf("*\n");
	else
	{
		printf("%d\n", node->item);
	}
}

void print_tree(tree_link root, int depth, int order)
{
	if (root==NULL)
	{
		print_line(root, depth);
		return;
	}

	if (order == 1)
	{
		print_line(root, depth);
		print_tree(root->left, depth + 1, order);
		print_tree(root->right, depth + 1, order);
	}
	else
		if (order ==2)
		{
			print_tree(root->right, depth + 1, order);
			print_line(root, depth);
			print_tree(root->left, depth + 1, order);
		}
		else
			printf("Invalid order argument (only 1-preorder, or 2-inorder): %d ", order);
}



void print_array(int arr[], int N)
{
	int i = 0;
	printf("\n");
	for (i =0; i<N; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}


/**
 * You may change this function, assuming you will not hardcode it. If your
 * char** words has a structure that is different from what is assumed here, you can
 * modify it to work for your structure.
 *
 * @param words
 * @param num_words
 */
void print_strings(char** words, int num_words){
    int i;
	printf("\n");
    for (i = 0; i< num_words; i++) {
        printf("%s\n", words[i]);
    }
    printf("\n");
}





// Fill out the code for functions below:


tree_link tree_from_array_preorder(Item arr[], int N)
{
    tree_link my_tree;

    if(arr[0]==0)
    {
        printf("\n\nRoot value in NULL. Now returning NULL.\n\n");
        return NULL;
    }

    int pos = 0;

    my_tree = tree_from_array_preorder_aux(arr,&pos,N);

    return my_tree;
}

tree_link tree_from_array_preorder_aux(Item arr[], int *pos, int N)
{
    if(arr[*pos] == 0)
    {
        *pos = *pos + 1;
        return NULL;
    }

    tree_link tree = new_tree_link(arr[*pos]);

    *pos = *pos + 1;

    tree->left = tree_from_array_preorder_aux(arr,pos,N);

    tree->right = tree_from_array_preorder_aux(arr,pos,N);

    return tree;
}

void free_tree(tree_link root)
{
    if(root == NULL)
        return;

    free_tree(root->left);
    free_tree(root->right);

    free(root);
}

// note that this will work also for when both left and right are NULL.
int count_one_child(tree_link root)
{
    if(root->left == NULL && root->right != NULL)
        return 1 + count_one_child(root->right);

    else if(root->right == NULL && root->left != NULL)
        return 1 + count_one_child(root->left);

    else if(root->left == NULL && root->right == NULL)
        return 0;

    return count_one_child(root->left) + count_one_child(root->right);
}

// A non-recursive implementation is easier.
tree_link tree_from_array_level(Item arr[], int N)
{
    tree_link tree = level_order_aux(arr,N,0);

    return tree;
}

tree_link level_order_aux(Item arr[], int N, int pos)
{
    tree_link tree;

    if(pos<N)
    {
        tree = new_tree_link(arr[pos]);
        tree->left = level_order_aux(arr,N,(pos*2)+1);
        tree->right = level_order_aux(arr,N,(pos*2)+2);
    }

    else
        return NULL;

    return tree;
}

void free_words(char** words, int num_words)
{
    int i;

    if(words==NULL)
        return;

    for(i=0; i<num_words; i++)
        free(words[i]);

    free(words);
}

char** read_from_file(char* fname, int * size)
{
    FILE *fp = fopen(fname,"r");

    if(fp == NULL)
    {
        printf("\nFile not found, now returning NULL.\n\n");
        *size = 0;
        return NULL;
    }

    int i=1;
    char line[1000];

    if(fscanf(fp,"%s",line) == EOF)
    {
        printf("The file is empty, now returning NULL\n\n");
        return NULL;
    }

    while(fscanf(fp,"%s",line) != EOF && i!= N_MAX)
        i++;

    *size = i;

    char** list = malloc(sizeof(char*) * *size);

    for(i=0; i<*size; i++)
        list[i] = malloc(sizeof(char) * 1000);

    fseek(fp,0,SEEK_SET);

    for(i=0; i<*size; i++)
        fscanf(fp,"%s",list[i]);

    fclose(fp);

    return list;

}

void swap(int* arr, int index_1, int index_2)
{
    int temp;

    temp = arr[index_1];
    arr[index_1] = arr[index_2];
    arr[index_2] = temp;
}

void len_sort(char** words, int num_words)
{
    if(words==NULL)
    {
        printf("\nThe array is NULL. Now returning.\n\n");
        return;
    }

    // This array will store the length of the strings
    int* str_size = malloc(sizeof(int) * num_words);

    // This array will store the location of string in char** words
    int* str_loc = malloc(sizeof(int) * num_words);


    char** list_copy = malloc(sizeof(char*) * num_words);

    int i;

    for(i=0; i<num_words; i++)
        list_copy[i] = malloc(sizeof(char) * 1000);

    for(i=0; i<num_words; i++)
        strcpy(list_copy[i],words[i]);

    for(i=0; i<num_words; i++)
    {
        str_loc[i] = i;
        str_size[i] = strlen(words[i]);
    }

    bool flag = false;

    // This is an implementation of bubble sort.
    while(!flag)
    {
        flag = true;

        for(i=1; i<num_words; i++)
        {
            if(str_size[i-1] > str_size[i])
            {
                swap(str_size,i-1,i);
                swap(str_loc,i-1,i);
                flag = false;
            }
        }
    }

    for(i=0; i<num_words; i++)
    {
        strcpy(words[i],list_copy[str_loc[i]]);
    }

    free(str_loc);
    free(str_size);
    free_words(list_copy,num_words);
}
