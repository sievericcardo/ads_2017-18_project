/*
 *  File:   insertion_sort_usage.c
 *  Author: Riccardo Sieve
 *
 *  Created on 6 November, 10:55
 */

#include "../algorithms/headers/insertion_sort.h"
#include <time.h>

#define MAX_ELEMENTS 60 // 20000000 total

int main() {
    FILE* fin;
    int64_t temp;
    int i=0;

    /* I'm using a relative path with dataset outside the project folder 
     * structure. It may be changed if the file is in a different position. */
    fin = fopen("../../../datasets/integers.csv", "r");

    if(fin == NULL) {
        file_exception();
    }

    ArrayList* structure = ArrayList_create();

    while(fscanf(fin, "%lld", &temp) != EOF && i < MAX_ELEMENTS) {
        ArrayList_add(structure, (int64_t*)new_big_int(temp));
        i++; // The 20M may be too much, do one step at a time
    }

    fclose(fin);

    time_t init_time = time(NULL);
    insertion_sort(structure, compare_big_int);

    time_t end_time = time(NULL);
    printf("Execution time was %ld\n", end_time - init_time);

    ArrayList_print(structure, print_big_int);

    ArrayList_free(structure);

    return 0;
}
