#include <iostream>
using namespace std;

struct node {
	int data;
	node* next;
};

void clear_list(node*& head_ptr)
{
    if (head_ptr == nullptr) return;
    if (head_ptr->next == nullptr)
    {
        delete head_ptr; head_ptr = nullptr; return;
    }
    clear_list(head_ptr->next);
}
