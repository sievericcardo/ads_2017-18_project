#include "headers/utility_functions.h"

int random_number(int number) {
    return rand() % number;
}

/*
 * The following functions serve us to create new elements that we need when
 * we insert the into the list.
 * We create a function for almost every type */
int* new_int(int value) {
    int* element = (int*) malloc (sizeof(int));
    *element = value;

    return element;
}

float* new_float(float value) {
    float* element = (float*) malloc (sizeof(float));
    *element = value;

    return element;
}

long* new_long(long value) {
    long* element = (long*) malloc (sizeof(long));
    *element = value;

    return element;
}

double* new_double(double value) {
    double* element = (double*) malloc (sizeof(double));
    *element = value;

    return element;
}

char* new_string(char* string) {
    return string;
}

/*
 * Functions used to generate the pointer functions that will be used to print
 * the content of the list */
void print_int (void *element) {
    printf("%d ", *(int *)element);
}

void print_float (void *element) {
    printf("%f ", *(float *)element);
}

void print_long (void *element) {
    printf("%ld ", *(long *)element);
}

void print_double (void *element) {
    printf("%f ", *(double *)element);
}

void print_string (void *element) {
    printf("%s ", (char *)element);
}
