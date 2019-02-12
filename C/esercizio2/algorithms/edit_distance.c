#include "headers/edit_distance.h"

boolean* is_checked;

/**
 * We get two strings in input and we are going to give back the number of
 * deletions and insertions needed to make the two strings equals. */

/* I could have used strlen instead. Creating this simple function allow me
 * not to import the string library */
int length (char* array) {
    boolean is_iterable = TRUE;
    int size = 0;

    while(is_iterable) {
        if(!array[size]) {
            is_iterable = FALSE;
        } else {
            size++;
        }
    }

    return size;
}

int edit_distance (char* s1, char* s2) {
    if((length(s1) == 0) && !(length(s2) == 0))
        return length(s2);
    else if(!(length(s1) == 0) && (length(s2) == 0))
        return length(s1);

    boolean* is_checked;
    int occurrence, d_i_counter;

    is_checked = (boolean *) malloc (length(s2) * sizeof(boolean));

    // First initialisation
    d_i_counter=0;
    for(int i=0; i<length(s2); i++) {
        is_checked[i] = FALSE;
    }

    /* We check character by character if there's a corresponding one.
     * If there's one we stop the parsing and proceed with the next char.
     * In the best case we would have a O(2n) and it's the case where we have
     * two matching strings from the beginning
     * In the worst case we would have O(n^2) since we would iterate two
     * separate for loops up to the end */
    for(int i=0; i<length(s1); i++) {
        boolean iterate = TRUE;
        occurrence = FALSE;

        for(int j=0; j<length(s2) && iterate; j++) {
            if(s1[i] == s2[j] && !is_checked[j]) {
                occurrence = TRUE;
                is_checked[j] = TRUE;
                iterate = FALSE;
            }
        }

        // If the letter wasn't found I increment the counter
        if(!occurrence) {
            d_i_counter++;
        }
    }

    return (d_i_counter + abs(length(s1) - length(s2)));
}

/* Start of the recursive section.
 * We are going to define two different recursive function. The first one
 * is used to iterate the second string, checking every character of the
 * second one, with the one passed */
boolean recursive_f (char c, char* s2, int j) {
    if(j == length(s2)) {
        return FALSE;
    } else if(c == s2[j] && !is_checked[j]) {
        is_checked[j] = TRUE;
        return TRUE;
    }

    return recursive_f(c, s2, j+1);
}

/* We check character by character if there's a corresponding one.
 * If there's one we stop the parsing and proceed with the next char.
 * In the best case we would have a O(2n) and it's the case where we have
 * two matching strings from the beginning
 * In the worst case we would have O(n^2) since we would iterate two
 * separate for loops up to the end.
 * We normally iterate the firs array and we use recursion on the function
 * that actually check the occurrences. */
int edit_distance_r (char* s1, char* s2, int i) {
    if(i < length(s1)) {
        boolean occurrence = recursive_f(s1[i], s2, 0);

        // If the letter wasn't found I increment the counter
        if(!occurrence) {
            return 1 + edit_distance_r(s1, s2, i+1);
        } else {
            return 0 + edit_distance_r(s1, s2, i+1);
        }
    } else {
        return 0;
    }
}

/* This function only sets the array of boolean and let the two recursive
 * functions to make the operations */
int edit_distance_dyn (char* s1, char* s2) {
    if((length(s1) == 0) && !(length(s2) == 0))
        return length(s2);
    else if(!(length(s1) == 0) && (length(s2) == 0))
        return length(s1);
    
    // Set all elements to false before beginning the functions.
    is_checked = (boolean *) malloc (length(s2) * sizeof(boolean));

    // First initialisation
    for(int i=0; i<length(s2); i++) {
        is_checked[i] = FALSE;
    }

    if(length(s1) < length(s2))
        return (edit_distance_r(s1, s2, 0) +  abs(length(s1) - length(s2)));

    return (edit_distance_r(s1, s2, 0));
}

/* These two functions are used to print correctly everything */
void print_distance(char* s1, char* s2) {
    int i_counter, d_counter, d_i_counter;

    i_counter = d_counter = d_i_counter = 0;

    if(length(s1) == 0) {
        i_counter = length(s2);
        printf("Distance between %s and %s is %d insertions and %d deletions\n", s1, s2, d_i_counter+i_counter, d_i_counter+d_counter);
    } else if(length(s2) == 0) {
        d_counter = length(s2);
        printf("Distance between %s and %s is %d insertions and %d deletions\n", s1, s2, d_i_counter+i_counter, d_i_counter+d_counter);
    } else {
        if(length(s1) < length(s2)) {
            i_counter = length(s2) - length(s1);
        } else {
            d_counter = length(s1) - length(s2);
        }

        d_i_counter = edit_distance(s1, s2) - ((length(s1) > length(s2)) ? length(s1) - length(s2) : length(s2) - length(s1));

        printf("Distance between %s and %s is %d insertions and %d deletions\n", s1, s2, d_i_counter+i_counter, d_i_counter+d_counter);
    }
}

void print_distance_r(char* s1, char* s2) {
    int i_counter, d_counter, d_i_counter;

    i_counter = d_counter = d_i_counter = 0;

    if(length(s1) == 0) {
        i_counter = length(s2);
        printf("Distance between %s and %s is %d insertions and %d deletions\n", s1, s2, d_i_counter+i_counter, d_i_counter+d_counter);
    } else if(length(s2) == 0) {
        d_counter = length(s2);
        printf("Distance between %s and %s is %d insertions and %d deletions\n", s1, s2, d_i_counter+i_counter, d_i_counter+d_counter);
    } else {
        if(length(s1) < length(s2)) {
        i_counter = length(s2) - length(s1);
        } else {
            d_counter = length(s1) - length(s2);
        }

        d_i_counter = edit_distance_dyn(s1, s2) - ((length(s1) > length(s2)) ? length(s1) - length(s2) : length(s2) - length(s1));

        printf("Distance between %s and %s is %d insertions and %d deletions\n", s1, s2, d_i_counter+i_counter, d_i_counter+d_counter);
    }
}
