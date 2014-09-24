#include "singly_linked_list.h"

using namespace std;

void add_node(node*& head_ptr, const int& payload)
{
    //first add a node to store the payload
    node* new_node = new node();
    new_node->data = payload;

    //if the list is empty, make the head point to the new node and 
    //the new node point to nullptr
    if( head_ptr == nullptr)
    {
        head_ptr = new_node;
        new_node->next = nullptr;
    }
    //if the new node should go at the front, we need a special case
    else if(new_node->data < head_ptr->data) 
    {
        new_node->next = head_ptr;
        head_ptr = new_node;
    }

    //find the first node whose number is bigger (or equal to) payload
    else
    {
        node* cursor = head_ptr;
        node* cursor_after = head_ptr->next;
        //scroll to the first location where cursor points to data greater than
        //or equal to payload 
        while(cursor != nullptr && cursor_after != nullptr && cursor_after->data < payload)
        {
            cursor = cursor->next;
            cursor_after = cursor_after->next;
        }
        new_node->next = cursor->next; 
        cursor->next = new_node; 
    }





}

bool remove_node(node*& head_ptr, const int& target)
{
    //need a special case for when the target is the head
    if(head_ptr->data == target)
    {
        node *destroy = head_ptr;
        head_ptr = head_ptr->next;
        delete destroy;
        return true;
    }
    node* cursor = head_ptr;
    //find the node before the one you want to remove, so you can later set it to point to
    //the node after the target
    while (cursor != nullptr)
    {
        if(cursor->next != nullptr && cursor->next->data == target)
        {
            node* destroy = cursor->next;
            cursor->next = cursor->next->next;
            delete destroy;
            return true;
        }
        cursor = cursor->next;
    }
    return false;
}

bool find_list(const node*& head_ptr, const int& target)
{
    const node* cursor = head_ptr;
    while (cursor != nullptr)
    {
        if(cursor->data == target)
            return true;
        cursor = cursor->next;
    }
    return false;
}

//delete all elements
void clear_list(node*& head_ptr)
{
    //if the list is already clear - return

    if(head_ptr == nullptr)
        return;

    //start at the second node and delete all the nodes until it is the nullptr
    //then point head_ptr to null
    node* cursor = head_ptr->next;
    while (cursor != nullptr)
    {
        node* destroy;
        destroy = cursor;
        delete destroy;
        cursor = cursor->next;
    }
    head_ptr = nullptr;
}

void print_list(const node*& head_ptr)
{
    const node* cursor = head_ptr;
    while (cursor != nullptr)
    {
        cout << cursor->data << " ";
        cursor = cursor->next;
    }
    cout << endl;
}

//this will copy recursively starting at the end node.
void copy_list(const node*& source_ptr, node*& dest_ptr)
{
    //first clear the list associated with the dest_ptr
    //base case 1 - source empty
    if(source_ptr == nullptr) 
    {
        clear_list(dest_ptr);
        return;
    }
    //base case 2 - source has only one item
    //make a new node with the same data as the source - point it to null
    else if(source_ptr->next == nullptr)
    {
        node *new_node = new node();
        new_node->data = source_ptr->data;
        new_node->next = nullptr;
        clear_list(dest_ptr);
        dest_ptr = new_node;
        return;
    }
    //first call the copy function on the next nodes
    //make a new node, make it's data the same as the source node's data
    //then make it point to the destination 
    else
    {
        const node* source_ptr_next = source_ptr->next;
        copy_list(source_ptr_next, dest_ptr);
        node *new_node = new node();
        new_node->data = source_ptr->data;
        new_node->next = dest_ptr;
        dest_ptr = new_node;
    }

        
}

