/*
 *  File:   utility_functions.h
 *  Author: Riccardo Sieve
 *
 *  Created on 19 October, 11:27
 */

#ifndef UTILITY_FUNCTIONS_INCLUDED
#define UTILITY_FUNCTIONS_INCLUDED

#include <stdio.h>
#include <stdlib.h>

int random_number(int );
int* new_int(int );
float* new_float(float );
long* new_long(long );
double* new_double(double );
char* new_string(char* );
void print_int(void *);
void print_float(void *);
void print_long(void *);
void print_double(void *);
void print_string(void *);

#endif
