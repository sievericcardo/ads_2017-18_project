/*
 *  File:   edit_distance.h
 *  Author: Riccardo Sieve
 *
 *  Created on 17 October, 10:30
 */

#ifndef EDIT_DISTANCE_INCLUDED
#define EDIT_DISTANCE_INCLUDED

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* Custom boolean type */
typedef enum {FALSE, TRUE} boolean;

int length (char* );
int edit_distance (char* , char* );
int edit_distance_dyn (char* , char* );
void print_distance (char* , char* );
void print_distance_r (char* , char* );

#endif
