#include "../algorithms/headers/edit_distance.h"
#include "Unity/unity.h"
#include "Unity/unity_internals.h"

#include <stdlib.h>
#include <math.h>
#include <string.h>

static void test_iterative_empty_string () {
    char* str1 = "";
    char* str2 = "test";

    TEST_ASSERT_EQUAL_INT(strlen(str2), edit_distance(str1, str2));
}

static void test_recursive_empty_string () {
    char* str1 = "";
    char* str2 = "test";

    TEST_ASSERT_EQUAL_INT(strlen(str2), edit_distance_dyn(str1, str2));
}

static void test_iterative_empty_string_1 () {
    char* str1 = "test";
    char* str2 = "";

    TEST_ASSERT_EQUAL_INT(strlen(str1), edit_distance(str1, str2));
}

static void test_recursive_empty_string_1 () {
    char* str1 = "test";
    char* str2 = "";

    TEST_ASSERT_EQUAL_INT(strlen(str1), edit_distance_dyn(str1, str2));
}

static void test_iterative_string_with_distance_0 () {
    char* str1 = "mia";
    char* str2 = "mai";

    TEST_ASSERT_EQUAL_INT(0, edit_distance_dyn(str1, str2));
}

static void test_recursive_string_with_distance_0 () {
    char* str1 = "mia";
    char* str2 = "mai";

    TEST_ASSERT_EQUAL_INT(0, edit_distance_dyn(str1, str2));
}

static void test_iterative_string_with_distance_1 () {
    char* str1 = "main";
    char* str2 = "mia";

    TEST_ASSERT_EQUAL_INT(1, edit_distance_dyn(str1, str2));
}

static void test_recursive_string_with_distance_1 () {
    char* str1 = "main";
    char* str2 = "mia";

    TEST_ASSERT_EQUAL_INT(1, edit_distance_dyn(str1, str2));
}

static void test_iterative_string_with_distance_5 () {
    char* str1 = "Asti";
    char* str2 = "Cuneo";

    TEST_ASSERT_EQUAL_INT(5, edit_distance_dyn(str1, str2));
}

static void test_recursive_string_with_distance_5 () {
    char* str1 = "Asti";
    char* str2 = "Cuneo";

    TEST_ASSERT_EQUAL_INT(5, edit_distance_dyn(str1, str2));
}

static void test_iterative_string_with_distance_7 () {
    char* str1 = "Carmagnola";
    char* str2 = "Sciarpa";

    TEST_ASSERT_EQUAL_INT(7, edit_distance_dyn(str1, str2));
}

static void test_recursive_string_with_distance_7 () {
    char* str1 = "Carmagnola";
    char* str2 = "Sciarpa";

    TEST_ASSERT_EQUAL_INT(7, edit_distance_dyn(str1, str2));
}

int main() {
    UNITY_BEGIN();
    RUN_TEST(test_iterative_empty_string);
    RUN_TEST(test_recursive_empty_string);
    RUN_TEST(test_iterative_empty_string_1);
    RUN_TEST(test_recursive_empty_string_1);
    RUN_TEST(test_iterative_string_with_distance_0);
    RUN_TEST(test_recursive_string_with_distance_0);
    RUN_TEST(test_iterative_string_with_distance_1);
    RUN_TEST(test_recursive_string_with_distance_1);
    RUN_TEST(test_iterative_string_with_distance_5);
    RUN_TEST(test_recursive_string_with_distance_5);
    RUN_TEST(test_iterative_string_with_distance_7);
    RUN_TEST(test_recursive_string_with_distance_7);
    UNITY_END();

    return 0;
}
