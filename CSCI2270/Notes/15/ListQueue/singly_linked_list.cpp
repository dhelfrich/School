#include "singly_linked_list.h"

using namespace std;

void add_node(node*& head_ptr, const int& payload)
{
	node* added_node = new node;
	added_node->data = payload;
	if (head_ptr == nullptr)
	{
		head_ptr = added_node;
		added_node->next = nullptr;
	}
	else
	{
		if (head_ptr->data > payload)
		{
			added_node->next = head_ptr;
			head_ptr = added_node;
		}
		else
		{
			node* cursor = head_ptr;
			while (cursor != nullptr && cursor->next != nullptr 
				&& cursor->next->data < payload)
				cursor = cursor->next;
			if (cursor->next == nullptr)
			{	
				cursor->next = added_node;
				added_node->next = nullptr;
			}	
			else
			{
				added_node->next = cursor->next;
				cursor->next = added_node;
			}
		}
	}		
}

bool remove_node(node*& head_ptr, const int& target)
{
	if (head_ptr == nullptr) return false;
	
	node* removed_node_ptr = head_ptr;	
	if (removed_node_ptr->data == target)
	{
		head_ptr = head_ptr->next;
		delete removed_node_ptr;
		removed_node_ptr = nullptr;
		return true;
	}
	
	while (removed_node_ptr != nullptr && 
		removed_node_ptr->next != nullptr &&
		removed_node_ptr->next->data != target)
		removed_node_ptr = removed_node_ptr->next;
		
	if (removed_node_ptr != nullptr &&
		removed_node_ptr->next != nullptr)
	{
		node* next_node_ptr = removed_node_ptr->next->next; 
		delete removed_node_ptr->next;
		removed_node_ptr->next = next_node_ptr;
		return true;
	}
		
	return false;	
}

void clear_list(node*& head_ptr)
{
	node* destroyed_node_ptr;
	while (head_ptr != nullptr)
	{
		destroyed_node_ptr = head_ptr;
		head_ptr = head_ptr->next;
		delete destroyed_node_ptr;
	}
}

void print_list(const node* head_ptr)
{
	const node* printed_node_ptr = head_ptr;
	while (printed_node_ptr != nullptr)
	{
		cout << printed_node_ptr->data << " ";
		printed_node_ptr = printed_node_ptr->next;
	}
	cout << endl;
}

bool find_list(const node* head_ptr, const int& target)
{
	const node* cursor = head_ptr;
	while (cursor != nullptr)
	{
		if (cursor->data == target)
			return true;
		cursor = cursor->next;
	}
	return false;
}

void copy_list(const node* source_ptr, node*& dest_ptr)
{
	clear_list(dest_ptr);
	if (source_ptr == nullptr)
		return;
	dest_ptr = new node();
	dest_ptr->data = source_ptr->data;
	dest_ptr->next = nullptr;
	node* cursor = dest_ptr;
	while (source_ptr->next != nullptr)
	{
		source_ptr =  source_ptr->next;
		cursor->next = new node();
		cursor->next->data = source_ptr->data;
		cursor->next->next = nullptr;
		cursor = cursor->next;
	}
}
		
