OUTPUT_INSERTION= build/insertion.out
OUTPUT_INSERTION_TEST= build/insertion_test.out

OUTPUT_MERGE= build/merge.out
OUTPUT_MERGE_TEST= build/merge_test.out

C= gcc
CFLAGS= -std=c99 -pedantic -Werror

UTILS= utils/error_handling.c algorithms/arraylist.c
TEST_UTILS= test/Unity/unity.c

INPUT_INSERTION= $(C) $(CFLAGS) $(UTILS) algorithms/insertion_sort.c usage/insertion_sort_usage.c -o $(OUTPUT_INSERTION)

INPUT_INSERTION_TEST= $(C) $(CFLAGS) $(UTILS) $(TEST_UTILS) algorithms/insertion_sort.c test/insertion_sort_tests.c -o $(OUTPUT_INSERTION_TEST)

INPUT_MERGE= $(C) $(CFLAGS) $(UTILS) algorithms/merge_sort.c usage/merge_sort_usage.c -o $(OUTPUT_MERGE)

INPUT_MERGE_TEST= $(C) $(CFLAGS) $(UTILS) $(TEST_UTILS) algorithms/merge_sort.c test/merge_sort_tests.c -o $(OUTPUT_MERGE_TEST)

.PHONY: clean

all:
	$(INPUT_INSERTION) && $(INPUT_INSERTION_TEST) && $(INPUT_MERGE) && $(INPUT_MERGE_TEST)

clean:
	rm -rf build/* out.txt

run:
	./$(OUTPUT_INSERTION)

insertion_test:
	./$(OUTPUT_INSERTION_TEST)

merge:
	./$(OUTPUT_MERGE)

merge_test:
	./$(OUTPUT_MERGE_TEST)
