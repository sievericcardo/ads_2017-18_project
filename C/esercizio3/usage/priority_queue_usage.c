/**
 *  Usage for the priority queue.
 *  It accepts as input any kind of type (it has been tested as follows with
 *  int, float, double, long and strings). First of all it must be created
 *  an element of type queue (which is a Node*), than it is updated every time
 *  Queue_insert_element is called.
 *  Insert element accepts: the queue that will be returned after insertion,
 *  the element casted to pointer of type calling the function created to
 *  generate a new element (int, float, long, double, char*), the size of the
 *  element (sizeof(type)) and the priority (works well with random). The
 *  priority can be created with rand() or, if willing to give a range, with
 *  random_number(limit).
 *  print_queue needs the queue and the pointer function (print_type).
 *  Queue_delete_element needs only the queue as it will automatically search for
 *  the first element with maximum priority to eliminate */

#include "../algorithms/headers/priority_queue.h"
#include "../utils/headers/utility_functions.h"
#include <math.h>

int main() {

    printf("Starting simulation with integers value\n");

    Queue int_queue = NULL;

    printf("Start inserting data\n");

    int_queue = Queue_insert_element(int_queue, (int*) new_int(15), sizeof(int), random_number(100));
    int_queue = Queue_insert_element(int_queue, (int*) new_int(7), sizeof(int), random_number(100));
    int_queue = Queue_insert_element(int_queue, (int*) new_int(4), sizeof(int), random_number(100));
    int_queue = Queue_insert_element(int_queue, (int*) new_int(13), sizeof(int), random_number(100));
    int_queue = Queue_insert_element(int_queue, (int*) new_int(20), sizeof(int), random_number(100));
    int_queue = Queue_insert_element(int_queue, (int*) new_int(8), sizeof(int), random_number(100));
    int_queue = Queue_insert_element(int_queue, (int*) new_int(1), sizeof(int), random_number(100));

    print_queue(int_queue, print_int);

    //int_queue = Queue_delete_element(int_queue);
    Queue_delete_element(int_queue);

    print_queue(int_queue, print_int);

    Queue float_queue = NULL;

    float_queue = Queue_insert_element(float_queue, (float*) new_float(15), sizeof(float), random_number(100));
    float_queue = Queue_insert_element(float_queue, (float*) new_float(7), sizeof(float), random_number(100));
    float_queue = Queue_insert_element(float_queue, (float*) new_float(4), sizeof(float), random_number(100));
    float_queue = Queue_insert_element(float_queue, (float*) new_float(13), sizeof(float), random_number(100));
    float_queue = Queue_insert_element(float_queue, (float*) new_float(20), sizeof(float), random_number(100));
    float_queue = Queue_insert_element(float_queue, (float*) new_float(8), sizeof(float), random_number(100));
    float_queue = Queue_insert_element(float_queue, (float*) new_float(1), sizeof(float), random_number(100));

    print_queue(float_queue, print_float);

    Queue_delete_element(float_queue);

    print_queue(float_queue, print_float);

    printf("Size of %ld\n", int_queue->size);

    printf("Starting simulation with long value\n");

    Queue long_queue = NULL;

    long_queue = Queue_insert_element(long_queue, (long*) new_long(15), sizeof(long), random_number(100));
    long_queue = Queue_insert_element(long_queue, (long*) new_long(7), sizeof(long), random_number(100));
    long_queue = Queue_insert_element(long_queue, (long*) new_long(4), sizeof(long), random_number(100));
    long_queue = Queue_insert_element(long_queue, (long*) new_long(13), sizeof(long), random_number(100));
    long_queue = Queue_insert_element(long_queue, (long*) new_long(20), sizeof(long), random_number(100));
    long_queue = Queue_insert_element(long_queue, (long*) new_long(8), sizeof(long), random_number(100));
    long_queue = Queue_insert_element(long_queue, (long*) new_long(1), sizeof(long), random_number(100));

    print_queue(long_queue, print_long);

    Queue_delete_element(long_queue);

    print_queue(long_queue, print_long);

    printf("Starting simulation with double value\n");

    Queue double_queue = NULL;

    double_queue = Queue_insert_element(double_queue, (double*) new_double(15), sizeof(double), random_number(100));
    double_queue = Queue_insert_element(double_queue, (double*) new_double(7), sizeof(double), random_number(100));
    double_queue = Queue_insert_element(double_queue, (double*) new_double(4), sizeof(double), random_number(100));
    double_queue = Queue_insert_element(double_queue, (double*) new_double(13), sizeof(double), random_number(100));
    double_queue = Queue_insert_element(double_queue, (double*) new_double(20), sizeof(double), random_number(100));
    double_queue = Queue_insert_element(double_queue, (double*) new_double(8), sizeof(double), random_number(100));
    double_queue = Queue_insert_element(double_queue, (double*) new_double(1), sizeof(double), random_number(100));

    print_queue(double_queue, print_double);

    Queue_delete_element(double_queue);

    print_queue(double_queue, print_double);

    printf("Starting simulation with strings\n");

    Queue string_queue = NULL;

    string_queue = Queue_insert_element(string_queue, (char*) new_string("Simulation"), sizeof(char*), random_number(100));
    string_queue = Queue_insert_element(string_queue, (char*) new_string("for"), sizeof(char*), random_number(100));
    string_queue = Queue_insert_element(string_queue, (char*) new_string("the"), sizeof(char*), random_number(100));
    string_queue = Queue_insert_element(string_queue, (char*) new_string("priority"), sizeof(char*), random_number(100));
    string_queue = Queue_insert_element(string_queue, (char*) new_string("queue"), sizeof(char*), random_number(100));
    string_queue = Queue_insert_element(string_queue, (char*) new_string("exercise"), sizeof(char*), random_number(100));

    print_queue(string_queue, print_string);

    Queue_delete_element(string_queue);

    print_queue(string_queue, print_string);

    return 0;
}
