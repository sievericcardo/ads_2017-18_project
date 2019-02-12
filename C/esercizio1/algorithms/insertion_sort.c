#include "headers/insertion_sort.h"

/*
 * Swapping the address of the whole data structure. Creating a temp data 
 * and then swap the whole buckets */
void swap_elements(void** element1, void** element2) {
    void* temp = *element1;
    *element1 = *element2;
    *element2 = temp;
}

void insertion_sort(ArrayList* arraylist, int (*fptr)(void*, void*)) {
    int i=0, j=0;
    
    for (i=0; i<arraylist->size-1; i++) {
        if(((*fptr)(ArrayList_get(arraylist, i+1), 
                    (ArrayList_get(arraylist, i)))) == -1)
            for(j=i+1; j>=1; j--) {
                if(((*fptr)(ArrayList_get(arraylist, j), 
                            ArrayList_get(arraylist, j-1))) == -1) {
                    swap_elements(&((arraylist->data)[j]), &((arraylist->data))[j-1]);
                } else {
                    j=0;
                }
            }
    }
}
