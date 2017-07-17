/* This program will implement
 * quick find and slow union and show
 * how many connected components there are.*/

 #include <stdio.h>
 #define N 8

 int main(void)
 {
     int i,p,q,check,id[N];

     for(i=0;i<N;i++)
     {
         id[i]=i;
     }

     for(i=0;i<N;i++)
         {
             printf("%d ",id[i]);
         }

    printf("\n\n");

     while(scanf("%d %d",&p,&q)==2)
     {
         for(i=0,check=id[p];i<N;i++)
         {
             if(id[i]==check)
                id[i]=id[q];
         }

         for(i=0;i<N;i++)
         {
             printf("%d ",id[i]);
         }

         printf("\n\n");
     }

     return 0;
 }
