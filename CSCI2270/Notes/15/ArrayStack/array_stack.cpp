#include "array_stack.h"

using namespace std;


void init(array_stack& stk)
{
	init(stk.arr);
}

void destr(array_stack& stk)
{
	destr(stk.arr);
}

void print(const array_stack& stk)
{
	cout << "stack" << endl;
	print(stk.arr);
}

void push(array_stack& stk, const int& payload)
{
	add(stk.arr, payload);
}

bool pop(array_stack& stk)
{
	if (stk.arr.count == 0)
		return false;
	stk.arr.count--;
	return true;
}

int top(const array_stack& stk)
{
	return stk.arr.data[stk.arr.count-1];
}

bool empty(const array_stack& stk)
{
	return stk.arr.count == 0;
}
