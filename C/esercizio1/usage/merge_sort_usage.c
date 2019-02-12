/*
 *  File:   merge_sort_usage.c
 *  Author: Riccardo Sieve
 *
 *  Created on 16 October, 10:45
 */

#include "../algorithms/headers/merge_sort.h"
#include <time.h>

#define MAX_ELEMENTS 20000000// 20000000 max elements

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
    //while(fscanf(fin, "%lld", &temp) != EOF) {
        ArrayList_add(structure, (int64_t*)new_big_int(temp));
        i++;
    }

    // closing file for cleanup of memory
    fclose(fin);

    time_t init_time = time(NULL);
    merge_sort(structure, compare_big_int, 0, structure->size-1);

    time_t end_time = time(NULL);
    printf("Execution time was %ld\n", end_time - init_time);

    /* I'm using a relative path with dataset outside the project folder 
     * structure. It may be changed if the file is in a different position. */
    fin = fopen("../../../datasets/sums.txt", "r");

    if(fin == NULL) {
        file_exception();
    }

    int64_t sum_element=0;

    while(fscanf(fin, "%lld", &sum_element) != EOF) {
        int index = ArrayList_get_nearest_index(structure, (int64_t*)new_big_int(sum_element), compare_big_int);

        int64_t upper_bound = *(int64_t*)structure->data[structure->size-1] + *(int64_t*)structure->data[structure->size-2];

        if(sum_element > upper_bound)
            index=0;

        boolean occurrence = FALSE;

        for(int i=index; i>0 && !occurrence; i--) {
            for(int j=0; j<i && !occurrence; j++) {
                if((*(int64_t*)ArrayList_get(structure, i) + 
                    *(int64_t*)ArrayList_get(structure, j)) == 
                    sum_element) {

                    printf("Found the occurrence of sum for %lld\n", sum_element);
                    printf("Indexes are: %d %d\n", i, j);
                    printf("Corresponding values are %lld and %lld\n", 
                                *(int64_t*)(structure->data)[i], 
                                *(int64_t*)(structure->data)[j]);
                    occurrence = TRUE; // occurrence found

                } else if ((*(int64_t*)ArrayList_get(structure, i) + 
                            *(int64_t*)ArrayList_get(structure, j)) >
                             sum_element) {
                    break;
                }
            }
        }
    }

    fclose(fin);

    ArrayList_free(structure);

    return 0;
}
