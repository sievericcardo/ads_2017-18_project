#include "../algorithms/headers/merge_sort.h"
#include "Unity/unity.h"
#include "Unity/unity_internals.h"

#include <stdlib.h>
#include <math.h>

static void test_arraylist_ordered() {
    ArrayList* arraylist = ArrayList_create();

    for(int i=0; i<100; i++) {
        ArrayList_add(arraylist, (int*)new_int(rand()%100));
    }

    merge_sort(arraylist, compare_int, 0, arraylist->size-1);

    for(int i=0; i<99; i++)
        TEST_ASSERT_NOT_EQUAL(1, compare_int((int*)arraylist->data[i], 
                                             (int*)arraylist->data[i+1]));

    TEST_ASSERT_EQUAL_INT(100, arraylist->size);
}

static void test_arraylist_reverse_ordered() {
    ArrayList* arraylist = ArrayList_create();

    for(int i=50; i>0; i--) {
        ArrayList_add(arraylist, (int*)new_int(i));
    }

    merge_sort(arraylist, compare_int, 0, arraylist->size-1);

    for(int i=0; i<49; i++)
        TEST_ASSERT_NOT_EQUAL(1, compare_int((int*)arraylist->data[i], 
                                             (int*)arraylist->data[i+1]));

    TEST_ASSERT_EQUAL_INT(50, arraylist->size);
    TEST_ASSERT_EQUAL_INT(20, *(int*)ArrayList_get(arraylist, 19));
}

static void test_arraylist_already_ordered() {
    ArrayList* arraylist = ArrayList_create();

    for(int i=0; i<50; i++) {
        ArrayList_add(arraylist, (int*)new_int(i));
    }

    merge_sort(arraylist, compare_int, 0, arraylist->size-1);

    for(int i=0; i<49; i++)
        TEST_ASSERT_NOT_EQUAL(1, compare_int((int*)arraylist->data[i], 
                                             (int*)arraylist->data[i+1]));

    TEST_ASSERT_EQUAL_INT(50, arraylist->size);
    TEST_ASSERT_EQUAL_INT(19, *(int*)ArrayList_get(arraylist, 19));
}

int main() {
    UNITY_BEGIN();
    RUN_TEST(test_arraylist_ordered);
    RUN_TEST(test_arraylist_reverse_ordered);
    RUN_TEST(test_arraylist_already_ordered);
    UNITY_END();

    return 0;
}
