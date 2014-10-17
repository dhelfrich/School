#include "singly_linked_list.h"

using namespace std;

struct list_queue {
	node* head_ptr;
	node* tail_ptr;
};

void init(list_queue& que);

void destr(list_queue& que);

void add(list_queue& que, const int& payload);

bool remove(list_queue& que);

int front(const list_queue& que);

bool empty(const list_queue& que);

void print(const list_queue& que);
