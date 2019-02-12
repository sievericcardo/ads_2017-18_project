#include "headers/merge_sort.h"

void merge(ArrayList* arraylist, int (*fptr)(void*, void*), int l, int m, int r) {
    int i, j, k;
    int first_parser = m - l + 1;
    int second_parser =  r - m;
  
    /* create temp arrays */
    void** left_subarray;
    void** right_subarray;

    left_subarray = (void**) malloc(first_parser * sizeof(void*));
    right_subarray = (void**) malloc(second_parser * sizeof(void*));

    if(left_subarray == NULL || right_subarray == NULL) {
        malloc_exception();
    }
  
    /* Copy data to temp arrays left_subarray[] and right_subarray[] */
    for (i = 0; i < first_parser; i++) 
        left_subarray[i] = ArrayList_get(arraylist, l+i); 
    for (j = 0; j < second_parser; j++)
        right_subarray[j] = ArrayList_get(arraylist, m+1+j);

    /* Merge the temp arrays back into arraylist[l..r]*/
    i = 0; // Initial index of first subarray 
    j = 0; // Initial index of second subarray 
    k = l; // Initial index of merged subarray

    while (i < first_parser && j < second_parser) {
        if (!(((*fptr)(right_subarray[j], left_subarray[i])) == -1)) {
            (arraylist->data)[k] = (left_subarray)[i]; 
            i++; 
        } else {
            (arraylist->data)[k] = (right_subarray)[j];
            j++;
        } 
        k++; 
    }

    /* Copy the remaining elements of left_subarray[] */
    while (i < first_parser) {
        (arraylist->data)[k] = (left_subarray)[i]; 
        i++; 
        k++; 
    }

    /* Copy the remaining elements of right_subarray[] */
    while (j < second_parser) 
    { 
        (arraylist->data)[k] = (right_subarray)[j]; 
        j++; 
        k++; 
    } 
} 

void merge_sort(ArrayList* arraylist, int (*fptr)(void*, void*), int l, int r) {
    if(l<r) {
        int p = l+(r-l)/2;

        merge_sort(arraylist, fptr, l, p);
        merge_sort(arraylist, fptr, p+1, r);

        merge(arraylist, fptr, l, p, r);
    }
}
