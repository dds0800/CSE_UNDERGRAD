/*
 This code is from "Algorithms in C, Third Edition,"
               by Robert Sedgewick, Addison-Wesley, 1998.
*/

#include <stdio.h>
#define N 10
main()
  { int i, p, q, t, id[N];
    for (i = 0; i < N; i++) id[i] = i;
    while (scanf("%d %d", &p, &q) == 2)
      {
        if (id[p] == id[q])
        {
	     printf(" %d %d already connected\n", p, q);
          continue;
        }
        for (t = id[p], i = 0; i < N; i++)
          if (id[i] == t) id[i] = id[q];
        printf(" %d %d newly connected\n", p, q);

         printf("The values of the array are\n\n");

          for(i=0;i<N;i++)
          {
              printf("%d ",id[i]);
          }

          printf("\n\n");
      }
 }
