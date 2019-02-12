DISTANCE_USAGE= build/distance.out
DISTANCE_TEST= build/distance_test.out

C= gcc
CFLAGS= -std=c99 -pedantic -Werror

UTILS= utils/error_handling.c
TEST_UTILS= test/Unity/unity.c

USAGE= $(C) $(CFLAGS) $(UTILS) algorithms/edit_distance.c  usage/edit_distance_usage.c -o $(DISTANCE_USAGE)

TEST= $(C) $(CFLAGS) $(UTILS) $(TEST_UTILS) algorithms/edit_distance.c  test/edit_distance_tests.c -o $(DISTANCE_TEST)

.PHONY: clean

all:
	$(USAGE) && $(TEST)

clean:
	rm -rf build/*

run:
	./$(DISTANCE_USAGE)

distance_test:
	./$(DISTANCE_TEST)