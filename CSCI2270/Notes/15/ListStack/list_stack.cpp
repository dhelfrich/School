#include "list_stack.h"

using namespace std;

void init(list_stack& stk)
{
    stk.head_ptr = nullptr;
}

void push(list_stack& stk, const int& payload)
{
    if (stk.head_ptr == nullptr)
    {   
        stk.head_ptr = new node();
        stk.head_ptr->data = payload;
        stk.head_ptr->next = nullptr;
    
    }
    else
    {
        node* rest_of_list = stk.head_ptr;     
        stk.head_ptr = new node();
        stk.head_ptr->data = payload;
        stk.head_ptr->next = rest_of_list;
    }
}

bool pop(list_stack& stk)
{
    if (stk.head_ptr == nullptr)
        return false;
    node* rest_of_list = stk.head_ptr->next;
    delete stk.head_ptr;
    stk.head_ptr = rest_of_list;
    return true;

}

void destr(list_stack& stk)
{
    clear_list(stk.head_ptr);

}

void print(const list_stack& stk)
{
    print_list(stk.head_ptr);

}

bool empty(list_stack& stk)
{
    return (stk.head_ptr == nullptr);

}

int top(list_stack& stk)
{
    return stk.head_ptr->data;

}

