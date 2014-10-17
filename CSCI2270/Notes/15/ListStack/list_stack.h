#include "singly_linked_list.h"

using namespace std;

struct list_stack {
	node* head_ptr;
};

void init(list_stack& stk);

void destr(list_stack& stk);

void push(list_stack& stk, const int& payload);

bool pop(list_stack& stk);

int top(const list_stack& stk);

bool empty(const list_stack& stk);

void print(const list_stack& stk);
