/*
 *  File:   edit_distance_usage.h
 *  Author: Riccardo Sieve
 *
 *  Created on 17 October, 11:12
 */

/**
 *  The usage for our algorithms consists in getting every element in the 
 *  correctme.txt file and search for any word in the dictionary.txt file
 *  with minimum distance from the initial word.
 *  The idea for the implementations, goes as follow.
 *  Whenever I check every element of the dictionary, if I find an element
 *  with edit distance less then usual, I'm gonna reset the counter, if it
 *  is equal, then I'm just gonna increment the counter, otherwise I do
 *  nothing. */

#include <limits.h>
#include <time.h>

#include "../algorithms/headers/edit_distance.h"
#include "../utils/headers/error_handling.h"

#define STRING_LENGTH 2000

int main() {
    FILE* fin;
    FILE* fin2;

    char s1[STRING_LENGTH], s2[STRING_LENGTH]; 

    fin = fopen("../../../datasets/correctme.txt", "r");
    fin2 = fopen("../../../datasets/dictionary.txt", "r");

    if(fin == NULL || fin2 == NULL) {
        file_exception();
    }

    time_t init_time = time(NULL);
    while(fscanf(fin, "%s", s1) != EOF) {
        int word_counter = 0;
        int min_distance = INT_MAX;

        while(fscanf(fin2, "%s", s2) != EOF) {
            if(edit_distance_dyn(s1, s2) < min_distance) {
                min_distance = edit_distance_dyn(s1, s2);
                word_counter = 1;
            } else if (edit_distance_dyn(s1, s2) == min_distance) {
                word_counter++;
            }
        }

        printf("The word '%s' has %d occurrence with distance %d\n", s1, word_counter, min_distance);
        fseek(fin2, 0, SEEK_SET );
    }

    time_t end_time = time(NULL);
    printf("The total time of execution was %ld\n", end_time - init_time);

    fclose(fin);
    fclose(fin2);

    return 0;
}
