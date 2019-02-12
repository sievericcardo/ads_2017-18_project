/*
 *  File:   priority_queue.h
 *  Author: Riccardo Sieve
 *
 *  Created on 16 October, 14:20
 */

#ifndef PRIORITY_QUEUE_INCLUDED
#define PRIORITY_QUEUE_INCLUDED

#include "../../utils/headers/utility_functions.h"
#include "../../utils/headers/error_handling.h"
#include <limits.h>
#include <assert.h>

/* Custom boolean type */
typedef enum {FALSE, TRUE} boolean;

struct Node {
    size_t size;
    void* element;
    int priority;
    struct Node* next;
};

typedef struct Node* Queue;

Queue Queue_insert_element(Queue , void* , size_t , int );
void Queue_delete_element(Queue );
void Queue_free(Queue);
void print_queue(Queue , void (*fptr)(void*));
int get_max_priority(Queue );

#endif
