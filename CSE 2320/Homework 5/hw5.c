/*
 * Daniel Singh
 * dds0800 ID: 1000930800
 * CSE 2320 Dr. Stefan
 * Homework 5
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int min_dist(int dist1, int dist2)
{
    if(dist1<dist2)
        return dist1;
    else
        return dist2;
}
int edit_distance(char* s1, char* s2)
{
    int length1 = 1, length2 = 1, i, j, distance;

    for(i=0; s1[i]!='\0'; i++)
        length1++;

    for(i=0; s2[i]!='\0'; i++)
        length2++;


    int** distance_arr = malloc(sizeof(int*)*length1);

    for(i=0; i<length1; i++)
        distance_arr[i] = (int*)malloc(sizeof(int)*length2);

    for(i=0; i<length1; i++)
        distance_arr[i][0] = i;

    for(i=0; i<length2; i++)
        distance_arr[0][i] = i;

    for (i = 1; i < length1; i++)
    {
        for (j = 1; j < length2; j++)
        {
            if (s1[i-1] == s2[j-1])
                distance_arr[i][j] = distance_arr[i-1][j-1];

            else
                distance_arr[i][j] = 1 + min_dist(min_dist(distance_arr[i][j-1],distance_arr[i-1][j]),distance_arr[i-1][j-1]);
        }
    }
    distance = distance_arr[length1-1][length2-1];
    for(i=0; i<length1; i++)
        free(distance_arr[i]);

        free(distance_arr);
        return distance;
}

int main()
{
    char* s1 = malloc(sizeof(char) * 1000);
    char* s2 = malloc(sizeof(char) * 1000);

    while(true)
    {
        scanf("%s %s",s1,s2);

        if((strcmp(s1,"-1")==0) && (strcmp(s2,"-1")==0))
            break;

        printf("The edit distance is %d\n",edit_distance(s1,s2));
    }

    free(s1);
    free(s2);

    return 0;
}
