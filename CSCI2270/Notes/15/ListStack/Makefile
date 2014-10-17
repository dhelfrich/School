# Make file for HW4, CSCI2270
# All compilations occur with -Wall to print warnings, and -g to allow gdb debugging.
# The clean command uses rm to remove all expendable files (rm is part of
# the cs1300 compiler tools from www.cs.colorado.edu/~main/cs1300/README.html).

# define the different outputs of all g++ commands
# on Ubuntu, the .exe suffix disappears
EXPENDABLES = test_list_stack.o test_list_stack singly_linked_list.o list_stack.o

# make all is listed first, which lets you type "make" to recompile 
# anything that has changed in either your class, your test code, 
# or my test code.
all:
	@make $(EXPENDABLES)

# this compiles your test program and your singly_linked_list class together
test_list_stack: test_list_stack.o singly_linked_list.o list_stack.o
	g++ -std=c++0x -Wall -g test_list_stack.o singly_linked_list.o list_stack.o -o test_list_stack 

singly_linked_list.o: singly_linked_list.h singly_linked_list.cpp
	g++ -std=c++0x -Wall -g -c singly_linked_list.cpp -o singly_linked_list.o

list_stack.o: list_stack.h list_stack.cpp
	g++ -std=c++0x -Wall -g -c list_stack.cpp -o list_stack.o

# this compiles your test program, which is executable
test_list_stack.o: singly_linked_list.h test_list_stack.cpp list_stack.h
	g++ -std=c++0x -Wall -g -c test_list_stack.cpp -o test_list_stack.o

# this deletes all the output files
clean:
	rm -f $(EXPENDABLES)
