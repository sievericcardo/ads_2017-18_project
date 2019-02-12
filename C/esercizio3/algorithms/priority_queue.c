/**
 *  Code for the implementation of the priority queue.
 *  The algorithm has been implemented using the linked list data structure
 *  instead of the binary heap.
 *  The idea behind this choice is that linked lists are generally easier to
 *  mantain than binary heap and, even if the deletion complexity is O(n)
 *  whereas the complexity of the binary heap is O(lg n), we have an insertion
 *  complexity of O(1) whereas the complexity in binary heap is O(lg n),
 *  therefore in inserting our performance are slightly better.
 */

#include "headers/priority_queue.h"

int max(int number1, int number2) {
    return (number1 > number2 ? number1 : number2);
}

/*
 * We parse all the list to find the fist element with maximum priority
 * and return it */
struct Node* find_max_element(Queue queue) {
    void* max_element;
    int max_priority = -(INT_MAX);

    for(struct Node* iterator = queue;
                    iterator != NULL;
                    iterator = iterator->next) {
        if(max_priority < iterator->priority) {
            max_priority = iterator->priority;
            max_element = iterator->element;
        }
    }

    struct Node* max_element_node = (struct Node*) malloc (sizeof(struct Node));

    if(!max_element_node) {
        malloc_exception();
    }

    max_element_node->priority = max_priority;
    max_element_node->element = max_element;

    return max_element_node;
}

/* With head insertion I have O(1) in insertion */
Queue Queue_insert_element(Queue queue, void* element, size_t data_size, int priority) {
    struct Node* new_node = (struct Node*)  malloc(2*sizeof(struct Node));

    if(!new_node) {
        malloc_exception();
    }

    new_node->element = (void *) malloc (sizeof(data_size));
    new_node->element = element;
    new_node->priority = priority;
    
    if(queue) {
        new_node->next = queue;
        queue = new_node;
    } else {
        new_node->next = NULL;
        queue = new_node;
    }

    assert(queue); // It MUST exist by now

    return queue;
}

/*
 * We first call the function find_max_element and save it to a Node so that
 * we will know which element to remove */
void Queue_delete_element (Queue queue) {
    assert(queue); // Assert that a queue exists

    if(!queue->next) {
        queue = NULL;
        return;
    }

    struct Node* max_node = find_max_element(queue);
    struct Node* previous = NULL;

    printf("Found element with max priority %d\n", max_node->priority);

    for(struct Node* iterator = queue;
                iterator != NULL;
                previous = iterator, iterator = iterator->next) {
        if(iterator->priority == max_node->priority && iterator->element == max_node->element) {
            if(previous == NULL) {
                queue = iterator->next;
            } else if(iterator->next == NULL) {
                previous->next = NULL;
            } else {
                previous->next = iterator->next;
            }

            free(iterator);
        }   
    }
}

void Queue_free(Queue queue) {
    free(queue);
}

/* We use a pointer function to make it generic */
void print_queue(Queue queue, void (*fptr)(void*)) {
    printf("List values: ");
    for(struct Node* iterator = queue;
                iterator != NULL;
                iterator = iterator->next) {
        (*fptr)(iterator->element);
    }
    printf("\n");
    printf("List Priorities: ");
    for(struct Node* iterator = queue;
                iterator != NULL;
                iterator = iterator->next) {
        printf("%d ", iterator->priority);
    }
    printf("\n");
    printf("\n");
}

/*
 * We parse all the list to find the fist element with maximum priority
 * and return it */
int get_max_priority(Queue queue) {
    int max_priority = -(INT_MAX);

    for(struct Node* iterator = queue;
                    iterator != NULL;
                    iterator = iterator->next) {
        if(max_priority < iterator->priority) {
            max_priority = iterator->priority;
        }
    }

    return max_priority;
}

