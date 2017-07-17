/* This program uses code from "Algorithms in C, Third Edition,"
 *               by Robert Sedgewick, Addison-Wesley, 1998.
 */

#include <stdio.h>


 void print_array_int(int arr[], int size)
 {
	 int i;
	 printf("  i: ");
	 for (i = 0; i < size; i++)
		 printf("%3d ", i);
	 printf("\narr: ");
	 for (i = 0; i < size; i++)
		 printf("%3d ", arr[i]);
	 printf("\n");
 }

/* returns the set id of the object. */
int find(int object, int id[])
{
  int next_object;
  next_object = id[object];

  //printf("\nFind root of %d\n\t", object);
  //printf("   %d ", next_object);
  while (next_object != id[next_object])
  {
    next_object = id[next_object];
	printf("   %d ", next_object);
  }

  return next_object;
}

/* Unites the two sets specified by set_id1 and set_id2.
   Please note the new arguments: int p, and int q passed to this function.
   YOU SHOULD MODIFY ONLY THIS FUNCTION. NO OTHER CODE. (NO MAIN FILE, NO .H FILE).
 */
void set_union(int set_id1, int set_id2, int id[], int size, int size_arr[], int p, int q)
{
  int root,next,count=0;
  if (size_arr[set_id1] < size_arr[set_id2])
  {
	root = set_id2;

	while(p!=set_id1)
    {
        next=id[p];
        id[p]=root;
        count++;
        p=next;
    }

	while(q!=set_id2)
    {
        next=id[q];
        id[q]=root;
        count++;
        q=next;
    }
	id[set_id1] = set_id2;
	//size_arr[set_id2] = size_arr[set_id1]  + size_arr[set_id2];
	size_arr[set_id2] = count;
  }
  else
  {
	root = set_id1;

	while(p!=set_id1)
    {
        next=id[p];
        id[p]=root;
        count++;
        p=next;
    }

    while(q!=set_id2)
    {
        next=id[q];
        id[q]=root;
        count++;
        q=next;
    }
	id[set_id2] = set_id1;
	//size_arr[set_id2] = = size_arr[set_id1]  + size_arr[set_id2];
	size_arr[set_id1] = count;
  }
}
