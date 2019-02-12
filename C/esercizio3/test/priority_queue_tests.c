#include "../algorithms/headers/priority_queue.h"
#include "Unity/unity.h"
#include "Unity/unity_internals.h"

#include <stdlib.h>
#include <math.h>
#include <string.h>

static void test_queue_with_one_element() {
    Queue queue = NULL;

    queue = Queue_insert_element(queue, (int*)new_int(10), sizeof(int), 20);

    TEST_ASSERT_EQUAL_INT(20, get_max_priority(queue));

    Queue_free(queue);
}

static void test_queue_with_multiple_elements() {
    Queue queue = NULL;

    queue = Queue_insert_element(queue, (int*)new_int(10), sizeof(int), 20);
    queue = Queue_insert_element(queue, (float*)new_int(100), sizeof(float), 8);
    queue = Queue_insert_element(queue, (double*)new_int(80), sizeof(double), 24);
    queue = Queue_insert_element(queue, (char*)new_string("test"), sizeof(char*), 10);
    queue = Queue_insert_element(queue, (long*)new_int(64), sizeof(int), 40);

    TEST_ASSERT_EQUAL_INT(40, get_max_priority(queue));

    Queue_free(queue);
}

static void test_delete_queue_with_one_element() {
    Queue queue = NULL;

    queue = Queue_insert_element(queue, (int*)new_int(10), sizeof(int), 20);

    Queue_delete_element(queue);

    TEST_ASSERT_EQUAL_INT(20, get_max_priority(queue));

    Queue_free(queue);
}

static void test_delete_queue_with_multiple_elements() {
    Queue queue = NULL;

    queue = Queue_insert_element(queue, (int*)new_int(10), sizeof(int), 20);
    queue = Queue_insert_element(queue, (float*)new_int(14), sizeof(int), 8);
    queue = Queue_insert_element(queue, (double*)new_int(40), sizeof(int), 24);
    queue = Queue_insert_element(queue, (char*)new_string("test"), sizeof(char*), 10);
    queue = Queue_insert_element(queue, (long*)new_int(81), sizeof(int), 40);
    queue = Queue_insert_element(queue, (long*)new_int(81), sizeof(int), 6);

    Queue_delete_element(queue);

    TEST_ASSERT_EQUAL_INT(24, get_max_priority(queue));

    Queue_free(queue);
}

int main() {
    UNITY_BEGIN();
    RUN_TEST(test_queue_with_one_element);
    RUN_TEST(test_queue_with_multiple_elements);
    RUN_TEST(test_delete_queue_with_one_element);
    RUN_TEST(test_delete_queue_with_multiple_elements);
    UNITY_END();

    return 0;
}
