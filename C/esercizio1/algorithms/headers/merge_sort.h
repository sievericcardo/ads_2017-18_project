/*
 *  File:   merge_sort.h
 *  Author: Riccardo Sieve
 *
 *  Created on 5 November, 14:20
 */

#ifndef MERGE_SORT_INCLUDED
#define MERGE_SORT_INCLUDED

#include "../../utils/headers/error_handling.h"
#include "arraylist.h"

/* It accepts as input a pointer to a function implementing the */
/* relation precedence between the array elements. */
/* Such a function must accept as input two pointers to elements and */
/* return 0 iff the first element does not precede the second one and */
/* a number different from zero otherwise. */
void merge_sort(ArrayList*, int (*fptr)(void*, void*), int, int);

#endif
