# All compilations occur with -Wall to print warnings, and -g to allow gdb debugging.
# The clean command uses rm to remove all expendable files (rm is part of
# the cs1300 compiler tools from www.cs.colorado.edu/~main/cs1300/README.html).

# define the different outputs of all g++ commands
# on Ubuntu, the .exe suffix disappears
EXPENDABLES = test_list_queue.o test_list_queue singly_linked_list.o list_queue.o

# make all is listed first, which lets you type "make" to recompile 
# anything that has changed in either your class, your test code, 
# or my test code.
all:
	@make $(EXPENDABLES)

# this compiles your test program and your queue and singly_linked_list class together
test_list_queue: test_list_queue.o singly_linked_list.o list_queue.o
	g++ -std=c++0x -Wall -g test_list_queue.o singly_linked_list.o list_queue.o -o test_list_queue 

singly_linked_list.o: singly_linked_list.h singly_linked_list.cpp
	g++ -std=c++0x -Wall -g -c singly_linked_list.cpp -o singly_linked_list.o

list_queue.o: list_queue.h list_queue.cpp
	g++ -std=c++0x -Wall -g -c list_queue.cpp -o list_queue.o

test_list_queue.o: singly_linked_list.h test_list_queue.cpp list_queue.h
	g++ -std=c++0x -Wall -g -c test_list_queue.cpp -o test_list_queue.o

# this deletes all the output files
clean:
	rm -f $(EXPENDABLES)
