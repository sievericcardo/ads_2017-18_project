OUTPUT= build/priority_queue.out
OUTPUT_TEST= build/priority_queue_test.out

C= gcc
CFLAGS= -std=c99 -pedantic -Werror

UTILS= utils/error_handling.c utils/utility_functions.c
TEST_UTILS= test/Unity/unity.c

INPUT= $(C) $(CFLAGS) $(UTILS) algorithms/priority_queue.c usage/priority_queue_usage.c -o $(OUTPUT)

INPUT_TEST= $(C) $(CFLAGS) $(UTILS) $(TEST_UTILS) algorithms/priority_queue.c test/priority_queue_tests.c -o $(OUTPUT_TEST)

.PHONY: clean

all:
	$(INPUT) && $(INPUT_TEST)

clean:
	rm -rf build/*

run:
	./$(OUTPUT)

queue_test:
	./$(OUTPUT_TEST)